<%-- 
    Document   : listaDetalhes
    Created on : 29/11/2020, 21:52:44
    Author     : biancagolin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de Alugueis</title>
        
    </head>
   <body class="container">
        <h1>Relatório - Aluguel</h1>
        <table class="table">
            <thead>
                <th>ID Aluguel</th>
                <th>Cliente</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Placa</th>
                <th>Número de Diária(s)</th>
                <th>Loja</th>
                <th>Preço Diária</th>
                <th>Preço Total Diária</th>
            </thead>  
            <tbody>
                <c:forEach var="relatorio" items="${listaDetalhesAluguel}">
                    <tr>
                        <td>${relatorio.idAluguel}</td>
                        <td>${relatorio.nomeCliente}</td>
                        <td>${relatorio.marcaCarro}</td>
                        <td>${relatorio.modeloCarro}</td>
                        <td>${relatorio.placaCarro}</td>
                        <td>${relatorio.diasAluguel}</td>
                        <td>${relatorio.loja}</td>
                        <td>${relatorio.precoDiaria}</td>
                        <td>${relatorio.precoTotalDiaria}</td>
                    </tr>
                </c:forEach>
                    
                    <tr>
                        <td><b>Total</b></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td> <c:out value="${total}"/> </td>
                        
                    </tr>
            </tbody>
        </table>
        <br/>
        <a href="index.jsp" class="btn btn-primary">Voltar</a>
    </body>
</html>
