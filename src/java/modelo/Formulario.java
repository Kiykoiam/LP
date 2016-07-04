/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "formulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formulario.findAll", query = "SELECT f FROM Formulario f"),
    @NamedQuery(name = "Formulario.findByCodForm", query = "SELECT f FROM Formulario f WHERE f.codForm = :codForm"),
    @NamedQuery(name = "Formulario.findByResponsavelManutencaoFamilia", query = "SELECT f FROM Formulario f WHERE f.responsavelManutencaoFamilia = :responsavelManutencaoFamilia"),
    @NamedQuery(name = "Formulario.findByQtAutomovel", query = "SELECT f FROM Formulario f WHERE f.qtAutomovel = :qtAutomovel"),
    @NamedQuery(name = "Formulario.findByQtTvCor", query = "SELECT f FROM Formulario f WHERE f.qtTvCor = :qtTvCor"),
    @NamedQuery(name = "Formulario.findByQtMaquinaDeLavar", query = "SELECT f FROM Formulario f WHERE f.qtMaquinaDeLavar = :qtMaquinaDeLavar"),
    @NamedQuery(name = "Formulario.findByQtGeladeira", query = "SELECT f FROM Formulario f WHERE f.qtGeladeira = :qtGeladeira"),
    @NamedQuery(name = "Formulario.findByQtTvCabo", query = "SELECT f FROM Formulario f WHERE f.qtTvCabo = :qtTvCabo"),
    @NamedQuery(name = "Formulario.findByQtPc", query = "SELECT f FROM Formulario f WHERE f.qtPc = :qtPc"),
    @NamedQuery(name = "Formulario.findByQtInternetPaga", query = "SELECT f FROM Formulario f WHERE f.qtInternetPaga = :qtInternetPaga"),
    @NamedQuery(name = "Formulario.findByQtEmpregadaMensalista", query = "SELECT f FROM Formulario f WHERE f.qtEmpregadaMensalista = :qtEmpregadaMensalista"),
    @NamedQuery(name = "Formulario.findByQtEmpregadaDiarista", query = "SELECT f FROM Formulario f WHERE f.qtEmpregadaDiarista = :qtEmpregadaDiarista"),
    @NamedQuery(name = "Formulario.findByQtBanheiros", query = "SELECT f FROM Formulario f WHERE f.qtBanheiros = :qtBanheiros"),
    @NamedQuery(name = "Formulario.findByQtQuartos", query = "SELECT f FROM Formulario f WHERE f.qtQuartos = :qtQuartos"),
    @NamedQuery(name = "Formulario.findByEnsinoFundamental", query = "SELECT f FROM Formulario f WHERE f.ensinoFundamental = :ensinoFundamental"),
    @NamedQuery(name = "Formulario.findByEnsinoMedio", query = "SELECT f FROM Formulario f WHERE f.ensinoMedio = :ensinoMedio"),
    @NamedQuery(name = "Formulario.findByMembroFamilia", query = "SELECT f FROM Formulario f WHERE f.membroFamilia = :membroFamilia"),
    @NamedQuery(name = "Formulario.findByEstadoCivil", query = "SELECT f FROM Formulario f WHERE f.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Formulario.findByParentesco", query = "SELECT f FROM Formulario f WHERE f.parentesco = :parentesco"),
    @NamedQuery(name = "Formulario.findBySituacaoTrab", query = "SELECT f FROM Formulario f WHERE f.situacaoTrab = :situacaoTrab"),
    @NamedQuery(name = "Formulario.findByOcupacao", query = "SELECT f FROM Formulario f WHERE f.ocupacao = :ocupacao"),
    @NamedQuery(name = "Formulario.findByEscolaridade", query = "SELECT f FROM Formulario f WHERE f.escolaridade = :escolaridade"),
    @NamedQuery(name = "Formulario.findByRendaAluguelImovel", query = "SELECT f FROM Formulario f WHERE f.rendaAluguelImovel = :rendaAluguelImovel"),
    @NamedQuery(name = "Formulario.findByPensaoPorMorte", query = "SELECT f FROM Formulario f WHERE f.pensaoPorMorte = :pensaoPorMorte"),
    @NamedQuery(name = "Formulario.findByPensaoAlimenticia", query = "SELECT f FROM Formulario f WHERE f.pensaoAlimenticia = :pensaoAlimenticia"),
    @NamedQuery(name = "Formulario.findByAjudaTerceiros", query = "SELECT f FROM Formulario f WHERE f.ajudaTerceiros = :ajudaTerceiros"),
    @NamedQuery(name = "Formulario.findByBeneficiosSociais", query = "SELECT f FROM Formulario f WHERE f.beneficiosSociais = :beneficiosSociais"),
    @NamedQuery(name = "Formulario.findByRendaMensalBruta", query = "SELECT f FROM Formulario f WHERE f.rendaMensalBruta = :rendaMensalBruta"),
    @NamedQuery(name = "Formulario.findByMeioDeLocomocao", query = "SELECT f FROM Formulario f WHERE f.meioDeLocomocao = :meioDeLocomocao"),
    @NamedQuery(name = "Formulario.findByAtividadeAcademicas", query = "SELECT f FROM Formulario f WHERE f.atividadeAcademicas = :atividadeAcademicas"),
    @NamedQuery(name = "Formulario.findByAtividadeRemunerada", query = "SELECT f FROM Formulario f WHERE f.atividadeRemunerada = :atividadeRemunerada"),
    @NamedQuery(name = "Formulario.findByCondicaoDeManutencao", query = "SELECT f FROM Formulario f WHERE f.condicaoDeManutencao = :condicaoDeManutencao"),
    @NamedQuery(name = "Formulario.findByMora", query = "SELECT f FROM Formulario f WHERE f.mora = :mora"),
    @NamedQuery(name = "Formulario.findByVcFamilia", query = "SELECT f FROM Formulario f WHERE f.vcFamilia = :vcFamilia"),
    @NamedQuery(name = "Formulario.findByResideFamilia", query = "SELECT f FROM Formulario f WHERE f.resideFamilia = :resideFamilia"),
    @NamedQuery(name = "Formulario.findByImovelSituacao", query = "SELECT f FROM Formulario f WHERE f.imovelSituacao = :imovelSituacao"),
    @NamedQuery(name = "Formulario.findByDescricaoCasa", query = "SELECT f FROM Formulario f WHERE f.descricaoCasa = :descricaoCasa"),
    @NamedQuery(name = "Formulario.findByAguaF", query = "SELECT f FROM Formulario f WHERE f.aguaF = :aguaF"),
    @NamedQuery(name = "Formulario.findByLuzF", query = "SELECT f FROM Formulario f WHERE f.luzF = :luzF"),
    @NamedQuery(name = "Formulario.findByTelefoneF", query = "SELECT f FROM Formulario f WHERE f.telefoneF = :telefoneF"),
    @NamedQuery(name = "Formulario.findByCondominioF", query = "SELECT f FROM Formulario f WHERE f.condominioF = :condominioF"),
    @NamedQuery(name = "Formulario.findByMensalidadeEscolaF", query = "SELECT f FROM Formulario f WHERE f.mensalidadeEscolaF = :mensalidadeEscolaF"),
    @NamedQuery(name = "Formulario.findByAlimentacaoF", query = "SELECT f FROM Formulario f WHERE f.alimentacaoF = :alimentacaoF"),
    @NamedQuery(name = "Formulario.findBySaudeF", query = "SELECT f FROM Formulario f WHERE f.saudeF = :saudeF"),
    @NamedQuery(name = "Formulario.findByTransporteF", query = "SELECT f FROM Formulario f WHERE f.transporteF = :transporteF"),
    @NamedQuery(name = "Formulario.findByIptuF", query = "SELECT f FROM Formulario f WHERE f.iptuF = :iptuF"),
    @NamedQuery(name = "Formulario.findByAluguelF", query = "SELECT f FROM Formulario f WHERE f.aluguelF = :aluguelF"),
    @NamedQuery(name = "Formulario.findByPensaoAlimentF", query = "SELECT f FROM Formulario f WHERE f.pensaoAlimentF = :pensaoAlimentF"),
    @NamedQuery(name = "Formulario.findByOutroF", query = "SELECT f FROM Formulario f WHERE f.outroF = :outroF"),
    @NamedQuery(name = "Formulario.findByAguaE", query = "SELECT f FROM Formulario f WHERE f.aguaE = :aguaE"),
    @NamedQuery(name = "Formulario.findByLuzE", query = "SELECT f FROM Formulario f WHERE f.luzE = :luzE"),
    @NamedQuery(name = "Formulario.findByTelefoneE", query = "SELECT f FROM Formulario f WHERE f.telefoneE = :telefoneE"),
    @NamedQuery(name = "Formulario.findByCondominioE", query = "SELECT f FROM Formulario f WHERE f.condominioE = :condominioE"),
    @NamedQuery(name = "Formulario.findByIptuE", query = "SELECT f FROM Formulario f WHERE f.iptuE = :iptuE"),
    @NamedQuery(name = "Formulario.findByAluguelE", query = "SELECT f FROM Formulario f WHERE f.aluguelE = :aluguelE")})
