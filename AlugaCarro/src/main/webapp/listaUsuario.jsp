<%-- 
    Document   : listaUsuario
    Created on : 29/11/2020, 14:27:30
    Author     : biancagolin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Usuario</title>
        
        <script lang="text/javascript">
            function mostrarModalExclusao(id, email){
                console.log("mostrarModalExclusao", id);
                $("#emailUsuario").html(email);
                $('#idUsuario').val(id);
                $('#modalExclusao').modal('show');
            }
            
            function excluirUsuario() {
                var id = $('#idUsuario').val();
                console.log("Deletar cliente", id);
                $.get("ExcluirUsuario?id="+id, function(resposta) {
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
        <h1>Lista de Usuarios</h1>
        <table class="table">
            <thead>
                <th>ID</th>
                <th>E-mail</th>
                <th>Nome Funcionário</th>
            </thead>  
            <tbody>
                <c:forEach var="usuario" items="${listaUsuario}">
                    <tr>
                        <td>${usuario.id}</td>
                        <td>${usuario.email}</td>
                        <td>${usuario.nomeFuncionario}</td>
                        <td><a href="AlterarUsuario?id=${usuario.id}">Alterar</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao('${usuario.id}', '${usuario.email}')">Excluir</button></td>
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
                        Tem certeza que deseja excluir cliente <label id="emailUsuario"/></label>?
                    <input id="idUsuario" hidden="true"/>                   
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="excluirUsuario()">Sim</button>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        <a href="index.jsp" class="btn btn-primary">Voltar</a>
    </body>
</html>
