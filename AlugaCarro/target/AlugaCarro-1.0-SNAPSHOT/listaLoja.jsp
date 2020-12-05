<%-- 
    Document   : listaLoja
    Created on : 29/11/2020, 14:17:32
    Author     : biancagolin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Loja</title>
        
        <script lang="text/javascript">
            function mostrarModalExclusao(id, loja){
                console.log("mostrarModalExclusao", id);
                $("#nomeLoja").html(loja);
                $('#idFilial').val(id);
                $('#modalExclusao').modal('show');
            }
            
            function excluirCliente() {
                var id = $('#idFilial').val();
                console.log("Deletar cliente", id);
                $.get("ExcluirLoja?id="+id, function(resposta) {
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
        <h1>Lista de Lojas</h1>
        <table class="table">
            <thead>
                <th>ID</th>
                <th>Nome</th>
            </thead>  
            <tbody>
                <c:forEach var="loja" items="${listaLoja}">
                    <tr>
                        <td>${loja.id}</td>
                        <td>${loja.loja}</td>
                        <td><a href="AlterarLoja?id=${loja.id}">Alterar</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao('${loja.id}', '${loja.loja}')">Excluir</button></td>
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
                        Tem certeza que deseja excluir cliente <label id="nomeLoja"/></label>?
                    <input id="idFilial" hidden="true"/>                   
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
