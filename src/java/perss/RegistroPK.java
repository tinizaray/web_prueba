/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perss;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author userAT
 */
@Embeddable
public class RegistroPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "re_Id")
    private int reId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ma_Id")
    private int maId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "al_Id")
    private int alId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cur_Id")
    private int curId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "un_Id")
    private int unId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "do_Id")
    private int doId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qui_Id")
    private int quiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pa_Id")
    private int paId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "in_Id")
    private int inId;

    public RegistroPK() {
    }

    public RegistroPK(int reId, int maId, int alId, int curId, int unId, int doId, int quiId, int paId, int inId) {
        this.reId = reId;
        this.maId = maId;
        this.alId = alId;
        this.curId = curId;
        this.unId = unId;
        this.doId = doId;
        this.quiId = quiId;
        this.paId = paId;
        this.inId = inId;
    }

    public int getReId() {
        return reId;
    }

    public void setReId(int reId) {
        this.reId = reId;
    }

    public int getMaId() {
        return maId;
    }

    public void setMaId(int maId) {
        this.maId = maId;
    }

    public int getAlId() {
        return alId;
    }

    public void setAlId(int alId) {
        this.alId = alId;
    }

    public int getCurId() {
        return curId;
    }

    public void setCurId(int curId) {
        this.curId = curId;
    }

    public int getUnId() {
        return unId;
    }

    public void setUnId(int unId) {
        this.unId = unId;
    }

    public int getDoId() {
        return doId;
    }

    public void setDoId(int doId) {
        this.doId = doId;
    }

    public int getQuiId() {
        return quiId;
    }

    public void setQuiId(int quiId) {
        this.quiId = quiId;
    }

    public int getPaId() {
        return paId;
    }

    public void setPaId(int paId) {
        this.paId = paId;
    }

    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) reId;
        hash += (int) maId;
        hash += (int) alId;
        hash += (int) curId;
        hash += (int) unId;
        hash += (int) doId;
        hash += (int) quiId;
        hash += (int) paId;
        hash += (int) inId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroPK)) {
            return false;
        }
        RegistroPK other = (RegistroPK) object;
        if (this.reId != other.reId) {
            return false;
        }
        if (this.maId != other.maId) {
            return false;
        }
        if (this.alId != other.alId) {
            return false;
        }
        if (this.curId != other.curId) {
            return false;
        }
        if (this.unId != other.unId) {
            return false;
        }
        if (this.doId != other.doId) {
            return false;
        }
        if (this.quiId != other.quiId) {
            return false;
        }
        if (this.paId != other.paId) {
            return false;
        }
        if (this.inId != other.inId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "perss.RegistroPK[ reId=" + reId + ", maId=" + maId + ", alId=" + alId + ", curId=" + curId + ", unId=" + unId + ", doId=" + doId + ", quiId=" + quiId + ", paId=" + paId + ", inId=" + inId + " ]";
    }
    
}
