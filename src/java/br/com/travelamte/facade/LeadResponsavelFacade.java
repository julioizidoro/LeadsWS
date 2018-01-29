/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.facade;

import br.com.travelamte.dao.LeadResponsavelDao;
import br.com.travelamte.model.Leadresponsavel;
import java.util.List;

/**
 *
 * @author wolverine
 */
public class LeadResponsavelFacade {
    
    public List<Leadresponsavel> list(int unidade)  {
        LeadResponsavelDao leadResponsavelDao = new LeadResponsavelDao();
        return leadResponsavelDao.list(unidade);
    }
    
}
