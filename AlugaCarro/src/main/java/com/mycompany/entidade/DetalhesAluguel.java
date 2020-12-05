/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidade;

/**
 *
 * @author biancagolin
 */
public class DetalhesAluguel {
    private int idAluguel;
    private String nomeCliente;
    private String marcaCarro;
    private String modeloCarro;
    private String placaCarro;
    private int diasAluguel;
    private String loja;
    private double precoDiaria;
    private double precoTotalDiaria;
    private int idCarro;
    private int idLoja;
    private int idCliente;

    public DetalhesAluguel(int idAluguel, String nomeCliente, String marcaCarro, String modeloCarro, String placaCarro, int diasAluguel, String loja, double precoDiaria, double precoTotalDiaria) {
        this.idAluguel = idAluguel;
        this.nomeCliente = nomeCliente;
        this.marcaCarro = marcaCarro;
        this.modeloCarro = modeloCarro;
        this.placaCarro = placaCarro;
        this.diasAluguel = diasAluguel;
        this.loja = loja;
        this.precoDiaria = precoDiaria;
        this.precoTotalDiaria = precoTotalDiaria;
    }
    
    
    
    

    public DetalhesAluguel(int idAluguel, String nomeCliente, String marcaCarro, String modeloCarro, String placaCarro, int diasAluguel, String loja, double precoDiaria, double precoTotalDiaria, int idCarro, int idLoja, int idCliente) {
        this.idAluguel = idAluguel;
        this.nomeCliente = nomeCliente;
        this.marcaCarro = marcaCarro;
        this.modeloCarro = modeloCarro;
        this.placaCarro = placaCarro;
        this.diasAluguel = diasAluguel;
        this.loja = loja;
        this.precoDiaria = precoDiaria;
        this.precoTotalDiaria = precoTotalDiaria;
        this.idCarro = idCarro;
        this.idLoja = idLoja;
        this.idCliente = idCliente;
    }


    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public int getDiasAluguel() {
        return diasAluguel;
    }

    public void setDiasAluguel(int diasAluguel) {
        this.diasAluguel = diasAluguel;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public double getPrecoTotalDiaria() {
        return precoTotalDiaria;
    }

    public void setPrecoTotalDiaria(double precoTotalDiaria) {
        this.precoTotalDiaria = precoTotalDiaria;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
