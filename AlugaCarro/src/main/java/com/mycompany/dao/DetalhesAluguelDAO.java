/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.bd.ConexaoBD;
import com.mycompany.entidade.DetalhesAluguel;
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
public class DetalhesAluguelDAO {
    
    public static List<DetalhesAluguel> getDetalhesAluguel() {
        List<DetalhesAluguel> listaDetalhes = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select aluguel.id, cliente.nome, carro.marca, carro.modelo, carro.placa, aluguel.qntDiaAluguel, loja.loja, carro.preco from (((aluguel inner join carro on aluguel.idCarro = carro.id) inner join loja on loja.id = carro.idLoja) inner join cliente on aluguel.idCliente = cliente.id) group by aluguel.id;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int idAluguel = rs.getInt("id");
                String nomeCliente = rs.getString("nome");
                String marcaCarro = rs.getString("marca");
                String modeloCarro = rs.getString("modelo");
                String placaCarro = rs.getString("placa");
                int diasAluguel = rs.getInt("qntDiaAluguel");
                String loja = rs.getString("loja");
                double precoDiaria = rs.getDouble("preco");
                double precoTotalDiaria = precoDiaria * diasAluguel;
                
                listaDetalhes.add(
                    new DetalhesAluguel(
                        idAluguel, nomeCliente, marcaCarro, modeloCarro,
                        placaCarro, diasAluguel, loja, precoDiaria, precoTotalDiaria
                    )
                );
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DetalhesAluguelDAO.class.getName()).log(Level.SEVERE,null,ex);   
        }
        
        return listaDetalhes;
    }
    

}