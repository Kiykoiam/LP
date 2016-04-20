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
import modelo.Formulario;


public class FormularioDAO {
    public static List<Formulario> obterFormularios() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Formulario> formularios = new ArrayList<Formulario>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from formulario");
            while (rs.next()) {
                Formulario formulario;                         
                formulario = new Formulario(rs.getInt("codForm"),                         
                        rs.getString("responsavelManutencaoFamilia"),
                        rs.getInt("qtAutomovel"),
                        rs.getInt("qtTvCor"),
                        rs.getInt("qtMaquinaDeLavar"),
                        rs.getInt("qtGeladeira"),
                        rs.getInt("qtTvCabo"),
                        rs.getInt("qtPc"),
                        rs.getInt("qtInternetPaga"),
                        rs.getInt("qtEmpregadaMensalista"),
                        rs.getInt("qtEmpregadaDiarista"),
                        rs.getInt("qtBanheiros"),
                        rs.getInt("qtQuartos"),
                        rs.getString("ensinoFundamental"),
                        rs.getString("ensinoMedio"),
                        rs.getString("membroFamilia"),
                        rs.getString("estadoCivil"),
                        rs.getString("parentesco"),
                        rs.getString("situacaoTrab"),
                        rs.getString("ocupacao"),
                        rs.getString("escolaridade"),
                        rs.getFloat("rendaAluguelImovel"),
                        rs.getFloat("pensaoPorMorte"),
                        rs.getFloat("pensaoAlimenticia"),
                        rs.getFloat("ajudaTerceiros"),
                        rs.getFloat("beneficiosSociais"),
                        rs.getFloat("rendaMensalBruta"),
                        rs.getString("meioDeLocomocao"),
                        rs.getString("atividadeAcademicas"),
                        rs.getString("atividadeRemunerada"),
                        rs.getString("condicaoDeManutencao"),
                        rs.getString("mora"),
                        rs.getString("vcFamilia"),
                        rs.getString("resideFamilia"),
                        rs.getString("imovelSituacao"),
                        rs.getString("descricaoCasa"),
                        rs.getFloat("aguaF"),
                        rs.getFloat("luzF"),
                        rs.getFloat("telefoneF"),
                        rs.getFloat("condominioF"),
                        rs.getFloat("mensalidadeEscolaF"),
                        rs.getFloat("alimentacaoF"),
                        rs.getFloat("saudeF"),
                        rs.getFloat("transporteF"),
                        rs.getFloat("iptuF"),
                        rs.getFloat("aluguelF"),
                        rs.getFloat("pensaoAlimentF"),
                        rs.getFloat("outroF"),
                        rs.getFloat("aguaE"),
                        rs.getFloat("luzE"),
                        rs.getFloat("telefoneE"),
                        rs.getFloat("condominioE"),
                        rs.getFloat("iptuE"),
                        rs.getFloat("aluguelE"),null);
                        formulario.setCodCandidato(rs.getInt("CANDIDATO_codCandidato"));                
                formularios.add(formulario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return formularios;    
    }
     public static Formulario obterFormulario(int codForm) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Formulario formulario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from formulario where codForm = " + codForm);
            rs.first();
            formulario = new Formulario(rs.getInt("codForm"),
                    rs.getString("responsavelManutencaoFamilia"),
                        rs.getInt("qtAutomovel"),
                        rs.getInt("qtTvCor"),
                        rs.getInt("qtMaquinaDeLavar"),
                        rs.getInt("qtGeladeira"),
                        rs.getInt("qtTvCabo"),
                        rs.getInt("qtPc"),
                        rs.getInt("qtInternetPaga"),
                        rs.getInt("qtEmpregadaMensalista"),
                        rs.getInt("qtEmpregadaDiarista"),
                        rs.getInt("qtBanheiros"),
                        rs.getInt("qtQuartos"),
                        rs.getString("ensinoFundamental"),
                        rs.getString("ensinoMedio"),
                        rs.getString("membroFamilia"),
                        rs.getString("estadoCivil"),
                        rs.getString("parentesco"),
                        rs.getString("situacaoTrab"),
                        rs.getString("ocupacao"),
                        rs.getString("escolaridade"),
                        rs.getFloat("rendaAluguelImovel"),
                        rs.getFloat("pensaoPorMorte"),
                        rs.getFloat("pensaoAlimenticia"),
                        rs.getFloat("ajudaTerceiros"),
                        rs.getFloat("beneficiosSociais"),
                        rs.getFloat("rendaMensalBruta"),
                        rs.getString("meioDeLocomocao"),
                        rs.getString("atividadeAcademicas"),
                        rs.getString("atividadeRemunerada"),
                        rs.getString("condicaoDeManutencao"),
                        rs.getString("mora"),
                        rs.getString("vcFamilia"),
                        rs.getString("resideFamilia"),
                        rs.getString("imovelSituacao"),
                        rs.getString("descricaoCasa"),
                        rs.getFloat("aguaF"),
                        rs.getFloat("luzF"),
                        rs.getFloat("telefoneF"),
                        rs.getFloat("condominioF"),
                        rs.getFloat("mensalidadeEscolaF"),
                        rs.getFloat("alimentacaoF"),
                        rs.getFloat("saudeF"),
                        rs.getFloat("transporteF"),
                        rs.getFloat("iptuF"),
                        rs.getFloat("aluguelF"),
                        rs.getFloat("pensaoAlimentF"),
                        rs.getFloat("outroF"),
                        rs.getFloat("aguaE"),
                        rs.getFloat("luzE"),
                        rs.getFloat("telefoneE"),
                        rs.getFloat("condominioE"),
                        rs.getFloat("iptuE"),
                        rs.getFloat("aluguelE"),null);
                        formulario.setCodCandidato(rs.getInt("CANDIDATO_codCandidato"));                 
               
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return formulario;
    }
    
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
    //metodo para gravar no banco
    
