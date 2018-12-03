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

/**
 *
 * @author mathe
 */
@Stateless
public class ClienteManager implements ClienteManagerLocal {

    @EJB
    private ClienteFacadeLocal clienteFacade;

    @Override
    public boolean criaCliente(String nome, String endereco, String senha, String login) throws CreateException {
       Cliente u = clienteFacade.findByLogin(login);
        
        if(u == null) {
            
            u = new Cliente( nome, login,endereco, senha);
            clienteFacade.create(u);
            return true;
        } else {
            throw new CreateException("Login já cadastrado");
        }
    }

    @Override
    public boolean validaCliente(String login, String senha) throws CreateException {
        Cliente u = clienteFacade.findByLoginSenha(login,senha);
       if(u == null) {
            
            
            return false;
        } else {
           return true;
        }
    }

    
}
