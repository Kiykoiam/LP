package controller;

import dao.CandidatoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Candidato;

public class ManterCandidatoController extends HttpServlet {

    private Candidato candidato;
   
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
                    if(!operacao.equals("Incluir")){
                        int codCandidato = Integer.parseInt(request.getParameter("codCandidato"));
                        candidato = CandidatoDAO.getInstance().obterCandidato(codCandidato);
                        request.setAttribute("candidato", candidato);
                    }
                    RequestDispatcher View = request.getRequestDispatcher("/cadastrarCandidato.jsp");
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
                    int codCandidato = Integer.parseInt(request.getParameter("txtCodCandidato"));
                    String nome = request.getParameter("txtNomeCandidato");
                    int telefone = Integer.parseInt(request.getParameter("txtTelefone"));
                    String rg = request.getParameter("txtRg");
                    int cpf = Integer.parseInt(request.getParameter("txtCpf"));
                    int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
                    String sexo = request.getParameter("optSexo");
                    String rua = request.getParameter("txtRua");
                    int numero = Integer.parseInt(request.getParameter("txtNumero"));
                    String bairro = request.getParameter("txtBairro");
                    int cep = Integer.parseInt(request.getParameter("txtCep"));
                    String complemento = request.getParameter("txtComplemento");
                    String uf = request.getParameter("txtUf");
                    String cidade = request.getParameter("txtCidade");
                    String email = request.getParameter("txtEmail");
                    String anoDeIngresso = request.getParameter("txtAnoDeIngresso");
                    int celular = Integer.parseInt(request.getParameter("txtCelular"));
                    String previsaoTermino = request.getParameter("txtPrevisaoTermino");

                    if(operacao.equals("Incluir")) {
                        candidato = new Candidato(codCandidato);
                        candidato.setNome(nome);
                        candidato.setTelefone(telefone);
                        candidato.setRg(rg);
                        candidato.setCpf(cpf);
                        candidato.setMatricula(matricula);
                        candidato.setSexo(sexo);
                        candidato.setRua(rua);
                        candidato.setNumero(numero);
                        candidato.setBairro(bairro);
                        candidato.setCep(cep);
                        candidato.setComplemento(complemento);
                        candidato.setUf(uf);
                        candidato.setCidade(cidade);
                        candidato.setEmail(email);
                        candidato.setAnoDeIngresso(anoDeIngresso);
                        candidato.setCelular(celular);
                        candidato.setPrevisaoTermino(previsaoTermino);
                        CandidatoDAO.getInstance().salvar(candidato);                        
                    }
                    else if(operacao.equals("Editar")) {
                        candidato.setNome(nome);
                        candidato.setTelefone(telefone);
                        candidato.setRg(rg);
                        candidato.setCpf(cpf);
                        candidato.setMatricula(matricula);
                        candidato.setSexo(sexo);
                        candidato.setRua(rua);
                        candidato.setNumero(numero);
                        candidato.setBairro(bairro);
                        candidato.setCep(cep);
                        candidato.setComplemento(complemento);
                        candidato.setUf(uf);
                        candidato.setCidade(cidade);
                        candidato.setEmail(email);
                        candidato.setAnoDeIngresso(anoDeIngresso);
                        candidato.setCelular(celular);
                        candidato.setPrevisaoTermino(previsaoTermino);
                        CandidatoDAO.getInstance().editar(candidato);
                    }
                    else if (operacao.equals("Excluir")) {
                        CandidatoDAO.getInstance().excluir(candidato);
                    }
                    RequestDispatcher View = request.getRequestDispatcher("pesquisaCandidatoController");
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
