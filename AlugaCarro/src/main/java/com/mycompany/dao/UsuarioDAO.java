/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.bd.ConexaoBD;
import com.mycompany.entidade.Usuario;
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
public class UsuarioDAO {
    public static List<Usuario> getUsuario() {
        List<Usuario> listaUsuario = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select usuario.id, usuario.email, usuario.senha, usuario.idFuncionario, funcionario.nome from (usuario inner join funcionario on usuario.idFuncionario = funcionario.id) group by usuario.id;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                int idFuncionario = rs.getInt("idFuncionario");
                String nomeFuncionario = rs.getString("nome");
                listaUsuario.add(new Usuario(id, email, senha, idFuncionario, nomeFuncionario));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaUsuario;
    }
        
    public static void addUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = "insert into usuario(email, senha, idFuncionario) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            ps.setInt(3, usuario.getIdFuncionario());
            ps.execute();
        }
    
    public static Usuario getUsuario(int id) {
            Usuario usuario = null;
            try {
                Connection con = ConexaoBD.getConexao();
                String query = "select * from usuario where id=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String email = rs.getString("email");
                    String senha = rs.getString("senha");
                    int idFuncionario = rs.getInt("idFuncionario");
                    usuario = new Usuario(id, email, senha, idFuncionario);

                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return usuario;
        }
    
    public static void updateUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = ("update usuario set email=?, senha=?, idFuncionario=? where id = ?");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            ps.setInt(3, usuario.getIdFuncionario());
            ps.setInt(4, usuario.getId());
            ps.execute();
        }
        
    public static void deleteUsuario(int id) throws SQLException, ClassNotFoundException {
            Connection con = ConexaoBD.getConexao();
            String query = ("delete from usuario where id= ?");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        }
    
}
