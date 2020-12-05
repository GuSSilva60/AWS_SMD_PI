<%-- 
    Document   : cadastrarUsuario
    Created on : 29/11/2020, 13:41:59
    Author     : biancagolin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Usuario</title>
    </head>
<body class="container">
        <h1>Cadastro</h1>
        <form action="CadastrarUsuario" method="POST">
            <p>E-mail</p>
            <input name="email" class="form-control" required="true"/><br/>
            <p>Senha</p>
            <input type="password" name="senha" class="form-control" required="true"/><br/>
            <p>ID Funcionário</p>
            <input name="idFuncionario" class="form-control" required="true"/><br/>
            </br>
            <button type="submit" class="btn btn-primary">Enviar</button>            
        </form>
    </body>
</html>
