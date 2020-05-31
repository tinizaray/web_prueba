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
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")
    , @NamedQuery(name = "Docente.findByDoId", query = "SELECT d FROM Docente d WHERE d.doId = :doId")
    , @NamedQuery(name = "Docente.findByDoCedula", query = "SELECT d FROM Docente d WHERE d.doCedula = :doCedula")
    , @NamedQuery(name = "Docente.findByDoNombres", query = "SELECT d FROM Docente d WHERE d.doNombres = :doNombres")
    , @NamedQuery(name = "Docente.findByDoApellidos", query = "SELECT d FROM Docente d WHERE d.doApellidos = :doApellidos")
    , @NamedQuery(name = "Docente.findByDoProv", query = "SELECT d FROM Docente d WHERE d.doProv = :doProv")
    , @NamedQuery(name = "Docente.findByDoCiudad", query = "SELECT d FROM Docente d WHERE d.doCiudad = :doCiudad")
    , @NamedQuery(name = "Docente.findByDoDirec", query = "SELECT d FROM Docente d WHERE d.doDirec = :doDirec")
    , @NamedQuery(name = "Docente.findByDoTelef", query = "SELECT d FROM Docente d WHERE d.doTelef = :doTelef")
    , @NamedQuery(name = "Docente.findByDoMobil", query = "SELECT d FROM Docente d WHERE d.doMobil = :doMobil")
    , @NamedQuery(name = "Docente.findByDoUsu", query = "SELECT d FROM Docente d WHERE d.doUsu = :doUsu")
    , @NamedQuery(name = "Docente.findByDoPass", query = "SELECT d FROM Docente d WHERE d.doPass = :doPass")
    , @NamedQuery(name = "Docente.findByDoColegio", query = "SELECT d FROM Docente d WHERE d.doColegio = :doColegio")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "do_Id")
    private Integer doId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "do_Cedula")
    private String doCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "do_Nombres")
    private String doNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "do_Apellidos")
    private String doApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "do_Prov")
    private String doProv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "do_Ciudad")
    private String doCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "do_Direc")
    private String doDirec;
    @Size(max = 10)
    @Column(name = "do_Telef")
    private String doTelef;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "do_Mobil")
    private String doMobil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "do_usu")
    private String doUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "do_Pass")
    private String doPass;
    @Size(max = 100)
    @Column(name = "do_Colegio")
    private String doColegio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente")
    private Collection<Registro> registroCollection;

    public Docente() {
    }

    public Docente(Integer doId) {
        this.doId = doId;
    }

    public Docente(Integer doId, String doCedula, String doNombres, String doApellidos, String doProv, String doCiudad, String doDirec, String doMobil, String doUsu, String doPass) {
        this.doId = doId;
        this.doCedula = doCedula;
        this.doNombres = doNombres;
        this.doApellidos = doApellidos;
        this.doProv = doProv;
        this.doCiudad = doCiudad;
        this.doDirec = doDirec;
        this.doMobil = doMobil;
        this.doUsu = doUsu;
        this.doPass = doPass;
    }

    public Integer getDoId() {
        return doId;
    }

    public void setDoId(Integer doId) {
        this.doId = doId;
    }

    public String getDoCedula() {
        return doCedula;
    }

    public void setDoCedula(String doCedula) {
        this.doCedula = doCedula;
    }

    public String getDoNombres() {
        return doNombres;
    }

    public void setDoNombres(String doNombres) {
        this.doNombres = doNombres;
    }

    public String getDoApellidos() {
        return doApellidos;
    }

    public void setDoApellidos(String doApellidos) {
        this.doApellidos = doApellidos;
    }

    public String getDoProv() {
        return doProv;
    }

    public void setDoProv(String doProv) {
        this.doProv = doProv;
    }

    public String getDoCiudad() {
        return doCiudad;
    }

    public void setDoCiudad(String doCiudad) {
        this.doCiudad = doCiudad;
    }

    public String getDoDirec() {
        return doDirec;
    }

    public void setDoDirec(String doDirec) {
        this.doDirec = doDirec;
    }

    public String getDoTelef() {
        return doTelef;
    }

    public void setDoTelef(String doTelef) {
        this.doTelef = doTelef;
    }

    public String getDoMobil() {
        return doMobil;
    }

    public void setDoMobil(String doMobil) {
        this.doMobil = doMobil;
    }

    public String getDoUsu() {
        return doUsu;
    }

    public void setDoUsu(String doUsu) {
        this.doUsu = doUsu;
    }

    public String getDoPass() {
        return doPass;
    }

    public void setDoPass(String doPass) {
        this.doPass = doPass;
    }

    public String getDoColegio() {
        return doColegio;
    }

    public void setDoColegio(String doColegio) {
        this.doColegio = doColegio;
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
        hash += (doId != null ? doId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.doId == null && other.doId != null) || (this.doId != null && !this.doId.equals(other.doId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "perss.Docente[ doId=" + doId + " ]";
    }
    
}
