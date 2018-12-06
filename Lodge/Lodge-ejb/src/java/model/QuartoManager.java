/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Objects;
import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author marco
 */
@Stateless
public class QuartoManager implements QuartoManagerLocal {
    
    @EJB
    private QuartoFacadeLocal quartoFacade;
    private List<Quarto> l;
    
    @Override
    public List<Quarto> listaQuarto(Long id_estabelecimento) throws CreateException {
         List<Quarto> quartos = quartoFacade.findByIdEstabelecimento(id_estabelecimento);
         
         if (quartos != null) 
             return quartos;
         else
             throw new CreateException("Nenhum quarto registrado");
         
    }

    @Override
    public Quarto buscaQuarto(Long id_quarto) {
        return quartoFacade.find(id_quarto);
    }

}
