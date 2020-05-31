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
@Table(name = "unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u")
    , @NamedQuery(name = "Unidad.findByUnId", query = "SELECT u FROM Unidad u WHERE u.unId = :unId")
    , @NamedQuery(name = "Unidad.findByUnNombre", query = "SELECT u FROM Unidad u WHERE u.unNombre = :unNombre")
    , @NamedQuery(name = "Unidad.findByUnDireccion", query = "SELECT u FROM Unidad u WHERE u.unDireccion = :unDireccion")
    , @NamedQuery(name = "Unidad.findByUnPeriodo", query = "SELECT u FROM Unidad u WHERE u.unPeriodo = :unPeriodo")
    , @NamedQuery(name = "Unidad.findByUnTelef", query = "SELECT u FROM Unidad u WHERE u.unTelef = :unTelef")})
public class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "un_Id")
    private Integer unId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "un_Nombre")
    private String unNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "un_Direccion")
    private String unDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "un_Periodo")
    private String unPeriodo;
    @Size(max = 10)
    @Column(name = "un_Telef")
    private String unTelef;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidad")
    private Collection<Registro> registroCollection;

    public Unidad() {
    }

    public Unidad(Integer unId) {
        this.unId = unId;
    }

    public Unidad(Integer unId, String unNombre, String unDireccion, String unPeriodo) {
        this.unId = unId;
        this.unNombre = unNombre;
        this.unDireccion = unDireccion;
        this.unPeriodo = unPeriodo;
    }

    public Integer getUnId() {
        return unId;
    }

    public void setUnId(Integer unId) {
        this.unId = unId;
    }

    public String getUnNombre() {
        return unNombre;
    }

    public void setUnNombre(String unNombre) {
        this.unNombre = unNombre;
    }

    public String getUnDireccion() {
        return unDireccion;
    }

    public void setUnDireccion(String unDireccion) {
        this.unDireccion = unDireccion;
    }

    public String getUnPeriodo() {
        return unPeriodo;
    }

    public void setUnPeriodo(String unPeriodo) {
        this.unPeriodo = unPeriodo;
    }

    public String getUnTelef() {
        return unTelef;
    }

    public void setUnTelef(String unTelef) {
        this.unTelef = unTelef;
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
        hash += (unId != null ? unId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.unId == null && other.unId != null) || (this.unId != null && !this.unId.equals(other.unId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "perss.Unidad[ unId=" + unId + " ]";
    }
    
}
