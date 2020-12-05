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
public class Loja {
    private int id;
    private String loja;

    public Loja(int id, String loja) {
        this.id = id;
        this.loja = loja;
    }

    public Loja(String loja) {
        this.loja = loja;
    }
    
    

    public Loja() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }
    
    
}
