/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author wolverine
 */
@Entity
@Table(name = "leadresponsavel")
public class Leadresponsavel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idleadresponsavel")
    private Integer idleadresponsavel;
    @Column(name = "unidadenegocio_idunidadeNegocio")
    private int unidadenegocio;
    @Column(name = "usuario_idusuario")
    private int usuario;

    public Leadresponsavel() {
    }

    public Leadresponsavel(Integer idleadresponsavel) {
        this.idleadresponsavel = idleadresponsavel;
    }

    public Integer getIdleadresponsavel() {
        return idleadresponsavel;
    }

    public void setIdleadresponsavel(Integer idleadresponsavel) {
        this.idleadresponsavel = idleadresponsavel;
    }

    public int getUnidadenegocio() {
        return unidadenegocio;
    }

    public void setUnidadenegocio(int unidadenegocio) {
        this.unidadenegocio = unidadenegocio;
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
        hash += (idleadresponsavel != null ? idleadresponsavel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leadresponsavel)) {
            return false;
        }
        Leadresponsavel other = (Leadresponsavel) object;
        if ((this.idleadresponsavel == null && other.idleadresponsavel != null) || (this.idleadresponsavel != null && !this.idleadresponsavel.equals(other.idleadresponsavel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.travelmate.model.Leadresponsavel[ idleadresponsavel=" + idleadresponsavel + " ]";
    }
    
}
