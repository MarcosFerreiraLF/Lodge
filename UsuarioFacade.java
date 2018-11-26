/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jane
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "Ex13-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario findByLogin(String login) {

        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login");

        q.setParameter("login", login);

        try {

            Usuario u = (Usuario) q.getSingleResult();
            return u;
        } catch (NoResultException e) {
            
            return null;
        

        } catch (NonUniqueResultException ex)  {
            
            List<Usuario> resultList = q.getResultList();
            return resultList.get(0);
        }
    }
}
