package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Bolsa;
import modelo.Funcionario;

public class ManterBolsaController extends HttpServlet {

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
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarBolsa.jsp");
            view.forward(request, response);
        } catch(ServletException ex) {
        } catch(IOException ex) {            
        } catch(ClassNotFoundException ex){            
        }
    }
    
     public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response){
        int codBolsa = Integer.parseInt(request.getParameter("txtCodBolsa"));
        String nome = request.getParameter("txtNomeBolsa");
       int qtdadeVagas = Integer.parseInt(request.getParameter("txtQtdadeVagasBolsa"));
       String descricao = request.getParameter("txtDescricaoBolsa");
       String requisitos = request.getParameter("txtRequisitosBolsa");
       
       try{
         
       Bolsa bolsa = new Bolsa(codBolsa, nome, qtdadeVagas, descricao, requisitos);
       bolsa.gravar();
       RequestDispatcher view = request.getRequestDispatcher("PesquisaBolsaController");
       view.forward(request, response);
       }catch (IOException ex){           
       }catch (SQLException ex){           
       }catch (ClassNotFoundException ex){           
       }catch (ServletException ex){           
       }
    }
     
     public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");           
            int codBolsa = Integer.parseInt(request.getParameter("codBolsa"));
            Bolsa bolsa = Bolsa.obterBolsa(codBolsa);
            request.setAttribute("bolsa", bolsa);            
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarBolsa.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
     public void confirmarEditar(HttpServletRequest request, HttpServletResponse response){
        int codBolsa = Integer.parseInt(request.getParameter("txtCodBolsa"));
        String nome = request.getParameter("txtNomeBolsa");
       int qtdadeVagas = Integer.parseInt(request.getParameter("txtQtdadeVagasBolsa"));
       String descricao = request.getParameter("txtDescricaoBolsa");
       String requisitos = request.getParameter("txtRequisitosBolsa");
       
       try{
         
       Bolsa bolsa = new Bolsa(codBolsa, nome, qtdadeVagas, descricao, requisitos);
       bolsa.alterar();
       RequestDispatcher view = request.getRequestDispatcher("PesquisaBolsaController");
       view.forward(request, response);
       }catch (IOException ex){           
       }catch (SQLException ex){           
       }catch (ClassNotFoundException ex){           
       }catch (ServletException ex){           
       }
    }
     
     // metodo para excluir
     public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");           
            int codBolsa = Integer.parseInt(request.getParameter("codBolsa"));
            Bolsa bolsa = Bolsa.obterBolsa(codBolsa);
            request.setAttribute("bolsa", bolsa);            
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarBolsa.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
     
     public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response){
        int codBolsa = Integer.parseInt(request.getParameter("txtCodBolsa"));
        String nome = request.getParameter("txtNomeBolsa");
       int qtdadeVagas = Integer.parseInt(request.getParameter("txtQtdadeVagasBolsa"));
       String descricao = request.getParameter("txtDescricaoBolsa");
       String requisitos = request.getParameter("txtRequisitosBolsa");
       
       try{
         
       Bolsa bolsa = new Bolsa(codBolsa, nome, qtdadeVagas, descricao, requisitos);
       bolsa.excluir();
       RequestDispatcher view = request.getRequestDispatcher("PesquisaBolsaController");
       view.forward(request, response);
       }catch (IOException ex){           
       }catch (SQLException ex){           
       }catch (ClassNotFoundException ex){           
       }catch (ServletException ex){           
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
