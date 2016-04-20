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
import modelo.Edital;

public class EditalDAO {
    
    public static List<Edital> obterEditais() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Edital> editais = new ArrayList<Edital>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from edital");
            while (rs.next()) {
                Edital edital = new Edital(rs.getInt("codEdital"),
                        rs.getString("ano"),
                        rs.getString("descricao"),
                        rs.getString("categoria"),
                        rs.getInt("numero"));                
                edital.setChaveFunc(rs.getInt("funcionario_codFuncionario"));
                edital.setChaveBolsa(rs.getInt("bolsa_codBolsa"));
                editais.add(edital);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return editais;
    }
    
    public static Edital obterEdital(int codEdital) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Edital edital = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from edital where codEdital = " + codEdital);
            rs.first();
            edital = new Edital(rs.getInt("codEdital"),
                    rs.getString("ano"),
                        rs.getString("descricao"),
                        rs.getString("categoria"),
                        rs.getInt("numero"));                
                edital.setChaveFunc(rs.getInt("funcionario_codFuncionario"));
                edital.setChaveBolsa(rs.getInt("bolsa_codBolsa"));
               
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return edital;
    }
    //--------------
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
    //metodo gravar bd
     public static void gravar(Edital edital) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into edital (codEdital, ano, descricao, categoria, numero, funcionario_codFuncionario, bolsa_codBolsa) "
            + "values (?,?,?,?,?,?,?)";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1,edital.getCodEdital());
            comando.setString(2,edital.getAno());
            comando.setString(3,edital.getDescricao());
            comando.setString(4,edital.getCategoria());
            comando.setInt(5,edital.getNumero());
            
            if (edital.getFuncionario() == null) {
                comando.setNull(6, Types.NULL);                
            }
            else {
                comando.setInt(6, edital.getFuncionario().getCodFuncionario());
            }
            
            if (edital.getBolsa() == null) {
                comando.setNull(7, Types.NULL);                
            }
            else {
                comando.setInt(7, edital.getBolsa().getCodBolsa());
            }
            
            comando.execute();
            comando.close();
            conexao.close();
        }
            catch (SQLException e){
                    throw e;
            }
        
    }
     
     
     public static void alterar(Edital edital) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = " update edital set ano = ?, descricao = ?, categoria = ?, numero = ?, funcionario_codFuncionario = ?, bolsa_codBolsa = ? "
                    + " where codEdital = ? ";
                        
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1,edital.getAno());
            comando.setString(2,edital.getDescricao());
            comando.setString(3,edital.getCategoria());
            comando.setInt(4,edital.getNumero());
            
            if (edital.getFuncionario() == null) {
                comando.setNull(5, Types.NULL);                
            }
            else {
                comando.setInt(5, edital.getFuncionario().getCodFuncionario());
            }
            
            if (edital.getBolsa() == null) {
                comando.setNull(6, Types.NULL);                
            }
            else {
                comando.setInt(6, edital.getBolsa().getCodBolsa());
            }
           
            comando.setInt(7, edital.getCodEdital());
            comando.execute();
            comando.close();
            conexao.close();
        }
            catch (SQLException e){
                    throw e;
            }
        
    }
      public static void excluir(Edital edital) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = " delete from edital where codEdital = " + edital.getCodEdital();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }
    }