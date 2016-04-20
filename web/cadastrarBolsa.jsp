<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
    <head>
        <title> SAE </title>        
        <meta name="author" content="Milton Bogado Neto e Frederico Belluzzo"/>
        <meta name="description" content=" Sistema de Apoio Estudantil "/>
    </head>
    <body>
<h1> Cadastrar Bolsa  ${operacao}</h1>

<form action="ManterBolsaController?acao=confirmar${operacao}" method="post" name="frmManterBolsa" onsubmit="return validarFormulario(this)">
    <table>
        <tr>
            <td>Código Bolsa</td>
            <td> <input type="text" name="txtCodBolsa" value="${bolsa.codBolsa}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
        </tr>

        <tr>
            <td>Nome da bolsa :</td>
            <td><input type="text" name="txtNomeBolsa" value="${bolsa.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
        </tr>
        <tr>
            <td>Quantidade de vagas:</td>
            <td><input type="text" name="txtQtdadeVagasBolsa" value="${bolsa.qtdadeVagas}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
        </tr>
        <tr>
            <td>Descrição:</td>
            <td><input type="text" name="txtDescricaoBolsa" value="${bolsa.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
        </tr>
        <tr>
            <td>Requisitos</td>
            <td><input type="text"name="txtRequisitosBolsa" value="${bolsa.requisitos}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
        </tr>


        <tr>
            <td><input value="Confirmar " type="submit" name="btnConfirmar"></td>           
            
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
                if (form.txtCodBolsa.value == ""){
                    mensagem = mensagem + "Informe o Código da Bolsa\n";
                }                             
                if (form.txtNomeBolsa.value == ""){
                    mensagem = mensagem + "Informe o Nome da Bolsa\n";
                }             
                if (form.txtQtdadeVagasBolsa.value == ""){
                    mensagem = mensagem + "Informe a quantidade de vagas\n";
                }                  
                if (form.txtDescricaoBolsa.value == ""){
                    mensagem = mensagem + "Informe a descrição da bolsa\n";
                }
                if (form.txtRequisitosBolsa.value == ""){
                    mensagem = mensagem + "Informe os requisitos\n";
                }  
                if (!campoNumerico(form.txtCodBolsa.value)){
                    mensagem = mensagem + "Código da Bolsa deve ser numérico\n";
                }                  
                if (!campoNumerico(form.txtQtdadeVagasBolsa.value)){
                    mensagem = mensagem + "Total de vagas deve ser numérico\n";
                }                  
                                 
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            //-->
        </SCRIPT>   


</body>
<html>