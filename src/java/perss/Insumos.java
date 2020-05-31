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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author userAT
 */
@Entity
@Table(name = "insumos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumos.findAll", query = "SELECT i FROM Insumos i")
    , @NamedQuery(name = "Insumos.findByInId", query = "SELECT i FROM Insumos i WHERE i.inId = :inId")
    , @NamedQuery(name = "Insumos.findByInNombres", query = "SELECT i FROM Insumos i WHERE i.inNombres = :inNombres")})
public class Insumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "in_Id")
    private Integer inId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "in_Nombres")
    private String inNombres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumos")
    private Collection<Registro> registroCollection;

    public Insumos() {
    }

    public Insumos(Integer inId) {
        this.inId = inId;
    }

    public Insumos(Integer inId, String inNombres) {
        this.inId = inId;
        this.inNombres = inNombres;
    }

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public String getInNombres() {
        return inNombres;
    }

    public void setInNombres(String inNombres) {
        this.inNombres = inNombres;
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
        hash += (inId != null ? inId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumos)) {
            return false;
        }
        Insumos other = (Insumos) object;
        if ((this.inId == null && other.inId != null) || (this.inId != null && !this.inId.equals(other.inId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "perss.Insumos[ inId=" + inId + " ]";
    }
    
}
