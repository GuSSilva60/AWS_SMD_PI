/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.bd.ConexaoBD;
import com.mycompany.entidade.Funcionario;
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
public class FuncionarioDAO {
    
    public static List<Funcionario> getFuncionario() {
        List<Funcionario> listaFuncionario = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select funcionario.id, funcionario.nome,funcionario.cargo, funcionario.idLoja, loja.loja from (funcionario inner join loja on funcionario.idLoja = loja.id) group by funcionario.id;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int cargo = rs.getInt("cargo");
                int idLoja = rs.getInt("idLoja");
                String nomeLoja = rs.getString("loja");
                listaFuncionario.add(new Funcionario(id, nome, cargo, idLoja, nomeLoja));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaFuncionario;
    }
        
    public static void addFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = "insert into funcionario(nome, cargo, idLoja) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getCargo());
            ps.setInt(3, funcionario.getIdLoja());
            ps.execute();
        }
    
    public static Funcionario getFuncionario(int id) {
            Funcionario funcionario = null;
            try {
                Connection con = ConexaoBD.getConexao();
                String query = "select * from funcionario where id=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String nome = rs.getString("nome");
                    int cargo = rs.getInt("cargo");
                    int idLoja = rs.getInt("idLoja");
                    funcionario = new Funcionario(id, nome, cargo, idLoja);

                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return funcionario;
        }
    
    public static void updateFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = ("update funcionario set nome=?, cargo=?, idLoja=? where id = ?");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getCargo());
            ps.setInt(3, funcionario.getIdLoja());
            ps.setInt(4, funcionario.getId());
            ps.execute();
        }
        
    public static void deleteFuncionario(int id) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = ("delete from funcionario where id= ?");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        }
}
