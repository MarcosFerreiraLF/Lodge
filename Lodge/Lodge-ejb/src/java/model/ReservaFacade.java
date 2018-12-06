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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author matheus, marcos
 */
@Stateless
public class ReservaFacade extends AbstractFacade<Reserva> implements ReservaFacadeLocal {

    @PersistenceContext(unitName = "Lodge-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservaFacade() {
        super(Reserva.class);
    }

    @Override
    public List<Reserva> findByCpf(String cpf) {
        Query q = em.createQuery("SELECT u FROM Reserva u WHERE u.cpf_cliente =:cpf");
        q.setParameter("cpf", cpf);
        try{
            List<Reserva> reservas = q.getResultList();        
            return reservas;
            
        } catch (NoResultException ex){
            return null;
        }
    }
    
}
