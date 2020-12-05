/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.LojaDAO;
import com.mycompany.entidade.Loja;
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

@WebServlet(name = "AlterarLoja", urlPatterns = {"/AlterarLoja"})
public class AlterarLoja extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        Loja loja = LojaDAO.getLoja(id);
        request.setAttribute("loja", loja);

        RequestDispatcher requestDispacher = getServletContext().getRequestDispatcher("/alterarLoja.jsp");
        requestDispacher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String loja = request.getParameter("loja");
        int id = Integer.parseInt(idStr);
        Loja lojas = LojaDAO.getLoja(id);
        lojas.setId(id);
        lojas.setLoja(loja);
        
        try {
            LojaDAO.updateLoja(lojas);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaDeErro(ex, request, response);
        }
    }

}
