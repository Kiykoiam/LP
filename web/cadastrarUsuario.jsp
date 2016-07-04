-<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1> Cadastrar Usuário ${operacao} </h1>
        <form action="ManterUsuarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterUsuario" onsubmit="return validarFormulario(this)">
            <table >

                <tr>
                    <td>Código Usuário</td>
                    <td> <input type="text" name="txtCodUsuario" value="${usuario.CodUsuario}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Usuário</td>
                        <td><input type="text" name="txtNomeUsuario" value="${usuario.Nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Senha</td>
                        <td><input type="password"  name="txtSenha" value="${usuario.Senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Confirma Senha </td>
                        <td><input type="password"name="txtConfirmaSenha" value="${usuario.ConfirmacaoSenha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    
                    <tr>
                        <td>Grupo</td>
                        <td>
                            <select name="optGrupo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                             
                            <c:forEach items="${grupo}" var="grupo">
                                <option value="${grupo.CodGrupo}" <c:if test="${usuario.grupoCodGrupo.CodGrupo == grupo.CodGrupo}"> selected</c:if>>${funcionario.nome}</option>  
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