/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.bd.ConexaoBD;
import com.mycompany.entidade.DemandaProduto;
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
public class DemandaProdutoDAO {
    public static List<DemandaProduto> getDemandaProduto() {
        List<DemandaProduto> listaDemanda = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select carro.modelo, count(*) as \"Quantidade\" from carro group by modelo order by count(*) desc";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                
                String modeloCarro = rs.getString("modelo");
                String carro = rs.getString("Quantidade"); 
                
                listaDemanda.add(new DemandaProduto(modeloCarro, carro));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DemandaProdutoDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return listaDemanda;
    }
}
