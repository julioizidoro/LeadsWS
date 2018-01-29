/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.facade;

import br.com.travelamte.dao.LeadControleDao;
import br.com.travelamte.model.Leadcontrole;


/**
 *
 * @author Wolverine
 */
public class LeadControleFacade {
    
    public void salvar(Leadcontrole leadControle)  {
        LeadControleDao leadControleDao = new LeadControleDao();
        leadControleDao.salvar(leadControle);
    }
    
}
