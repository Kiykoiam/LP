package modelo;

import dao.EditalDAO;
import java.sql.SQLException;
import java.util.List;

public class Edital {
    private int codEdital;
    private String ano;
    private String descricao;
    private String categoria;
    private int  numero;
    private int codFuncionario;
    private int codBolsa;
    private Funcionario funcionario;
    private Bolsa bolsa;

    public Bolsa getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }
    

    public Edital(int codEdital, String ano, String descricao, String categoria, int numero) {
        this.codEdital = codEdital;
        this.ano = ano;
        this.descricao = descricao;
        this.categoria = categoria;
        this.numero = numero;
    }
    
    public Edital() {
        super();
    }

    public String getAno() {
        return ano;
    }
    
    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }    

    public int getCodEdital() {
        return codEdital;
    }

    public void setCodEdital(int codEdital) {
        this.codEdital = codEdital;
    }
    
     public static List<Edital> obterEditais() throws ClassNotFoundException {
        return EditalDAO.obterEditais();
    }   

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getCodBolsa() {
        return codBolsa;
    }

    public void setCodBolsa(int codBolsa) {
        this.codBolsa = codBolsa;
    }
    
    public void setChaveFunc(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public void setChaveBolsa(int codBolsa) {
        this.codBolsa = codBolsa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public static Edital obterEdital(int codEdital) throws ClassNotFoundException {
        return EditalDAO.obterEdital(codEdital);
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        EditalDAO.gravar(this);
    }
     public void alterar() throws SQLException, ClassNotFoundException {
        EditalDAO.alterar(this);
    }
     public void excluir() throws SQLException, ClassNotFoundException {
        EditalDAO.excluir(this);
    }
}
