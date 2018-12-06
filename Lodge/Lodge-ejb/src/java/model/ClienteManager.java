/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.FinderException;

/**
 *
 * @author mathe
 */
@Stateless
public class ClienteManager implements ClienteManagerLocal {

    @EJB
    private ClienteFacadeLocal clienteFacade;

    @Override
    public boolean criaCliente(String nome, String endereco, String sexo, String login, String senha, String cpf, Date dt_nasc) throws CreateException {
       Cliente u = clienteFacade.findByLogin(login);
        
        if(u == null) {
            
            u = new Cliente(nome, endereco, sexo, login, senha, cpf, dt_nasc );
            clienteFacade.create(u);
            return true;
        } else {
            throw new CreateException("Cliente já cadastrado");
        }
    }

    @Override
    public boolean validaCliente(Cliente u) {
       return u!=null;
    }
    
    @Override
    public Cliente buscaCliente(String login, String senha) {
         return clienteFacade.findByLoginSenha(login, senha);
    }

    
}
