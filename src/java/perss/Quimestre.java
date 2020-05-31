/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perss;

import java.io.Serializable;
import java.util.Collection;
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
 * @author userAT
 */
@Entity
@Table(name = "quimestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quimestre.findAll", query = "SELECT q FROM Quimestre q")
    , @NamedQuery(name = "Quimestre.findByQuiId", query = "SELECT q FROM Quimestre q WHERE q.quiId = :quiId")
    , @NamedQuery(name = "Quimestre.findByQuiNombre", query = "SELECT q FROM Quimestre q WHERE q.quiNombre = :quiNombre")})
public class Quimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "qui_Id")
    private Integer quiId;
    @Size(max = 45)
    @Column(name = "qui_Nombre")
    private String quiNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quimestre")
    private Collection<Registro> registroCollection;

    public Quimestre() {
    }

    public Quimestre(Integer quiId) {
        this.quiId = quiId;
    }

    public Integer getQuiId() {
        return quiId;
    }

    public void setQuiId(Integer quiId) {
        this.quiId = quiId;
    }

    public String getQuiNombre() {
        return quiNombre;
    }

    public void setQuiNombre(String quiNombre) {
        this.quiNombre = quiNombre;
    }

    @XmlTransient
    public Collection<Registro> getRegistroCollection() {
        return registroCollection;
    }

    public void setRegistroCollection(Collection<Registro> registroCollection) {
        this.registroCollection = registroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quiId != null ? quiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quimestre)) {
            return false;
        }
        Quimestre other = (Quimestre) object;
        if ((this.quiId == null && other.quiId != null) || (this.quiId != null && !this.quiId.equals(other.quiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "perss.Quimestre[ quiId=" + quiId + " ]";
    }
    
}