public class Formulario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codForm")
    private Integer codForm;
    @Size(max = 40)
    @Column(name = "responsavelManutencaoFamilia")
    private String responsavelManutencaoFamilia;
    @Column(name = "qtAutomovel")
    private Integer qtAutomovel;
    @Column(name = "qtTvCor")
    private Integer qtTvCor;
    @Column(name = "qtMaquinaDeLavar")
    private Integer qtMaquinaDeLavar;
    @Column(name = "qtGeladeira")
    private Integer qtGeladeira;
    @Column(name = "qtTvCabo")
    private Integer qtTvCabo;
    @Column(name = "qtPc")
    private Integer qtPc;
    @Column(name = "qtInternetPaga")
    private Integer qtInternetPaga;
    @Column(name = "qtEmpregadaMensalista")
    private Integer qtEmpregadaMensalista;
    @Column(name = "qtEmpregadaDiarista")
    private Integer qtEmpregadaDiarista;
    @Column(name = "qtBanheiros")
    private Integer qtBanheiros;
    @Column(name = "qtQuartos")
    private Integer qtQuartos;
    @Size(max = 45)
    @Column(name = "ensinoFundamental")
    private String ensinoFundamental;
    @Size(max = 45)
    @Column(name = "ensinoMedio")
    private String ensinoMedio;
    @Size(max = 45)
    @Column(name = "membroFamilia")
    private String membroFamilia;
    @Size(max = 45)
    @Column(name = "estadoCivil")
    private String estadoCivil;
    @Size(max = 45)
    @Column(name = "parentesco")
    private String parentesco;
    @Size(max = 45)
    @Column(name = "situacaoTrab")
    private String situacaoTrab;
    @Size(max = 45)
    @Column(name = "ocupacao")
    private String ocupacao;
    @Size(max = 45)
    @Column(name = "escolaridade")
    private String escolaridade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rendaAluguelImovel")
    private Float rendaAluguelImovel;
    @Column(name = "pensaoPorMorte")
    private Float pensaoPorMorte;
    @Column(name = "pensaoAlimenticia")
    private Float pensaoAlimenticia;
    @Column(name = "ajudaTerceiros")
    private Float ajudaTerceiros;
    @Column(name = "beneficiosSociais")
    private Float beneficiosSociais;
    @Column(name = "rendaMensalBruta")
    private Float rendaMensalBruta;
    @Size(max = 40)
    @Column(name = "meioDeLocomocao")
    private String meioDeLocomocao;
    @Size(max = 45)
    @Column(name = "atividadeAcademicas")
    private String atividadeAcademicas;
    @Size(max = 45)
    @Column(name = "atividadeRemunerada")
    private String atividadeRemunerada;
    @Size(max = 45)
    @Column(name = "condicaoDeManutencao")
    private String condicaoDeManutencao;
    @Size(max = 45)
    @Column(name = "mora")
    private String mora;
    @Size(max = 45)
    @Column(name = "vcFamilia")
    private String vcFamilia;
    @Size(max = 45)
    @Column(name = "resideFamilia")
    private String resideFamilia;
    @Size(max = 45)
    @Column(name = "imovelSituacao")
    private String imovelSituacao;
    @Size(max = 45)
    @Column(name = "descricaoCasa")
    private String descricaoCasa;
    @Column(name = "aguaF")
    private Float aguaF;
    @Column(name = "luzF")
    private Float luzF;
    @Column(name = "telefoneF")
    private Float telefoneF;
    @Column(name = "condominioF")
    private Float condominioF;
    @Column(name = "mensalidadeEscolaF")
    private Float mensalidadeEscolaF;
    @Column(name = "alimentacaoF")
    private Float alimentacaoF;
    @Column(name = "saudeF")
    private Float saudeF;
    @Column(name = "transporteF")
    private Float transporteF;
    @Column(name = "iptuF")
    private Float iptuF;
    @Column(name = "aluguelF")
    private Float aluguelF;
    @Column(name = "pensaoAlimentF")
    private Float pensaoAlimentF;
    @Column(name = "outroF")
    private Float outroF;
    @Column(name = "aguaE")
    private Float aguaE;
    @Column(name = "luzE")
    private Float luzE;
    @Column(name = "telefoneE")
    private Float telefoneE;
    @Column(name = "condominioE")
    private Float condominioE;
    @Column(name = "iptuE")
    private Float iptuE;
    @Column(name = "aluguelE")
    private Float aluguelE;
    @JoinColumn(name = "CANDIDATO_codCandidato", referencedColumnName = "codCandidato")
    @ManyToOne(optional = false)
    private Candidato cANDIDATOcodCandidato;

    public Formulario() {
    }

    public Formulario(Integer codForm) {
        this.codForm = codForm;
    }

    public Integer getCodForm() {
        return codForm;
    }

    public void setCodForm(Integer codForm) {
        this.codForm = codForm;
    }

    public String getResponsavelManutencaoFamilia() {
        return responsavelManutencaoFamilia;
    }

    public void setResponsavelManutencaoFamilia(String responsavelManutencaoFamilia) {
        this.responsavelManutencaoFamilia = responsavelManutencaoFamilia;
    }

    public Integer getQtAutomovel() {
        return qtAutomovel;
    }

    public void setQtAutomovel(Integer qtAutomovel) {
        this.qtAutomovel = qtAutomovel;
    }

    public Integer getQtTvCor() {
        return qtTvCor;
    }

    public void setQtTvCor(Integer qtTvCor) {
        this.qtTvCor = qtTvCor;
    }

    public Integer getQtMaquinaDeLavar() {
        return qtMaquinaDeLavar;
    }

    public void setQtMaquinaDeLavar(Integer qtMaquinaDeLavar) {
        this.qtMaquinaDeLavar = qtMaquinaDeLavar;
    }

    public Integer getQtGeladeira() {
        return qtGeladeira;
    }

    public void setQtGeladeira(Integer qtGeladeira) {
        this.qtGeladeira = qtGeladeira;
    }

    public Integer getQtTvCabo() {
        return qtTvCabo;
    }

    public void setQtTvCabo(Integer qtTvCabo) {
        this.qtTvCabo = qtTvCabo;
    }

    public Integer getQtPc() {
        return qtPc;
    }

    public void setQtPc(Integer qtPc) {
        this.qtPc = qtPc;
    }

    public Integer getQtInternetPaga() {
        return qtInternetPaga;
    }

    public void setQtInternetPaga(Integer qtInternetPaga) {
        this.qtInternetPaga = qtInternetPaga;
    }

    public Integer getQtEmpregadaMensalista() {
        return qtEmpregadaMensalista;
    }

    public void setQtEmpregadaMensalista(Integer qtEmpregadaMensalista) {
        this.qtEmpregadaMensalista = qtEmpregadaMensalista;
    }

    public Integer getQtEmpregadaDiarista() {
        return qtEmpregadaDiarista;
    }

    public void setQtEmpregadaDiarista(Integer qtEmpregadaDiarista) {
        this.qtEmpregadaDiarista = qtEmpregadaDiarista;
    }

    public Integer getQtBanheiros() {
        return qtBanheiros;
    }

    public void setQtBanheiros(Integer qtBanheiros) {
        this.qtBanheiros = qtBanheiros;
    }

    public Integer getQtQuartos() {
        return qtQuartos;
    }

    public void setQtQuartos(Integer qtQuartos) {
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

    public Float getRendaAluguelImovel() {
        return rendaAluguelImovel;
    }

    public void setRendaAluguelImovel(Float rendaAluguelImovel) {
        this.rendaAluguelImovel = rendaAluguelImovel;
    }

    public Float getPensaoPorMorte() {
        return pensaoPorMorte;
    }

    public void setPensaoPorMorte(Float pensaoPorMorte) {
        this.pensaoPorMorte = pensaoPorMorte;
    }

    public Float getPensaoAlimenticia() {
        return pensaoAlimenticia;
    }

    public void setPensaoAlimenticia(Float pensaoAlimenticia) {
        this.pensaoAlimenticia = pensaoAlimenticia;
    }

    public Float getAjudaTerceiros() {
        return ajudaTerceiros;
    }

    public void setAjudaTerceiros(Float ajudaTerceiros) {
        this.ajudaTerceiros = ajudaTerceiros;
    }

    public Float getBeneficiosSociais() {
        return beneficiosSociais;
    }

    public void setBeneficiosSociais(Float beneficiosSociais) {
        this.beneficiosSociais = beneficiosSociais;
    }

    public Float getRendaMensalBruta() {
        return rendaMensalBruta;
    }

    public void setRendaMensalBruta(Float rendaMensalBruta) {
        this.rendaMensalBruta = rendaMensalBruta;
    }

    public String getMeioDeLocomocao() {
        return meioDeLocomocao;
    }

    public void setMeioDeLocomocao(String meioDeLocomocao) {
        this.meioDeLocomocao = meioDeLocomocao;
    }

    public String getAtividadeAcademicas() {
        return atividadeAcademicas;
    }

    public void setAtividadeAcademicas(String atividadeAcademicas) {
        this.atividadeAcademicas = atividadeAcademicas;
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

    public String getVcFamilia() {
        return vcFamilia;
    }

    public void setVcFamilia(String vcFamilia) {
        this.vcFamilia = vcFamilia;
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

    public Float getAguaF() {
        return aguaF;
    }

    public void setAguaF(Float aguaF) {
        this.aguaF = aguaF;
    }

    public Float getLuzF() {
        return luzF;
    }

    public void setLuzF(Float luzF) {
        this.luzF = luzF;
    }

    public Float getTelefoneF() {
        return telefoneF;
    }

    public void setTelefoneF(Float telefoneF) {
        this.telefoneF = telefoneF;
    }

    public Float getCondominioF() {
        return condominioF;
    }

    public void setCondominioF(Float condominioF) {
        this.condominioF = condominioF;
    }

    public Float getMensalidadeEscolaF() {
        return mensalidadeEscolaF;
    }

    public void setMensalidadeEscolaF(Float mensalidadeEscolaF) {
        this.mensalidadeEscolaF = mensalidadeEscolaF;
    }

    public Float getAlimentacaoF() {
        return alimentacaoF;
    }

    public void setAlimentacaoF(Float alimentacaoF) {
        this.alimentacaoF = alimentacaoF;
    }

    public Float getSaudeF() {
        return saudeF;
    }

    public void setSaudeF(Float saudeF) {
        this.saudeF = saudeF;
    }

    public Float getTransporteF() {
        return transporteF;
    }

    public void setTransporteF(Float transporteF) {
        this.transporteF = transporteF;
    }

    public Float getIptuF() {
        return iptuF;
    }

    public void setIptuF(Float iptuF) {
        this.iptuF = iptuF;
    }

    public Float getAluguelF() {
        return aluguelF;
    }

    public void setAluguelF(Float aluguelF) {
        this.aluguelF = aluguelF;
    }

    public Float getPensaoAlimentF() {
        return pensaoAlimentF;
    }

    public void setPensaoAlimentF(Float pensaoAlimentF) {
        this.pensaoAlimentF = pensaoAlimentF;
    }

    public Float getOutroF() {
        return outroF;
    }

    public void setOutroF(Float outroF) {
        this.outroF = outroF;
    }

    public Float getAguaE() {
        return aguaE;
    }

    public void setAguaE(Float aguaE) {
        this.aguaE = aguaE;
    }

    public Float getLuzE() {
        return luzE;
    }

    public void setLuzE(Float luzE) {
        this.luzE = luzE;
    }

    public Float getTelefoneE() {
        return telefoneE;
    }

    public void setTelefoneE(Float telefoneE) {
        this.telefoneE = telefoneE;
    }

    public Float getCondominioE() {
        return condominioE;
    }

    public void setCondominioE(Float condominioE) {
        this.condominioE = condominioE;
    }

    public Float getIptuE() {
        return iptuE;
    }

    public void setIptuE(Float iptuE) {
        this.iptuE = iptuE;
    }

    public Float getAluguelE() {
        return aluguelE;
    }

    public void setAluguelE(Float aluguelE) {
        this.aluguelE = aluguelE;
    }

    public Candidato getCANDIDATOcodCandidato() {
        return cANDIDATOcodCandidato;
    }

    public void setCANDIDATOcodCandidato(Candidato cANDIDATOcodCandidato) {
        this.cANDIDATOcodCandidato = cANDIDATOcodCandidato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codForm != null ? codForm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulario)) {
            return false;
        }
        Formulario other = (Formulario) object;
        if ((this.codForm == null && other.codForm != null) || (this.codForm != null && !this.codForm.equals(other.codForm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Formulario[ codForm=" + codForm + " ]";
    }
    
}
