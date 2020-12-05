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
public class Carro {
    private int id;
    private String marca;
    private String modelo;
    private int qntPortas;
    private String placa;
    private double preco;
    private int idLoja;
    private String nomeLoja;

    public Carro(int id, String marca, String modelo, int qntPortas, String placa, double preco, int idLoja, String nomeLoja) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.qntPortas = qntPortas;
        this.placa = placa;
        this.preco = preco;
        this.idLoja = idLoja;
        this.nomeLoja = nomeLoja;
    }

    public Carro(int id, String marca, String modelo, int qntPortas, String placa, double preco, int idLoja) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.qntPortas = qntPortas;
        this.placa = placa;
        this.preco = preco;
        this.idLoja = idLoja;
    }
    
    
    
    public Carro(String marca, String modelo, int qntPortas, String placa, double preco, int idLoja) {
        this.marca = marca;
        this.modelo = modelo;
        this.qntPortas = qntPortas;
        this.placa = placa;
        this.preco = preco;
        this.idLoja = idLoja;
    }

    public Carro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQntPortas() {
        return qntPortas;
    }

    public void setQntPortas(int qntPortas) {
        this.qntPortas = qntPortas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }
    
    
}
