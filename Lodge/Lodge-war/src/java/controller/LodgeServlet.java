/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.ClienteManagerLocal;
import model.Estabelecimento;
import model.EstabelecimentosManagerLocal;
import model.Quarto;
import model.QuartoManagerLocal;
import model.Reserva;
import model.ReservaManagerLocal;

/**
 *
 * @author mathe
 */
public class LodgeServlet extends HttpServlet {

    @EJB
    private EstabelecimentosManagerLocal estabelecimentosManager;

    @EJB
    private ClienteManagerLocal clienteManager;
    
    @EJB
    private QuartoManagerLocal quartoManager;
    
    @EJB
    private ReservaManagerLocal reservaManager;

    

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
            throws ServletException, IOException, CreateException {
        String jsp = null;

        if (request.getRequestURI().endsWith("/novo")) {
           jsp = "cadastro.jsp";        
        }
        else if (request.getRequestURI().endsWith("/salva")) {
            salva(request);
            jsp = "mensagem.jsp";
        }
        else  if (request.getRequestURI().endsWith("/inicio")) 
            jsp = "home.jsp";
        
        else  if (request.getRequestURI().endsWith("/lista")) {
            lista(request);
            jsp = "estabelecimentos.jsp";
            
        }
        else  if(request.getRequestURI().endsWith("/logar"))
                   jsp = "login.jsp";
        
        else if(request.getRequestURI().endsWith("/efetuaLogin")){
            logar(request,response);
             
        }
                
        else if(request.getRequestURI().endsWith("/logout")){
            request.getSession().invalidate();
            jsp = "home.jsp";
        }
        else if (request.getRequestURI().endsWith("/listarQuartos")) {
            listarQuartos(request);
            jsp = "estabelecimento.jsp";
            
        } else  if(request.getRequestURI().endsWith("/reserva")){
            if (validaLogin(request)){
                 Long id_quarto = Long.parseLong(request.getParameter("id"));
                 Quarto q = quartoManager.buscaQuarto(id_quarto);
                  request.setAttribute("quarto", q);
                jsp = "reserva.jsp";  
            }
                
            else
                jsp = "login.jsp";
            
        } else if (request.getRequestURI().endsWith("/efetuarReserva")){
                reserva(request,response);
                jsp = "mensagem.jsp";
        }
        
         else  if (request.getRequestURI().endsWith("/listarReservas")) {
            if (validaLogin(request)==true) {
                    listaReservas(request);
                    jsp = "reservas.jsp";
            }else        
                    jsp = "login.jsp";     
        }
        else  if (request.getRequestURI().endsWith("/cancelarReserva")) {
            
            
            if (validaLogin(request)==true) {
                    Long id_reserva = Long.parseLong(request.getParameter("id"));
                     reservaManager.apagarReserva(id_reserva);
                   
                    jsp = "reservas.jsp";
            }else        
                    jsp = "login.jsp";     
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

    private void salva(HttpServletRequest request){
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String endereco = request.getParameter("endereco");
        String sexo = request.getParameter("sexo");
        String cpf = request.getParameter("cpf");
        String dt_nasc = request.getParameter("dataNasc");
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
      try{
            Date dataFormatada = formato.parse(dt_nasc);
            boolean sucesso = clienteManager.criaCliente(nome, endereco, sexo, login, senha, cpf, dataFormatada);
            
            if(sucesso)
                request.setAttribute("mensagem", "o cliente " +login+ "foi salvo");
            
        }catch(CreateException ex){            
            System.out.println(ex.getMessage());
            request.setAttribute("mensagem", "Falha ao salvar o cliente!");
        } catch(ParseException ex){
            System.out.println(ex.getMessage());
            request.setAttribute("mensagem", "Data inválida!");
        }
    }

    private void lista(HttpServletRequest request) {
        List listaEstabelecimentos = estabelecimentosManager.listaEstabelecimento();
        request.setAttribute("lista", listaEstabelecimentos);
    }
    private void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         String login = request.getParameter("email");
         String senha = request.getParameter("password");
         Cliente c = clienteManager.buscaCliente(login, senha);
        
        // Verifica usuario e senha
        
        if (clienteManager.validaCliente(c)==true) {
            request.getSession().setAttribute("cliente", c);
             request.getRequestDispatcher("home.jsp").forward(request, response);
        } 
        else {
             request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    private boolean validaLogin(HttpServletRequest request){
        Cliente c = (Cliente) request.getSession().getAttribute("cliente");
        return c != null;
    }
    

    private void listarQuartos(HttpServletRequest request) {
        Long id_estabelecimento = Long.parseLong(request.getParameter("id"));
        try{
            List listaQuartos = quartoManager.listaQuarto(id_estabelecimento);
            Estabelecimento e = estabelecimentosManager.buscaEstabelecimento(id_estabelecimento);
        //System.out.println("id do estab vindo do bd: "+e.getId());
            request.setAttribute("estabelecimento", e);
            request.setAttribute("lista_quartos", listaQuartos);
        } catch (CreateException ex) {
            request.setAttribute("lista_quartos", new ArrayList());
        }
        
    }

    private void reserva(HttpServletRequest request, HttpServletResponse response) {
          System.out.println("aqui o id:"+request.getParameter("id"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Long id_quarto = Long.parseLong(request.getParameter("id"));
        
      //System.out.println("aqui o id:"+"id");
       
        Cliente c = (Cliente) request.getSession().getAttribute("cliente");
        Quarto q = quartoManager.buscaQuarto(id_quarto);//buscarQuarto pelo id no manager
        Estabelecimento e = estabelecimentosManager.buscaEstabelecimento(q.getIdEstabelecimento());
        //request.setAttribute("quarto", q);
        String num_cartao = (String) request.getAttribute("cartao");
        
        try{
            Date entrada = format.parse(request.getParameter("dt_ent"));

            Date saida = format.parse(request.getParameter("dt_sai"));
         
            boolean sucesso = reservaManager.criaReserva(entrada, saida, q.getId(),c.getCpf(),q.getIdEstabelecimento(),num_cartao,e.getDescricao(),q.getPreco(),q.getNumero());
            
            if(sucesso)
                request.setAttribute("mensagem", "Reserva efetuada com sucesso");
            
        }catch(CreateException ex){            
            System.out.println(ex.getMessage());
            request.setAttribute("mensagem", "DIA INDISPONIVEL!");
        } catch (ParseException ex) {
           request.setAttribute("mensagem", "Data inválida!");
        }
    }

    private void listaReservas(HttpServletRequest request) throws CreateException {
         Cliente c = (Cliente) request.getSession().getAttribute("cliente");
       
        
        try{
            List listaReservas = reservaManager.listaReservas(c.getCpf());
            
            request.setAttribute("lista_reservas", listaReservas);
        } catch (CreateException ex) {
            request.setAttribute("lista_reservas", new ArrayList());
        }
    }

    
    
}
