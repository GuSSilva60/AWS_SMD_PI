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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author biancagolin
 */

@WebServlet(name = "CadastrarCarro", urlPatterns = {"/CadastrarCarro"})
public class CadastrarCarro extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String qntPortasStr = request.getParameter("qntPortas");
        String placa = request.getParameter("placa");
        String precoStr = request.getParameter("preco");
        String idLojaStr = request.getParameter("idLoja");
        int qntPortas = Integer.parseInt(qntPortasStr);
        double preco = Double.parseDouble(precoStr);
        int idLoja = Integer.parseInt(idLojaStr);
        
        Carro carro = new Carro(marca, modelo, qntPortas, placa, preco, idLoja);
        try {
            CarroDAO.addCarro(carro);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCarro.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaDeErro(ex, request, response);
        }
    }
}
