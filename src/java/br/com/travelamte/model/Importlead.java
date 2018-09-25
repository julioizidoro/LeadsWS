/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jizid
 */
@Entity
@Table(name = "importlead")
public class Importlead implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idimportlead")
    private Integer idimporlead;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "email")
    private String email;
    @Column(name = "datanascimento")
    @Temporal(TemporalType.DATE)
    private Date datanascimento;
    @Column(name= "fone")
    private String fone;
    @Column(name= "nomeprograma")
    private String nomeprograma;
    @Column(name= "programa")
    private Integer programa;
    @Column(name= "observacao")
    private String observacao;
    @Column(name= "unidade")
    private Integer unidade;
    @Column(name= "publicidade")
    private Integer publicidade;
    
    
    public Importlead() {
    }

    public Integer getIdimporlead() {
        return idimporlead;
    }

    public void setIdimporlead(Integer idimporlead) {
        this.idimporlead = idimporlead;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getNomeprograma() {
        return nomeprograma;
    }

    public void setNomeprograma(String nomeprograma) {
        this.nomeprograma = nomeprograma;
    }

    public Integer getPrograma() {
        return programa;
    }

    public void setPrograma(Integer programa) {
        this.programa = programa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getUnidade() {
        return unidade;
    }

    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }

    public Integer getPublicidade() {
        return publicidade;
    }

    public void setPublicidade(Integer publicidade) {
        this.publicidade = publicidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.idimporlead);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Importlead other = (Importlead) obj;
        if (!Objects.equals(this.idimporlead, other.idimporlead)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }

   

    

    


    
    
    
    
}