    public static void gravar(Formulario formulario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into formulario (codForm, responsavelManutencaoFamilia, qtAutomovel, qtTvCor, qtMaquinaDeLavar, qtGeladeira, "
                    + "qtTvCabo, qtPc, qtInternetPaga, qtEmpregadaMensalista, qtEmpregadaDiarista, qtBanheiros, qtQuartos, ensinoFundamental,"
                    + " ensinoMedio, membroFamilia,"
                    + " estadoCivil, parentesco, situacaoTrab, ocupacao, escolaridade, rendaAluguelImovel, pensaoPorMorte, pensaoAlimenticia, "
                    + "ajudaTerceiros, beneficiosSociais, rendaMensalBruta, meioDeLocomocao, atividadeAcademicas,"
                    + "atividadeRemunerada, condicaoDeManutencao, mora, vcFamilia, resideFamilia, imovelSituacao, descricaoCasa, aguaF, luzF, "
                    + "telefoneF, condominioF, mensalidadeEscolaF, alimentacaoF, saudeF, transporteF, iptuF, aluguelF, pensaoAlimentF, outroF, "
                    + "aguaE, luzE, telefoneE, condominioE, iptuE, aluguelE, CANDIDATO_codCandidato) "
            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1,formulario.getCodForm());
            comando.setString(2,formulario.getResponsavelManutencaoFamilia());
            comando.setInt(3,formulario.getQtAutomovel());
            comando.setInt(4,formulario.getQtTvCor());
            comando.setInt(5,formulario.getQtMaquinaDeLavar());
            comando.setInt(6,formulario.getQtGeladeira());
            comando.setInt(7,formulario.getQtTvCabo());
            comando.setInt(8,formulario.getQtPc());
            comando.setInt(9,formulario.getQtInternetPaga());
            comando.setInt(10,formulario.getQtEmpregadaMensalista());
            comando.setInt(11,formulario.getQtEmpregadaDiarista());
            comando.setInt(12,formulario.getQtBanheiros());
            comando.setInt(13,formulario.getQtQuartos());
            comando.setString(14,formulario.getEnsinoFundamental());
            comando.setString(15,formulario.getEnsinoMedio());
            comando.setString(16,formulario.getMembroFamilia());
            comando.setString(17,formulario.getEstadoCivil());
            comando.setString(18,formulario.getParentesco());
            comando.setString(19,formulario.getSituacaoTrab());
            comando.setString(20,formulario.getOcupacao());
            comando.setString(21,formulario.getEscolaridade());
            comando.setFloat(22,formulario.getRendaAluguelImovel());
            comando.setFloat(23,formulario.getPensaoPorMorte());
            comando.setFloat(24,formulario.getPensaoAlimenticia());
            comando.setFloat(25,formulario.getAjudaTerceiros());
            comando.setFloat(26,formulario.getBeneficiosSociais());
            comando.setFloat(27,formulario.getRendaMensalBruta());
            comando.setString(28,formulario.getMeioDeLocomocao());
            comando.setString(29,formulario.getAtividadeAcademicas());
            comando.setString(30,formulario.getAtividadeRemunerada());
            comando.setString(31,formulario.getCondicaoDeManutencao());
            comando.setString(32,formulario.getMora());
            comando.setString(33,formulario.getVcFamilia());
            comando.setString(34,formulario.getResideFamilia());
            comando.setString(35,formulario.getImovelSituacao());
            comando.setString(36,formulario.getDescricaoCasa());
            comando.setFloat(37,formulario.getAguaF());
            comando.setFloat(38,formulario.getLuzF());
            comando.setFloat(39,formulario.getTelefoneF());
            comando.setFloat(40,formulario.getCondominioF());
            comando.setFloat(41,formulario.getMensalidadeEscolaF());
            comando.setFloat(42,formulario.getAlimentacaoF());
            comando.setFloat(43,formulario.getSaudeF());
            comando.setFloat(44,formulario.getTransporteF());
            comando.setFloat(45,formulario.getIptuF());
            comando.setFloat(46,formulario.getAluguelF());
            comando.setFloat(47,formulario.getPensaoAlimentF());
            comando.setFloat(48,formulario.getOutroF());
            comando.setFloat(49,formulario.getAguaE());
            comando.setFloat(50,formulario.getLuzE());
            comando.setFloat(51,formulario.getTelefoneE());
            comando.setFloat(52,formulario.getCondominioE());
            comando.setFloat(53,formulario.getIptuE());
            comando.setFloat(54,formulario.getAluguelE());
            
            if (formulario.getCandidato() == null) {
                comando.setNull(55, Types.NULL);
            } else {
                comando.setInt(55, formulario.getCandidato().getCodCandidato());
            }
            
            comando.execute();
            comando.close();
            conexao.close();
        }
            catch (SQLException e){
                    throw e;
            }
        
    }
     public static void alterar(Formulario formulario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = " update formulario set responsavelManutencaoFamilia = ?, qtAutomovel = ?, qtTvCor = ?,qtMaquinaDeLavar = ?, qtGeladeira = ?, qtTvCabo = ?, qtPc = ?, qtInternetPaga = ?, qtEmpregadaMensalista = ?, qtEmpregadaDiarista = ?, qtBanheiros = ?, qtQuartos = ?, ensinoFundamental = ?, ensinoMedio = ?, membroFamilia = ?, estadoCivil = ?, parentesco = ?, situacaoTrab = ?, ocupacao = ?, escolaridade = ?, rendaAluguelImovel = ?, pensaoPorMorte = ?, pensaoAlimenticia = ?, ajudaTerceiros = ?, beneficiosSociais = ?, rendaMensalBruta = ?, meioDeLocomocao = ?, atividadeAcademicas = ?,atividadeRemunerada = ?, condicaoDeManutencao = ?, mora = ?, vcFamilia = ?, resideFamilia = ?, imovelSituacao = ?, descricaoCasa = ?, aguaF = ?, luzF = ?, telefoneF = ?, condominioF = ?, mensalidadeEscolaF = ?, alimentacaoF = ?, saudeF = ?, transporteF = ?, iptuF = ?, aluguelF = ?, pensaoAlimentF = ?, outroF = ?, aguaE = ?, luzE = ?, telefoneE = ?, condominioE = ?, iptuE = ?, aluguelE = ?, CANDIDATO_codCandidato = ? "
                    + " where codForm = ? ";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1,formulario.getResponsavelManutencaoFamilia());
            comando.setInt(2,formulario.getQtAutomovel());
            comando.setInt(3,formulario.getQtTvCor());
            comando.setInt(4,formulario.getQtMaquinaDeLavar());
            comando.setInt(5,formulario.getQtGeladeira());
            comando.setInt(6,formulario.getQtTvCabo());
            comando.setInt(7,formulario.getQtPc());
            comando.setInt(8,formulario.getQtInternetPaga());
            comando.setInt(9,formulario.getQtEmpregadaMensalista());
            comando.setInt(10,formulario.getQtEmpregadaDiarista());
            comando.setInt(11,formulario.getQtBanheiros());
            comando.setInt(12,formulario.getQtQuartos());
            comando.setString(13,formulario.getEnsinoFundamental());
            comando.setString(14,formulario.getEnsinoMedio());
            comando.setString(15,formulario.getMembroFamilia());
            comando.setString(16,formulario.getEstadoCivil());
            comando.setString(17,formulario.getParentesco());
            comando.setString(18,formulario.getSituacaoTrab());
            comando.setString(19,formulario.getOcupacao());
            comando.setString(20,formulario.getEscolaridade());
            comando.setFloat(21,formulario.getRendaAluguelImovel());
            comando.setFloat(22,formulario.getPensaoPorMorte());
            comando.setFloat(23,formulario.getPensaoAlimenticia());
            comando.setFloat(24,formulario.getAjudaTerceiros());
            comando.setFloat(25,formulario.getBeneficiosSociais());
            comando.setFloat(26,formulario.getRendaMensalBruta());
            comando.setString(27,formulario.getMeioDeLocomocao());
            comando.setString(28,formulario.getAtividadeAcademicas());
            comando.setString(29,formulario.getAtividadeRemunerada());
            comando.setString(30,formulario.getCondicaoDeManutencao());
            comando.setString(31,formulario.getMora());
            comando.setString(32,formulario.getVcFamilia());
            comando.setString(33,formulario.getResideFamilia());
            comando.setString(34,formulario.getImovelSituacao());
            comando.setString(35,formulario.getDescricaoCasa());
            comando.setFloat(36,formulario.getAguaF());
            comando.setFloat(37,formulario.getLuzF());
            comando.setFloat(38,formulario.getTelefoneF());
            comando.setFloat(39,formulario.getCondominioF());
            comando.setFloat(40,formulario.getMensalidadeEscolaF());
            comando.setFloat(41,formulario.getAlimentacaoF());
            comando.setFloat(42,formulario.getSaudeF());
            comando.setFloat(43,formulario.getTransporteF());
            comando.setFloat(44,formulario.getIptuF());
            comando.setFloat(45,formulario.getAluguelF());
            comando.setFloat(46,formulario.getPensaoAlimentF());
            comando.setFloat(47,formulario.getOutroF());
            comando.setFloat(48,formulario.getAguaE());
            comando.setFloat(49,formulario.getLuzE());
            comando.setFloat(50,formulario.getTelefoneE());
            comando.setFloat(51,formulario.getCondominioE());
            comando.setFloat(52,formulario.getIptuE());
            comando.setFloat(53,formulario.getAluguelE());
            
            if (formulario.getCandidato() == null) {
                comando.setNull(54, Types.NULL);
            } else {
                comando.setInt(54, formulario.getCandidato().getCodCandidato());
            }
            
            comando.setInt(55, formulario.getCodForm());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
     public static void excluir(Formulario formulario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = " delete from formulario where codForm = " + formulario.getCodForm();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }
}
