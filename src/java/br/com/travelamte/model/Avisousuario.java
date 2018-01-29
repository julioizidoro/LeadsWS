package br.com.travelamte.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "avisousuario")
public class Avisousuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idavisousuario")
    private Integer idavisousuario;
    @Column(name = "visto")
    private Boolean visto;
    @Column(name = "avisos_idavisos")
    private int avisos;
    @Column(name = "usuario_idusuario")
    private int usuario;

    public Avisousuario() {
    }

    public Avisousuario(Integer idavisousuario) {
        this.idavisousuario = idavisousuario;
    }

    public Integer getIdavisousuario() {
        return idavisousuario;
    }

    public void setIdavisousuario(Integer idavisousuario) {
        this.idavisousuario = idavisousuario;
    }

    public Boolean getVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }

    public int getAvisos() {
        return avisos;
    }

    public void setAvisos(int avisos) {
        this.avisos = avisos;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idavisousuario != null ? idavisousuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Avisousuario)) {
            return false;
        }
        Avisousuario other = (Avisousuario) object;
        if ((this.idavisousuario == null && other.idavisousuario != null) || (this.idavisousuario != null && !this.idavisousuario.equals(other.idavisousuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.travelmate.model.Avisousuario[ idavisousuario=" + idavisousuario + " ]";
    }
    
}

