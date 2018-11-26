/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.Local;

/**
 *
 * @author 201619030438
 */
@Local
public interface UsuarioManagerLocal {

    public boolean excluiUsuario(Long id) throws CreateException;

    public boolean criaUsuario(String nome, String login, String senha) throws CreateException;

    public List<Usuario> listaUsuarios();

    public Usuario buscaUsuario(Long id);
}
