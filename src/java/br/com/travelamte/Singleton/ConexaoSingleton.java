/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.Singleton;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kamilla Rodrigues
 */
public class ConexaoSingleton {
    
    
    private static EntityManager manager;
    private static EntityManager entityManager;
   
    
    
    public static EntityManager getConnection() {
        EntityManagerFactory emf = null;
        manager = null;
        emf = Persistence.createEntityManagerFactory("systmPU");
        manager = emf.createEntityManager();
        if (!manager.isOpen()) {
            System.out.print("Conexão fechada");
        }
        return manager;
    }
}
