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
public class Funcionario {
    private int id;
    private String nome;
    private int cargo;
    private int idLoja;
    private String nomeLoja;

    public Funcionario(int id, String nome, int cargo, int idLoja, String nomeLoja) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.idLoja = idLoja;
        this.nomeLoja = nomeLoja;
    }

    public Funcionario(String nome, int cargo, int idLoja) {
        this.nome = nome;
        this.cargo = cargo;
        this.idLoja = idLoja;
    }

    public Funcionario(int id, String nome, int cargo, int idLoja) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.idLoja = idLoja;
    }
    
    
    
    public String getCargoNome() {
        String nomeCargo = "";
        
        switch(this.cargo) {
            case 1:
                nomeCargo = "Gerente Global";
            break;
            case 2:
                nomeCargo = "Gerente Filial";
            break;
            case 3:
                nomeCargo = "Serviços";
            break;
            case 4:
                nomeCargo = "TI";
            break;
            default:
                nomeCargo = "Erro. Cargo não existe.";
        }
        return nomeCargo;
    }
    
    public Funcionario() {
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

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
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
