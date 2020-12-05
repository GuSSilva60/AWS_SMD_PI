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
public class Cliente {
    private int id;
    private String nome;
    private String cnh;
    private String cpf;
    private int idade;
    private String celular;

    public Cliente(int id, String nome, String cnh, String cpf, int idade, String celular) {
        this.id = id;
        this.nome = nome;
        this.cnh = cnh;
        this.cpf = cpf;
        this.idade = idade;
        this.celular = celular;
    }
    public Cliente(String nome, String cnh, String cpf, int idade, String celular) {
        this.nome = nome;
        this.cnh = cnh;
        this.cpf = cpf;
        this.idade = idade;
        this.celular = celular;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
        
}
