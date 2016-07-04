/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
import java.io.IOException;
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

    private Funcionario funcionario;
   
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
                        int CodFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));
                        funcionario = FuncionarioDAO.getInstance().obterFuncionario(CodFuncionario);
                        request.setAttribute("funcionario", funcionario);
                    }
                    RequestDispatcher View = request.getRequestDispatcher("/cadastrarFuncionario.jsp");
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
                    int CodFuncionario = Integer.parseInt(request.getParameter("txtCodFuncionario"));
                    String nome = request.getParameter("txtNomeFuncionario");
                    int telefone = Integer.parseInt(request.getParameter("txtTelefone"));         
                    String rg = request.getParameter("txtRg");
                    int cpf = Integer.parseInt(request.getParameter("txtCpf"));
                    String cidade = request.getParameter("txtCidade");
                    String sexo = request.getParameter("optSexo");
                    String rua = request.getParameter("txtRua");
                    int numero = Integer.parseInt(request.getParameter("txtNumero"));
                    String bairro = request.getParameter("txtBairro");
                    int cep = Integer.parseInt(request.getParameter("txtCep"));
                    String uf = request.getParameter("txtUf");
                    String email = request.getParameter("txtEmail");
                    int celular = Integer.parseInt(request.getParameter("txtCelular"));
                    if(operacao.equals("Incluir")) {
                        funcionario = new Funcionario(CodFuncionario);
                        funcionario.setNome(nome);
                        funcionario.setTelefone(telefone);
                        funcionario.setRg(rg);
                        funcionario.setCpf(cpf);
                        funcionario.setCidade(cidade);
                        funcionario.setSexo(sexo);
                        funcionario.setRua(rua);
                        funcionario.setNumero(numero);
                        funcionario.setBairro(bairro);
                        funcionario.setCep(cep);
                        funcionario.setUf(uf);
                        funcionario.setEmail(email);
                        funcionario.setCelular(celular);
                        FuncionarioDAO.getInstance().salvar(funcionario);                        
                    }
                    else if(operacao.equals("Editar")) {
                        funcionario.setNome(nome);
                        funcionario.setTelefone(telefone);
                        funcionario.setRg(rg);
                        funcionario.setCpf(cpf);
                        funcionario.setCidade(cidade);
                        funcionario.setSexo(sexo);
                        funcionario.setRua(rua);
                        funcionario.setNumero(numero);
                        funcionario.setBairro(bairro);
                        funcionario.setCep(cep);
                        funcionario.setUf(uf);
                        funcionario.setEmail(email);
                        funcionario.setCelular(celular);
                        FuncionarioDAO.getInstance().editar(funcionario);
                    }
                    else if (operacao.equals("Excluir")) {
                        FuncionarioDAO.getInstance().excluir(funcionario);
                    }
                    RequestDispatcher View = request.getRequestDispatcher("PesquisaFuncionarioController");
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
