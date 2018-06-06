/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.model;

import java.util.List;

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
    //private List<String> listaPais;
    private String idade;
    private String objetivo;
    private String duracao;
    private String quandoviajar;
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

   
    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getQuandoviajar() {
        return quandoviajar;
    }

    public void setQuandoviajar(String quandoviajar) {
        this.quandoviajar = quandoviajar;
    }
    
    
    
}
