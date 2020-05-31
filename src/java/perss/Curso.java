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
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")
    , @NamedQuery(name = "Curso.findByCurId", query = "SELECT c FROM Curso c WHERE c.curId = :curId")
    , @NamedQuery(name = "Curso.findByCurGrado", query = "SELECT c FROM Curso c WHERE c.curGrado = :curGrado")
    , @NamedQuery(name = "Curso.findByCurParalelo", query = "SELECT c FROM Curso c WHERE c.curParalelo = :curParalelo")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cur_Id")
    private Integer curId;
    @Size(max = 45)
    @Column(name = "Cur_Grado")
    private String curGrado;
    @Size(max = 45)
    @Column(name = "Cur_Paralelo")
    private String curParalelo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<Registro> registroCollection;

    public Curso() {
    }

    public Curso(Integer curId) {
        this.curId = curId;
    }

    public Integer getCurId() {
        return curId;
    }

    public void setCurId(Integer curId) {
        this.curId = curId;
    }

    public String getCurGrado() {
        return curGrado;
    }

    public void setCurGrado(String curGrado) {
        this.curGrado = curGrado;
    }

    public String getCurParalelo() {
        return curParalelo;
    }

    public void setCurParalelo(String curParalelo) {
        this.curParalelo = curParalelo;
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
        hash += (curId != null ? curId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.curId == null && other.curId != null) || (this.curId != null && !this.curId.equals(other.curId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "perss.Curso[ curId=" + curId + " ]";
    }
    
}
