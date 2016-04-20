package dao;

import static dao.CandidatoDAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Funcionario;

public class FuncionarioDAO {

    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario");
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(rs.getInt("codFuncionario"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("rg"),
                        rs.getInt("cpf"),
                        rs.getString("cidade"),
                        rs.getString("sexo"),
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("bairro"),
                        rs.getString("cep"),
                        rs.getString("uf"),
                        rs.getString("email"),
                        rs.getInt("celular"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionarios;
    }

    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario where codFuncionario = " + codFuncionario);
            rs.first();
            funcionario = new Funcionario(rs.getInt("codFuncionario"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("rg"),
                    rs.getInt("cpf"),
                    rs.getString("cidade"),
                    rs.getString("sexo"),
                    rs.getString("rua"),
                    rs.getString("numero"),
                    rs.getString("bairro"),
                    rs.getString("cep"),
                    rs.getString("uf"),
                    rs.getString("email"),
                    rs.getInt("celular"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionario;
    }

    // ----------------
    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
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

    public static void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into funcionario (codFuncionario, nome, telefone, rg, cpf, cidade, sexo, rua, numero, bairro, cep, uf, email, celular) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, funcionario.getCodFuncionario());
            comando.setString(2, funcionario.getNome());
            comando.setString(3, funcionario.getTelefone());
            comando.setString(4, funcionario.getRg());
            comando.setInt(5, funcionario.getCpf());
            comando.setString(6, funcionario.getCidade());
            comando.setString(7, funcionario.getSexo());
            comando.setString(8, funcionario.getRua());
            comando.setString(9, funcionario.getNumero());
            comando.setString(10, funcionario.getBairro());
            comando.setString(11, funcionario.getCep());
            comando.setString(12, funcionario.getUf());
            comando.setString(13, funcionario.getEmail());
            comando.setInt(14, funcionario.getCelular());

            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }

    }
    
    public static void alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = " update funcionario set nome = ?, telefone = ?, rg = ?, cpf = ?, cidade = ?, sexo = ?, rua = ?, numero = ?, bairro = ?, cep = ?, uf = ?, email = ?, celular = ? "
                    + " where codFuncionario = ? ";
                        
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getTelefone());
            comando.setString(3, funcionario.getRg());
            comando.setInt(4, funcionario.getCpf());
            comando.setString(5, funcionario.getCidade());
            comando.setString(6, funcionario.getSexo());
            comando.setString(7, funcionario.getRua());
            comando.setString(8, funcionario.getNumero());
            comando.setString(9, funcionario.getBairro());
            comando.setString(10, funcionario.getCep());
            comando.setString(11, funcionario.getUf());
            comando.setString(12, funcionario.getEmail());
            comando.setInt(13, funcionario.getCelular());
           
            comando.setInt(14, funcionario.getCodFuncionario());
            comando.execute();
            comando.close();
            conexao.close();
        }
            catch (SQLException e){
                    throw e;
            }
        
    }
     public static void excluir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = " delete from funcionario where codFuncionario = " + funcionario.getCodFuncionario();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }
}
