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
public interface PagamentoFacadeLocal {

    void create(Pagamento pagamento);

    void edit(Pagamento pagamento);

    void remove(Pagamento pagamento);

    Pagamento find(Object id);

    List<Pagamento> findAll();

    List<Pagamento> findRange(int[] range);

    int count();
    
}
