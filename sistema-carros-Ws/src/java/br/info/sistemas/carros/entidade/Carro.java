package br.info.sistemas.carros.entidade;

import java.util.Date;
import java.util.Objects;

public class Carro {
    
    private Integer id;
    private String placa;
    private String chassi;
    private String renavam;
    private String modelo;
    private String marca;
    private Date ano;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getRenavam() {
        return renavam;
    }
    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public Date getAno() {
        return ano;
    }
    public void setAno(Date ano) {
        this.ano = ano;
    }

}
