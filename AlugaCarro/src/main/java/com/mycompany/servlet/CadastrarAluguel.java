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
 * @author vickp
 */

@WebServlet(name = "CadastrarAluguel", urlPatterns = {"/CadastrarAluguel"})
public class CadastrarAluguel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dataLocacao = request.getParameter("dataLocacao");
        String dataDevolucao = request.getParameter("dataDevolucao");
        String localRetirada = request.getParameter("localRetirada");
        String jurosStr = request.getParameter("juros");
        String localDevolucao = request.getParameter("localDevolucao");
        String qntDiaAluguelStr = request.getParameter("qntDiaAluguel");
        String idClienteStr = request.getParameter("idCliente");
        String idCarroStr = request.getParameter("idCarro");
        double juros = Double.parseDouble(jurosStr);
        int qntDiaAluguel = Integer.parseInt(qntDiaAluguelStr);
        int idCliente = Integer.parseInt(idClienteStr);
        int idCarro = Integer.parseInt(idCarroStr);

        Aluguel aluguel = new Aluguel(dataLocacao, dataDevolucao, juros, localRetirada, localDevolucao, qntDiaAluguel, idCliente, idCarro);
        try {
            AluguelDAO.addAluguel(aluguel);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarAluguel.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaDeErro(ex, request, response);
        }
    }
   

}
