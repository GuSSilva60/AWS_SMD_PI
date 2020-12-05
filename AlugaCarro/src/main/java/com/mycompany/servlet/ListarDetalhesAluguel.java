/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;


import com.mycompany.dao.DetalhesAluguelDAO;
import com.mycompany.entidade.DetalhesAluguel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author biancagolin
 */
@WebServlet(name = "ListarDetalhesAluguel", urlPatterns = {"/ListarDetalhesAluguel"})
public class ListarDetalhesAluguel extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        
        List<DetalhesAluguel> listaDetalhesAluguel = DetalhesAluguelDAO.getDetalhesAluguel();
        request.setAttribute("listaDetalhesAluguel", listaDetalhesAluguel);
        
        Double total = 0.0;
        for(DetalhesAluguel detalhe : listaDetalhesAluguel){
            total += detalhe.getPrecoTotalDiaria();
        }
        
        request.setAttribute("total", total);
        
        RequestDispatcher requestDispacher = getServletContext()
                .getRequestDispatcher("/listaDetalhes.jsp");
        requestDispacher.forward(request, response);
    }

}