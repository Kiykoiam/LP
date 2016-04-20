package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Candidato;

public class ManterCandidatoController extends HttpServlet {

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
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
             confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
             prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
             confirmarExcluir(request, response);
        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");            
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarCandidato.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } 
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int codCandidato = Integer.parseInt(request.getParameter("txtCodCandidato"));
        String nome = request.getParameter("txtNomeCandidato");
        String telefone = request.getParameter("txtTelefone");
        String rg = request.getParameter("txtRg");
        String cpf = request.getParameter("txtCpf");
        int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
        String sexo = request.getParameter("optSexo");
        String rua = request.getParameter("txtRua");
        String numero = request.getParameter("txtNumero");
        String bairro = request.getParameter("txtBairro");
        String cep = request.getParameter("txtCep");
        String complemento = request.getParameter("txtComplemento");
        String uf = request.getParameter("txtUf");
        String cidade = request.getParameter("txtCidade");
        String email = request.getParameter("txtEmail");
        String anoDeIngresso = request.getParameter("txtAnoDeIngresso");
        int celular = Integer.parseInt(request.getParameter("txtCelular"));
        String previsaoTermino = request.getParameter("txtPrevisaoTermino");
        try {
            Candidato candidato = new Candidato(codCandidato, nome, telefone, rg, cpf, matricula, sexo, rua, numero, bairro, cep, complemento, uf, cidade, email, anoDeIngresso, celular, previsaoTermino );
            candidato.gravar();
            RequestDispatcher view = request.getRequestDispatcher("pesquisaCandidatoController");
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
            int codCandidato = Integer.parseInt(request.getParameter("codCandidato"));
            Candidato candidato = Candidato.obterCandidato(codCandidato);
            request.setAttribute("candidato", candidato);            
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarCandidato.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
     public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int codCandidato = Integer.parseInt(request.getParameter("txtCodCandidato"));
        String nome = request.getParameter("txtNomeCandidato");
        String telefone = request.getParameter("txtTelefone");
        String rg = request.getParameter("txtRg");
        String cpf = request.getParameter("txtCpf");
        int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
        String sexo = request.getParameter("optSexo");
        String rua = request.getParameter("txtRua");
        String numero = request.getParameter("txtNumero");
        String bairro = request.getParameter("txtBairro");
        String cep = request.getParameter("txtCep");
        String complemento = request.getParameter("txtComplemento");
        String uf = request.getParameter("txtUf");
        String cidade = request.getParameter("txtCidade");
        String email = request.getParameter("txtEmail");
        String anoDeIngresso = request.getParameter("txtAnoDeIngresso");
        int celular = Integer.parseInt(request.getParameter("txtCelular"));
        String previsaoTermino = request.getParameter("txtPrevisaoTermino");
        try {
            Candidato candidato = new Candidato(codCandidato, nome, telefone, rg, cpf, matricula, sexo, rua, numero, bairro, cep, complemento, uf, cidade, email, anoDeIngresso, celular, previsaoTermino );
            candidato.alterar();
            RequestDispatcher view = request.getRequestDispatcher("pesquisaCandidatoController");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }
     
     //metodo para excluir
     public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");           
            int codCandidato = Integer.parseInt(request.getParameter("codCandidato"));
            Candidato candidato = Candidato.obterCandidato(codCandidato);
            request.setAttribute("candidato", candidato);            
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarCandidato.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
     
     public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int codCandidato = Integer.parseInt(request.getParameter("txtCodCandidato"));
        String nome = request.getParameter("txtNomeCandidato");
        String telefone = request.getParameter("txtTelefone");
        String rg = request.getParameter("txtRg");
        String cpf = request.getParameter("txtCpf");
        int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
        String sexo = request.getParameter("optSexo");
        String rua = request.getParameter("txtRua");
        String numero = request.getParameter("txtNumero");
        String bairro = request.getParameter("txtBairro");
        String cep = request.getParameter("txtCep");
        String complemento = request.getParameter("txtComplemento");
        String uf = request.getParameter("txtUf");
        String cidade = request.getParameter("txtCidade");
        String email = request.getParameter("txtEmail");
        String anoDeIngresso = request.getParameter("txtAnoDeIngresso");
        int celular = Integer.parseInt(request.getParameter("txtCelular"));
        String previsaoTermino = request.getParameter("txtPrevisaoTermino");
        try {
            Candidato candidato = new Candidato(codCandidato, nome, telefone, rg, cpf, matricula, sexo, rua, numero, bairro, cep, complemento, uf, cidade, email, anoDeIngresso, celular, previsaoTermino );
            candidato.excluir();
            RequestDispatcher view = request.getRequestDispatcher("pesquisaCandidatoController");
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
