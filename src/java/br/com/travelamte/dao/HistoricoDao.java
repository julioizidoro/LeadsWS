/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;

import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Leadhistorico;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author wolverine
 */
public class HistoricoDao {
    
    public Leadhistorico salvar(Leadhistorico historico) {
        EntityManager manager;
        manager = ConexaoSingleton.getConnection();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        historico = manager.merge(historico);
        tx.commit();
        manager.close();
        return historico;
    }
    
}
