<%-- 
    Document   : pesquisaUsuario
    Created on : 27/06/2016, 09:48:44
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Usuarios</title>
    </head>
    <body>
        <h1>Pesquisa de Usuarios</h1>
        <table border = 1>
            <tr>
                <th>Código Usuarios</th>
                <th>Nome Usuarios</th>
                <th colspan = 2>Ação</th>
            </tr>
            <c:forEach items="${usuarios}" var="usuario">
            <tr>
                <td><c:out value="${usuario.CodUsuario}" /></td>
                <td><c:out value="${usuario.Nome}" /></td>
                <td><a href="ManterUsuarioController?acao=prepararOperacao&operacao=Editar&CodUsuario=<c:out value="${usuario.CodUsuario}"/>">Editar</a></td>
                <td><a href="ManterUsuarioController?acao=prepararOperacao&operacao=Excluir&CodUsuario=<c:out value="${usuario.CodUsuario}"/>">Excluir</a></td>
            </tr>
        </c:forEach>
        </table>
        <form action="ManterUsuarioController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
