/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author marco
 */
@Stateless
public class ReservaManager implements ReservaManagerLocal {
    
    @EJB
    private ReservaFacadeLocal reservaFacade;

    @Override
    public boolean criaReserva(Date dt_entrada,Date dt_saida, Long id_quarto, String cpf_cliente, Long id_estabelecimento, String num_cartao, String nomeHotel, double diaria,String numeroQuarto) throws CreateException{
        for (Reserva r : reservaFacade.findAll()){
            
            if(r != null)//se existe alguma reserva no sistema
                if(r.getId_quarto().equals(id_quarto)) //se existem reservas no quarto desejado
                     
                     //se entrada da nova reserva antes da saida da reserva registrada
                     //ou saida da nova reserva depois da entrada da reserva registrada
                     //reserva não pode ser efetuada
                    if(dt_entrada.before(r.getDt_saida()) || dt_saida.after(r.getDt_entrada()))
                        throw new CreateException("Conflito entre datas de reservas");

        }
                //não existe nenhuma reserva no sistema ou nenhuma reserva no quarto desejado
                //ou nenhuma reserva interfere nas datas da nova reserva
                 Reserva reserva = new Reserva(dt_entrada,dt_saida,id_quarto,cpf_cliente,id_estabelecimento,num_cartao,nomeHotel,diaria,numeroQuarto);
                 reservaFacade.create(reserva);
               
        return true;
    }
    
   

    @Override
    public List<Reserva> listaReservas(String cpf) throws CreateException {
         List<Reserva> reservas = reservaFacade.findByCpf(cpf);
         
         if (reservas != null) 
             return reservas;
         else
             throw new CreateException("Nenhuma reserva registrada");
    }

    @Override
    public Reserva buscaReserva(Long id_reserva) {
       Reserva r = reservaFacade.find(id_reserva);
        return r;
    }

    @Override
    public boolean apagarReserva(Long id_reserva) {
        Reserva r = reservaFacade.find(id_reserva);
        
        if(r==null){
            return false;
        }
        else{
           reservaFacade.remove(r);
        }
        
        return true;
    }
}
