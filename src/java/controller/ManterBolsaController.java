package controller;

import dao.BolsaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Bolsa;

public class ManterBolsaController extends HttpServlet {

    private Bolsa bolsa;
   
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
                        int codBolsa = Integer.parseInt(request.getParameter("codBolsa"));
                        bolsa = BolsaDAO.getInstance().obterBolsa(codBolsa);
                        request.setAttribute("bolsa", bolsa);
                    }
                    RequestDispatcher View = request.getRequestDispatcher("/cadastrarBolsa.jsp");
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
                    int codBolsa = Integer.parseInt(request.getParameter("txtCodBolsa"));
                    String nome = request.getParameter("txtNomeBolsa");
                    int qtdadeVagas = Integer.parseInt(request.getParameter("txtQtdadeVagasBolsa"));
                    String descricao = request.getParameter("txtDescricaoBolsa");
                    String requisitos = request.getParameter("txtRequisitosBolsa");

                    if(operacao.equals("Incluir")) {
                        bolsa = new Bolsa(codBolsa);
                        bolsa.setNome(nome);
                        bolsa.setQtdadeVagas(qtdadeVagas);
                        bolsa.setDescricao(descricao);
                        bolsa.setRequisitos(requisitos);
                        BolsaDAO.getInstance().salvar(bolsa);                        
                    }
                    else if(operacao.equals("Editar")) {
                        bolsa.setNome(nome);
                        bolsa.setQtdadeVagas(qtdadeVagas);
                        bolsa.setDescricao(descricao);
                        bolsa.setRequisitos(requisitos);
                        BolsaDAO.getInstance().editar(bolsa);
                    }
                    else if (operacao.equals("Excluir")) {
                        BolsaDAO.getInstance().excluir(bolsa);
                    }
                    RequestDispatcher View = request.getRequestDispatcher("PesquisaBolsaController");
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
