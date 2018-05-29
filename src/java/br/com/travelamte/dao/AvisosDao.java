/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;

import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Avisos;
import br.com.travelamte.model.Avisousuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author wolverine
 */
public class AvisosDao {
    
    public Avisos salvar(Avisos aviso) {
        EntityManager manager;
        manager = ConexaoSingleton.getConnection();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        aviso = manager.merge(aviso);
        tx.commit();
        manager.close();
        return aviso;
    }
    
    public Avisousuario salvar(Avisousuario avisoUsuario) {
        EntityManager manager;
        manager = ConexaoSingleton.getConnection();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        avisoUsuario = manager.merge(avisoUsuario);
        tx.commit();
        manager.close();
        return avisoUsuario;
    }
    
}
