package modelo;

import dao.CursoDAO;
import java.sql.SQLException;
import java.util.List;

public class Curso {

    private int codCurso;
    private String nome;
    private String cargaHoraria;
    private String tipoCurso;
    private String totalPeriodos;
    private Funcionario funcionario;
    private int codFuncionario;

    public Curso() {
        super();
    }

    public Curso(int codCurso, String nome, String cargaHoraria, String tipoCurso, String totalPeriodos, Funcionario funcionario) {
        this.codCurso = codCurso;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.tipoCurso = tipoCurso;
        this.totalPeriodos = totalPeriodos;
        this.funcionario = funcionario;
    }
    

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getTotalPeriodos() {
        return totalPeriodos;
    }

    public void setTotalPeriodos(String totalPeriodos) {
        this.totalPeriodos = totalPeriodos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public static List<Curso> obterCursos() throws ClassNotFoundException {
        return CursoDAO.obterCursos();
    }
    
    public static Curso obterCurso(int codCurso) throws ClassNotFoundException {
        return CursoDAO.obterCurso(codCurso);
    }
    public void gravar() throws SQLException, ClassNotFoundException {
        CursoDAO.gravar(this);
    }
    public void alterar() throws SQLException, ClassNotFoundException {
        CursoDAO.alterar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException {
        CursoDAO.excluir(this);
    }
}
