package modelo;

import dao.FormularioDAO;
import java.sql.SQLException;
import java.util.List;

public class Formulario {
    //cadastrar familia
    private int codForm;
    private String responsavelManutencaoFamilia;
    private int qtAutomovel;
    private int qtTvCor;
    private int qtMaquinaDeLavar;
    private int qtGeladeira;
    private int qtTvCabo;
    private int qtPc;
    private int qtInternetPaga;
    private int qtEmpregadaMensalista;
    private int qtEmpregadaDiarista;    
    private int qtBanheiros;
    private int qtQuartos;    
    //instituicao em que cursou fundamental/medio
    private String ensinoFundamental;
    private String ensinoMedio;    
    //cadastro renda familiar
    private String membroFamilia;
    private String estadoCivil;
    private String parentesco;
    private String situacaoTrab;
    private String ocupacao;
    private String escolaridade;
    private float rendaAluguelImovel;
    private float pensaoPorMorte;
    private float pensaoAlimenticia;
    private float ajudaTerceiros;
    private float beneficiosSociais;
    private float rendaMensalBruta;    
    //cadastrar meio locomocao
    private String meioDeLocomocao;    
    //cadastrar atividades
    private String atividadeAcademicas;
    private String atividadeRemunerada;    
    //cadastrar manutenção estudantil
    private String condicaoDeManutencao;    
    //manter moradia
    private String mora;
    private String vcFamilia;
    private String resideFamilia;
    private String imovelSituacao;
    private String descricaoCasa;
    //despesas
    private float aguaF;
    private float luzF;
    private float telefoneF;
    private float condominioF;
    private float mensalidadeEscolaF;
    private float alimentacaoF;
    private float saudeF;
    private float transporteF;
    private float iptuF;
    private float aluguelF;
    private float pensaoAlimentF;
    private float outroF;
    private float aguaE;
    private float luzE;
    private float telefoneE;
    private float condominioE;
    private float iptuE;
    private float aluguelE;
    private Candidato candidato;
    private int codCandidato;
    

    public Formulario(int codForm, String responsavelManutencaoFamilia, int qtAutomovel, int qtTvCor, int qtMaquinaDeLavar, int qtGeladeira, int qtTvCabo, int qtPc, int qtInternetPaga, int qtEmpregadaMensalista, int qtEmpregadaDiarista, int qtBanheiros, int qtQuartos, String ensinoFundamental, String ensinoMedio, String membroFamilia, String estadoCivil, String parentesco, String situacaoTrab, String ocupacao, String escolaridade, float rendaAluguelImovel, float pensaoPorMorte, float pensaoAlimenticia, float ajudaTerceiros, float beneficiosSociais, float rendaMensalBruta, String meioDeLocomocao, String atividadeAcademicas, String atividadeRemunerada, String condicaoDeManutencao, String mora, String vcFamilia, String resideFamilia, String imovelSituacao, String descricaoCasa, float aguaF, float luzF, float telefoneF, float condominioF, float mensalidadeEscolaF, float alimentacaoF, float saudeF, float transporteF, float iptuF, float aluguelF, float pensaoAlimentF, float outroF, float aguaE, float luzE, float telefoneE, float condominioE, float iptuE, float aluguelE, Candidato candidato) {
        this.codForm = codForm;
        this.responsavelManutencaoFamilia = responsavelManutencaoFamilia;
        this.qtAutomovel = qtAutomovel;
        this.qtTvCor = qtTvCor;
        this.qtMaquinaDeLavar = qtMaquinaDeLavar;
        this.qtGeladeira = qtGeladeira;
        this.qtTvCabo = qtTvCabo;
        this.qtPc = qtPc;
        this.qtInternetPaga = qtInternetPaga;
        this.qtEmpregadaMensalista = qtEmpregadaMensalista;
        this.qtEmpregadaDiarista = qtEmpregadaDiarista;
        this.qtBanheiros = qtBanheiros;
        this.qtQuartos = qtQuartos;
        this.ensinoFundamental = ensinoFundamental;
        this.ensinoMedio = ensinoMedio;
        this.membroFamilia = membroFamilia;
        this.estadoCivil = estadoCivil;
        this.parentesco = parentesco;
        this.situacaoTrab = situacaoTrab;
        this.ocupacao = ocupacao;
        this.escolaridade = escolaridade;
        this.rendaAluguelImovel = rendaAluguelImovel;
        this.pensaoPorMorte = pensaoPorMorte;
        this.pensaoAlimenticia = pensaoAlimenticia;
        this.ajudaTerceiros = ajudaTerceiros;
        this.beneficiosSociais = beneficiosSociais;
        this.rendaMensalBruta = rendaMensalBruta;
        this.meioDeLocomocao = meioDeLocomocao;
        this.atividadeAcademicas = atividadeAcademicas;
        this.atividadeRemunerada = atividadeRemunerada;
        this.condicaoDeManutencao = condicaoDeManutencao;
        this.mora = mora;
        this.vcFamilia = vcFamilia;
        this.resideFamilia = resideFamilia;
        this.imovelSituacao = imovelSituacao;
        this.descricaoCasa = descricaoCasa;
        this.aguaF = aguaF;
        this.luzF = luzF;
        this.telefoneF = telefoneF;
        this.condominioF = condominioF;
        this.mensalidadeEscolaF = mensalidadeEscolaF;
        this.alimentacaoF = alimentacaoF;
        this.saudeF = saudeF;
        this.transporteF = transporteF;
        this.iptuF = iptuF;
        this.aluguelF = aluguelF;
        this.pensaoAlimentF = pensaoAlimentF;
        this.outroF = outroF;
        this.aguaE = aguaE;
        this.luzE = luzE;
        this.telefoneE = telefoneE;
        this.condominioE = condominioE;
        this.iptuE = iptuE;
        this.aluguelE = aluguelE;
        this.candidato = candidato;
    }

