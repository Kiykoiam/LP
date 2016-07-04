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
        <h1> Cadastrar Candidato ${operacao} </h1>
        <form action="ManterCandidatoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCandidato" onsubmit="return validarFormulario(this)">
            <table >

                <tr>
                    <td>Código Candidato</td>
                    <td> <input type="text" name="txtCodCandidato" value="${candidato.codCandidato}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome</td>
                        <td><input type="text" name="txtNomeCandidato" value="${candidato.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Telefone</td>
                        <td><input type="text"  name="txtTelefone" value="${candidato.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>RG</td>
                        <td><input type="text"name="txtRg" value="${candidato.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>CPF</td>
                        <td><input type="text"  name="txtCpf" value="${candidato.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Matricula</td>
                        <td><input type="text"  name="txtMatricula" value="${candidato.matricula}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Sexo</td>
                        <td> <select name="optSexo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Masculino" <c:if test="${candidato.sexo == 'Masculino'}"> selected</c:if>>Masculino</option>
                            <option value="Feminino" <c:if test="${candidato.sexo == 'Feminino'}"> selected</c:if>>Feminino</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Rua</td>
                        <td><input type="text"  name="txtRua" value="${candidato.rua}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Número</td>
                        <td><input type="text"  name="txtNumero" value="${candidato.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Bairro</td>
                        <td><input type="text"  name="txtBairro" value="${candidato.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>CEP</td>
                        <td><input type="text"  name="txtCep" value="${candidato.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Complemento</td>
                        <td><input type="text"  name="txtComplemento" value="${candidato.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>UF</td>
                        <td><input type="text"  name="txtUf" value="${candidato.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Cidade</td>
                        <td><input type="text"  name="txtCidade" value="${candidato.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text"  name="txtEmail" value="${candidato.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Ano de Ingresso</td>
                        <td><input type="text"  name="txtAnoDeIngresso" value="${candidato.anoDeIngresso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Celular</td>
                        <td><input type="text"  name="txtCelular" value="${candidato.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Previsão Termino</td>
                        <td><input type="text"  name="txtPrevisaoTermino" value="${candidato.previsaoTermino}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                if (form.txtCodCandidato.value == ""){
                    mensagem = mensagem + "Informe o Código do Candidato\n";
                }                             
                if (form.txtNomeCandidato.value == ""){
                    mensagem = mensagem + "Informe o Nome do Candidato\n";
                }             
                if (form.txtTelefone.value == ""){
                    mensagem = mensagem + "Informe o número de telefone\n";
                }                  
                if (form.txtRg.value == ""){
                    mensagem = mensagem + "Informe o RG\n";
                }
                if (form.txtCpf.value == ""){
                    mensagem = mensagem + "Informe o CPF\n";
                } 
                if (form.txtMatricula.value == ""){
                    mensagem = mensagem + "Informe o número de matricula\n";
                } 
                if (form.optSexo.value == ""){
                    mensagem = mensagem + "Informe o seu sexo\n";
                }
                if (form.txtRua.value == ""){
                    mensagem = mensagem + "Informe o nome da sua rua\n";
                }
                if (form.txtNumero.value == ""){
                    mensagem = mensagem + "Informe o número da sua casa\n";
                }
                if (form.txtBairro.value == ""){
                    mensagem = mensagem + "Informe o nome do seu bairro\n";
                }
                if (form.txtCep.value == ""){
                    mensagem = mensagem + "Informe o seu cep\n";
                }
                if (form.txtComplemento.value == ""){
                    mensagem = mensagem + "Informe o complemento\n";
                }
                if (form.txtUf.value == ""){
                    mensagem = mensagem + "Informe seu UF\n";
                }
                if (form.txtCidade.value == ""){
                    mensagem = mensagem + "Informe sua cidade\n";
                }
                if (form.txtEmail.value == ""){
                    mensagem = mensagem + "Informe seu email\n";
                }
                if (form.txtAnoDeIngresso.value == ""){
                    mensagem = mensagem + "Informe o ano de ingresso\n";
                }
                if (form.txtCelular.value == ""){
                    mensagem = mensagem + "Informe o seu celular\n";
                }
                if (form.txtPrevisaoTermino.value == ""){
                    mensagem = mensagem + "Informe a previsão termino do curso\n";
                }
                if (!campoNumerico(form.txtCodCandidato.value)){
                    mensagem = mensagem + "Código do candidato deve ser numérico\n";
                }                  
                if (!campoNumerico(form.txtMatricula.value)){
                    mensagem = mensagem + "A matricula deve ser numérico\n";
                }                  
                if (!campoNumerico(form.txtCelular.value)){
                    mensagem = mensagem + "Celular deve ser numérica\n";
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