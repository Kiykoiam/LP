package dao;

import static dao.CursoDAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Candidato;

public class CandidatoDAO {
    
    public static List<Candidato> obterCandidatos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Candidato> candidatos = new ArrayList<Candidato>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from candidato");
            while (rs.next()) {
                Candidato candidato = new Candidato(rs.getInt("codCandidato"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("rg"),
                        rs.getString("cpf"),
                        rs.getInt("matricula"),
                        rs.getString("sexo"),
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("bairro"),
                        rs.getString("cep"),
                        rs.getString("complemento"),
                        rs.getString("uf"),
                        rs.getString("cidade"),
                        rs.getString("email"), 
                        rs.getString("anoDeIngresso"),
                        rs.getInt("celular"),
                        rs.getString("previsaoTermino"));                                                           
                candidatos.add(candidato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return candidatos;
    }
    
    public static Candidato obterCandidato(int codCandidato) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Candidato candidato = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from candidato where codCandidato = " + codCandidato);
            rs.first();
            candidato = new Candidato(rs.getInt("codCandidato"),
                     rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("rg"),
                        rs.getString("cpf"),
                        rs.getInt("matricula"),
                        rs.getString("sexo"),
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("bairro"),
                        rs.getString("cep"),
                        rs.getString("complemento"),
                        rs.getString("uf"),
                        rs.getString("cidade"),
                        rs.getString("email"), 
                        rs.getString("anoDeIngresso"),
                        rs.getInt("celular"),
                        rs.getString("previsaoTermino"));                                                           
               
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return candidato;
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
    // metodo para gravar
    
    public static void gravar(Candidato candidato) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into candidato (codCandidato, nome, telefone, rg, cpf, matricula, sexo, rua, numero, bairro, cep, complemento, uf, cidade, email, anoDeIngresso, celular, previsaoTermino) "
            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1,candidato.getCodCandidato());
            comando.setString(2,candidato.getNome());
            comando.setString(3,candidato.getTelefone());
            comando.setString(4,candidato.getRg());
            comando.setString(5,candidato.getCpf());
            comando.setInt(6,candidato.getMatricula());
            comando.setString(7,candidato.getSexo());
            comando.setString(8,candidato.getRua());
            comando.setString(9,candidato.getNumero());
            comando.setString(10,candidato.getBairro());
            comando.setString(11,candidato.getCep());
            comando.setString(12,candidato.getComplemento());
            comando.setString(13,candidato.getUf());
            comando.setString(14,candidato.getCidade());
            comando.setString(15,candidato.getEmail());
            comando.setString(16,candidato.getAnoDeIngresso());
            comando.setInt(17,candidato.getCelular());
            comando.setString(18,candidato.getPrevisaoTermino());
            
        
            comando.execute();
            comando.close();
            conexao.close();
        }
            catch (SQLException e){
                    throw e;
            }
        
    }
    
    public static void alterar(Candidato candidato) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = " update candidato set nome = ?, telefone = ?, rg = ?, cpf = ?, matricula = ?, sexo = ?, rua = ?, numero = ?, "
                    + " bairro = ?, cep = ?, complemento = ?, uf = ?, cidade = ?, email = ?, anoDeIngresso = ?, celular = ?, "
                    + " previsaoTermino = ? "
                    + " where codCandidato = ? ";
                        
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1,candidato.getNome());
            comando.setString(2,candidato.getTelefone());
            comando.setString(3,candidato.getRg());
            comando.setString(4,candidato.getCpf());
            comando.setInt(5,candidato.getMatricula());
            comando.setString(6,candidato.getSexo());
            comando.setString(7,candidato.getRua());
            comando.setString(8,candidato.getNumero());
            comando.setString(9,candidato.getBairro());
            comando.setString(10,candidato.getCep());
            comando.setString(11,candidato.getComplemento());
            comando.setString(12,candidato.getUf());
            comando.setString(13,candidato.getCidade());
            comando.setString(14,candidato.getEmail());
            comando.setString(15,candidato.getAnoDeIngresso());
            comando.setInt(16,candidato.getCelular());
            comando.setString(17,candidato.getPrevisaoTermino());
           
            comando.setInt(18, candidato.getCodCandidato());
            comando.execute();
            comando.close();
            conexao.close();
        }
            catch (SQLException e){
                    throw e;
            }
        
    }
     public static void excluir(Candidato candidato) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = " delete from candidato where codCandidato = " + candidato.getCodCandidato();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }
}
