/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.bd.ConexaoBD;
import com.mycompany.entidade.Carro;
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
 * @author vickp
 */
public class CarroDAO {
    
        public static List<Carro> getCarro() {
        List<Carro> listaCarro = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select carro.id, carro.marca, carro.modelo, carro.qntPortas, carro.placa, carro.preco, carro.idLoja, loja.loja from (carro inner join loja on carro.idLoja = loja.id) group by carro.id;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int qntPortas = rs.getInt("qntPortas");
                String placa = rs.getString("placa");
                double preco = rs.getDouble("preco");
                int idLoja = rs.getInt("idLoja");
                String nomeLoja = rs.getString("loja");
                listaCarro.add(new Carro(id, marca, modelo, qntPortas, placa, preco, idLoja, nomeLoja));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaCarro;
    }
        
        public static List<Carro> getCarroLoja() {
        List<Carro> listaCarro = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select carro.id, carro.marca, carro.modelo, carro.qntPortas, carro.placa, carro.preco, loja.loja from (carro inner join loja on carro.idLoja = loja.id) group by carro.id;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int qntPortas = rs.getInt("qntPortas");
                String placa = rs.getString("placa");
                double preco = rs.getDouble("preco");
                int idLoja = rs.getInt("idLoja");
                String loja = rs.getString("loja");
                listaCarro.add(new Carro());

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaCarro;
    }
        
    public static void addCarro(Carro carro) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoBD.getConexao();
        String query = "insert into carro(marca, modelo, qntPortas, placa, preco, idLoja) values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, carro.getMarca());
        ps.setString(2, carro.getModelo());
        ps.setInt(3, carro.getQntPortas());
        ps.setString(4, carro.getPlaca());
        ps.setDouble(5, carro.getPreco());
        ps.setInt(6, carro.getIdLoja());
        ps.execute();

    }
    
        public static Carro getCarro(int id) {
        Carro carro = null;
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from carro where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int qntPortas = rs.getInt("qntPortas");
                String placa = rs.getString("placa");
                double preco = rs.getDouble("preco");
                int idLoja = rs.getInt("idLoja");
                carro = new Carro(id, marca, modelo, qntPortas, placa, preco, idLoja);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return carro;
    }
        
    public static void updateCarro(Carro carro) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoBD.getConexao();
        String query = ("update carro set marca= ?, modelo= ?, qntPortas= ?, placa= ?, preco= ? where id= ?");
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, carro.getMarca());
        ps.setString(2, carro.getModelo());
        ps.setInt(3, carro.getQntPortas());
        ps.setString(4, carro.getPlaca());
        ps.setDouble(5, carro.getPreco());
        ps.setInt(6, carro.getId());
        ps.execute();
    }

    public static void deleteCarro(int id) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoBD.getConexao();
        String query = ("delete from carro where id= ?");
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
    }
}
