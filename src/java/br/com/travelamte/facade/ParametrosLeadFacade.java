/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.facade;

import br.com.travelamte.dao.ParametrosLeadDao;
import br.com.travelamte.model.Parametroslead;


/**
 *
 * @author jizid
 */
public class ParametrosLeadFacade {
    
    public Parametroslead get(){
        ParametrosLeadDao parametrosLeadDao = new ParametrosLeadDao();
        return parametrosLeadDao.get();
    }
    
    public Parametroslead salvar(Parametroslead parametrosLead) {
        ParametrosLeadDao parametrosLeadDao = new ParametrosLeadDao();
        return parametrosLeadDao.salvar(parametrosLead);
    }
    
    
    
}
