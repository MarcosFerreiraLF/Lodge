/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.Local;

/**
 *
 * @author marco
 */
@Local
public interface ReservaManagerLocal {
    
    public boolean criaReserva(Date dt_entrada,Date dt_saida, Long id_quarto, String cpf_cliente, Long id_estabelecimento, String num_cartao, String nomeHotel, double diaria, String numeroQuarto) throws CreateException;

    public List listaReservas(String cpf) throws CreateException;
     public Reserva buscaReserva(Long id_reserva);
     public boolean apagarReserva(Long id_reserva);
}
