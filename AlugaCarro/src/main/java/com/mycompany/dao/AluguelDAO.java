/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.bd.ConexaoBD;
import com.mycompany.entidade.Aluguel;
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
public class AluguelDAO {
    
    public static List<Aluguel> getAluguel() {
        List<Aluguel> listaAluguel = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select aluguel.id, aluguel.dataLocacao, aluguel.dataDevolucao, aluguel.juros, aluguel.localRetirada, aluguel.localDevolucao, aluguel.qntDiaAluguel, aluguel.idCliente, cliente.nome, aluguel.idCarro, carro.modelo from ((aluguel inner join carro on aluguel.idCarro = carro.id) inner join cliente on aluguel.idCliente = cliente.id) group by aluguel.id;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String dataLocacao = rs.getString("dataLocacao");
                String dataDevolucao = rs.getString("dataDevolucao");
                double juros= rs.getDouble("juros");
                String localRetirada = rs.getString("localRetirada");
                String localDevolucao = rs.getString("localDevolucao");
                int qntDiaAluguel = rs.getInt("qntDiaAluguel");
                int idCliente = rs.getInt("idCliente");
                int idCarro = rs.getInt("idCarro");
                String nomeCliente = rs.getString("nome");
                String nomeCarro = rs.getString("modelo");
                listaAluguel.add(new Aluguel(id, dataLocacao, dataDevolucao, juros, localRetirada, localDevolucao, qntDiaAluguel, idCliente, idCarro, nomeCliente, nomeCarro));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaAluguel;
    }
    
    public static void addAluguel(Aluguel aluguel) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoBD.getConexao();
        String query = "insert into aluguel(dataLocacao, dataDevolucao, juros, localRetirada, localDevolucao, qntDiaAluguel, idCliente, idCarro) values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, aluguel.getDataLocacao());
        ps.setString(2, aluguel.getDataDevolucao());
        ps.setDouble(3, aluguel.getJuros());
        ps.setString(4, aluguel.getLocalRetirada());
        ps.setString(5, aluguel.getLocalDevolucao());
        ps.setInt(6, aluguel.getQntDiaAluguel());
        ps.setInt(7, aluguel.getIdCliente());
        ps.setInt(8, aluguel.getIdCarro());
        ps.execute();

    }
    
    public static Aluguel getAluguel(int id) {
        Aluguel aluguel = null;
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from aluguel where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String dataLocacao = rs.getString("dataLocacao");
                String dataDevolucao = rs.getString("dataDevolucao");
                String localRetirada = rs.getString("localRetirada");
                String localDevolucao = rs.getString("localDevolucao");
                int qntDiaAluguel = rs.getInt("qntDiaAluguel");
                int idCliente = rs.getInt("idCliente");
                int idCarro = rs.getInt("idCarro");
                aluguel = new Aluguel(id, dataLocacao, dataDevolucao, localRetirada, localDevolucao, qntDiaAluguel, idCliente, idCarro);
                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aluguel;
    }
    
    public static void updateAluguel(Aluguel aluguel) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoBD.getConexao();
        String query = ("update aluguel set dataLocacao= ?, dataDevolucao= ?,localRetirada= ?, localDevolucao= ?, qntDiaAluguel= ?, idCliente= ?, idCarro= ? where id= ?");
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, aluguel.getDataLocacao());
        ps.setString(2, aluguel.getDataDevolucao());
        //ps.setDouble(3, aluguel.getJuros());
        ps.setString(3, aluguel.getLocalRetirada());
        ps.setString(4, aluguel.getLocalDevolucao());
        ps.setInt(5, aluguel.getQntDiaAluguel());
        ps.setInt(6, aluguel.getIdCliente());
        ps.setInt(7, aluguel.getIdCarro());
        ps.setInt(8, aluguel.getId());
        ps.execute();
    }
    
    public static void deleteAluguel(int id) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoBD.getConexao();
        String query = ("delete from aluguel where id= ?");
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
    }
}
