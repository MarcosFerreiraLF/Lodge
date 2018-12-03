/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mathe
 */
@Local
public interface EstabelecimentoFacadeLocal {

    void create(Estabelecimento estabelecimento);

    void edit(Estabelecimento estabelecimento);

    void remove(Estabelecimento estabelecimento);

    Estabelecimento find(Object id);

    List<Estabelecimento> findAll();

    List<Estabelecimento> findRange(int[] range);

    int count();
    
}
