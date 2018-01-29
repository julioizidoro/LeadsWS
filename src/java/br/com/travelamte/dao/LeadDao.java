/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;

import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Lead;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author jizid
 */
public class LeadDao {
    
    public Lead salvar(Lead lead) {
        EntityManager manager;
        manager = ConexaoSingleton.getInstanceSysTM();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        lead = manager.merge(lead);
        tx.commit();
        return lead;
    }
    
    public Lead getLead(int idCliente){
        EntityManager manager = ConexaoSingleton.getInstanceSysTM();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query q = manager.createQuery("select l from Lead l where l.cliente=" + idCliente +
                " and (l.situacao<6 or l.situacao=8)");
        Lead lead = null;
        if (q.getResultList().size() > 0) {
            lead = (Lead) q.getResultList().get(0);
        }
        tx.commit();
        return lead;
    }
}
