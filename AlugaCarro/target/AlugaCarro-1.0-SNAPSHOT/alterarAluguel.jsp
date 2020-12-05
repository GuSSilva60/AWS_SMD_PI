<%-- 
    Document   : alterarAluguel
    Created on : 29/11/2020, 11:54:25
    Author     : biancagolin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Aluguel</title>
    </head>
    <body class="container">
        <h1>Alteração de aluguel: ${aluguel.id}</h1>
        <form action="AlterarAluguel" method="POST">
            <p>ID</p>
            <input name="id" value="${aluguel.id}" readonly="true" class="form-control"/><br/>
            <p>Data de locação</p>
            <input name="dataLocacao" value="${aluguel.dataLocacao}" class="form-control"/><br/>
            <p>Data de devolução</p>
            <input name="dataDevolucao" value="${aluguel.dataDevolucao}" class="form-control"/><br/>
            <p>Local de Retirada</p>
            <input name="localRetirada" value="${aluguel.localRetirada}" class="form-control"/><br/>
            <p>Local de devolução</p>
            <input name="localDevolucao" value="${aluguel.localDevolucao}" class="form-control"/><br/>
            <p>Número de Diária(s)</p>
            <input name="qntDiaAluguel" value="${aluguel.qntDiaAluguel}" class="form-control"/><br/>
            <p>Cliente</p>
            <input name="idCliente" value="${aluguel.idCliente}" class="form-control"/><br/>
            <p>Carro</p>
            <input name="idCarro" value="${aluguel.idCarro}" class="form-control"/><br/>
            </br>
            <button type="submit" class="btn btn-primary">Enviar</button>

        </form>
    </body>
</html>
