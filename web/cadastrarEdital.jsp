<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
    <head >
        <title> SAE </title>
        <meta name="author" content="Milton Bogado Neto e Frederico Belluzzo"/>
        <meta name="description" content=" Sistema de Apoio Estudantil "/>
    </head>
    <body>		
        <h1> Cadastrar Edital ${operacao} </h1>
        <form action="ManterEditalController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterEdital" onsubmit="return validarFormulario(this)">
            <table >

                <tr>
                    <td>Código Edital</td>
                    <td> <input type="text" name="txtCodEdital" value="${edital.codEdital}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Ano </td>
                        <td><input type="text" name="txtAnoEdital" value="${edital.ano}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Descrição</td>
                        <td><input type="text"  name="txtDescricao" value="${edital.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Categoria</td>
                        <td><input type="text"name="txtCategoria" value="${edital.categoria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Número</td>
                        <td><input type="text"name="txtNumero" value="${edital.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                </tr>
                <tr>
                <td>Funcionario</td>
                        <td>
                            <select name="optFuncionario" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                             
                            <c:forEach items="${funcionario}" var="funcionario">
                                <option value="${funcionario.codFuncionario}" <c:if test="${edital.fUNCIONARIOcodFuncionario.codFuncionario == funcionario.codFuncionario}"> selected</c:if>>${funcionario.nome}</option>  
                            </c:forEach>
                        </select>
                </tr>
                <tr>
                <td>Bolsa</td>
                        <td>
                            <select name="optBolsa" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                             
                            <c:forEach items="${bolsa}" var="bolsa">
                                <option value="${bolsa.codBolsa}" <c:if test="${edital.bOLSAcodBolsa.codBolsa == bolsa.codBolsa}"> selected</c:if>>${bolsa.nome}</option>  
                            </c:forEach>
                        </select>
                </tr>
                
                <tr>
                    <td><input value="Finalizar Cadastro" type="submit" /></td>
                    <td><input value="Cancelar Cadastro" type="submit" /></td>

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
                if (form.txtCodEdital.value == "") {
                    mensagem = mensagem + "Informe o Código do edital\n";
                }
                if (form.txtAnoEdital.value == "") {
                    mensagem = mensagem + "Informe o ano do edital\n";
                }
                if (form.txtDescricao.value == "") {
                    mensagem = mensagem + "Informe descrição do edital\n";
                }
                if (form.txtCategoria.value == "") {
                    mensagem = mensagem + "Informe a categoria\n";
                }
                if (form.txtNumero.value == "") {
                    mensagem = mensagem + "Informe o numero\n";
                }
               
                if (!campoNumerico(form.txtNumero.value)) {
                    mensagem = mensagem + "Numero do Edital deve ser numérico\n";
                }
                  if (!campoNumerico(form.txtCodEdital.value)) {
                    mensagem = mensagem + "Código do Edital deve ser numérico\n";
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