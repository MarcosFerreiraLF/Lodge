/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.ejb.CreateException;
import javax.ejb.Local;

/**
 *
 * @author mathe
 */
@Local
public interface ClienteManagerLocal {
     public boolean criaCliente(String nome, String endereco, String sexo, String senha,String login, String cpf, Date dt_nasc)throws CreateException;
      public boolean validaCliente(Cliente c);
      public Cliente buscaCliente(String login, String senha);
}
