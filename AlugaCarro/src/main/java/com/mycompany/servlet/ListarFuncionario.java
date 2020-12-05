/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.FuncionarioDAO;
import com.mycompany.entidade.Funcionario;
import java.io.IOException;
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

@WebServlet(name = "ListarFuncionario", urlPatterns = {"/ListarFuncionario"})
public class ListarFuncionario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        
        List<Funcionario> listaFuncionario = FuncionarioDAO.getFuncionario();
        request.setAttribute("listaFuncionario", listaFuncionario);
        
        RequestDispatcher requestDispacher = getServletContext()
                .getRequestDispatcher("/listaFuncionario.jsp");
        requestDispacher.forward(request, response);
    }

}
