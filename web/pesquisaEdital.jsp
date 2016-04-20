<%-- 
    Document   : pesquisaCurso
    Created on : 05/11/2015, 10:25:17
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Editais</title>
    </head>
    <body>
        <h1>Pesquisa de Editais</h1>
        <table border = 1>
            <tr>
                <th>Código Edital</th>
                <th>Ano Edital</th>
                <th colspan = 2>Ação</th>
            </tr>
            <c:forEach items="${editais}" var="edital">
            <tr>
                <td><c:out value="${edital.codEdital}" /></td>
                <td><c:out value="${edital.ano}" /></td>
                <td><a href="ManterEditalController?acao=prepararEditar&codEdital=<c:out value="${edital.codEdital}"/>">Editar</a></td>
                <td><a href="ManterEditalController?acao=prepararExcluir&codEdital=<c:out value="${edital.codEdital}"/>">Excluir</a></td>
            </tr>
        </c:forEach>
        </table>
        <form action="ManterEditalController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
