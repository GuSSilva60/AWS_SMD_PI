/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.UsuarioDAO;
import com.mycompany.entidade.Usuario;
import com.mycompany.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author biancagolin
 */

@WebServlet(name = "AlterarUsuario", urlPatterns = {"/AlterarUsuario"})
public class AlterarUsuario extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        Usuario usuario = UsuarioDAO.getUsuario(id);
        request.setAttribute("usuario", usuario);

        RequestDispatcher requestDispacher = getServletContext().getRequestDispatcher("/alterarUsuario.jsp");
        requestDispacher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String idFuncionarioStr = request.getParameter("idFuncionario");
        int id = Integer.parseInt(idStr);
        int idFuncionario = Integer.parseInt(idFuncionarioStr);
        Usuario usuario = UsuarioDAO.getUsuario(id);
        usuario.setId(id);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setIdFuncionario(idFuncionario);
        
        try {
            UsuarioDAO.updateUsuario(usuario);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaDeErro(ex, request, response);
        }
    }

}
