/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;

import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Leadcontrole;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Wolverine
 */
public class LeadControleDao {
    
    public void salvar(Leadcontrole leadControle){
        EntityManager manager;
        manager = ConexaoSingleton.getInstanceSysTM();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        leadControle = manager.merge(leadControle);
        tx.commit();
    }
    
}
