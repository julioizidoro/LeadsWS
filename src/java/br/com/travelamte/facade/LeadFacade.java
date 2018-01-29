/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.facade;

import br.com.travelamte.dao.LeadDao;
import br.com.travelamte.model.Lead;


/**
 *
 * @author jizid
 */
public class LeadFacade {
    
    public Lead salvar(Lead lead)  {
        LeadDao leadDao = new LeadDao();
        return leadDao.salvar(lead);
    }
    
    public Lead getLead(int idCliente){
        LeadDao leadDao = new LeadDao();
        return leadDao.getLead(idCliente);
    }
}
