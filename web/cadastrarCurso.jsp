<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
    <head >
        <title> SAE </title>
        <meta "charset=utf-8" />
        <meta name="author" content="Milton Bogado Neto e Frederico Belluzzo"/>
        <meta name="description" content=" Sistema de Apoio Estudantil "/>
    </head>
    <body>		
        <h1> Cadastrar Curso ${operacao} </h1>
        <form action="ManterCursoController?acao=confirmar${operacao}" method="post" name="frmManterCurso" onsubmit="return validarFormulario(this)">
            <table >

                <tr>
                    <td>Código Curso</td>
                    <td> <input type="text" name="txtCodCurso" value="${curso.codCurso}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Curso</td>
                        <td><input type="text" name="txtNomeCurso" value="${curso.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Total de períodos</td>
                        <td><input type="text"  name="txtTotalPeriodos" value="${curso.totalPeriodos}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Carga Horário</td>
                        <td><input type="text"name="txtCargaHoraria" value="${curso.cargaHoraria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Tipo Curso:</td> 
                        <td>
                            <select name="optTipoCurso" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Técnico" <c:if test="${curso.tipoCurso == 'Técnico'}"> selected</c:if>>Técnico</option>
                            <option value="Integrado" <c:if test="${curso.tipoCurso == 'Integrado'}"> selected</c:if>>Integrado</option>
                            <option value="Superior" <c:if test="${curso.tipoCurso == 'Superior'}"> selected</c:if>>Superior</option>
                            </select>
                        </td>

                    </tr>
                    <tr>
                        <td>Funcionario</td>
                        <td>
                            <select name="optFuncionario" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                             
                            <c:forEach items="${funcionario}" var="funcionario">
                                <option value="${funcionario.codFuncionario}" <c:if test="${curso.funcionario.codFuncionario == funcionario.codFuncionario}"> selected</c:if>>${funcionario.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input value="Finalizar Cadastro" type="submit" name="btnConfirmar" /></td>
                    <td><input value="Cancelar Cadastro" type="submit" name="btnCancelar" /></td>

                </tr>
            </table>
        </form>
        <SCRIPT language="JavaScript">
<!--

            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++)
                {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) == -1)
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) {
                var mensagem;
                mensagem = "";
                if (form.txtCodCurso.value == "") {
                    mensagem = mensagem + "Informe o Código do curso\n";
                }
                if (form.txtNomeCurso.value == "") {
                    mensagem = mensagem + "Informe o Nome do curso\n";
                }
                if (form.txtTotalPeriodos.value == "") {
                    mensagem = mensagem + "Informe o total dos periodos\n";
                }
                if (form.txtCargaHoraria.value == "") {
                    mensagem = mensagem + "Informe a carga horaria\n";
                }
                if (form.optTipoCurso.value == "") {
                    mensagem = mensagem + "Informe o tipo do curso\n";
                }
                if (form.optFuncionario.value == "") {
                    mensagem = mensagem + "Informe o funcionario \n";
                }
                if (!campoNumerico(form.txtCodCurso.value)) {
                    mensagem = mensagem + "Código do Curso deve ser numérico\n";
                }
                 if (!campoNumerico(form.txtTotalPeriodos.value)) {
                    mensagem = mensagem + "Total periodos deve ser número\n";
                }
                 if (!campoNumerico(form.txtCargaHoraria.value)) {
                    mensagem = mensagem + "CCarga horária do curso deve ser número!o\n";
                }
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
//-->
        </SCRIPT> 



    </body>
    <html>