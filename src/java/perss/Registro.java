/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perss;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author userAT
 */
@Entity
@Table(name = "registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r")
    , @NamedQuery(name = "Registro.findByReId", query = "SELECT r FROM Registro r WHERE r.registroPK.reId = :reId")
    , @NamedQuery(name = "Registro.findByReNota", query = "SELECT r FROM Registro r WHERE r.reNota = :reNota")
    , @NamedQuery(name = "Registro.findByMaId", query = "SELECT r FROM Registro r WHERE r.registroPK.maId = :maId")
    , @NamedQuery(name = "Registro.findByAlId", query = "SELECT r FROM Registro r WHERE r.registroPK.alId = :alId")
    , @NamedQuery(name = "Registro.findByCurId", query = "SELECT r FROM Registro r WHERE r.registroPK.curId = :curId")
    , @NamedQuery(name = "Registro.findByUnId", query = "SELECT r FROM Registro r WHERE r.registroPK.unId = :unId")
    , @NamedQuery(name = "Registro.findByDoId", query = "SELECT r FROM Registro r WHERE r.registroPK.doId = :doId")
    , @NamedQuery(name = "Registro.findByQuiId", query = "SELECT r FROM Registro r WHERE r.registroPK.quiId = :quiId")
    , @NamedQuery(name = "Registro.findByPaId", query = "SELECT r FROM Registro r WHERE r.registroPK.paId = :paId")
    , @NamedQuery(name = "Registro.findByInId", query = "SELECT r FROM Registro r WHERE r.registroPK.inId = :inId")})
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegistroPK registroPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "re_Nota")
    private double reNota;
    @JoinColumn(name = "al_Id", referencedColumnName = "al_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumnos alumnos;
    @JoinColumn(name = "Cur_Id", referencedColumnName = "Cur_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "do_Id", referencedColumnName = "do_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Docente docente;
    @JoinColumn(name = "in_Id", referencedColumnName = "in_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Insumos insumos;
    @JoinColumn(name = "ma_Id", referencedColumnName = "ma_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materias materias;
    @JoinColumn(name = "pa_Id", referencedColumnName = "pa_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Parciales parciales;
    @JoinColumn(name = "qui_Id", referencedColumnName = "qui_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quimestre quimestre;
    @JoinColumn(name = "un_Id", referencedColumnName = "un_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Unidad unidad;

    public Registro() {
    }

    public Registro(RegistroPK registroPK) {
        this.registroPK = registroPK;
    }

    public Registro(RegistroPK registroPK, double reNota) {
        this.registroPK = registroPK;
        this.reNota = reNota;
    }

    public Registro(int reId, int maId, int alId, int curId, int unId, int doId, int quiId, int paId, int inId) {
        this.registroPK = new RegistroPK(reId, maId, alId, curId, unId, doId, quiId, paId, inId);
    }

    public RegistroPK getRegistroPK() {
        return registroPK;
    }

    public void setRegistroPK(RegistroPK registroPK) {
        this.registroPK = registroPK;
    }

    public double getReNota() {
        return reNota;
    }

    public void setReNota(double reNota) {
        this.reNota = reNota;
    }

    public Alumnos getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Insumos getInsumos() {
        return insumos;
    }

    public void setInsumos(Insumos insumos) {
        this.insumos = insumos;
    }

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }

    public Parciales getParciales() {
        return parciales;
    }

    public void setParciales(Parciales parciales) {
        this.parciales = parciales;
    }

    public Quimestre getQuimestre() {
        return quimestre;
    }

    public void setQuimestre(Quimestre quimestre) {
        this.quimestre = quimestre;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registroPK != null ? registroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.registroPK == null && other.registroPK != null) || (this.registroPK != null && !this.registroPK.equals(other.registroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "perss.Registro[ registroPK=" + registroPK + " ]";
    }
    
}
