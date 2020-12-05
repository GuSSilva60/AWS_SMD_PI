<%-- 
    Document   : alterarLoja
    Created on : 29/11/2020, 18:02:10
    Author     : biancagolin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Loja</title>
    </head>
    <body class="container">
        <h1>Alteração de cadastro: ${loja.loja}</h1>
        <form action="AlterarLoja" method="POST">
            <p>ID</p>
            <input name="id" value="${loja.id}" readonly="true" class="form-control"/><br/>
            <p>Nome</p>
            <input name="loja" value="${loja.loja}" class="form-control"/><br/>
            </br>
            <button type="submit" class="btn btn-primary">Enviar</button>            
        </form>
    </body>
</html>
