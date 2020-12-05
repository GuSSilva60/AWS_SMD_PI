/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.AluguelDAO;
import com.mycompany.entidade.Aluguel;
import com.mycompany.utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.io.PrintWriter;
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
 * @author vickp
 */

@WebServlet(name = "AlterarAluguel", urlPatterns = {"/AlterarAluguel"})
public class AlterarAluguel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        Aluguel aluguel = AluguelDAO.getAluguel(id);
        request.setAttribute("aluguel", aluguel);

        RequestDispatcher requestDispacher = getServletContext().getRequestDispatcher("/alterarAluguel.jsp");
        requestDispacher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String idStr = request.getParameter("id");
        String dataLocacao = request.getParameter("dataLocacao");
        String dataDevolucao = request.getParameter("dataDevolucao");
        String localRetirada = request.getParameter("localRetirada");
       // String jurosStr = request.getParameter("juros");
        String localDevolucao = request.getParameter("localDevolucao");
        String qntDiaAluguelStr = request.getParameter("qntDiaAluguel");
        String idClienteStr = request.getParameter("idCliente");
        String idCarroStr = request.getParameter("idCarro");
        int id = Integer.parseInt(idStr);
        //double juros = Double.parseDouble(jurosStr);
        int qntDiaAluguel = Integer.parseInt(qntDiaAluguelStr);
        int idCliente = Integer.parseInt(idClienteStr);
        int idCarro = Integer.parseInt(idCarroStr);
        
        Aluguel aluguel = AluguelDAO.getAluguel(id);
        aluguel.setId(id);
        aluguel.setDataLocacao(dataLocacao);
        aluguel.setDataDevolucao(dataDevolucao);
        aluguel.setLocalRetirada(localRetirada);
       // aluguel.setJuros(juros);
        aluguel.setLocalDevolucao(localDevolucao);
        aluguel.setQntDiaAluguel(qntDiaAluguel);
        aluguel.setIdCliente(idCliente);
        aluguel.setIdCarro(idCarro);
        
        try {
            AluguelDAO.updateAluguel(aluguel);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlterarAluguel.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaDeErro(ex, request, response);
        }
    }

}
