package modelo;

import dao.CandidatoDAO;
import java.sql.SQLException;
import java.util.List;

public class Candidato {
    private int codCandidato;
    private String nome;
    private String telefone;
    private String rg;
    private String cpf;
    private int matricula;
    private String sexo;
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private String complemento;
    private String uf;
    private String cidade;
    private String email;
    private String anoDeIngresso;
    private int celular;    
    private String previsaoTermino;

    public Candidato(int codCandidato, String nome, String telefone, String rg, String cpf, int matricula, String sexo, String rua, String numero, String bairro, String cep, String complemento, String uf, String cidade, String email, String anoDeIngresso, int celular, String previsaoTermino) {
        this.codCandidato = codCandidato;
        this.nome = nome;
        this.telefone = telefone;
        this.rg = rg;
        this.cpf = cpf;
        this.matricula = matricula;
        this.sexo = sexo;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
        this.uf = uf;
        this.cidade = cidade;
        this.email = email;
        this.anoDeIngresso = anoDeIngresso;
        this.celular = celular;
        this.previsaoTermino = previsaoTermino;
    }
       
    public static List<Candidato> obterCandidatos() throws ClassNotFoundException {
        return CandidatoDAO.obterCandidatos();
    }

    public int getCodCandidato() {
        return codCandidato;
    }

    public void setCodCandidato(int codCandidato) {
        this.codCandidato = codCandidato;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnoDeIngresso() {
        return anoDeIngresso;
    }

    public void setAnoDeIngresso(String anoDeIngresso) {
        this.anoDeIngresso = anoDeIngresso;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getPrevisaoTermino() {
        return previsaoTermino;
    }

    public void setPrevisaoTermino(String previsaoTermino) {
        this.previsaoTermino = previsaoTermino;
    }
    public static Candidato obterCandidato(int codCandidato) throws ClassNotFoundException {
        return CandidatoDAO.obterCandidato(codCandidato);
    }
    public void gravar() throws SQLException, ClassNotFoundException {
        CandidatoDAO.gravar(this);
    }
     public void alterar() throws SQLException, ClassNotFoundException {
        CandidatoDAO.alterar(this);
    }
     public void excluir() throws SQLException, ClassNotFoundException {
        CandidatoDAO.excluir(this);
    }
}
