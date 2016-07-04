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
@Table(name = "edital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edital.findAll", query = "SELECT e FROM Edital e"),
    @NamedQuery(name = "Edital.findByCodEdital", query = "SELECT e FROM Edital e WHERE e.codEdital = :codEdital"),
    @NamedQuery(name = "Edital.findByAno", query = "SELECT e FROM Edital e WHERE e.ano = :ano"),
    @NamedQuery(name = "Edital.findByDescricao", query = "SELECT e FROM Edital e WHERE e.descricao = :descricao"),
    @NamedQuery(name = "Edital.findByCategoria", query = "SELECT e FROM Edital e WHERE e.categoria = :categoria"),
    @NamedQuery(name = "Edital.findByNumero", query = "SELECT e FROM Edital e WHERE e.numero = :numero")})
public class Edital implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codEdital")
    private Integer codEdital;
    @Size(max = 40)
    @Column(name = "ano")
    private String ano;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 45)
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "numero")
    private Integer numero;
    @JoinColumn(name = "BOLSA_codBolsa", referencedColumnName = "codBolsa")
    @ManyToOne
    private Bolsa bOLSAcodBolsa;
    @JoinColumn(name = "FUNCIONARIO_codFuncionario", referencedColumnName = "codFuncionario")
    @ManyToOne
    private Funcionario fUNCIONARIOcodFuncionario;

    public Edital() {
    }

    public Edital(Integer codEdital) {
        this.codEdital = codEdital;
    }

    public Integer getCodEdital() {
        return codEdital;
    }

    public void setCodEdital(Integer codEdital) {
        this.codEdital = codEdital;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Bolsa getBOLSAcodBolsa() {
        return bOLSAcodBolsa;
    }

    public void setBOLSAcodBolsa(Bolsa bOLSAcodBolsa) {
        this.bOLSAcodBolsa = bOLSAcodBolsa;
    }

    public Funcionario getFUNCIONARIOcodFuncionario() {
        return fUNCIONARIOcodFuncionario;
    }

    public void setFUNCIONARIOcodFuncionario(Funcionario fUNCIONARIOcodFuncionario) {
        this.fUNCIONARIOcodFuncionario = fUNCIONARIOcodFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEdital != null ? codEdital.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edital)) {
            return false;
        }
        Edital other = (Edital) object;
        if ((this.codEdital == null && other.codEdital != null) || (this.codEdital != null && !this.codEdital.equals(other.codEdital))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Edital[ codEdital=" + codEdital + " ]";
    }
    
}
