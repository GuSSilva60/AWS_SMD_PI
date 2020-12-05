/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.dao.CarroDAO;
import com.mycompany.entidade.Carro;
import com.mycompany.utils.Utils;
import java.io.IOException;
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
 * @author vickp
 */

@WebServlet(name = "AlterarCarro", urlPatterns = {"/AlterarCarro"})
public class AlterarCarro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        Carro carro = CarroDAO.getCarro(id);
        request.setAttribute("carro", carro);

        RequestDispatcher requestDispacher = getServletContext().getRequestDispatcher("/alterarCarro.jsp");
        requestDispacher.forward(request, response);
        
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String qntPortasStr = request.getParameter("qntPortas");
        String placa = request.getParameter("placa");
        String precoStr = request.getParameter("preco");
        String idLojaStr = request.getParameter("idLoja");
        int id = Integer.parseInt(idStr);
        int qntPortas = Integer.parseInt(qntPortasStr);
        int idLoja = Integer.parseInt(idLojaStr);
        double preco = Double.parseDouble(precoStr);
        Carro carro = CarroDAO.getCarro(id);
        carro.setMarca(marca);
        carro.setMarca(modelo);
        carro.setQntPortas(qntPortas);
        carro.setPlaca(placa);
        carro.setPreco(preco);
        
        try {
            CarroDAO.updateCarro(carro);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlterarCarro.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaDeErro(ex, request, response);
        }
    }
}
