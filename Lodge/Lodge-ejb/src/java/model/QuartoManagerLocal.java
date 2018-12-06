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
 * @author marco
 */
@Local
public interface QuartoManagerLocal {
    public List<Quarto> listaQuarto(Long id_estabelecimento) throws CreateException;
    public Quarto buscaQuarto(Long id_quarto);
}
