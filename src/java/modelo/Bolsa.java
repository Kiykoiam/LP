/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "bolsa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bolsa.findAll", query = "SELECT b FROM Bolsa b"),
    @NamedQuery(name = "Bolsa.findByCodBolsa", query = "SELECT b FROM Bolsa b WHERE b.codBolsa = :codBolsa"),
    @NamedQuery(name = "Bolsa.findByNome", query = "SELECT b FROM Bolsa b WHERE b.nome = :nome"),
    @NamedQuery(name = "Bolsa.findByQtdadeVagas", query = "SELECT b FROM Bolsa b WHERE b.qtdadeVagas = :qtdadeVagas"),
    @NamedQuery(name = "Bolsa.findByDescricao", query = "SELECT b FROM Bolsa b WHERE b.descricao = :descricao"),
    @NamedQuery(name = "Bolsa.findByRequisitos", query = "SELECT b FROM Bolsa b WHERE b.requisitos = :requisitos")})
public class Bolsa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codBolsa")
    private Integer codBolsa;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Column(name = "qtdadeVagas")
    private Integer qtdadeVagas;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 45)
    @Column(name = "requisitos")
    private String requisitos;
    @OneToMany(mappedBy = "bOLSAcodBolsa")
    private List<Edital> editalList;

    public Bolsa() {
    }

    public Bolsa(Integer codBolsa) {
        this.codBolsa = codBolsa;
    }

    public Integer getCodBolsa() {
        return codBolsa;
    }

    public void setCodBolsa(Integer codBolsa) {
        this.codBolsa = codBolsa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdadeVagas() {
        return qtdadeVagas;
    }

    public void setQtdadeVagas(Integer qtdadeVagas) {
        this.qtdadeVagas = qtdadeVagas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    @XmlTransient
    public List<Edital> getEditalList() {
        return editalList;
    }

    public void setEditalList(List<Edital> editalList) {
        this.editalList = editalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBolsa != null ? codBolsa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bolsa)) {
            return false;
        }
        Bolsa other = (Bolsa) object;
        if ((this.codBolsa == null && other.codBolsa != null) || (this.codBolsa != null && !this.codBolsa.equals(other.codBolsa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Bolsa[ codBolsa=" + codBolsa + " ]";
    }
    
}
