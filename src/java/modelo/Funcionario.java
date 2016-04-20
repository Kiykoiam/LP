package modelo;

import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.List;

public class Funcionario {

    private int codFuncionario;
    private String nome;
    private String telefone;
    private String rg;
    private int cpf;
    private String cidade;
    private String sexo;
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private String uf;
    private String email;
    private int celular;

    public Funcionario(int codFuncionario, String nome, String telefone, String rg, int cpf, String cidade, String sexo, String rua, String numero, String bairro, String cep, String uf, String email, int celular) {
        this.codFuncionario = codFuncionario;
        this.nome = nome;
        this.telefone = telefone;
        this.rg = rg;
        this.cpf = cpf;
        this.cidade = cidade;
        this.sexo = sexo;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.uf = uf;
        this.email = email;
        this.celular = celular;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException {
        return FuncionarioDAO.obterFuncionarios();
    }

    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException {
        return FuncionarioDAO.obterFuncionario(codFuncionario);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.gravar(this);
    }
     public void alterar() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.alterar(this);
    }
      public void excluir() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.excluir(this);
    }
}
