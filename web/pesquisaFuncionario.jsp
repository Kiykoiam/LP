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
        <title>Pesquisa de Funcionario</title>
    </head>
    <body>
        <h1>Pesquisa de Funcionarios</h1>
        <table border = 1>
            <tr>
                <th>Código Funcionario</th>
                <th>Nome Funcionario</th>
                <th colspan = 2>Ação</th>
            </tr>
            <c:forEach items="${funcionarios}" var="funcionario">
            <tr>
                <td><c:out value="${funcionario.codFuncionario}" /></td>
                <td><c:out value="${funcionario.nome}" /></td>
                <td><a href="ManterFuncionarioController?acao=prepararEditar&codFuncionario=<c:out value="${funcionario.codFuncionario}"/>">Editar</a></td>
                <td><a href="ManterFuncionarioController?acao=prepararExcluir&codFuncionario=<c:out value="${funcionario.codFuncionario}"/>">Excluir</a></td>
            </tr>
        </c:forEach>
        </table>
        <form action="ManterFuncionarioController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
