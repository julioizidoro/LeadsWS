/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;

import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Importlead;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author julioizidoro
 */
public class ImportleadDao {
    
     public List<Importlead> listar() {
    	EntityManager manager = ConexaoSingleton.getConnection();
	EntityTransaction tx = manager.getTransaction();
	Query q = manager.createQuery("SELECT i FROM Importlead i");
        List<Importlead> lista = null;
        if (q.getResultList().size() > 0) {
            lista = q.getResultList();
        }
        manager.close();
        return lista;
    }
    
}
