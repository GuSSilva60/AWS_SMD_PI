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
public class Usuario {
    private int id;
    private String email;
    private String senha;
    private int idFuncionario;
    private String nomeFuncionario;

    public Usuario() {
    }

    public Usuario(int id, String email, String senha, int idFuncionario) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.idFuncionario = idFuncionario;
    }

    public Usuario(int id, String email, String senha, int idFuncionario, String nomeFuncionario) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
    }
    
    

    public Usuario(String email, String senha, int idFuncionario) {
        this.email = email;
        this.senha = senha;
        this.idFuncionario = idFuncionario;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    
    
}
