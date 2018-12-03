/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ClienteFacadeLocal;
import model.ClienteManagerLocal;
import model.EstabelecimentosManagerLocal;

/**
 *
 * @author mathe
 */
public class LodgeServlet extends HttpServlet {

    @EJB
    private EstabelecimentosManagerLocal estabelecimentosManager;

    @EJB
    private ClienteManagerLocal clienteManager;

    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param session servlet session
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, CreateException {
        String jsp = null;

        if (request.getRequestURI().endsWith("/novo")) {
           jsp = "cadastro.jsp";
            
            
        }
        else if (request.getRequestURI().endsWith("/salva")) {
            //... receber dados e salvar
            try {
                salva(request);
            } catch (ParseException ex) {
                //Logger.getLogger(LodgeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            jsp = "mensagem.jsp";
        }
        else  if (request.getRequestURI().endsWith("/inicio")) {
            jsp = "home.jsp";
        }
        else  if (request.getRequestURI().endsWith("/busca")) {
            
 
            if (validaLogin(request)==true) {
                    lista(request);
                    jsp = "resultado.jsp";
            }
             else
            {
                    jsp = "login.jsp";
            }
           
        }
        else  if(request.getRequestURI().endsWith("/logar"))
                   jsp = "login.jsp";
        else if(request.getRequestURI().endsWith("/efetuaLogin"))
            logar(request,response);  
        else if(request.getRequestURI().endsWith("/logout")){
            request.getSession().invalidate();
            jsp = "login.jsp";
        }
         else  if (request.getRequestURI().endsWith("/mostrarReservas")) {
            
 
            if (validaLogin(request)==true) {
                    lista(request);
                    jsp = "resultado.jsp";
            }
             else
            {
                    jsp = "login.jsp";
            }
           
        }
        
            

        request.getRequestDispatcher(jsp).forward(request, response);
    }

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
        try {
            processRequest(request, response);
        } catch (CreateException ex) {
            Logger.getLogger(LodgeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (CreateException ex) {
            Logger.getLogger(LodgeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void salva(HttpServletRequest request) throws ParseException {
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
       String endereco = request.getParameter("endereco");
       //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
       //String datanasci = request.getParameter("datanasc");
       //Date dataFormatada = formato.parse(datanasci);
      // System.out.println(dataFormatada);
       // Usuario u = new Usuario(nome, login, senha);
        
      try{
            
            boolean sucesso = clienteManager.criaCliente(nome, endereco, senha,login);
            
            if(sucesso){
                request.setAttribute("mensagem", "o usuario " +login+ "foi salvo");
            }
        }catch(CreateException e){            
            System.out.println(e.getMessage());
            request.setAttribute("mensagem", "Falha ao salvar o usuario!");
            
            }
        
        
    }

    private void lista(HttpServletRequest request) {
        List listaUsuarios = estabelecimentosManager.listaEstabelecimento();
        request.setAttribute("lista", listaUsuarios);
    }
    private void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CreateException{
         String usuario = request.getParameter("nome");
         String senha = request.getParameter("senha");
 
        // Verifica usuario e senha
        // provavelmente você utilizará um banco de dados
        // Neste exemplo utilizaremos valores fixos
        
        if (clienteManager.validaCliente(usuario, senha)==true) {
            request.getSession().setAttribute("usuario", usuario);
             request.getRequestDispatcher("home.jsp").forward(request, response);
        } 
        else {
             request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    private boolean validaLogin(HttpServletRequest request){
        String usuario = (String) request.getSession().getAttribute("usuario");
 
            if (usuario != null) {
                System.out.println(usuario);
                   return true;
            }
        else
        {
            return false;
        }
    }
    
}
