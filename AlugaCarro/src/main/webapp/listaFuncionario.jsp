<%-- 
    Document   : listaFuncionario
    Created on : 29/11/2020, 13:59:21
    Author     : biancagolin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Funcionários</title>
        <script lang="text/javascript">
            function mostrarModalExclusao(id, nome){
                console.log("mostrarModalExclusao", id);
                $("#nomeFuncionario").html(nome);
                $('#idEmpregado').val(id);
                $('#modalExclusao').modal('show');
            }
            
            function excluirCliente() {
                var id = $('#idEmpregado').val();
                console.log("Deletar cliente", id);
                $.get("ExcluirFuncionario?id="+id, function(resposta) {
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
        <h1>Lista de Funcionários</h1>
        <table class="table">
            <thead>
                <th>Nome</th>
                <th>Cargo</th>
                <th>ID Loja</th>
            </thead>  
            <tbody>
                <c:forEach var="funcionario" items="${listaFuncionario}">
                    <tr>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.getCargoNome()}</td>
                        <td>${funcionario.nomeLoja}</td>
                        <td><a href="AlterarFuncionario?id=${funcionario.id}">Alterar</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao('${funcionario.id}', '${funcionario.nome}')">Excluir</button></td>
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
                        Tem certeza que deseja excluir cliente <label id="nomeFuncionario"/></label>?
                    <input id="idEmpregado" hidden="true"/>                   
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
