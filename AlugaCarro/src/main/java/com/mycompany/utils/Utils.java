/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author biancagolin
 */
public class Utils {
        public static void mostrarTelaDeErro(Exception ex, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String msgErro = ex.getMessage();
            request.setAttribute("msgErro", msgErro);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/erro.jsp");
            requestDispatcher.forward(request, response);
    }

    public static void mostrarTelaDeSucesso(HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("sucesso.jsp");
    }
}
