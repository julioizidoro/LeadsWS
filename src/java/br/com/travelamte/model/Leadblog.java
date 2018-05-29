/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.model;

/**
 *
 * @author julioizidoro
 */
public class Leadblog {
    
    private String nome;
    private String email;
    private String telefone;
    private String estado;
    private String cidade;
    private String tipoIntercambio;
    private String detalhe; 
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipoIntercambio() {
        return tipoIntercambio;
    }

    public void setTipoIntercambio(String tipoIntercambio) {
        this.tipoIntercambio = tipoIntercambio;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }
    
    
    
}
