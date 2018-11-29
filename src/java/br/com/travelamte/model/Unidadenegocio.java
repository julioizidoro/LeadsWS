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
 * @author jizid
 */
@Entity
@Table(name = "unidadenegocio")
public class Unidadenegocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idunidadeNegocio")
    private Integer idunidadeNegocio;
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Column(name = "leadautomatica")
    private boolean leadautomatica;
    @Column(name = "usuarioleadautomatica")
    private int usuarioleadautomatica;
    @Column(name = "situacao")
    private boolean situacao;
    @Column(name = "nomews")
    private String nomews;
    @Column(name = "idws")
    private Integer idws;
    
    
    
    

    public Unidadenegocio() {
    }

    public Integer getIdunidadeNegocio() {
        return idunidadeNegocio;
    }

    public void setIdunidadeNegocio(Integer idunidadeNegocio) {
        this.idunidadeNegocio = idunidadeNegocio;
    }

    

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public boolean isLeadautomatica() {
        return leadautomatica;
    }

    public void setLeadautomatica(boolean leadautomatica) {
        this.leadautomatica = leadautomatica;
    }

    public int getUsuarioleadautomatica() {
        return usuarioleadautomatica;
    }

    public void setUsuarioleadautomatica(int usuarioleadautomatica) {
        this.usuarioleadautomatica = usuarioleadautomatica;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public String getNomews() {
        return nomews;
    }

    public void setNomews(String nomews) {
        this.nomews = nomews;
    }

    public Integer getIdws() {
        return idws;
    }

    public void setIdws(Integer idws) {
        this.idws = idws;
    }

   
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idunidadeNegocio != null ? idunidadeNegocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidadenegocio)) {
            return false;
        }
        Unidadenegocio other = (Unidadenegocio) object;
        if ((this.idunidadeNegocio == null && other.idunidadeNegocio != null) || (this.idunidadeNegocio != null && !this.idunidadeNegocio.equals(other.idunidadeNegocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.leadws.model.Unidadenegocio[ idunidadeNegocio=" + idunidadeNegocio + " ]";
    }
    
}
