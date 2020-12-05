<%-- 
    Document   : listaDemanda
    Created on : 30/11/2020, 18:13:58
    Author     : biancagolin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos Mais Alugados</title>
    </head>
    <body class="container">
        <h1>Produtos Mais Alugados</h1>
        <table class="table">
            <thead>
            <th>Modelo</th>
            <th>Quantidade</th>
            </thead>
            <tbody>
                <c:forEach var="demanda" items="${listaDemanda}">
                    <tr>
                        <td><c:out value="${demanda.modeloCarro}"/></td>
                        <td>${demanda.carro}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
