/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;


import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Pais;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author julioizidoro
 */
public class PaisDao {
    
    public Pais consultarNome(String nome) {
    	EntityManager manager = ConexaoSingleton.getConnection();
        Query q = manager.createQuery("select p from Pais p where p.nome='" + nome + "'" );
        Pais pais = null;
        if (q.getResultList().size() > 0) {
        	pais = (Pais) q.getResultList().get(0);
        } 
        return pais;
     }
    
}
