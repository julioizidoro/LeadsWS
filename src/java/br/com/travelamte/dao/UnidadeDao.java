/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;

import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Unidadenegocio;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author jizid
 */
public class UnidadeDao {
    
    public Unidadenegocio getUsuarioResponsavel(int idUnidade){
        EntityManager manager = ConexaoSingleton.getConnection();
        Query q = manager.createQuery("select u from Unidadenegocio u where u.idunidadeNegocio=" + idUnidade);
        Unidadenegocio unidade = null;
        if (q.getResultList().size()>0){
            unidade = (Unidadenegocio) q.getResultList().get(0);
        }
        manager.close();
        return unidade;
    }
    
    public Unidadenegocio getUnidade(int idUnidade){
        EntityManager manager = ConexaoSingleton.getConnection();
        Query q = manager.createQuery("select u from Unidadenegocio u where u.idunidadeNegocio=" +  idUnidade);
        Unidadenegocio unidade = null;
        if (q.getResultList().size()>0){
            unidade = (Unidadenegocio) q.getResultList().get(0);
        }
        manager.close();
        return unidade;
    }
    
    public void salvar(Unidadenegocio unidade){
        EntityManager manager = ConexaoSingleton.getConnection();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.merge(unidade);
        tx.commit();
        manager.close();
    }
    
    public Unidadenegocio getUnidade(String nome){
        EntityManager manager = ConexaoSingleton.getConnection();
        Query q = manager.createQuery("select u from Unidadenegocio u where u.nomews='" +  nome + "'");
        Unidadenegocio unidade = null;
        if (q.getResultList().size()>0){
            unidade = (Unidadenegocio) q.getResultList().get(0);
        }
        manager.close();
        return unidade;
    }
    
}