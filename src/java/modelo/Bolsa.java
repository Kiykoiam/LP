package modelo;

import dao.BolsaDAO;
import java.sql.SQLException;
import java.util.List;

public class Bolsa {
    private int codBolsa;
    private String nome;
    private int qtdadeVagas;
    private String descricao;
    private String requisitos;

    public Bolsa(int codBolsa, String nome, int qtdadeVagas, String descricao, String requisitos) {
        this.codBolsa = codBolsa;
        this.nome = nome;
        this.qtdadeVagas = qtdadeVagas;
        this.descricao = descricao;
        this.requisitos = requisitos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdadeVagas() {
        return qtdadeVagas;
    }

    public void setQtdadeVagas(int qtdadeVagas) {
        this.qtdadeVagas = qtdadeVagas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }
    
    public static List<Bolsa> obterBolsas() throws ClassNotFoundException {
        return BolsaDAO.obterBolsas();
    }

    public int getCodBolsa() {
        return codBolsa;
    }

    public void setCodBolsa(int codBolsa) {
        this.codBolsa = codBolsa;
    }
    public static Bolsa obterBolsa(int codBolsa) throws ClassNotFoundException {
        return BolsaDAO.obterBolsa(codBolsa);
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        BolsaDAO.gravar(this);
    }
     public void alterar() throws SQLException, ClassNotFoundException {
        BolsaDAO.alterar(this);
    }
     public void excluir() throws SQLException, ClassNotFoundException {
        BolsaDAO.excluir(this);
    }
}
