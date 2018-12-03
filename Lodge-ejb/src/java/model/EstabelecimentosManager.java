/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author mathe
 */
@Stateless
public class EstabelecimentosManager implements EstabelecimentosManagerLocal {

    @EJB
    private EstabelecimentoFacadeLocal estabelecimentoFacade;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Estabelecimento> listaEstabelecimento() {
        return estabelecimentoFacade.findAll();
    }
}
