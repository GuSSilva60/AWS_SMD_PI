<%-- 
    Document   : alterarCarro
    Created on : 29/11/2020, 11:34:13
    Author     : biancagolin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Carro</title>
    </head>
    <body class="container">
        <h1>Alteração de cadastro de carro: ${carro.marca}</h1>
        <form action="AlterarCarro" method="POST">
            <p>ID</p>
            <input name="id" value="${carro.id}" readonly="true" class="form-control"/><br/>
            <p>Marca</p>
            <input name="marca" value="${carro.marca}" class="form-control"/><br/>
            <p>Modelo</p>
            <input name="modelo" value="${carro.modelo}" class="form-control"/><br/>
            <p>Portas</p>
            <input name="qntPortas" value="${carro.qntPortas}" class="form-control"/><br/>
            <p>Placa</p>
            <input name="placa" value="${carro.placa}" readonly="true" class="form-control"/><br/>
            <p>Preço</p>
            <input name="preco" value="${carro.preco}" class="form-control"/><br/>
            <p>Loja</p>
            <input name="idLoja" value="${carro.idLoja}" class="form-control"/><br/>
            </br>
            <button type="submit" class="btn btn-primary">Enviar</button>
            
        </form>
</html>
