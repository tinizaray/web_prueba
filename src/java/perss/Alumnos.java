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
@Table(name = "alumnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a")
    , @NamedQuery(name = "Alumnos.findByAlId", query = "SELECT a FROM Alumnos a WHERE a.alId = :alId")
    , @NamedQuery(name = "Alumnos.findByAlNombres", query = "SELECT a FROM Alumnos a WHERE a.alNombres = :alNombres")
    , @NamedQuery(name = "Alumnos.findByAlApellidos", query = "SELECT a FROM Alumnos a WHERE a.alApellidos = :alApellidos")
    , @NamedQuery(name = "Alumnos.findByAlCedula", query = "SELECT a FROM Alumnos a WHERE a.alCedula = :alCedula")
    , @NamedQuery(name = "Alumnos.findByAlDir", query = "SELECT a FROM Alumnos a WHERE a.alDir = :alDir")
    , @NamedQuery(name = "Alumnos.findByAlMobil", query = "SELECT a FROM Alumnos a WHERE a.alMobil = :alMobil")
    , @NamedQuery(name = "Alumnos.findByAlRep", query = "SELECT a FROM Alumnos a WHERE a.alRep = :alRep")})
public class Alumnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "al_Id")
    private Integer alId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "al_Nombres")
    private String alNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "al_Apellidos")
    private String alApellidos;
    @Size(max = 10)
    @Column(name = "al_Cedula")
    private String alCedula;
    @Size(max = 100)
    @Column(name = "al_Dir")
    private String alDir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "al_Mobil")
    private String alMobil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "al_Rep")
    private String alRep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnos")
    private Collection<Registro> registroCollection;

    public Alumnos() {
    }

    public Alumnos(Integer alId) {
        this.alId = alId;
    }

    public Alumnos(Integer alId, String alNombres, String alApellidos, String alMobil, String alRep) {
        this.alId = alId;
        this.alNombres = alNombres;
        this.alApellidos = alApellidos;
        this.alMobil = alMobil;
        this.alRep = alRep;
    }

    public Integer getAlId() {
        return alId;
    }

    public void setAlId(Integer alId) {
        this.alId = alId;
    }

    public String getAlNombres() {
        return alNombres;
    }

    public void setAlNombres(String alNombres) {
        this.alNombres = alNombres;
    }

    public String getAlApellidos() {
        return alApellidos;
    }

    public void setAlApellidos(String alApellidos) {
        this.alApellidos = alApellidos;
    }

    public String getAlCedula() {
        return alCedula;
    }

    public void setAlCedula(String alCedula) {
        this.alCedula = alCedula;
    }

    public String getAlDir() {
        return alDir;
    }

    public void setAlDir(String alDir) {
        this.alDir = alDir;
    }

    public String getAlMobil() {
        return alMobil;
    }

    public void setAlMobil(String alMobil) {
        this.alMobil = alMobil;
    }

    public String getAlRep() {
        return alRep;
    }

    public void setAlRep(String alRep) {
        this.alRep = alRep;
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
        hash += (alId != null ? alId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.alId == null && other.alId != null) || (this.alId != null && !this.alId.equals(other.alId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "perss.Alumnos[ alId=" + alId + " ]";
    }
    
}
