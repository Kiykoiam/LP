<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr> 
                <td>Bolsa por Modalidade:
                    <form action="RelatorioCursoPar" method="post">
                        <select name="optFuncionario">
                            <option value="0" <c:if test="${funcionario.codFuncionario == null}"> selected</c:if>> </option>  
                            <c:forEach items="${funcionarios}" var="funcionario">
                                <option value="${funcionario.codFuncionario}" <c:if test="${curso.funcionario.codFuncionario == funcionario.codFuncionario}"> selected</c:if>>${funcionario.codFuncionario}</option>  
                            </c:forEach>                    
                            <input type="submit" name="" value="Gerar Relatório Curso Parametro"/>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>