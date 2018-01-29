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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "agenda")
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idagenda")
    private Integer idagenda;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Size(max = 100)
    @Column(name = "evento")
    private String evento;
    @Size(max = 30)
    @Column(name = "situacao")
    private String situacao;
    @Size(max = 50)
    @Column(name = "quemAgendou")
    private String quemAgendou;
    @Column(name = "idControleLoja")
    private Integer idControleLoja;

    public Agenda() {
    }

    public Agenda(Integer idagenda) {
        this.idagenda = idagenda;
    }

    public Integer getIdagenda() {
        return idagenda;
    }

    public void setIdagenda(Integer idagenda) {
        this.idagenda = idagenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getQuemAgendou() {
        return quemAgendou;
    }

    public void setQuemAgendou(String quemAgendou) {
        this.quemAgendou = quemAgendou;
    }

    public Integer getIdControleLoja() {
        return idControleLoja;
    }

    public void setIdControleLoja(Integer idControleLoja) {
        this.idControleLoja = idControleLoja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idagenda != null ? idagenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.idagenda == null && other.idagenda != null) || (this.idagenda != null && !this.idagenda.equals(other.idagenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.travelamte.model.Agenda[ idagenda=" + idagenda + " ]";
    }
    
}
