/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;

import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Leadresponsavel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author wolverine
 */
public class LeadResponsavelDao {
    
    public List<Leadresponsavel> list(int unidade)  {
        EntityManager manager = ConexaoSingleton.getInstanceSysTM();
       Query q = manager.createQuery("select l from Leadresponsavel l where l.unidadenegocio=" + unidade);
        List<Leadresponsavel> lista = null;
        if (q.getResultList().size() > 0) {
            lista = q.getResultList();
        }
        return lista;
    }
    
}
