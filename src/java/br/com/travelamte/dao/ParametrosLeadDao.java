/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;

import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Parametroslead;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author jizid
 */
public class ParametrosLeadDao {
    
    public Parametroslead get(){
        EntityManager manager = ConexaoSingleton.getInstanceSysTM();
        Query q = manager.createQuery("select p from Parametroslead p");
        if (q.getResultList().size()>0){
            return (Parametroslead) q.getResultList().get(0);
        }
        return null;
    }
    
    public Parametroslead salvar(Parametroslead parametrosLead) {
    	EntityManager manager = ConexaoSingleton.getInstanceSysTM();
	EntityTransaction tx = manager.getTransaction();
	tx.begin();
        parametrosLead = manager.merge(parametrosLead);
        tx.commit();
        return parametrosLead;
    }
}
