/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 201619030438
 */
@Stateless
public class UsuarioManager implements UsuarioManagerLocal {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    @Override
    public boolean criaUsuario(String nome, String login, String senha) throws CreateException {

        Usuario u = usuarioFacade.findByLogin(login);

        if (u == null) {

            u = new Usuario(nome, login, senha);
            usuarioFacade.create(u);
            return true;
        } else {
            throw new CreateException("Login já cadastrado");
        }
    }

    @Override
    public List<Usuario> listaUsuarios() {
        return usuarioFacade.findAll();

    }
    
    @Override
    public Usuario buscaUsuario (Long id) {
        return usuarioFacade.find(id);
    }
    
     @Override
    public boolean excluiUsuario(Long id) throws CreateException {

        Usuario u = usuarioFacade.find(id);

        if (u != null) {
            usuarioFacade.remove(u);
            return true;
        } else {
            throw new CreateException("Usuario não encontrado");
        }
    }
}
