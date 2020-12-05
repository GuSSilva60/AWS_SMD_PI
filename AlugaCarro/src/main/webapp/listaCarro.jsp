<%-- 
    Document   : listaCarro
    Created on : 27/11/2020, 18:28:38
    Author     : biancagolin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista De Carros</title>
    </head>
    <script lang="text/javascript">
            function mostrarModalExclusao(id, modelo){
                console.log("mostrarModalExclusao", id);
                $("#modeloCarro").html(modelo);
                $('#idCarro').val(id);
                $('#modalExclusao').modal('show');
            }
            
            function excluirCarro() {
                var id = $('#idCarro').val();
                console.log("Deletar carro", id);
                $.get("ExcluirCarro?id="+id, function(resposta) {
                    $('#modalExclusao').modal('hide');
                    if (resposta === true) {
                        console.log("Funcionou");
                    } else {
                        console.log("Ops");
                    }
                    window.location.reload();
                });
            }
        </script>
    <body class="container">
       <h1>Lista De Carros</h1>
        <table class="table">
            <thead>
                <th>ID</th>
                <th>Modelo</th>
                <th>Marca</th>                
                <th>N.º de Portas</th>
                <th>Placa</th>
                <th>Preço</th>
                <th>Loja</th>
            </thead>  
            <tbody>
                <c:forEach var="carro" items="${listaCarro}">
                    <tr>  
                        <td>${carro.id}</td>
                        <td>${carro.modelo}</td>
                        <td>${carro.marca}</td>
                        <td>${carro.qntPortas}</td>
                        <td>${carro.placa}</td>
                        <td>${carro.preco}</td>
                        <td>${carro.nomeLoja}</td>
                        <td><a href="AlterarCarro?id=${carro.id}">Alterar</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao('${carro.id}', '${carro.modelo}')">Excluir</button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="modal fade" id="modalExclusao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Tem certeza que deseja excluir este carro <label id="modeloCarro"/></label>?
                    <input id="idCarro" hidden="true"/>                   
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="excluirCarro()">Sim</button>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        <a href="index.jsp" class="btn btn-primary">Voltar</a>
    </body>
</html>
