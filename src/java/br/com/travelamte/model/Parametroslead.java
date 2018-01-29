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
@Table(name = "parametroslead")
public class Parametroslead implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparametroslead")
    private Integer idparametroslead;
    @Column(name = "banco")
    private String banco;
    @Column(name = "usuairo")
    private String usuairo;
    @Column(name = "senha")
    private String senha;
    @Column(name = "temporizador")
    private Integer temporizador;
    @Column(name = "produto")
    private Integer produto;
    @Column(name = "publicidade")
    private Integer publicidade;
    @Column(name = "idcontato")
    private Integer idcontato;
    @Column(name = "tipoorigem")
    private Integer tipoorigem;

    public Parametroslead() {
    }

    public Parametroslead(Integer idparametroslead) {
        this.idparametroslead = idparametroslead;
    }

    public Integer getIdparametroslead() {
        return idparametroslead;
    }

    public void setIdparametroslead(Integer idparametroslead) {
        this.idparametroslead = idparametroslead;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getUsuairo() {
        return usuairo;
    }

    public void setUsuairo(String usuairo) {
        this.usuairo = usuairo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getTemporizador() {
        return temporizador;
    }

    public void setTemporizador(Integer temporizador) {
        this.temporizador = temporizador;
    }

    public Integer getProduto() {
        return produto;
    }

    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    public Integer getPublicidade() {
        return publicidade;
    }

    public void setPublicidade(Integer publicidade) {
        this.publicidade = publicidade;
    }

    public Integer getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(Integer idcontato) {
        this.idcontato = idcontato;
    }

    public Integer getTipoorigem() {
        return tipoorigem;
    }

    public void setTipoorigem(Integer tipoorigem) {
        this.tipoorigem = tipoorigem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparametroslead != null ? idparametroslead.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametroslead)) {
            return false;
        }
        Parametroslead other = (Parametroslead) object;
        if ((this.idparametroslead == null && other.idparametroslead != null) || (this.idparametroslead != null && !this.idparametroslead.equals(other.idparametroslead))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.leadws.model.Parametroslead[ idparametroslead=" + idparametroslead + " ]";
    }
    
}
