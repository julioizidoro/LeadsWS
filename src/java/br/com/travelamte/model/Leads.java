/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.model;

import java.io.Serializable;

/**
 *
 * @author jizid
 */
public class Leads implements Serializable {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private Integer unidade;
    private String unidade_desc;
    private String mensagem;
    private String Urlclient;
    
    public Leads() {
    }

    public Leads(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getUnidade() {
        return unidade;
    }

    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getUnidade_desc() {
        return unidade_desc;
    }

    public void setUnidade_desc(String unidade_desc) {
        this.unidade_desc = unidade_desc;
    }

    public String getUrlclient() {
        return Urlclient;
    }

    public void setUrlclient(String Urlclient) {
        this.Urlclient = Urlclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leads)) {
            return false;
        }
        Leads other = (Leads) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Leads{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", unidade=" + unidade + ", unidade_desc=" + unidade_desc + ", mensagem=" + mensagem + ", Urlclient=" + Urlclient + '}';
    }


    
    
    
    
}
