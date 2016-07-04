package controller;

import dao.CandidatoDAO;
import dao.FormularioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Candidato;
import modelo.Formulario;

/**
 *
 * @author Frederico Belluzzo
 */
public class ManterFormularioController extends HttpServlet {

    private Formulario formulario;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String acao = request.getParameter("acao");
            if (acao.equals("prepararOperacao")){
                prepararOperacao(request, response);
            }
           if(acao.equals("confirmarOperacao")){
                confirmarOperacao(request, response);
            }
            }
            
            public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
                try{
                    String operacao = request.getParameter("operacao");
                    request.setAttribute("operacao", operacao);  
                    request.setAttribute("candidato", CandidatoDAO.getInstance().obterCandidatos());
                    if(!operacao.equals("Incluir")){
                        int codFormulario = Integer.parseInt(request.getParameter("codForm"));
                        formulario = FormularioDAO.getInstance().obterFormulario(codFormulario);
                        request.setAttribute("formulario", formulario);
                    }
                    RequestDispatcher View = request.getRequestDispatcher("/cadastrarFormulario.jsp");
                    View.forward(request, response);
                } catch (ServletException e) {
                    throw e;
                } catch (IOException e) {
                    throw new ServletException(e);
                }
            }
            
            public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                try{
                    String operacao = request.getParameter("operacao");
                    int codFormulario = Integer.parseInt(request.getParameter("txtCodFormulario"));
                    String responsavelMF = request.getParameter("txtRMF");
                    int qtAutomovel = Integer.parseInt(request.getParameter("txtQtAutomovel"));
                    int qtTvCor = Integer.parseInt(request.getParameter("txtQtTvCor"));
                    int qtMaquinaDeLavar = Integer.parseInt(request.getParameter("txtQtMaquinaDeLavar"));                   
                    int qtGeladeira = Integer.parseInt(request.getParameter("txtQtGeladeira"));
                    int qtTvCabo = Integer.parseInt(request.getParameter("txtQtTvCabo"));
                    int qtPc = Integer.parseInt(request.getParameter("txtQtPc"));
                    int qtInternetPaga = Integer.parseInt(request.getParameter("txtQtInternetPaga"));
                    int qtEmpregadaMensalista = Integer.parseInt(request.getParameter("txtQtEmpregadaMensalista"));
                    int qtEmpregadaDiarista = Integer.parseInt(request.getParameter("txtQtEmpregadaDiarista"));
                    int qtBanheiros = Integer.parseInt(request.getParameter("txtQtBanheiros"));
                    int qtQuartos = Integer.parseInt(request.getParameter("txtQtQuartos"));
                    String ensinoFundamental = request.getParameter("txtEnsinoFundamental");
                    String ensinoMedio = request.getParameter("txtEnsinoMedio");
                    String membroFamilia = request.getParameter("txtMembroFamilia");
                    String estadoCivil = request.getParameter("optEstadoCivil");
                    String parentesco = request.getParameter("txtParentesco");
                    String situacaoTrab = request.getParameter("txtSituacaoTrab");
                    String ocupacao = request.getParameter("txtOcupacao");
                    String escolaridade = request.getParameter("txtEscolaridade");
                    float rendaAluguelImovel = Float.parseFloat(request.getParameter("txtRendaAluguelImovel"));
                    float pensaoPorMorte = Float.parseFloat(request.getParameter("txtPensaoPorMorte"));
                    float pensaoAlimenticia = Float.parseFloat(request.getParameter("txtPensaoAlimenticia"));
                    float ajudaTerceiros = Float.parseFloat(request.getParameter("txtAjudaTerceiros"));
                    float beneficiosSociais = Float.parseFloat(request.getParameter("txtBeneficiosSociais"));
                    float rendaMensalBruta = Float.parseFloat(request.getParameter("txtRendaMensalBruta"));
                    String meioDeLocomocao = request.getParameter("txtMeioDeLocomocao");
                    String atividadeAcademicas = request.getParameter("txtAtividadeAcademicas");                    
                    String atividadeRemunerada = request.getParameter("txtAtividadeRemunerada");                    
                    String condicaoDeManutencao = request.getParameter("txtCondicaoDeManutencao");
                    String mora = request.getParameter("txtMora");
                    String vcFamilia = request.getParameter("txtVcFamilia");
                    String resideFamilia = request.getParameter("txtResideFamilia");
                    String imovelSituacao = request.getParameter("txtImovelSituacao");                    
                    String descricaoCasa = request.getParameter("txtDescricaoCasa");
                    float aguaF = Float.parseFloat(request.getParameter("txtAguaF"));
                    float luzF = Float.parseFloat(request.getParameter("txtLuzF"));
                    float telefoneF = Float.parseFloat(request.getParameter("txtTelefoneF"));
                    float condominioF = Float.parseFloat(request.getParameter("txtCondominioF"));
                    float mensalidadeEscolaF = Float.parseFloat(request.getParameter("txtMensalidadeEscolaF"));
                    float alimentacaoF = Float.parseFloat(request.getParameter("txtAlimentacaoF"));
                    float saudeF = Float.parseFloat(request.getParameter("txtSaudeF"));
                    float transporteF = Float.parseFloat(request.getParameter("txtTransporteF"));
                    float iptuF = Float.parseFloat(request.getParameter("txtIptuF"));
                    float aluguelF = Float.parseFloat(request.getParameter("txtAluguelF"));
                    float pensaoAlimentF = Float.parseFloat(request.getParameter("txtPensaoAlimentF"));
                    float outroF = Float.parseFloat(request.getParameter("txtOutroF"));
                    float aguaE = Float.parseFloat(request.getParameter("txtAguaE"));
                    float luzE = Float.parseFloat(request.getParameter("txtLuzE"));
                    float telefoneE = Float.parseFloat(request.getParameter("txtTelefoneE"));
                    float condominioE = Float.parseFloat(request.getParameter("txtCondominioE"));
                    float iptuE = Float.parseFloat(request.getParameter("txtIptuE"));
                    float aluguelE = Float.parseFloat(request.getParameter("txtAluguelE"));
                    int candidatoId = Integer.parseInt(request.getParameter("optCandidato"));
                    Candidato nomeCandidato = null;
                    if (candidatoId != 0) {
                        nomeCandidato = CandidatoDAO.getInstance().obterCandidato(candidatoId);
                    }

                    if(operacao.equals("Incluir")) {
                        formulario = new Formulario(codFormulario);
                        formulario.setResponsavelManutencaoFamilia(responsavelMF);
                        formulario.setQtAutomovel(qtAutomovel);
                        formulario.setQtTvCor(qtTvCor);
                        formulario.setQtMaquinaDeLavar(qtMaquinaDeLavar);
                        formulario.setQtGeladeira(qtGeladeira);
                        formulario.setQtTvCabo(qtTvCabo);
                        formulario.setQtPc(qtPc);
                        formulario.setQtInternetPaga(qtInternetPaga);
                        formulario.setQtEmpregadaMensalista(qtEmpregadaMensalista);
                        formulario.setQtEmpregadaDiarista(qtEmpregadaDiarista);
                        formulario.setQtBanheiros(qtBanheiros);
                        formulario.setQtQuartos(qtQuartos);
                        formulario.setEnsinoFundamental(ensinoFundamental);
                        formulario.setEnsinoMedio(ensinoMedio);
                        formulario.setMembroFamilia(membroFamilia);
                        formulario.setEstadoCivil(estadoCivil);
                        formulario.setParentesco(parentesco);
                        formulario.setSituacaoTrab(situacaoTrab);
                        formulario.setOcupacao(ocupacao);
                        formulario.setEscolaridade(escolaridade);
                        formulario.setRendaAluguelImovel(rendaAluguelImovel);
                        formulario.setPensaoPorMorte(pensaoPorMorte);  
                        formulario.setPensaoAlimenticia(pensaoAlimenticia);    
                        formulario.setAjudaTerceiros(ajudaTerceiros);        
                        formulario.setBeneficiosSociais(beneficiosSociais);        
                        formulario.setRendaMensalBruta(rendaMensalBruta);        
                        formulario.setMeioDeLocomocao(meioDeLocomocao);        
                        formulario.setAtividadeAcademicas(atividadeAcademicas);        
                        formulario.setAtividadeRemunerada(atividadeRemunerada);        
                        formulario.setCondicaoDeManutencao(condicaoDeManutencao);
                        formulario.setMora(mora);        
                        formulario.setVcFamilia(vcFamilia);        
                        formulario.setResideFamilia(resideFamilia);        
                        formulario.setImovelSituacao(imovelSituacao);        
                        formulario.setDescricaoCasa(descricaoCasa);        
                        formulario.setAguaF(aguaF);       
                        formulario.setLuzF(luzF);        
                        formulario.setTelefoneF(telefoneF);        
                        formulario.setCondominioF(condominioF);        
                        formulario.setMensalidadeEscolaF(mensalidadeEscolaF);        
                        formulario.setAlimentacaoF(alimentacaoF);        
                        formulario.setSaudeF(saudeF);        
                        formulario.setTransporteF(transporteF);        
                        formulario.setIptuF(iptuF);        
                        formulario.setAluguelF(aluguelF);        
                        formulario.setPensaoAlimentF(pensaoAlimentF);        
                        formulario.setOutroF(outroF);        
                        formulario.setAguaE(aguaE);       
                        formulario.setLuzE(luzE);       
                        formulario.setTelefoneE(telefoneE);        
                        formulario.setCondominioE(condominioE);       
                        formulario.setIptuE(iptuE);     
                        formulario.setAluguelE(aluguelE);        
                        formulario.setCANDIDATOcodCandidato(nomeCandidato);
                        FormularioDAO.getInstance().salvar(formulario);                        
                    }
                    else if(operacao.equals("Editar")) {
                        formulario.setResponsavelManutencaoFamilia(responsavelMF);
                        formulario.setQtAutomovel(qtAutomovel);
                        formulario.setQtTvCor(qtTvCor);
                        formulario.setQtMaquinaDeLavar(qtMaquinaDeLavar);
                        formulario.setQtGeladeira(qtGeladeira);
                        formulario.setQtTvCabo(qtTvCabo);
                        formulario.setQtPc(qtPc);
                        formulario.setQtInternetPaga(qtInternetPaga);
                        formulario.setQtEmpregadaMensalista(qtEmpregadaMensalista);
                        formulario.setQtEmpregadaDiarista(qtEmpregadaDiarista);
                        formulario.setQtBanheiros(qtBanheiros);
                        formulario.setQtQuartos(qtQuartos);
                        formulario.setEnsinoFundamental(ensinoFundamental);
                        formulario.setEnsinoMedio(ensinoMedio);
                        formulario.setMembroFamilia(membroFamilia);
                        formulario.setEstadoCivil(estadoCivil);
                        formulario.setParentesco(parentesco);
                        formulario.setSituacaoTrab(situacaoTrab);
                        formulario.setOcupacao(ocupacao);
                        formulario.setEscolaridade(escolaridade);
                        formulario.setRendaAluguelImovel(rendaAluguelImovel);
                        formulario.setPensaoPorMorte(pensaoPorMorte);  
                        formulario.setPensaoAlimenticia(pensaoAlimenticia);    
                        formulario.setAjudaTerceiros(ajudaTerceiros);        
                        formulario.setBeneficiosSociais(beneficiosSociais);        
                        formulario.setRendaMensalBruta(rendaMensalBruta);        
                        formulario.setMeioDeLocomocao(meioDeLocomocao);        
                        formulario.setAtividadeAcademicas(atividadeAcademicas);        
                        formulario.setAtividadeRemunerada(atividadeRemunerada);        
                        formulario.setCondicaoDeManutencao(condicaoDeManutencao);
                        formulario.setMora(mora);        
                        formulario.setVcFamilia(vcFamilia);        
                        formulario.setResideFamilia(resideFamilia);        
                        formulario.setImovelSituacao(imovelSituacao);        
                        formulario.setDescricaoCasa(descricaoCasa);        
                        formulario.setAguaF(aguaF);       
                        formulario.setLuzF(luzF);        
                        formulario.setTelefoneF(telefoneF);        
                        formulario.setCondominioF(condominioF);        
                        formulario.setMensalidadeEscolaF(mensalidadeEscolaF);        
                        formulario.setAlimentacaoF(alimentacaoF);        
                        formulario.setSaudeF(saudeF);        
                        formulario.setTransporteF(transporteF);        
                        formulario.setIptuF(iptuF);        
                        formulario.setAluguelF(aluguelF);        
                        formulario.setPensaoAlimentF(pensaoAlimentF);        
                        formulario.setOutroF(outroF);        
                        formulario.setAguaE(aguaE);       
                        formulario.setLuzE(luzE);       
                        formulario.setTelefoneE(telefoneE);        
                        formulario.setCondominioE(condominioE);       
                        formulario.setIptuE(iptuE);     
                        formulario.setAluguelE(aluguelE);        
                        formulario.setCANDIDATOcodCandidato(nomeCandidato);  
                        FormularioDAO.getInstance().editar(formulario);
                    }
                    else if (operacao.equals("Excluir")) {
                        FormularioDAO.getInstance().excluir(formulario);
                    }
                    RequestDispatcher View = request.getRequestDispatcher("PesquisaFormularioController");
                    View.forward(request, response);
                }
                catch (ServletException e){
                    throw e;
                }
                catch (IOException e) {
                    throw new ServletException(e);
                }
            }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
