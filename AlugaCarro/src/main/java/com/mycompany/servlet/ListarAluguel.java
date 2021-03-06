/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.AluguelDAO;
import com.mycompany.entidade.Aluguel;
import java.io.IOException;
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

@WebServlet(name = "ListarAluguel", urlPatterns = {"/ListarAluguel"})
public class ListarAluguel extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Aluguel> listaAluguel= AluguelDAO.getAluguel();
        request.setAttribute("listaAluguel", listaAluguel);
        
        RequestDispatcher requestDispacher = getServletContext()
                .getRequestDispatcher("/listaAluguel.jsp");
        requestDispacher.forward(request, response);
    }
}
