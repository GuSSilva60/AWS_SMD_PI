/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.bd.ConexaoBD;
import com.mycompany.entidade.Cliente;
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
public class ClienteDAO {
        public static List<Cliente> getClientes() {
        List<Cliente> listaCliente = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from cliente";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnh = rs.getString("cnh");
                String cpf = rs.getString("cpf");
                int idade = rs.getInt("idade");
                String celular = rs.getString("celular");
                listaCliente.add(new Cliente(id, nome, cnh, cpf, idade, celular));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaCliente;
    }
        
        public static void addCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = "insert into cliente(nome, cnh, cpf, idade, celular) values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCnh());
            ps.setString(3, cliente.getCpf());
            ps.setInt(4, cliente.getIdade());
            ps.setString(5, cliente.getCelular());
            ps.execute();

        }
 
        public static Cliente getCliente(int id) {
            Cliente cliente = null;
            try {
                Connection con = ConexaoBD.getConexao();
                String query = "select * from cliente where id=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String nome = rs.getString("nome");
                    String cnh = rs.getString("cnh");
                    String cpf = rs.getString("cpf");
                    int idade = rs.getInt("idade");
                    String celular = rs.getString("celular");
                    cliente = new Cliente(id, nome, cnh, cpf, idade, celular);

                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return cliente;
        }
   
        public static void updateCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = ("update cliente set nome=?, cnh=?, cpf=?, idade=?, celular= ? where id = ?");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCnh());
            ps.setString(3, cliente.getCpf());
            ps.setInt(4, cliente.getIdade());
            ps.setString(5, cliente.getCelular());
            ps.setInt(6, cliente.getId());
            ps.execute();
        }
        
        public static void deleteCliente(int id) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = ("delete from cliente where id= ?");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        }
}
