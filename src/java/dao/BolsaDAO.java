package dao;

import static dao.CursoDAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Bolsa;
import modelo.Curso;

public class BolsaDAO {
    public static List<Bolsa> obterBolsas() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Bolsa> bolsas = new ArrayList<Bolsa>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from bolsa");
            while (rs.next()) {
                Bolsa bolsa = new Bolsa(rs.getInt("codBolsa"),
                        rs.getString("nome"),
                        rs.getInt("qtdadeVagas"),
                        rs.getString("descricao"),
                        rs.getString("requisitos"));
                bolsas.add(bolsa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return bolsas;
    }
     public static Bolsa obterBolsa(int codBolsa) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Bolsa bolsa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from bolsa where codBolsa = " + codBolsa);
            rs.first();
            bolsa = new Bolsa(rs.getInt("codBolsa"),
                    rs.getString("nome"),
                        rs.getInt("qtdadeVagas"),
                        rs.getString("descricao"),
                        rs.getString("requisitos"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return bolsa;
    }
    
    //------------
    public static void fecharConexao(Connection conexao, Statement comando) {
        try{
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
        }
    }
    // metodo para gravar no banco
    public static void gravar(Bolsa bolsa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into bolsa (codBolsa, nome, qtdadeVagas, descricao, requisitos) "
            + "values (?,?,?,?,?)";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1,bolsa.getCodBolsa());
            comando.setString(2,bolsa.getNome());
            comando.setInt(3,bolsa.getQtdadeVagas());
            comando.setString(4,bolsa.getDescricao());
            comando.setString(5,bolsa.getRequisitos());
            
           
            
            comando.execute();
            comando.close();
            conexao.close();
        }
            catch (SQLException e){
                    throw e;
            }
        
    }
    
    public static void alterar(Bolsa bolsa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = " update bolsa set nome = ?, qtdadeVagas = ?, descricao = ?, requisitos = ? "
                    + " where codBolsa = ? ";
                        
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1,bolsa.getNome());
            comando.setInt(2,bolsa.getQtdadeVagas());
            comando.setString(3,bolsa.getDescricao());
            comando.setString(4,bolsa.getRequisitos());
            
           
            comando.setInt(5, bolsa.getCodBolsa());
            comando.execute();
            comando.close();
            conexao.close();
        }
            catch (SQLException e){
                    throw e;
            }
        
    }
     public static void excluir(Bolsa bolsa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = " delete from bolsa where codBolsa = " + bolsa.getCodBolsa();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }
}
