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
 * @author mathe
 */
@Stateless
public class QuartoFacade extends AbstractFacade<Quarto> implements QuartoFacadeLocal {

    @PersistenceContext(unitName = "Lodge-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuartoFacade() {
        super(Quarto.class);
    }

    @Override
    public List<Quarto> findByIdEstabelecimento(Long id) {
        Query q = em.createQuery("SELECT u FROM Quarto u WHERE u.idEstabelecimento =:id");
        q.setParameter("id", id);
        try{
            List<Quarto> quartos = q.getResultList();        
            return quartos;
            
        } catch (NoResultException ex){
            return null;
        }
        
        
    }
    
}
