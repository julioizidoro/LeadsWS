/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;

import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Publicidade;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author julioizidoro
 */
public class PublicidadeDao {
    
    public Publicidade getPublicidade(String nome) {
    	EntityManager manager = ConexaoSingleton.getConnection();
        Query q = manager.createQuery("select p from Publicidade  p WHERE p.mostrar=1 and p.descricao='" + nome + "' order by p.descricao");
        Publicidade publicidade = null;
        if (q.getResultList().size()>0){
            publicidade = (Publicidade) q.getResultList().get(0);
        }
        return publicidade;
    }
    
}
