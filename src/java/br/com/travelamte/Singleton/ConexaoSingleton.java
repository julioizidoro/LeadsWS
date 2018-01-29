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
    
    
    private static EntityManagerFactory emfSysTM = null;
    private static EntityManager managerSysTM= null;
    private static EntityManagerFactory emfLead = null;
    private static EntityManager managerLead= null;
   
    
    
    public static EntityManager getInstanceSysTM() {
//        emfSysTM = null;
//        if (managerSysTM!=null){
//            if (managerSysTM.isOpen()){
//                managerSysTM.close();
//            }
//        }
        if (emfSysTM == null) {
            Map mapa = new HashMap();
            mapa.put("hibernate.connection.url", "jdbc:mysql://localhost:8081/systm");
            mapa.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            mapa.put("hibernate.connection.password", "simples");
            mapa.put("hibernate.connection.username", "root");
            mapa.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
            mapa.put("hibernate.show_sql", "true");
            mapa.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            emfSysTM = Persistence.createEntityManagerFactory("systmPU", mapa);
            managerSysTM = emfSysTM.createEntityManager();
        }
        if (!managerSysTM.isOpen()) {
            System.out.print("Verifique conexão com banco de dados SysTM");
        }
        return managerSysTM;
    }
   
}
