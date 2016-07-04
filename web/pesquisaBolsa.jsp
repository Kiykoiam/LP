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
        <title>Pesquisa de Bolsas</title>
    </head>
    <body>
        <h1>Pesquisa de Bolsas</h1>
        <table border = 1>
            <tr>
                <th>Código Bolsas</th>
                <th>Nome Bolsa</th>
                <th colspan = 2>Ação</th>
            </tr>
            <c:forEach items="${bolsas}" var="bolsa">
            <tr>
                <td><c:out value="${bolsa.codBolsa}" /></td>
                <td><c:out value="${bolsa.nome}" /></td>
                <td><a href="ManterBolsaController?acao=prepararOperacao&operacao=Editar&codBolsa=<c:out value="${bolsa.codBolsa}"/>">Editar</a></td>
                <td><a href="ManterBolsaController?acao=prepararOperacao&operacao=Excluir&codBolsa=<c:out value="${bolsa.codBolsa}"/>">Excluir</a></td>
            </tr>
        </c:forEach>
        </table>
        <form action="ManterBolsaController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
