/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.ClienteDAO;
import com.mycompany.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author biancagolin
 */

@WebServlet(name = "ExcluirCliente", urlPatterns = {"/ExcluirCliente"})
public class ExcluirCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        try {
            ClienteDAO.deleteCliente(id);
            response.getWriter().print(true);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExcluirCliente.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().print(false);
        }
    }
}
