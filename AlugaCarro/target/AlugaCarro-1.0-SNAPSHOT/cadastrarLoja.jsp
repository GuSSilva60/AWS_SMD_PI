<%-- 
    Document   : cadastrarLoja
    Created on : 29/11/2020, 13:37:34
    Author     : biancagolin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Loja</title>
    </head>
    <body class="container">
        <h1>Cadastro</h1>
        <form action="CadastrarLoja" method="POST">
            <p>Nome Loja</p>
            <input name="loja" class="form-control" required="true"/><br/>
            </br>
            <button type="submit" class="btn btn-primary">Enviar</button>            
        </form>
    </body>
</html>
