<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAE Relatorios</title>
    </head>
    <body>
        <h1>Emitir Relatório Resultado Final por Aluno</h1>

        <form action="RelatorioCursoPar" method="post" name="frmRelatorioCurso" onsubmit="return validarFormulario(this)">
            Escolha o Funcionario
            <select name="optFuncionario">
                
                <c:forEach items="${funcionarios}" var="funcionario">
                    <option value="${funcionario.codFuncionario}" <c:if test="${curso.funcionario.codFuncionario == funcionario.codFuncionario}"> selected</c:if>>${funcionario.codFuncionario}</option>  
                </c:forEach>
            </select>
            <input type="submit" value="Emitir Relatório" name="btnConfirmar">            
        </form>
    </body>
</html>