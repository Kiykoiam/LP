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
        <h1> Cadastrar Funcionario ${operacao} </h1>
        <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFuncionario" onsubmit="return validarFormulario(this)">
            <table >

                <tr>
                    <td>Código Funcionario</td>
                    <td> <input type="text" name="txtCodFuncionario" value="${funcionario.codFuncionario}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome</td>
                        <td><input type="text" name="txtNomeFuncionario" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Telefone</td>
                        <td><input type="text"  name="txtTelefone" value="${funcionario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>RG</td>
                        <td><input type="text"name="txtRg" value="${funcionario.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>CPF</td>
                        <td><input type="text"  name="txtCpf" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Cidade</td>
                        <td><input type="text"  name="txtCidade" value="${funcionario.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Sexo</td>
                        <td> <select name="optSexo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Masculino" <c:if test="${funcionario.sexo == 'Masculino'}"> selected</c:if>>Masculino</option>
                            <option value="Feminino" <c:if test="${funcionario.sexo == 'Feminino'}"> selected</c:if>>Feminino</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Rua</td>
                        <td><input type="text"  name="txtRua" value="${funcionario.rua}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Número</td>
                        <td><input type="text"  name="txtNumero" value="${funcionario.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Bairro</td>
                        <td><input type="text"  name="txtBairro" value="${funcionario.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>CEP</td>
                        <td><input type="text"  name="txtCep" value="${funcionario.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>UF</td>
                        <td><input type="text"  name="txtUf" value="${funcionario.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Email</td>
                        <td><input type="text"  name="txtEmail" value="${funcionario.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Celular</td>
                        <td><input type="text"  name="txtCelular" value="${funcionario.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                if (form.txtCodFuncionario.value == "") {
                    mensagem = mensagem + "Informe o Código do funcionario\n";
                }
                if (form.txtNomeFuncionario.value == "") {
                    mensagem = mensagem + "Informe o Nome do funcionario\n";
                }
                if (form.txtTelefone.value == "") {
                    mensagem = mensagem + "Informe o número de telefone\n";
                }
                if (form.txtRg.value == "") {
                    mensagem = mensagem + "Informe o RG\n";
                }
                if (form.txtCpf.value == "") {
                    mensagem = mensagem + "Informe o CPF\n";
                }
              
                if (form.optSexo.value == "") {
                    mensagem = mensagem + "Informe o seu sexo\n";
                }
                if (form.txtRua.value == "") {
                    mensagem = mensagem + "Informe o nome da sua rua\n";
                }
                if (form.txtNumero.value == "") {
                    mensagem = mensagem + "Informe o número da sua casa\n";
                }
                if (form.txtBairro.value == "") {
                    mensagem = mensagem + "Informe o nome do seu bairro\n";
                }
                if (form.txtCep.value == "") {
                    mensagem = mensagem + "Informe o seu cep\n";
                }
               
                if (form.txtUf.value == "") {
                    mensagem = mensagem + "Informe seu UF\n";
                }
                if (form.txtCidade.value == "") {
                    mensagem = mensagem + "Informe sua cidade\n";
                }
                if (form.txtEmail.value == "") {
                    mensagem = mensagem + "Informe seu email\n";
                }
              
                if (form.txtCelular.value == "") {
                    mensagem = mensagem + "Informe o seu celular\n";
                }
                
                if (!campoNumerico(form.txtCodFuncionario.value)) {
                    mensagem = mensagem + "Código do funcionario deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCpf.value)) {
                    mensagem = mensagem + "A matricula deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCelular.value)) {
                    mensagem = mensagem + "Celular deve ser numérica\n";
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