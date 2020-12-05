<%-- 
    Document   : cadastrarFuncionario
    Created on : 29/11/2020, 13:26:48
    Author     : biancagolin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Funcionario</title>
    </head>
    <body class="container">
        <h1>Cadastro</h1>
        <form action="CadastrarFuncionario" method="POST">
            <p>Nome</p>
            <input name="nome" class="form-control" required="true"/><br/>
            <p>Cargo</p>
            <input name="cargo" class="form-control" required="true"/><br/>
            <p>Loja</p>
            <input name="idLoja" class="form-control" required="true"/><br/>
            </br>
            <button type="submit" class="btn btn-primary">Enviar</button>            
        </form>
    </body>
</html>
