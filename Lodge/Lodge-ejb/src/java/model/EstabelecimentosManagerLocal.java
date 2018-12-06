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
public interface EstabelecimentosManagerLocal {
    public List<Estabelecimento> listaEstabelecimento(); 

    public Estabelecimento buscaEstabelecimento(Long idEstabelecimento);
}
