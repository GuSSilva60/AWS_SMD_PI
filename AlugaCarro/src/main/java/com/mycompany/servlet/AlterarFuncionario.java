/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.FuncionarioDAO;
import com.mycompany.entidade.Funcionario;
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
@WebServlet(name = "AlterarFuncionario", urlPatterns = {"/AlterarFuncionario"})
public class AlterarFuncionario extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        Funcionario funcionario = FuncionarioDAO.getFuncionario(id);
        request.setAttribute("funcionario", funcionario);

        RequestDispatcher requestDispacher = getServletContext().getRequestDispatcher("/alterarFuncionario.jsp");
        requestDispacher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String cargoStr = request.getParameter("cargo");
        String idLojaStr = request.getParameter("idLoja");
        int id = Integer.parseInt(idStr);
        int cargo = Integer.parseInt(cargoStr);
        int idLoja = Integer.parseInt(idLojaStr);
        Funcionario funcionario = FuncionarioDAO.getFuncionario(id);
        funcionario.setId(id);
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setIdLoja(idLoja);
        
        try {
            FuncionarioDAO.updateFuncionario(funcionario);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaDeErro(ex, request, response);
        }
    }

}
