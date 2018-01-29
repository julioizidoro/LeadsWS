/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jizid
 */
@Entity
@Table(name = "lead")
public class Lead implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlead")
    private Integer idlead;
    @Column(name = "dataenvio")
    @Temporal(TemporalType.DATE)
    private Date dataenvio;
    @Column(name = "horaenvio")
    private String horaenvio;
    @Column(name = "jaecliente")
    private Boolean jaecliente;
    @Column(name = "dataultimocontato")
    @Temporal(TemporalType.DATE)
    private Date dataultimocontato;
    @Column(name = "situacao")
    private Integer situacao;
    @Column(name = "dataproximocontato")
    @Temporal(TemporalType.DATE)
    private Date dataproximocontato;
    @Column(name = "horaproximocontato")
    private String horaproximocontato;
    @Column(name = "motivocancelamento")
    private String motivocancelamento;
    @Lob
    @Column(name = "notas")
    private String notas;
    @Column(name = "cliente_idcliente")
    private int cliente;
    @Column(name = "produtos_idprodutos")
    private int produtos;
    @Column(name = "tipocontato_idtipocontato")
    private int tipocontato;
    @Column(name = "unidadenegocio_idunidadeNegocio")
    private int unidadenegocio;
    @Column(name = "usuario_idusuario")
    private int usuario;
    @Column(name = "motivocancelamento_idmotivocancelamento")
    private int motivocancelamento1;
    @Column(name = "idcontrole")
    private int idcontrole;
    @Column(name = "publicidade_idpublicidade")
    private int publicidade;
    @Column(name = "pais_idpais")
    private int pais;
    @Column(name = "horarecebimento")
    private String horarecebimento;
    @Temporal(TemporalType.DATE)
    @Column(name = "datarecebimento")
    private Date datarecebimento;
    @Column(name = "Urlclient")
    private String Urlclient;
    

    public Lead() {
        idcontrole = 0;
    }

    public Integer getIdlead() {
        return idlead;
    }

    public void setIdlead(Integer idlead) {
        this.idlead = idlead;
    }

    public Date getDataenvio() {
        return dataenvio;
    }

    public void setDataenvio(Date dataenvio) {
        this.dataenvio = dataenvio;
    }

    public String getHoraenvio() {
        return horaenvio;
    }

    public void setHoraenvio(String horaenvio) {
        this.horaenvio = horaenvio;
    }

    public Boolean getJaecliente() {
        return jaecliente;
    }

    public void setJaecliente(Boolean jaecliente) {
        this.jaecliente = jaecliente;
    }

    public Date getDataultimocontato() {
        return dataultimocontato;
    }

    public void setDataultimocontato(Date dataultimocontato) {
        this.dataultimocontato = dataultimocontato;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public Date getDataproximocontato() {
        return dataproximocontato;
    }

    public void setDataproximocontato(Date dataproximocontato) {
        this.dataproximocontato = dataproximocontato;
    }

    public String getHoraproximocontato() {
        return horaproximocontato;
    }

    public void setHoraproximocontato(String horaproximocontato) {
        this.horaproximocontato = horaproximocontato;
    }

    public String getMotivocancelamento() {
        return motivocancelamento;
    }

    public void setMotivocancelamento(String motivocancelamento) {
        this.motivocancelamento = motivocancelamento;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getProdutos() {
        return produtos;
    }

    public void setProdutos(int produtos) {
        this.produtos = produtos;
    }

    public int getTipocontato() {
        return tipocontato;
    }

    public void setTipocontato(int tipocontato) {
        this.tipocontato = tipocontato;
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

    public int getMotivocancelamento1() {
        return motivocancelamento1;
    }

    public void setMotivocancelamento1(int motivocancelamento1) {
        this.motivocancelamento1 = motivocancelamento1;
    }

    public int getIdcontrole() {
        return idcontrole;
    }

    public void setIdcontrole(int idcontrole) {
        this.idcontrole = idcontrole;
    }

    public int getPublicidade() {
        return publicidade;
    }

    public void setPublicidade(int publicidade) {
        this.publicidade = publicidade;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public Date getDatarecebimento() {
        return datarecebimento;
    }

    public void setDatarecebimento(Date datarecebimento) {
        this.datarecebimento = datarecebimento;
    }

    public void setHorarecebimento(String horarecebimento){
        this.horarecebimento = horarecebimento;
    }
    
    public String getHorarecebimento(){
        return this.horarecebimento;
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
        hash += (idlead != null ? idlead.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lead)) {
            return false;
        }
        Lead other = (Lead) object;
        if ((this.idlead == null && other.idlead != null) || (this.idlead != null && !this.idlead.equals(other.idlead))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.leadws.model.Lead[ idlead=" + idlead + " ]";
    }
    
}
