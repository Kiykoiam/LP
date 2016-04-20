package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;
import modelo.Funcionario;

public class ManterCursoController extends HttpServlet {

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
            request.setAttribute("funcionario", Funcionario.obterFuncionarios());
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarCurso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
        String nome = request.getParameter("txtNomeCurso");
        String cargaHoraria = request.getParameter("txtCargaHoraria");
        String tipoCurso = request.getParameter("optTipoCurso");
        String totalPeriodos = request.getParameter("txtTotalPeriodos");
        int funcionario = Integer.parseInt(request.getParameter("optFuncionario"));
        try {
            Funcionario func = null;
            if (funcionario != 0) {
                func = Funcionario.obterFuncionario(funcionario);
            }
            Curso curso = new Curso(codCurso, nome, cargaHoraria, tipoCurso, totalPeriodos, func);
            curso.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
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
            request.setAttribute("funcionario", Funcionario.obterFuncionarios());
            int codCurso = Integer.parseInt(request.getParameter("codCurso"));
            Curso curso = Curso.obterCurso(codCurso);
            request.setAttribute("curso", curso);            
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarCurso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
    
    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
        String nome = request.getParameter("txtNomeCurso");
        String cargaHoraria = request.getParameter("txtCargaHoraria");
        String tipoCurso = request.getParameter("optTipoCurso");
        String totalPeriodos = request.getParameter("txtTotalPeriodos");
        int funcionario = Integer.parseInt(request.getParameter("optFuncionario"));
        try {
            Funcionario func = null;
            if (funcionario != 0) {
                func = Funcionario.obterFuncionario(funcionario);
            }
            Curso curso = new Curso(codCurso, nome, cargaHoraria, tipoCurso, totalPeriodos, func);
            curso.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
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
            request.setAttribute("funcionario", Funcionario.obterFuncionarios());
            int codCurso = Integer.parseInt(request.getParameter("codCurso"));
            Curso curso = Curso.obterCurso(codCurso);
            request.setAttribute("curso", curso);            
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarCurso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
    
    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
        String nome = request.getParameter("txtNomeCurso");
        String cargaHoraria = request.getParameter("txtCargaHoraria");
        String tipoCurso = request.getParameter("optTipoCurso");
        String totalPeriodos = request.getParameter("txtTotalPeriodos");
        int funcionario = Integer.parseInt(request.getParameter("optFuncionario"));
        try {
            Funcionario func = null;
            if (funcionario != 0) {
                func = Funcionario.obterFuncionario(funcionario);
            }
            Curso curso = new Curso(codCurso, nome, cargaHoraria, tipoCurso, totalPeriodos, func);
            curso.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
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
