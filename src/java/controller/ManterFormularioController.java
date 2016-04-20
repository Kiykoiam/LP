package controller;

import java.io.IOException;
import java.sql.SQLException;
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

   /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else {
            if (acao.equals("confirmarIncluir")) {
                confirmarIncluir(request, response);
            } else {
                if (acao.equals("prepararEditar")) {
                    prepararEditar(request, response);
                } else {
                    if (acao.equals("confirmarEditar")) {
                        confirmarEditar(request, response);
                    } else {
                        if (acao.equals("prepararExcluir")) {
                            prepararExcluir(request, response);
                        } else {
                            if (acao.equals("confirmarExcluir")) {
                                confirmarExcluir(request, response);
                            }
                        }
                    }
                }
            }
        }
    }
    
     public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("candidato", Candidato.obterCandidatos());
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarFormulario.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
     
      public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int codForm = Integer.parseInt(request.getParameter("txtCodFormulario"));
        String responsavelManutencaoFamilia = request.getParameter("txtRMF");
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
        int candidato = Integer.parseInt(request.getParameter("optCandidato"));
        try {
            Candidato cand = null;
            if (candidato != 0) {
                cand = Candidato.obterCandidato(candidato);
            }
            Formulario formulario = new Formulario(codForm, responsavelManutencaoFamilia, qtAutomovel, qtTvCor, qtMaquinaDeLavar, qtGeladeira, qtTvCabo, qtPc, qtInternetPaga,
                    qtEmpregadaMensalista, qtEmpregadaDiarista, qtBanheiros, qtQuartos, ensinoFundamental, ensinoMedio, membroFamilia, estadoCivil, parentesco, situacaoTrab, ocupacao,
                    escolaridade, rendaAluguelImovel, pensaoPorMorte, pensaoAlimenticia, ajudaTerceiros, beneficiosSociais, rendaMensalBruta, meioDeLocomocao, atividadeAcademicas, 
                    atividadeRemunerada, condicaoDeManutencao, mora, vcFamilia, resideFamilia, imovelSituacao, descricaoCasa, aguaF, luzF, telefoneF, condominioF, mensalidadeEscolaF, 
                    alimentacaoF, saudeF, transporteF, iptuF, aluguelF, pensaoAlimentF, outroF, aguaE, luzE, telefoneE, condominioE, iptuE, aluguelE, cand);
            formulario.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormularioController");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }
     
    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("candidato", Candidato.obterCandidatos());
            int codForm = Integer.parseInt(request.getParameter("codForm"));
            Formulario formulario = Formulario.obterFormulario(codForm);
            request.setAttribute("formulario", formulario);            
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarFormulario.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    } 
    
    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int codForm = Integer.parseInt(request.getParameter("txtCodFormulario"));
        String responsavelManutencaoFamilia = request.getParameter("txtRMF");
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
        int candidato = Integer.parseInt(request.getParameter("optCandidato"));
        try {
            Candidato func = null;
            if (candidato != 0) {
                func = Candidato.obterCandidato(candidato);
            }
            Formulario formulario = new Formulario(codForm, responsavelManutencaoFamilia, qtAutomovel, qtTvCor, qtMaquinaDeLavar, qtGeladeira, qtTvCabo, qtPc, qtInternetPaga,
                    qtEmpregadaMensalista, qtEmpregadaDiarista, qtBanheiros, qtQuartos, ensinoFundamental, ensinoMedio, membroFamilia, estadoCivil, parentesco, situacaoTrab, ocupacao,
                    escolaridade, rendaAluguelImovel, pensaoPorMorte, pensaoAlimenticia, ajudaTerceiros, beneficiosSociais, rendaMensalBruta, meioDeLocomocao, atividadeAcademicas, 
                    atividadeRemunerada, condicaoDeManutencao, mora, vcFamilia, resideFamilia, imovelSituacao, descricaoCasa, aguaF, luzF, telefoneF, condominioF, mensalidadeEscolaF, 
                    alimentacaoF, saudeF, transporteF, iptuF, aluguelF, pensaoAlimentF, outroF, aguaE, luzE, telefoneE, condominioE, iptuE, aluguelE, func);
            formulario.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormularioController");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }
       public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("candidato", Candidato.obterCandidatos());
            int codForm = Integer.parseInt(request.getParameter("codForm"));
            Formulario formulario = Formulario.obterFormulario(codForm);
            request.setAttribute("formulario", formulario);            
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarFormulario.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
       
       public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int codForm = Integer.parseInt(request.getParameter("txtCodFormulario"));
        String responsavelManutencaoFamilia = request.getParameter("txtRMF");
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
        int candidato = Integer.parseInt(request.getParameter("optCandidato"));
        try {
            Candidato func = null;
            if (candidato != 0) {
                func = Candidato.obterCandidato(candidato);
            }
            Formulario formulario = new Formulario(codForm, responsavelManutencaoFamilia, qtAutomovel, qtTvCor, qtMaquinaDeLavar, qtGeladeira, qtTvCabo, qtPc, qtInternetPaga,
                    qtEmpregadaMensalista, qtEmpregadaDiarista, qtBanheiros, qtQuartos, ensinoFundamental, ensinoMedio, membroFamilia, estadoCivil, parentesco, situacaoTrab, ocupacao,
                    escolaridade, rendaAluguelImovel, pensaoPorMorte, pensaoAlimenticia, ajudaTerceiros, beneficiosSociais, rendaMensalBruta, meioDeLocomocao, atividadeAcademicas, 
                    atividadeRemunerada, condicaoDeManutencao, mora, vcFamilia, resideFamilia, imovelSituacao, descricaoCasa, aguaF, luzF, telefoneF, condominioF, mensalidadeEscolaF, 
                    alimentacaoF, saudeF, transporteF, iptuF, aluguelF, pensaoAlimentF, outroF, aguaE, luzE, telefoneE, condominioE, iptuE, aluguelE, func);
            formulario.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormularioController");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
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
