<%-- 
    Document   : listaClientes
    Created on : 27/11/2020, 15:38:57
    Author     : biancagolin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        
        <script lang="text/javascript">
            function mostrarModalExclusao(id, nome){
                console.log("mostrarModalExclusao", id);
                $("#nomeCliente").html(nome);
                $('#idCliente').val(id);
                $('#modalExclusao').modal('show');
            }
            
            function excluirCliente() {
                var id = $('#idCliente').val();
                console.log("Deletar cliente", id);
                $.get("ExcluirCliente?id="+id, function(resposta) {
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
    </head>
    <body class="container">
        <h1>Lista de Clientes</h1>
        <table class="table">
            <thead>
                <th>ID</th>
                <th>Nome</th>
                <th>CNH</th>
                <th>CPF</th>
                <th>Idade</th>
                <th>Celular</th>
            </thead>  
            <tbody>
                <c:forEach var="cliente" items="${listaClientes}">
                    <tr>
                        <td>${cliente.id}</td>
                        <td>${cliente.nome}</td>
                        <td>${cliente.cnh}</td>
                        <td>${cliente.cpf}</td>
                        <td>${cliente.idade}</td>
                        <td>${cliente.celular}</td>
                        <td><a href="AlterarCliente?id=${cliente.id}">Alterar</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao('${cliente.id}', '${cliente.nome}')">Excluir</button></td>
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
                        Tem certeza que deseja excluir cliente <label id="nomeCliente"/></label>?
                    <input id="idCliente" hidden="true"/>                   
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="excluirCliente()">Sim</button>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        <a href="index.jsp" class="btn btn-primary">Voltar</a>
    </body>
</html>
