/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.UsuarioDAO;
import com.mycompany.entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author biancagolin
 */

@WebServlet(name = "ListarUsuario", urlPatterns = {"/ListarUsuario"})
public class ListarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        
        List<Usuario> listaUsuario = UsuarioDAO.getUsuario();
        request.setAttribute("listaUsuario", listaUsuario);
        
        RequestDispatcher requestDispacher = getServletContext()
                .getRequestDispatcher("/listaUsuario.jsp");
        requestDispacher.forward(request, response);
    }
}
