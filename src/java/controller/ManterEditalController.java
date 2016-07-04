
package controller;

import dao.BolsaDAO;
import dao.EditalDAO;
import dao.FuncionarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Bolsa;
import modelo.Edital;
import modelo.Funcionario;


public class ManterEditalController extends HttpServlet {

    private Edital edital;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("funcionario", FuncionarioDAO.getInstance().obterFuncionarios());
            request.setAttribute("bolsa", BolsaDAO.getInstance().obterBolsas());
           
            if (!operacao.equals("Incluir")) {
                int CodEdital = Integer.parseInt(request.getParameter("codEdital"));
                edital = EditalDAO.getInstance().obterEdital(CodEdital);
                request.setAttribute("edital", edital);
            }
            RequestDispatcher View = request.getRequestDispatcher("/cadastrarEdital.jsp");
            View.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            int codEdital = Integer.parseInt(request.getParameter("txtCodEdital"));
            String anoEdital = request.getParameter("txtAnoEdital");
            String descricao = request.getParameter("txtDescricao");
            String categoria = request.getParameter("txtCategoria");
            int numero = Integer.parseInt(request.getParameter("txtNumero"));
            int funcionarioId = Integer.parseInt(request.getParameter("optFuncionario"));            
            int bolsaId = Integer.parseInt(request.getParameter("optBolsa"));
            
            Funcionario nomeFuncionario = null;
            Bolsa nomeBolsa = null;
            if (funcionarioId != 0 && bolsaId != 0) {
                nomeFuncionario = FuncionarioDAO.getInstance().obterFuncionario(funcionarioId);
                nomeBolsa = BolsaDAO.getInstance().obterBolsa(bolsaId);
            }    
           
            if (operacao.equals("Incluir")) {
                edital = new Edital(codEdital);
                edital.setAno(anoEdital);
                edital.setDescricao(descricao);
                edital.setCategoria(categoria);
                edital.setNumero(numero);                
                edital.setFUNCIONARIOcodFuncionario(nomeFuncionario);
                edital.setBOLSAcodBolsa(nomeBolsa);
               EditalDAO.getInstance().salvar(edital);
            } else if (operacao.equals("Editar")) {
                edital.setAno(anoEdital);
                edital.setDescricao(descricao);
                edital.setCategoria(categoria);
                edital.setNumero(numero);                
                edital.setFUNCIONARIOcodFuncionario(nomeFuncionario);
                edital.setBOLSAcodBolsa(nomeBolsa);
                EditalDAO.getInstance().editar(edital);
            } else if (operacao.equals("Excluir")) {
                EditalDAO.getInstance().excluir(edital);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaEditalController");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
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
