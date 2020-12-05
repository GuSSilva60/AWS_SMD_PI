/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.DemandaProdutoDAO;
import com.mycompany.entidade.DemandaProduto;
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
 */

@WebServlet(name = "ListarDemanda", urlPatterns = {"/ListarDemanda"})
public class ListarDemanda extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<DemandaProduto> listaDemanda = DemandaProdutoDAO.getDemandaProduto();
        request.setAttribute("listaDemanda", listaDemanda);
        
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/listaDemanda.jsp");
        requestDispatcher.forward(request, response);
    }

}
