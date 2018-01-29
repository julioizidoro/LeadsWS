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
 * @author Wolverine
 */
@Entity
@Table(name = "leadhistorico")
public class Leadhistorico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idleadhistorico")
    private Integer idleadhistorico;
    @Column(name = "datahistorico")
    @Temporal(TemporalType.DATE)
    private Date datahistorico;
    @Lob
    @Column(name = "historico")
    private String historico;
    @Column(name = "cliente_idcliente")
    private int cliente;
    @Column(name = "tipocontato_idtipocontato")
    private int tipocontato;
    @Column(name = "tipoorcamento")
    private String tipoorcamento;
    @Column(name = "idorcamento")
    private Integer idorcamento;

    public Leadhistorico() {
        setTipoorcamento("s");
        setIdorcamento(0);
        setHistorico("");
    }

    public Leadhistorico(Integer idleadhistorico) {
        this.idleadhistorico = idleadhistorico;
    }

    public Integer getIdleadhistorico() {
        return idleadhistorico;
    }

    public void setIdleadhistorico(Integer idleadhistorico) {
        this.idleadhistorico = idleadhistorico;
    }

    public Date getDatahistorico() {
        return datahistorico;
    }

    public void setDatahistorico(Date datahistorico) {
        this.datahistorico = datahistorico;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getTipocontato() {
        return tipocontato;
    }

    public void setTipocontato(int tipocontato) {
        this.tipocontato = tipocontato;
    }

    public String getTipoorcamento() {
        return tipoorcamento;
    }

    public void setTipoorcamento(String tipoorcamento) {
        this.tipoorcamento = tipoorcamento;
    }

    public Integer getIdorcamento() {
        return idorcamento;
    }

    public void setIdorcamento(Integer idorcamento) {
        this.idorcamento = idorcamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idleadhistorico != null ? idleadhistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Leadhistorico)) {
            return false;
        }
        Leadhistorico other = (Leadhistorico) object;
        if ((this.idleadhistorico == null && other.idleadhistorico != null) || (this.idleadhistorico != null && !this.idleadhistorico.equals(other.idleadhistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.travelmate.model.Leadhistorico[ idleadhistorico=" + idleadhistorico + " ]";
    }

}
