/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.ClienteDAO;
import com.mycompany.entidade.Cliente;
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
@WebServlet(name = "AlterarCliente", urlPatterns = {"/AlterarCliente"})
public class AlterarCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        Cliente cliente = ClienteDAO.getCliente(id);
        request.setAttribute("cliente", cliente);

        RequestDispatcher requestDispacher = getServletContext().getRequestDispatcher("/alterarCliente.jsp");
        requestDispacher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String cnh = request.getParameter("cnh");
        String cpf = request.getParameter("cpf");
        String idadeStr = request.getParameter("idade");
        String celular = request.getParameter("celular");
        int id = Integer.parseInt(idStr);
        int idade = Integer.parseInt(idadeStr);
        Cliente cliente = ClienteDAO.getCliente(id);
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setCnh(cnh);
        cliente.setCpf(cpf);
        cliente.setIdade(idade);
        cliente.setCelular(celular);
        
        try {
            ClienteDAO.updateCliente(cliente);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaDeErro(ex, request, response);
        }
    }
}
