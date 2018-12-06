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
 * @author mathe
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "Lodge-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public Cliente findByLogin(String login) {
       Query q = em.createQuery("SELECT u FROM Cliente u WHERE u.login = :login");

        q.setParameter("login", login);

        try {

            Cliente u = (Cliente) q.getSingleResult();
            return u;
        } catch (NoResultException e) {
            
            return null;
        

        } catch (NonUniqueResultException ex)  {
            
          //  List<Usuario> resultList = q.getResultList();
          List<Cliente> resultList = q.getResultList();
            return resultList.get(0);
        }
    }

    @Override
    public Cliente findByLoginSenha(String login, String senha) {
        Query q = em.createQuery("SELECT u FROM Cliente u WHERE u.login =:login and u.senha = :senha");

        q.setParameter("login", login);
        q.setParameter("senha", senha);

        try {

           Cliente u = (Cliente) q.getSingleResult();
            return u;
        } catch (NoResultException e) {
            
            return null;
        

        } catch (NonUniqueResultException ex)  {
            
          //  List<Usuario> resultList = q.getResultList();
          List<Cliente> resultList = q.getResultList();
            return resultList.get(0);
        }
    }
    
}
