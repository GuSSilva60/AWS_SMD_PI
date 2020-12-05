/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.CarroDAO;
import com.mycompany.entidade.Carro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author biancagolin
 * @author vickp
 */

@WebServlet(name = "ListarCarro", urlPatterns = {"/ListarCarro"})
public class ListarCarro extends HttpServlet {
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Carro> listaCarro= CarroDAO.getCarro();
        request.setAttribute("listaCarro", listaCarro);
        
        RequestDispatcher requestDispacher = getServletContext()
                .getRequestDispatcher("/listaCarro.jsp");
        requestDispacher.forward(request, response);
    }
}