    public String getResponsavelManutencaoFamilia() {
        return responsavelManutencaoFamilia;
    }

    public void setResponsavelManutencaoFamilia(String responsavelManutencaoFamilia) {
        this.responsavelManutencaoFamilia = responsavelManutencaoFamilia;
    }

    public int getQtAutomovel() {
        return qtAutomovel;
    }

    public void setQtAutomovel(int qtAutomovel) {
        this.qtAutomovel = qtAutomovel;
    }

    public int getQtTvCor() {
        return qtTvCor;
    }

    public void setQtTvCor(int qtTvCor) {
        this.qtTvCor = qtTvCor;
    }

    public int getQtMaquinaDeLavar() {
        return qtMaquinaDeLavar;
    }

    public void setQtMaquinaDeLavar(int qtMaquinaDeLavar) {
        this.qtMaquinaDeLavar = qtMaquinaDeLavar;
    }

    public int getQtGeladeira() {
        return qtGeladeira;
    }

    public void setQtGeladeira(int qtGeladeira) {
        this.qtGeladeira = qtGeladeira;
    }

    public int getQtTvCabo() {
        return qtTvCabo;
    }

    public void setQtTvCabo(int qtTvCabo) {
        this.qtTvCabo = qtTvCabo;
    }

    public int getQtPc() {
        return qtPc;
    }

    public void setQtPc(int qtPc) {
        this.qtPc = qtPc;
    }

    public int getQtInternetPaga() {
        return qtInternetPaga;
    }

    public void setQtInternetPaga(int qtInternetPaga) {
        this.qtInternetPaga = qtInternetPaga;
    }

    public int getQtEmpregadaMensalista() {
        return qtEmpregadaMensalista;
    }

    public void setQtEmpregadaMensalista(int qtEmpregadaMensalista) {
        this.qtEmpregadaMensalista = qtEmpregadaMensalista;
    }

    public int getQtEmpregadaDiarista() {
        return qtEmpregadaDiarista;
    }

    public void setQtEmpregadaDiarista(int qtEmpregadaDiarista) {
        this.qtEmpregadaDiarista = qtEmpregadaDiarista;
    }

    public int getQtBanheiros() {
        return qtBanheiros;
    }

    public void setQtBanheiros(int qtBanheiros) {
        this.qtBanheiros = qtBanheiros;
    }

