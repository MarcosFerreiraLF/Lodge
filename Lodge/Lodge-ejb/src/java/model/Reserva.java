/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mathe
 */
@Entity
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dt_entrada;
    private Date dt_saida;
    private Long id_quarto;
    private String cpf_cliente;
    private Long id_estabelecimento;
    private String num_cartao;
    private String nomeHotel;
    private double diaria;
    private String numeroQuarto;

    public Reserva(Date dt_entrada,Date dt_saida, Long id_quarto, String cpf_cliente, Long id_estabelecimento, String num_cartao, String nomeHotel, double diaria, String numeroQuarto) {
        this.dt_entrada = dt_entrada;
        this.dt_saida = dt_saida;
        this.id_quarto = id_quarto;
        this.cpf_cliente = cpf_cliente;
        this.id_estabelecimento = id_estabelecimento;
        this.num_cartao = num_cartao;
        this.nomeHotel = nomeHotel;
        this.diaria = diaria;
        this.numeroQuarto = numeroQuarto;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(Double diaria) {
        this.diaria = diaria;
    }

    public String getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(String numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }
    
    public Reserva() {
    }

    public Reserva(Date dt_entrada, Date dt_saida, Long id_quarto, Long id_estabelecimento, String cpf_cliente, String cartao) {
        this.dt_entrada = dt_entrada;
        this.dt_saida = dt_saida;
        this.id_quarto = id_quarto;
        this.cpf_cliente = cpf_cliente;
        this.id_estabelecimento = id_estabelecimento;
        if(cartao==null)
            this.num_cartao = cartao;
        else
            this.num_cartao = "0";
    }
    
    public Date getDt_entrada() {
        return dt_entrada;
    }

    public void setDt_entrada(Date dt_entrada) {
        this.dt_entrada = dt_entrada;
    }

    public Date getDt_saida() {
        return dt_saida;
    }

    public void setDt_saida(Date dt_saida) {
        this.dt_saida = dt_saida;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(Long id_quarto) {
        this.id_quarto = id_quarto;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public Long getId_estabelecimento() {
        return id_estabelecimento;
    }

    public void setId_estabelecimento(Long id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }

    public String getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(String num_cartao) {
        this.num_cartao = num_cartao;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Reserva[ id=" + id + " ]";
    }
    
}
