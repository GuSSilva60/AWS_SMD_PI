<%-- 
    Document   : index
    Created on : 27/11/2020, 16:44:50
    Author     : biancagolin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora de Carros</title>
    </head>
    <body>
        
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img class="d-block w-100" src="img/up.jpg" alt="Primeiro Slide">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="img/versa.jpg" alt="Segundo Slide">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="img/volvo.jpg" alt="Terceiro Slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Anterior</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Próximo</span>
            </a>
        </div>
        <%--<h1>Menu</h1>
        <a href="ListarClientes">Listar Clientes</a>
        <br/>
        <a href="cadastrarCliente.jsp">Cadastrar Clientes</a><br/>
        <a href="ListarCarro">Listar Carros</a>
        <br/>
        <a href="cadastrarCarro.jsp">Cadastrar Carros</a><br/>
        <a href="ListarAluguel">Listar Aluguel</a>
        <br/>
        <a href="cadastrarAluguel.jsp">Cadastrar Aluguel</a><br/>
                --%>
    </body>
</html>
