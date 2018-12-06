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
public interface CartaoFacadeLocal {

    void create(Cartao cartao);

    void edit(Cartao cartao);

    void remove(Cartao cartao);

    Cartao find(Object id);

    List<Cartao> findAll();

    List<Cartao> findRange(int[] range);

    int count();
    
}
