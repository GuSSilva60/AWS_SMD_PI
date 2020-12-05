<%-- 
    Document   : cadastrarCarro
    Created on : 27/11/2020, 21:08:24
    Author     : biancagolin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Carro</title>
    </head>
    <body class="container">
        <h1>Cadastro Carro</h1>
        <form action="CadastrarCarro" method="POST">
            <p>Marca</p>
            <input name="marca" class="form-control" required="true"/><br/>
            <p>Modelo</p>
            <input name="modelo" class="form-control" required="true"/><br/>
            <p>Número de Portas</p>
            <input name="qntPortas" class="form-control" required="true"/><br/>
            <p>Placa</p>
            <input name="placa" class="form-control" required="true"/><br/>
            <p>Valor Diária</p>
            <input name="preco" class="form-control" required="true"/><br/>
        <label for="cars">Escolha uma loja:</label>
        <select name="idLoja" id="loja">
          <option value="1">1 - São Paulo</option>
          <option value="2">2 - Campo Grande</option>
          <option value="3">3 - Joinville</option>
          <option value="4">4 - Brasília</option>
        </select>
        </br>
        <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </body>
</html>
