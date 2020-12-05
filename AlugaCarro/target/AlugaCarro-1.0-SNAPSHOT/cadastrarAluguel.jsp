<%-- 
    Document   : cadastrarAluguel
    Created on : 28/11/2020, 00:29:51
    Author     : biancagolin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Aluguel</title>
    </head>
    <body class="container">
         <h1>Cadastro Aluguel</h1>
        <form action="CadastrarAluguel" method="POST">
            <p>Data de locação</p>
            <input name="dataLocacao" class="form-control" required="true"/><br/>
            <p>Data de devolução</p>
            <input name="dataDevolucao" class="form-control" required="true"/><br/>
            <p>Juros</p>
            <input name="juros" class="form-control" required="true"/><br/>
            <p>Local de Retirada</p>
            <input name="localRetirada" class="form-control" required="true"/><br/>
            <p>Local de Devolução</p>
            <input name="localDevolucao" class="form-control" required="true"/><br/>
            <p>Dias de Aluguel</p>
            <input name="qntDiaAluguel" class="form-control" required="true"/><br/>
            <p>Cliente</p>
            <input name="idCliente" class="form-control" required="true"/><br/>
            <p>Carro</p>
            <input name="idCarro" class="form-control" required="true"/><br/>
            </br>
            <button type="submit" class="btn btn-primary">Enviar</button>
            
        </form>
    </body>
</html>
