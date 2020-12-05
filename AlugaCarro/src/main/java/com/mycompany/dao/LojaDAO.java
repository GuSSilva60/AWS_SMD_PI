/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;


import com.mycompany.bd.ConexaoBD;
import com.mycompany.entidade.Loja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author biancagolin
 */
public class LojaDAO {
    public static List<Loja> getLoja() {
        List<Loja> listaLoja = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from loja";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String loja = rs.getString("loja");
                listaLoja.add(new Loja(id, loja));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaLoja;
    }
        
    public static void addLoja(Loja loja) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = "insert into loja(loja) values (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, loja.getLoja());
            ps.execute();
        }
    
    public static Loja getLoja(int id) {
            Loja lojas = null;
            try {
                Connection con = ConexaoBD.getConexao();
                String query = "select * from loja where id=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String loja = rs.getString("loja");
                    lojas = new Loja(id, loja);

                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return lojas;
        }
    
    public static void updateLoja(Loja loja) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = ("update loja set loja=? where id = ?");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, loja.getLoja());
            ps.setInt(2, loja.getId());
            ps.execute();
        }
        
    public static void deleteLoja(int id) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = ("delete from loja where id= ?");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        }
    
}
