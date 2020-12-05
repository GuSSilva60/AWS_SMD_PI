<%-- 
    Document   : listaAluguel
    Created on : 27/11/2020, 20:11:19
    Author     : biancagolin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista De Alugueis</title>
    </head>
     <script lang="text/javascript">
            function mostrarModalExclusao(id, idCliente){
                console.log("mostrarModalExclusao", id, idCliente);
                $("#idCliente").html(idCliente);
                $('#idAluguel').val(id);
                $('#modalExclusao').modal('show');
            }
            
            function excluirAluguel() {
                var id = $('#idAluguel').val();
                console.log("Deletar aluguel", id);
                $.get("ExcluirAluguel?id="+id, function(resposta) {
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
       <h1>Lista De Alugueis</h1>
        <table class="table">
            <thead>
                <th>ID Aluguel</th>
                <th>Data de locação</th>
                <th>Data de devolução</th>
                <th>Local Retirada</th>
                <th>Local Devolução</th>
                <th>Número de Diária(s)</th>
                <th>Cliente</th>
                <th>Carro</th>
            </thead>  
            <tbody>
                <c:forEach var="aluguel" items="${listaAluguel}">
                    <tr>
                        <td>${aluguel.id}</td>
                        <td>${aluguel.dataLocacao}</td>
                        <td>${aluguel.dataDevolucao}</td>
                        <td>${aluguel.localRetirada}</td>
                        <td>${aluguel.localDevolucao}</td>
                        <td>${aluguel.qntDiaAluguel}</td>
                        <td>${aluguel.nomeCliente}</td>
                        <td>${aluguel.nomeCarro}</td>
                        <td><a href="AlterarAluguel?id=${aluguel.id}">Alterar</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao('${aluguel.id}', '${aluguel.idCliente}')">Excluir</button></td>
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
                        Tem certeza que deseja excluir este registro de aluguel <label id="idCliente"/></label>?
                    <input id="idAluguel" hidden="true"/>                   
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="excluirAluguel()">Sim</button>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        <a href="index.jsp" class="btn btn-primary">Voltar</a>
    </body>
</html>
