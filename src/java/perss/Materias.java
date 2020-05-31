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
@Table(name = "materias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m")
    , @NamedQuery(name = "Materias.findByMaId", query = "SELECT m FROM Materias m WHERE m.maId = :maId")
    , @NamedQuery(name = "Materias.findByMaNombre", query = "SELECT m FROM Materias m WHERE m.maNombre = :maNombre")
    , @NamedQuery(name = "Materias.findByMaParalelo", query = "SELECT m FROM Materias m WHERE m.maParalelo = :maParalelo")
    , @NamedQuery(name = "Materias.findByMaEsp", query = "SELECT m FROM Materias m WHERE m.maEsp = :maEsp")})
public class Materias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ma_Id")
    private Integer maId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ma_Nombre")
    private String maNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ma_paralelo")
    private String maParalelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ma_Esp")
    private String maEsp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materias")
    private Collection<Registro> registroCollection;

    public Materias() {
    }

    public Materias(Integer maId) {
        this.maId = maId;
    }

    public Materias(Integer maId, String maNombre, String maParalelo, String maEsp) {
        this.maId = maId;
        this.maNombre = maNombre;
        this.maParalelo = maParalelo;
        this.maEsp = maEsp;
    }

    public Integer getMaId() {
        return maId;
    }

    public void setMaId(Integer maId) {
        this.maId = maId;
    }

    public String getMaNombre() {
        return maNombre;
    }

    public void setMaNombre(String maNombre) {
        this.maNombre = maNombre;
    }

    public String getMaParalelo() {
        return maParalelo;
    }

    public void setMaParalelo(String maParalelo) {
        this.maParalelo = maParalelo;
    }

    public String getMaEsp() {
        return maEsp;
    }

    public void setMaEsp(String maEsp) {
        this.maEsp = maEsp;
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
        hash += (maId != null ? maId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.maId == null && other.maId != null) || (this.maId != null && !this.maId.equals(other.maId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "perss.Materias[ maId=" + maId + " ]";
    }
    
}
