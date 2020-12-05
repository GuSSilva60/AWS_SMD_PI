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
public class Aluguel {
    private int id;
    private String dataLocacao;
    private String dataDevolucao;
    private double juros;
    private String localRetirada;
    private String localDevolucao;
    private int qntDiaAluguel;
    private int idCliente;
    private int idCarro;
    
    private String nomeCliente;
    private String nomeCarro;

  
    
    

    public Aluguel(int id, String dataLocacao, String dataDevolucao, double juros, String localRetirada, String localDevolucao, int qntDiaAluguel, int idCliente, int idCarro, String nomeCliente, String nomeCarro) {
        this.id = id;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.juros = juros;
        this.localRetirada = localRetirada;
        this.localDevolucao = localDevolucao;
        this.qntDiaAluguel = qntDiaAluguel;
        this.idCliente = idCliente;
        this.idCarro = idCarro;
        this.nomeCliente = nomeCliente;
        this.nomeCarro = nomeCarro;
    }

    public Aluguel(String dataLocacao, String dataDevolucao, double juros, String localRetirada, String localDevolucao, int qntDiaAluguel, int idCliente, int idCarro) {
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.juros = juros;
        this.localRetirada = localRetirada;
        this.localDevolucao = localDevolucao;
        this.qntDiaAluguel = qntDiaAluguel;
        this.idCliente = idCliente;
        this.idCarro = idCarro;
    }

    public Aluguel(int id, String dataLocacao, String dataDevolucao, String localRetirada, String localDevolucao, int qntDiaAluguel, int idCliente, int idCarro) {
        this.id = id;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.localRetirada = localRetirada;
        this.localDevolucao = localDevolucao;
        this.qntDiaAluguel = qntDiaAluguel;
        this.idCliente = idCliente;
        this.idCarro = idCarro;
    }
    
    

    public Aluguel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public String getLocalRetirada() {
        return localRetirada;
    }

    public void setLocalRetirada(String localRetirada) {
        this.localRetirada = localRetirada;
    }

    public String getLocalDevolucao() {
        return localDevolucao;
    }

    public void setLocalDevolucao(String localDevolucao) {
        this.localDevolucao = localDevolucao;
    }

    public int getQntDiaAluguel() {
        return qntDiaAluguel;
    }

    public void setQntDiaAluguel(int qntDiaAluguel) {
        this.qntDiaAluguel = qntDiaAluguel;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }
    
    
}
