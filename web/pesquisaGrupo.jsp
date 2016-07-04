<%-- 
    Document   : pesquisaGrupo
    Created on : 27/06/2016, 09:52:32
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Grupos</title>
    </head>
    <body>
        <h1>Pesquisa de Grupos</h1>
        <table border = 1>
            <tr>
                <th>Código Grupos</th>
                <th>Descrição Grupos</th>
                <th colspan = 2>Ação</th>
            </tr>
            <c:forEach items="${Grupos}" var="grupo">
            <tr>
                <td><c:out value="${grupo.CodGrupo}" /></td>
                <td><c:out value="${grupo.Descricao}" /></td>
                <td><a href="ManterGrupoController?acao=prepararOperacao&operacao=Editar&CodGrupo=<c:out value="${grupo.CodGrupo}"/>">Editar</a></td>
                <td><a href="ManterGrupoController?acao=prepararOperacao&operacao=Excluir&CodGrupo=<c:out value="${grupo.CodGrupo}"/>">Excluir</a></td>
            </tr>
        </c:forEach>
        </table>
        <form action="ManterGrupoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
