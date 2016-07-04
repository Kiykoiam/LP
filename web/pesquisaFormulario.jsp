<%-- 
    Document   : pesquisaFormulario
    Created on : 21/12/2015, 18:51:51
    Author     : Frederico Belluzzo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Formularios</title>
    </head>
    <body>
        <h1>Pesquisa de Formularios</h1>
        <table border = 1>
            <tr>
                <th>Código Formulario</th>
                <th>Nome Candidato</th>
                <th colspan = 2>Ação</th>
            </tr>
            <c:forEach items="${formularios}" var="formulario">
            <tr>
                <td><c:out value="${formulario.codForm}" /></td>
                <td><c:out value="${formulario.cANDIDATOcodCandidato.nome}" /></td>
                <td><a href="ManterFormularioController?acao=prepararOperacao&operacao=Editar&codForm=<c:out value="${formulario.codForm}"/>">Editar</a></td>
                <td><a href="ManterFormularioController?acao=prepararOperacao&operacao=Excluir&codForm=<c:out value="${formulario.codForm}"/>">Excluir</a></td>
            </tr>
        </c:forEach>
        </table>
        <form action="ManterFormularioController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
