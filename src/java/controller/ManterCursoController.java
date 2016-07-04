package controller;

import dao.CursoDAO;
import dao.FuncionarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;
import modelo.Funcionario;

public class ManterCursoController extends HttpServlet {

    private Curso curso;

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
            if (!operacao.equals("Incluir")) {
                int codCurso = Integer.parseInt(request.getParameter("codCurso"));
                curso = CursoDAO.getInstance().obterCurso(codCurso);
                request.setAttribute("curso", curso);
            }
            RequestDispatcher View = request.getRequestDispatcher("/cadastrarCurso.jsp");
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
            int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
            String nomeCurso = request.getParameter("txtNomeCurso");
            int totalPeriodos = Integer.parseInt(request.getParameter("txtTotalPeriodos"));
             int cargaHoraria = Integer.parseInt(request.getParameter("txtCargaHoraria"));
            String tipoCurso = request.getParameter("optTipoCurso");
            int funcionarioId = Integer.parseInt(request.getParameter("optFuncionario"));
            Funcionario nomeFuncionario = null;
            if (funcionarioId != 0) {
                nomeFuncionario = FuncionarioDAO.getInstance().obterFuncionario(funcionarioId);
            }
            if (operacao.equals("Incluir")) {
                curso = new Curso(codCurso);
                curso.setNome(nomeCurso);
                curso.setTotalPeriodos(totalPeriodos);
                curso.setCargaHoraria(cargaHoraria);
                curso.setTipoCurso(tipoCurso);                
                curso.setFuncionarioId(nomeFuncionario);
               CursoDAO.getInstance().salvar(curso);
            } else if (operacao.equals("Editar")) {
                curso.setNome(nomeCurso);
                curso.setTotalPeriodos(totalPeriodos);
                curso.setCargaHoraria(cargaHoraria);
                curso.setTipoCurso(tipoCurso);                
                curso.setFuncionarioId(nomeFuncionario);
                CursoDAO.getInstance().editar(curso);
            } else if (operacao.equals("Excluir")) {
                CursoDAO.getInstance().excluir(curso);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
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
