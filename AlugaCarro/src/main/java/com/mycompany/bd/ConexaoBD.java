/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author biancagolin
 * @author vick
 */
public class ConexaoBD {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConexao() throws SQLException, ClassNotFoundException {        
        String url = "jdbc:mysql://localhost:3306/senac?useSSL=false";//"jdbc:derby://localhost:1527/aluguel";
        String user = "root";
        String password = "admin";
        return DriverManager.getConnection(url, user, password);
    }
}
