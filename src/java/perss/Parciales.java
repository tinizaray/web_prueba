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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author userAT
 */
@Entity
@Table(name = "parciales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parciales.findAll", query = "SELECT p FROM Parciales p")
    , @NamedQuery(name = "Parciales.findByPaId", query = "SELECT p FROM Parciales p WHERE p.paId = :paId")
    , @NamedQuery(name = "Parciales.findByPaNombres", query = "SELECT p FROM Parciales p WHERE p.paNombres = :paNombres")})
public class Parciales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pa_Id")
    private Integer paId;
    @Size(max = 45)
    @Column(name = "pa_Nombres")
    private String paNombres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parciales")
    private Collection<Registro> registroCollection;

    public Parciales() {
    }

    public Parciales(Integer paId) {
        this.paId = paId;
    }

    public Integer getPaId() {
        return paId;
    }

    public void setPaId(Integer paId) {
        this.paId = paId;
    }

    public String getPaNombres() {
        return paNombres;
    }

    public void setPaNombres(String paNombres) {
        this.paNombres = paNombres;
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
        hash += (paId != null ? paId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parciales)) {
            return false;
        }
        Parciales other = (Parciales) object;
        if ((this.paId == null && other.paId != null) || (this.paId != null && !this.paId.equals(other.paId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "perss.Parciales[ paId=" + paId + " ]";
    }
    
}
