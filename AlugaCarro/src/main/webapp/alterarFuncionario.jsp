<%-- 
    Document   : alterarFuncionario
    Created on : 29/11/2020, 14:44:21
    Author     : biancagolin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Funcionário</title>
    </head>
    <body class="container">
        <h1>Alteração de cadastro: ${funcionario.nome}</h1>
        <form action="AlterarFuncionario" method="POST">
            <p>ID</p>
            <input name="id" value="${funcionario.id}" readonly="true" class="form-control"/><br/>
            <p>Nome</p>
            <input name="nome" value="${funcionario.nome}" class="form-control"/><br/>
            <p>Cargo</p>
            <input name="cargo" value="${funcionario.cargo}" class="form-control"/><br/>
            <p>Loja</p>
            <input name="idLoja" value="${funcionario.idLoja}" lass="form-control"/><br/>
            </br>
            <button type="submit" class="btn btn-primary">Enviar</button>            
        </form>
    </body>
</html>
