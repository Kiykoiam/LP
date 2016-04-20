/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Funcionario;

/**
 *
 * @author Aluno
 */
public class ManterFuncionarioController extends HttpServlet {

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
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarFuncionario.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } 
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int codFuncionario = Integer.parseInt(request.getParameter("txtCodFuncionario"));
        String nome = request.getParameter("txtNomeFuncionario");
        String telefone = request.getParameter("txtTelefone");
        String rg = request.getParameter("txtRg");
        int cpf = Integer.parseInt(request.getParameter("txtCpf"));
        String cidade = request.getParameter("txtCidade");
        String sexo = request.getParameter("optSexo");
        String rua = request.getParameter("txtRua");
        String numero = request.getParameter("txtNumero");
        String bairro = request.getParameter("txtBairro");
        String cep = request.getParameter("txtCep");
        String uf = request.getParameter("txtUf");
        String email = request.getParameter("txtEmail");
        int celular = Integer.parseInt(request.getParameter("txtCelular"));
        try {
            Funcionario funcionario = new Funcionario(codFuncionario, nome, telefone, rg, cpf, cidade, sexo, rua, numero, bairro, cep, uf, email, celular);
            funcionario.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFuncionarioController");
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
            int codFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));
            Funcionario funcionario = Funcionario.obterFuncionario(codFuncionario);
            request.setAttribute("funcionario", funcionario);            
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarFuncionario.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
    
     public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int codFuncionario = Integer.parseInt(request.getParameter("txtCodFuncionario"));
        String nome = request.getParameter("txtNomeFuncionario");
        String telefone = request.getParameter("txtTelefone");
        String rg = request.getParameter("txtRg");
        int cpf = Integer.parseInt(request.getParameter("txtCpf"));
        String cidade = request.getParameter("txtCidade");
        String sexo = request.getParameter("optSexo");
        String rua = request.getParameter("txtRua");
        String numero = request.getParameter("txtNumero");
        String bairro = request.getParameter("txtBairro");
        String cep = request.getParameter("txtCep");
        String uf = request.getParameter("txtUf");
        String email = request.getParameter("txtEmail");
        int celular = Integer.parseInt(request.getParameter("txtCelular"));
        try {
            Funcionario funcionario = new Funcionario(codFuncionario, nome, telefone, rg, cpf, cidade, sexo, rua, numero, bairro, cep, uf, email, celular);
            funcionario.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFuncionarioController");
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
            int codFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));
            Funcionario funcionario = Funcionario.obterFuncionario(codFuncionario);
            request.setAttribute("funcionario", funcionario);            
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarFuncionario.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
     public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int codFuncionario = Integer.parseInt(request.getParameter("txtCodFuncionario"));
        String nome = request.getParameter("txtNomeFuncionario");
        String telefone = request.getParameter("txtTelefone");
        String rg = request.getParameter("txtRg");
        int cpf = Integer.parseInt(request.getParameter("txtCpf"));
        String cidade = request.getParameter("txtCidade");
        String sexo = request.getParameter("optSexo");
        String rua = request.getParameter("txtRua");
        String numero = request.getParameter("txtNumero");
        String bairro = request.getParameter("txtBairro");
        String cep = request.getParameter("txtCep");
        String uf = request.getParameter("txtUf");
        String email = request.getParameter("txtEmail");
        int celular = Integer.parseInt(request.getParameter("txtCelular"));
        try {
            Funcionario funcionario = new Funcionario(codFuncionario, nome, telefone, rg, cpf, cidade, sexo, rua, numero, bairro, cep, uf, email, celular);
            funcionario.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFuncionarioController");
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
