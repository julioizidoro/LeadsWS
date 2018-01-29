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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Column(name = "unidadeNegocio_idunidadeNegocio")
    private int unidadenegocio;
    @Column(name = "recebeleadautomatica")
    private boolean recebeleadautomatica; 

    public Usuario() {
    }
  
    
    
    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public int getUnidadenegocio() {
        return unidadenegocio;
    }

    public void setUnidadenegocio(int unidadenegocio) {
        this.unidadenegocio = unidadenegocio;
    }

    public boolean isRecebeleadautomatica() {
        return recebeleadautomatica;
    }

    public void setRecebeleadautomatica(boolean recebeleadautomatica) {
        this.recebeleadautomatica = recebeleadautomatica;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return "br.com.travelmate.model.Usuario[ idusuario=" + idusuario + " ]";
    }
}