    public int getQtQuartos() {
        return qtQuartos;
    }

    public void setQtQuartos(int qtQuartos) {
        this.qtQuartos = qtQuartos;
    }

    public String getEnsinoFundamental() {
        return ensinoFundamental;
    }

    public void setEnsinoFundamental(String ensinoFundamental) {
        this.ensinoFundamental = ensinoFundamental;
    }

    public String getEnsinoMedio() {
        return ensinoMedio;
    }

    public void setEnsinoMedio(String ensinoMedio) {
        this.ensinoMedio = ensinoMedio;
    }

    public String getMembroFamilia() {
        return membroFamilia;
    }

    public void setMembroFamilia(String membroFamilia) {
        this.membroFamilia = membroFamilia;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getSituacaoTrab() {
        return situacaoTrab;
    }

    public void setSituacaoTrab(String situacaoTrab) {
        this.situacaoTrab = situacaoTrab;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public float getRendaAluguelImovel() {
        return rendaAluguelImovel;
    }

    public void setRendaAluguelImovel(float rendaAluguelImovel) {
        this.rendaAluguelImovel = rendaAluguelImovel;
    }

    public float getPensaoPorMorte() {
        return pensaoPorMorte;
    }

    public void setPensaoPorMorte(float pensaoPorMorte) {
        this.pensaoPorMorte = pensaoPorMorte;
    }

    public float getPensaoAlimenticia() {
        return pensaoAlimenticia;
    }

    public void setPensaoAlimenticia(float pensaoAlimenticia) {
        this.pensaoAlimenticia = pensaoAlimenticia;
    }

    public float getAjudaTerceiros() {
        return ajudaTerceiros;
    }

    public void setAjudaTerceiros(float ajudaTerceiros) {
        this.ajudaTerceiros = ajudaTerceiros;
    }

    public float getBeneficiosSociais() {
        return beneficiosSociais;
    }

    public void setBeneficiosSociais(float beneficiosSociais) {
        this.beneficiosSociais = beneficiosSociais;
    }

    public float getRendaMensalBruta() {
        return rendaMensalBruta;
    }

    public void setRendaMensalBruta(float rendaMensalBruta) {
        this.rendaMensalBruta = rendaMensalBruta;
    }

    public String getMeioDeLocomocao() {
        return meioDeLocomocao;
    }

    public void setMeioDeLocomocao(String meioDeLocomocao) {
        this.meioDeLocomocao = meioDeLocomocao;
    }

    public String getAtividdeAcademicas() {
        return atividadeAcademicas;
    }

    public void setAtividdeAcademicas(String atividdeAcademicas) {
        this.atividadeAcademicas = atividdeAcademicas;
    }

    public String getAtividadeRemunerada() {
        return atividadeRemunerada;
    }

    public void setAtividadeRemunerada(String atividadeRemunerada) {
        this.atividadeRemunerada = atividadeRemunerada;
    }

    public String getCondicaoDeManutencao() {
        return condicaoDeManutencao;
    }

    public void setCondicaoDeManutencao(String condicaoDeManutencao) {
        this.condicaoDeManutencao = condicaoDeManutencao;
    }

    public String getMora() {
        return mora;
    }

    public void setMora(String mora) {
        this.mora = mora;
    }

    public String getBcFamilia() {
        return vcFamilia;
    }

    public void setBcFamilia(String bcFamilia) {
        this.vcFamilia = bcFamilia;
    }

    public String getResideFamilia() {
        return resideFamilia;
    }

    public void setResideFamilia(String resideFamilia) {
        this.resideFamilia = resideFamilia;
    }

    public String getImovelSituacao() {
        return imovelSituacao;
    }

    public void setImovelSituacao(String imovelSituacao) {
        this.imovelSituacao = imovelSituacao;
    }

    public String getDescricaoCasa() {
        return descricaoCasa;
    }

    public void setDescricaoCasa(String descricaoCasa) {
        this.descricaoCasa = descricaoCasa;
    }

    public float getAguaF() {
        return aguaF;
    }

    public void setAguaF(float aguaF) {
        this.aguaF = aguaF;
    }

    public float getLuzF() {
        return luzF;
    }

    public void setLuzF(float luzF) {
        this.luzF = luzF;
    }

    public float getTelefoneF() {
        return telefoneF;
    }

    public void setTelefoneF(float telefoneF) {
        this.telefoneF = telefoneF;
    }

    public float getCondominioF() {
        return condominioF;
    }

    public void setCondominioF(float condominioF) {
        this.condominioF = condominioF;
    }

    public float getMensalidadeEscolaF() {
        return mensalidadeEscolaF;
    }

    public void setMensalidadeEscolaF(float mensalidadeEscolaF) {
        this.mensalidadeEscolaF = mensalidadeEscolaF;
    }

    public float getAlimentacaoF() {
        return alimentacaoF;
    }

    public void setAlimentacaoF(float alimentacaoF) {
        this.alimentacaoF = alimentacaoF;
    }

    public float getSaudeF() {
        return saudeF;
    }

    public void setSaudeF(float saudeF) {
        this.saudeF = saudeF;
    }

    public float getTransporteF() {
        return transporteF;
    }

    public void setTransporteF(float transporteF) {
        this.transporteF = transporteF;
    }

    public float getIptuF() {
        return iptuF;
    }

    public void setIptuF(float iptuF) {
        this.iptuF = iptuF;
    }

    public float getAluguelF() {
        return aluguelF;
    }

    public void setAluguelF(float aluguelF) {
        this.aluguelF = aluguelF;
    }

    public float getPensaoAlimentF() {
        return pensaoAlimentF;
    }

    public void setPensaoAlimentF(float pensaoAlimentF) {
        this.pensaoAlimentF = pensaoAlimentF;
    }

    public float getOutroF() {
        return outroF;
    }

    public void setOutroF(float outroF) {
        this.outroF = outroF;
    }

    public float getAguaE() {
        return aguaE;
    }

    public void setAguaE(float aguaE) {
        this.aguaE = aguaE;
    }

    public float getLuzE() {
        return luzE;
    }

    public void setLuzE(float luzE) {
        this.luzE = luzE;
    }

    public float getTelefoneE() {
        return telefoneE;
    }

    public void setTelefoneE(float telefoneE) {
        this.telefoneE = telefoneE;
    }

    public float getCondominioE() {
        return condominioE;
    }

    public void setCondominioE(float condominioE) {
        this.condominioE = condominioE;
    }

    public float getIptuE() {
        return iptuE;
    }

    public void setIptuE(float iptuE) {
        this.iptuE = iptuE;
    }

    public float getAluguelE() {
        return aluguelE;
    }

    public void setAluguelE(float aluguelE) {
        this.aluguelE = aluguelE;
    }

    public int getCodForm() {
        return codForm;
    }

    public void setCodForm(int codForm) {
        this.codForm = codForm;
    }

    public String getAtividadeAcademicas() {
        return atividadeAcademicas;
    }

    public void setAtividadeAcademicas(String atividadeAcademicas) {
        this.atividadeAcademicas = atividadeAcademicas;
    }

    public String getVcFamilia() {
        return vcFamilia;
    }

    public void setVcFamilia(String vcFamilia) {
        this.vcFamilia = vcFamilia;
    }
    public static List<Formulario> obterFormularios() throws ClassNotFoundException {
        return FormularioDAO.obterFormularios();
    }
    public static Formulario obterFormulario(int codFormulario) throws ClassNotFoundException {
        return FormularioDAO.obterFormulario(codFormulario);
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        FormularioDAO.gravar(this);
    }
     public void alterar() throws SQLException, ClassNotFoundException {
        FormularioDAO.alterar(this);
    }
     public void excluir() throws SQLException, ClassNotFoundException {
        FormularioDAO.excluir(this);
    }

    public Candidato getCandidato() throws ClassNotFoundException {
        if ((codCandidato != 0) && (candidato == null)) {
            candidato = Candidato.obterCandidato(codCandidato);
        }
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public int getCodCandidato() {
        return codCandidato;
    }

    public void setCodCandidato(int codCandidato) {
        this.codCandidato = codCandidato;
    }

    
    
    
}
