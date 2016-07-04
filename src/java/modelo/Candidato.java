/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "candidato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c"),
    @NamedQuery(name = "Candidato.findByCodCandidato", query = "SELECT c FROM Candidato c WHERE c.codCandidato = :codCandidato"),
    @NamedQuery(name = "Candidato.findByNome", query = "SELECT c FROM Candidato c WHERE c.nome = :nome"),
    @NamedQuery(name = "Candidato.findByTelefone", query = "SELECT c FROM Candidato c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Candidato.findByRg", query = "SELECT c FROM Candidato c WHERE c.rg = :rg"),
    @NamedQuery(name = "Candidato.findByCpf", query = "SELECT c FROM Candidato c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "Candidato.findByMatricula", query = "SELECT c FROM Candidato c WHERE c.matricula = :matricula"),
    @NamedQuery(name = "Candidato.findBySexo", query = "SELECT c FROM Candidato c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Candidato.findByRua", query = "SELECT c FROM Candidato c WHERE c.rua = :rua"),
    @NamedQuery(name = "Candidato.findByNumero", query = "SELECT c FROM Candidato c WHERE c.numero = :numero"),
    @NamedQuery(name = "Candidato.findByBairro", query = "SELECT c FROM Candidato c WHERE c.bairro = :bairro"),
    @NamedQuery(name = "Candidato.findByCep", query = "SELECT c FROM Candidato c WHERE c.cep = :cep"),
    @NamedQuery(name = "Candidato.findByComplemento", query = "SELECT c FROM Candidato c WHERE c.complemento = :complemento"),
    @NamedQuery(name = "Candidato.findByUf", query = "SELECT c FROM Candidato c WHERE c.uf = :uf"),
    @NamedQuery(name = "Candidato.findByCidade", query = "SELECT c FROM Candidato c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "Candidato.findByEmail", query = "SELECT c FROM Candidato c WHERE c.email = :email"),
    @NamedQuery(name = "Candidato.findByAnoDeIngresso", query = "SELECT c FROM Candidato c WHERE c.anoDeIngresso = :anoDeIngresso"),
    @NamedQuery(name = "Candidato.findByCelular", query = "SELECT c FROM Candidato c WHERE c.celular = :celular"),
    @NamedQuery(name = "Candidato.findByPrevisaoTermino", query = "SELECT c FROM Candidato c WHERE c.previsaoTermino = :previsaoTermino")})
public class Candidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codCandidato")
    private Integer codCandidato;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private Integer telefone;
    @Size(max = 45)
    @Column(name = "rg")
    private String rg;
    @Column(name = "cpf")
    private Integer cpf;
    @Column(name = "matricula")
    private Integer matricula;
    @Size(max = 45)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 45)
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 45)
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private Integer cep;
    @Size(max = 45)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 45)
    @Column(name = "uf")
    private String uf;
    @Size(max = 45)
    @Column(name = "cidade")
    private String cidade;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "anoDeIngresso")
    private String anoDeIngresso;
    @Column(name = "celular")
    private Integer celular;
    @Size(max = 45)
    @Column(name = "previsaoTermino")
    private String previsaoTermino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cANDIDATOcodCandidato")
    private List<Formulario> formularioList;

    public Candidato() {
    }

    public Candidato(Integer codCandidato) {
        this.codCandidato = codCandidato;
    }

    public Integer getCodCandidato() {
        return codCandidato;
    }

    public void setCodCandidato(Integer codCandidato) {
        this.codCandidato = codCandidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnoDeIngresso() {
        return anoDeIngresso;
    }

    public void setAnoDeIngresso(String anoDeIngresso) {
        this.anoDeIngresso = anoDeIngresso;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getPrevisaoTermino() {
        return previsaoTermino;
    }

    public void setPrevisaoTermino(String previsaoTermino) {
        this.previsaoTermino = previsaoTermino;
    }

    @XmlTransient
    public List<Formulario> getFormularioList() {
        return formularioList;
    }

    public void setFormularioList(List<Formulario> formularioList) {
        this.formularioList = formularioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCandidato != null ? codCandidato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.codCandidato == null && other.codCandidato != null) || (this.codCandidato != null && !this.codCandidato.equals(other.codCandidato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Candidato[ codCandidato=" + codCandidato + " ]";
    }
    
}
