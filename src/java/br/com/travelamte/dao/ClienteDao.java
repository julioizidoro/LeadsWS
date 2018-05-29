/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;

import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author jizid
 */
public class ClienteDao {
    
    public Cliente salvar(Cliente cliente) {
    	EntityManager manager = ConexaoSingleton.getConnection();
	EntityTransaction tx = manager.getTransaction();
	tx.begin();
        cliente = manager.merge(cliente);
        tx.commit();
        manager.close();
        return cliente;
    }
    
    public Cliente consultarEmail(String email) {
        EntityManager manager = ConexaoSingleton.getConnection();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query q = manager.createQuery("select c from Cliente c where c.email='" + email + "'");
        Cliente cliente = null;
        if (q.getResultList().size() > 0) {
            cliente = (Cliente) q.getResultList().get(0);
        }
        tx.commit();
        manager.close();
        return cliente;
    }
}
