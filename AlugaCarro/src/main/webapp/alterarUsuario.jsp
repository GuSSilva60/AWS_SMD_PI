<%-- 
    Document   : alterarUsuario
    Created on : 29/11/2020, 18:24:00
    Author     : biancagolin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Usuario</title>
    </head>
    <body class="container">
        <h1>Alteração de cadastro: ${usuario.email}</h1>
        <form action="AlterarUsuario" method="POST">
            <p>ID</p>
            <input name="id" value="${usuario.id}" readonly="true" class="form-control"/><br/>
            <p>Email</p>
            <input name="email" value="${usuario.email}" class="form-control"/><br/>
            <p>Senha</p>
            <input type="password" name="senha" value="${usuario.senha}" class="form-control"/><br/>
            <p>ID Funcionário</p>
            <input name="idFuncionario" value="${usuario.idFuncionario}" readonly="true" class="form-control"/><br/>
            </br>
            <button type="submit" class="btn btn-primary">Enviar</button>            
        </form>
    </body>
</html>
