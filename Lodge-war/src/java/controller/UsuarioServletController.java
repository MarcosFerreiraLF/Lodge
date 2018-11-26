/*
 * Material utilizado para as aulas práticas das disciplinas da Faculdade de
Computação da Universidade Federal de Mato Grosso do Sul (FACOM / UFMS).
Seu uso é permitido para fins apenas acadêmicos, todavia mantendo a
referência de autoria.
 */
/**
 * @author Professora Jane Sandim Eleutério
 * @version Outubro/2018
 */
package controller;

import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import java.io.IOException;
import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioManagerLocal;
import static model.Usuario_.id;

/**
 *
 * @author Jane
 */
public class UsuarioServletController extends HttpServlet {

    @EJB
    private UsuarioManagerLocal usuarioManager;


    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String jsp = null;

        if (request.getRequestURI().endsWith("/inicio")) {
            jsp = "index.jsp";
        } else if (request.getRequestURI().endsWith("/novo")) {
            jsp = "novo.jsp";
        } else if (request.getRequestURI().endsWith("/salva")) {
            //... receber dados e salvar
            salva(request);
            jsp = "mensagem.jsp";
        } else if (request.getRequestURI().endsWith("/lista")) {
            //... prepara a lista
            lista(request);
            jsp = "lista.jsp";
        }else if (request.getRequestURI().endsWith("/excluir")) {
            exclui(request);
            jsp = "mensagem.jsp";
        }

        request.getRequestDispatcher(jsp).forward(request, response);
    }
    
    
    private void salva(HttpServletRequest request) {

        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        try{
            
            boolean sucesso = usuarioManager.criaUsuario(nome, login, senha);
            
            if(sucesso){
                request.setAttribute("mensagem", "o usuario " +login+ " foi salvo");
            }
        }catch(CreateException e){            
            System.out.println(e.getMessage());
            request.setAttribute("mensagem", "Falha ao salvar o usuario!");
            
        }
    }

    private void lista(HttpServletRequest request) {
            List listaUsuarios = usuarioManager.listaUsuarios();
            request.setAttribute("lista", listaUsuarios);
    }
    
    private void exclui(HttpServletRequest request) {
        
        Long id = Long.parseLong( request.getParameter("id") );
       
        try {
            boolean sucesso = usuarioManager.excluiUsuario(id);
            
            if(sucesso){
                request.setAttribute("mensagem", "O usuario foi removido");
            }
        } catch (CreateException e) {
            System.out.println(e.getMessage());
            request.setAttribute("mensagem", "Falha ao remover o usuario! ");
        }        
    }
    
   /* private String editar (HttpServletRequest){
        String jps;
        
        Long id = Long.parseLong( request.getParameter("id") );
        
        if(request.getParameter("enviado") == null){
            
            Usuario u = usuarioManager.buscaUsuario(id);
        
            request.setAtribute("user", ul);
            jps = "edita.jsp";
        }else{
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
    
            jps = "mensagem.jps";
        }
        
        return jps;
    }
 */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
