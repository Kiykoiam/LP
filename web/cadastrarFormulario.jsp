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
        <h1> Cadastrar Formulario ${operacao} </h1>
        <form action="ManterFormularioController?acao=confirmar${operacao}" method="post" name="frmManterFormulario" onsubmit="return validarFormulario(this)">
            <table >

                <tr>
                    <td>Código Formulario</td>
                    <td> <input type="text" name="txtCodFormulario" value="${formulario.codForm}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Responsavel pela Manutencao Familiar </td>
                        <td><input type="text" name="txtRMF" value="${formulario.responsavelManutencaoFamilia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Quantidade de Automovel(is)</td>
                        <td><input type="text"  name="txtQtAutomovel" value="${formulario.qtAutomovel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Quantidade de Tv com Cor</td>
                        <td><input type="text"name="txtQtTvCor" value="${formulario.qtTvCor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Quantidade de Maquina de Lavar</td>
                        <td><input type="text"name="txtQtMaquinaDeLavar" value="${formulario.qtMaquinaDeLavar}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Quantidade de Geladeira</td>
                        <td><input type="text"name="txtQtGeladeira" value="${formulario.qtGeladeira}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Quantidade de Tv a Cabo</td>
                        <td><input type="text"name="txtQtTvCabo" value="${formulario.qtTvCabo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Quantidade de Computador</td>
                        <td><input type="text"name="txtQtPc" value="${formulario.qtPc}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Quantidade de Internet paga</td>
                        <td><input type="text"name="txtQtInternetPaga" value="${formulario.qtInternetPaga}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Quantidade de Empregada Mensalista</td>
                        <td><input type="text"name="txtQtEmpregadaMensalista" value="${formulario.qtEmpregadaMensalista}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Quantidade de Empregada Diarista</td>
                        <td><input type="text"name="txtQtEmpregadaDiarista" value="${formulario.qtEmpregadaDiarista}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Quantidade de Banheiros</td>
                        <td><input type="text"name="txtQtBanheiros" value="${formulario.qtBanheiros}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Quantidade de Quartos</td>
                        <td><input type="text"name="txtQtQuartos" value="${formulario.qtQuartos}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Onde Cursou o Ensino Fundamental?</td>
                        <td><input type="text"name="txtEnsinoFundamental" value="${formulario.ensinoFundamental}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Onde Cursou o Ensino Medio?</td>
                        <td><input type="text"name="txtEnsinoMedio" value="${formulario.ensinoMedio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Nome do Membro da familia</td>
                        <td><input type="text"name="txtMembroFamilia" value="${formulario.membroFamilia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>                    
                    <tr>
                        <td>Estado Civil:</td> 
                        <td>
                            <select name="optEstadoCivil" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Solteiro" <c:if test="${formulario.estadoCivil == 'Solteiro'}"> selected</c:if>>Solteiro</option>
                            <option value="Casado" <c:if test="${formulario.estadoCivil == 'Casado'}"> selected</c:if>>Casado</option>                            
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Parentesco</td>
                        <td><input type="text"name="txtParentesco" value="${formulario.parentesco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Situação de Trabalho</td>
                        <td><input type="text"name="txtSituacaoTrab" value="${formulario.situacaoTrab}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Ocupação</td>
                        <td><input type="text"name="txtOcupacao" value="${formulario.ocupacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Escolaridade</td>
                        <td><input type="text"name="txtEscolaridade" value="${formulario.escolaridade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Renda de Aluguel de Imovel</td> 
                        <td><input type="text"name="txtRendaAluguelImovel" value="${formulario.rendaAluguelImovel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>                        
                    </tr>
                    <tr>
                        <td>Pensão por Morte</td> 
                        <td><input type="text"name="txtPensaoPorMorte" value="${formulario.pensaoPorMorte}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>    
                    </tr>
                    <tr>
                        <td>Pensão Alimenticia</td> 
                        <td><input type="text"name="txtPensaoAlimenticia" value="${formulario.pensaoAlimenticia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Ajuda de Terceiros</td> 
                        <td><input type="text"name="txtAjudaTerceiros" value="${formulario.ajudaTerceiros}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Beneficios Sociais</td> 
                        <td><input type="text"name="txtBeneficiosSociais" value="${formulario.beneficiosSociais}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Renda Mensal Bruta</td>
                        <td><input type="text"name="txtRendaMensalBruta" value="${formulario.rendaMensalBruta}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Meio de Locomoção</td>
                        <td><input type="text"name="txtMeioDeLocomocao" value="${formulario.meioDeLocomocao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Atividade Academica</td>
                        <td><input type="text"name="txtAtividadeAcademicas" value="${formulario.atividadeAcademicas}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Atividade Remunerada</td>
                        <td><input type="text"name="txtAtividadeRemunerada" value="${formulario.atividadeRemunerada}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Condição de Manutenção</td>
                        <td><input type="text"name="txtCondicaoDeManutencao" value="${formulario.condicaoDeManutencao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Reside</td>
                        <td><input type="text"name="txtMora" value="${formulario.mora}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Familia</td>
                        <td><input type="text"name="txtVcFamilia" value="${formulario.vcFamilia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Reside Familia</td>
                        <td><input type="text"name="txtResideFamilia" value="${formulario.resideFamilia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Situação do Imovel</td>
                        <td><input type="text"name="txtImovelSituacao" value="${formulario.imovelSituacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Descrição da Casa</td>
                        <td><input type="text"name="txtDescricaoCasa" value="${formulario.descricaoCasa}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Agua da Familia</td>
                        <td><input type="text"name="txtAguaF" value="${formulario.aguaF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Luz da Familia</td>
                        <td><input type="text"name="txtLuzF" value="${formulario.luzF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Telefone da Familia</td>
                        <td><input type="text"name="txtTelefoneF" value="${formulario.telefoneF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Condominio da Familia</td>
                        <td><input type="text"name="txtCondominioF" value="${formulario.condominioF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Mensalidade Escolar</td>
                        <td><input type="text"name="txtMensalidadeEscolaF" value="${formulario.mensalidadeEscolaF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Alimentação da Familia</td>
                        <td><input type="text"name="txtAlimentacaoF" value="${formulario.alimentacaoF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Saude da Familia</td>
                        <td><input type="text"name="txtSaudeF" value="${formulario.saudeF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Transporte da Familia</td>
                        <td><input type="text"name="txtTransporteF" value="${formulario.transporteF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com IPTU Familiar</td>
                        <td><input type="text"name="txtIptuF" value="${formulario.iptuF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Aluguel da Familia</td>
                        <td><input type="text"name="txtAluguelF" value="${formulario.aluguelF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Pensão Alimenticia da Familia</td>
                        <td><input type="text"name="txtPensaoAlimentF" value="${formulario.pensaoAlimentF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Outros Gastos da Familia</td>
                        <td><input type="text"name="txtOutroF" value="${formulario.outroF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Agua do Estudante</td>
                        <td><input type="text"name="txtAguaE" value="${formulario.aguaE}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Luz do Estudante</td>
                        <td><input type="text"name="txtLuzE" value="${formulario.luzE}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Telefone do Estudante</td>
                        <td><input type="text"name="txtTelefoneE" value="${formulario.telefoneE}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Condominio do Estudante</td>
                        <td><input type="text"name="txtCondominioE" value="${formulario.condominioE}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com IPTU do Estudante</td>
                        <td><input type="text"name="txtIptuE" value="${formulario.iptuE}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                     <tr>
                        <td>Gasto com Aluguel do Estudante</td>
                        <td><input type="text"name="txtAluguelE" value="${formulario.aluguelE}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                    </tr>
                    <tr>
                        <td>Candidato</td>
                        <td>
                            <select name="optCandidato" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                             
                            <c:forEach items="${candidato}" var="candidato">
                                <option value="${candidato.codCandidato}" <c:if test="${formulatio.candidato.codCandidato == candidato.codCandidato}"> selected</c:if>>${candidato.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input value="Finalizar Cadastro" type="submit" name="btnConfirmar" /></td>
                    <td><input value="Cancelar Cadastro" type="submit" name="btnCancelar" /></td>

                </tr>
            </table>
        </form><SCRIPT language="JavaScript">
            <!--
            
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789.";
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
                if (form.txtCodFormulario.value == "") {
                    mensagem = mensagem + "Informe o Código do Formulario\n";
                }
                if (form.txtRMF.value == "") {
                    mensagem = mensagem + "Informe o Responsavel pela manutenção familiar\n";
                }
                if (form.txtQtAutomovel.value == "") {
                    mensagem = mensagem + "Informe a quantidade de automoveis\n";
                }
                if (form.txtQtTvCor.value == "") {
                    mensagem = mensagem + "Informe a quantidade de tv com cor\n";
                }
                if (form.txtQtMaquinaDeLavar.value == "") {
                    mensagem = mensagem + "Informe a quantidade de maquina de lavar\n";
                }
                if (form.txtQtGeladeira.value == "") {
                    mensagem = mensagem + "Informe a quantidade de geladeira\n";
                }
                if (form.txtQtTvCabo.value == "") {
                    mensagem = mensagem + "Informe a quantidade de tv a cabo\n";
                }
                if (form.txtQtPc.value == "") {
                    mensagem = mensagem + "Informe a quantidade de computador\n";
                }
                if (form.txtQtInternetPaga.value == "") {
                    mensagem = mensagem + "Informe a quantidade de internet paga\n";
                }
                if (form.txtQtEmpregadaMensalista.value == "") {
                    mensagem = mensagem + "Informe a quantidade de empregada mensalista\n";
                }
                if (form.txtQtEmpregadaDiarista.value == "") {
                    mensagem = mensagem + "Informe a quantidade de empregada diarista\n";
                }
                if (form.txtQtBanheiros.value == "") {
                    mensagem = mensagem + "Informe a quantidade de banheiros\n";
                }
                if (form.txtQtQuartos.value == "") {
                    mensagem = mensagem + "Informe a quantidade de quartos\n";
                }
                if (form.txtEnsinoFundamental.value == "") {
                    mensagem = mensagem + "Informe a onde cursou o ensino fundamental\n";
                }
                if (form.txtEnsinoMedio.value == "") {
                    mensagem = mensagem + "Informe onde cursou o ensino medio\n";
                }
                if (form.txtMembroFamilia.value == "") {
                    mensagem = mensagem + "Informe um membro da familia\n";
                }
                if (form.txtParentesco.value == "") {
                    mensagem = mensagem + "Informe o parentesco\n";
                }
                if (form.txtSituacaoTrab.value == "") {
                    mensagem = mensagem + "Informe a situação de trabalho\n";
                }
                if (form.txtOcupacao.value == "") {
                    mensagem = mensagem + "Informe a ocupação\n";
                }
                if (form.txtEscolaridade.value == "") {
                    mensagem = mensagem + "Informe a escolaridade\n";
                }
                if (form.txtRendaAluguelImovel.value == "") {
                    mensagem = mensagem + "Informe o aluguel do imovel\n";
                }
                if (form.txtPensaoPorMorte.value == "") {
                    mensagem = mensagem + "Informe o valor da pensão por morte\n";
                }
                if (form.txtPensaoAlimenticia.value == "") {
                    mensagem = mensagem + "Informe o valor da pensão alimenticia\n";
                }
                if (form.txtAjudaTerceiros.value == "") {
                    mensagem = mensagem + "Informe o valor da ajuda de terceiros\n";
                }
                if (form.txtBeneficiosSociais.value == "") {
                    mensagem = mensagem + "Informe o beneficio social\n";
                }
                if (form.txtRendaMensalBruta.value == "") {
                    mensagem = mensagem + "Informe a renda mensal bruta\n";
                }
                if (form.txtMeioDeLocomocao.value == "") {
                    mensagem = mensagem + "Informe o meio de transporte ate o instituto\n";
                }
                if (form.txtAtividadeAcademicas.value == "") {
                    mensagem = mensagem + "Informe sua atividade academica\n";
                }
                if (form.txtAtividadeRemunerada.value == "") {
                    mensagem = mensagem + "Informe sua atividade remunerada\n";
                }
                if (form.txtCondicaoDeManutencao.value == "") {
                    mensagem = mensagem + "Informe condição de manutenção\n";
                }
                if (form.txtMora.value == "") {
                    mensagem = mensagem + "Informe sua moradia\n";
                }
                if (form.txtVcFamilia.value == "") {
                    mensagem = mensagem + "Informe sua renda familiar\n";
                }
                if (form.txtResideFamilia.value == "") {
                    mensagem = mensagem + "Informe onde familia reside\n";
                }
                 if (form.txtImovelSituacao.value == "") {
                    mensagem = mensagem + "Informe a situação do imovel\n";
                }
                 if (form.txtDescricaoCasa.value == "") {
                    mensagem = mensagem + "Informe a descrição da casa\n";
                }
                 if (form.txtAguaF.value == "") {
                    mensagem = mensagem + "Informe a conta de agua da familia\n";
                }
                 if (form.txtLuzF.value == "") {
                    mensagem = mensagem + "Informe a conta de luz da familia\n";
                }
                if (form.txtTelefoneF.value == "") {
                    mensagem = mensagem + "Informe a conta de telefone da familia\n";
                }
                if (form.txtCondominioF.value == "") {
                    mensagem = mensagem + "Informe a conta de condominio da familia\n";
                }
                if (form.txtMensalidadeEscolaF.value == "") {
                    mensagem = mensagem + "Informe a conta da mensalidade escolar da fanilia\n";
                }
                if (form.txtAlimentacaoF.value == "") {
                    mensagem = mensagem + "Informe a conta de alimentação da familia\n";
                }
                if (form.txtSaudeF.value == "") {
                    mensagem = mensagem + "Informe os gastos com saude da familia\n";
                }
                if (form.txtTransporteF.value == "") {
                    mensagem = mensagem + "Informeo gasto com transporte da familia\n";
                }
                if (form.txtIptuF.value == "") {
                    mensagem = mensagem + "Informe a o valor gasto com IPTU\n";
                }
                if (form.txtAluguelF.value == "") {
                    mensagem = mensagem + "Informe o valor do aluguel\n";
                }
                if (form.txtPensaoAlimentF.value == "") {
                    mensagem = mensagem + "Informe o valor da pensao alimenticia\n";
                }
                if (form.txtOutroF.value == "") {
                    mensagem = mensagem + "Informe o valor de outros gastos familiares\n";
                }
                if (form.txtAguaE.value == "") {
                    mensagem = mensagem + "Informe o valor da agua do estudante\n";
                }
                if (form.txtLuzE.value == "") {
                    mensagem = mensagem + "Informe o valor da luz do estudante\n";
                }
                if (form.txtTelefoneE.value == "") {
                    mensagem = mensagem + "Informe o telefone do estudante\n";
                }
                if (form.txtCondominioE.value == "") {
                    mensagem = mensagem + "Informe o valor do condominio do estudante\n";
                }
                if (form.txtIptuE.value == "") {
                    mensagem = mensagem + "Informe o valor do IPTU do estudante\n";
                }
                if (form.txtAluguelE.value == "") {
                    mensagem = mensagem + "Informe o valor do aluguel do estudante\n";
                }
                if (!campoNumerico(form.txtCodFormulario.value)) {
                    mensagem = mensagem + "Codigo do formulario deve ser numérico\n";
                }
                if (!campoNumerico(form.txtQtAutomovel.value)) {
                    mensagem = mensagem + "A quantidade de automoveis deve ser numérica\n";
                }
                if (!campoNumerico(form.txtQtTvCor.value)) {
                    mensagem = mensagem + "A quantidade de tvs com cor deve ser numérica\n";
                }
                if (!campoNumerico(form.txtQtMaquinaDeLavar.value)) {
                    mensagem = mensagem + "A quantidade de maquina de lavar deve ser numérica\n";
                }
                if (!campoNumerico(form.txtQtTvCabo.value)) {
                    mensagem = mensagem + "A quantidade de tvs a cabo deve ser numérica\n";
                }
                if (!campoNumerico(form.txtQtPc.value)) {
                    mensagem = mensagem + "A quantidade de pcs deve ser numérica\n";
                }
                if (!campoNumerico(form.txtQtInternetPaga.value)) {
                    mensagem = mensagem + "A quantidade de internet paga deve ser numérica\n";
                }
                if (!campoNumerico(form.txtQtEmpregadaMensalista.value)) {
                    mensagem = mensagem + "A quantidade de Empregadas Mensalistas deve ser numérica\n";
                }
                if (!campoNumerico(form.txtQtEmpregadaDiarista.value)) {
                    mensagem = mensagem + "A quantidade de Empregadas Diaristas deve ser numérica\n";
                }
                 if (!campoNumerico(form.txtQtBanheiros.value)) {
                    mensagem = mensagem + "A quantidade de banheiros deve ser numérica\n";
                }
                 if (!campoNumerico(form.txtQtQuartos.value)) {
                    mensagem = mensagem + "A quantidade de quartos deve ser numérico\n";
                }
                 if (!campoNumerico(form.txtPensaoPorMorte.value)) {
                    mensagem = mensagem + "A quantidade de pensoes por morte deve ser numérica\n";
                }
                  if (!campoNumerico(form.txtPensaoAlimenticia.value)) {
                    mensagem = mensagem + "A quantidade de pensoes alimenticias deve ser numérica\n";
                }
                  if (!campoNumerico(form.txtRendaMensalBruta.value)) {
                    mensagem = mensagem + "A quantidade de Renda Mensal Bruta deve ser numérica\n";
                }
                  
                 if (!campoNumerico(form.txtAguaF.value)) {
                    mensagem = mensagem + "O valor da agua deve ser numérico\n";
                }
                if (!campoNumerico(form.txtLuzF.value)) {
                    mensagem = mensagem + "O valor da luz deve ser numérico\n";
                }
                if (!campoNumerico(form.txtTelefoneF.value)) {
                    mensagem = mensagem + "O valor do telefone deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCondominioF.value)) {
                    mensagem = mensagem + "O valor do condominio deve ser numérico\n";
                }
                if (!campoNumerico(form.txtMensalidadeEscolaF.value)) {
                    mensagem = mensagem + "O valor da mensalidade escolar deve ser numérico\n";
                }
                if (!campoNumerico(form.txtSaudeF.value)) {
                    mensagem = mensagem + "O valor gasto com saude deve ser numérico\n";
                }
                if (!campoNumerico(form.txtTransporteF.value)) {
                    mensagem = mensagem + "O valor gasto com transporte deve ser numérico\n";
                }
                if (!campoNumerico(form.txtIptuF.value)) {
                    mensagem = mensagem + "o valor gasto com iptu deve ser numerico\n";
                }
                if (!campoNumerico(form.txtAluguelF.value)) {
                    mensagem = mensagem + "O valor gasto com aluguel deve ser numérico\n";
                }
                if (!campoNumerico(form.txtPensaoAlimentF.value)) {
                    mensagem = mensagem + "O valor gasto com Pensao Alimenticia deve ser numérico\n";
                }
                if (!campoNumerico(form.txtAguaE.value)) {
                    mensagem = mensagem + "O valor gasto com Agua deve ser numérico\n";
                }
                if (!campoNumerico(form.txtLuzE.value)) {
                    mensagem = mensagem + "O valor gasto com luz deve ser numérico\n";
                }
                if (!campoNumerico(form.txtTelefoneE.value)) {
                    mensagem = mensagem + "O valor gasto com telefone deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCondominioE.value)) {
                    mensagem = mensagem + "O valor gasto com condominio deve ser numérico\n";
                }
                if (!campoNumerico(form.txtIptuE.value)) {
                    mensagem = mensagem + "O valor gasto com iptu deve ser numérico\n";
                }
                if (!campoNumerico(form.txtAluguelE.value)) {
                    mensagem = mensagem + "O valor gasto com aluguel deve ser numérico\n";
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