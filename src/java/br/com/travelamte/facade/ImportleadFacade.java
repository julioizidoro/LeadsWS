/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.facade;

import br.com.travelamte.dao.ImportleadDao;
import br.com.travelamte.model.Importlead;
import java.util.List;

/**
 *
 * @author julioizidoro
 */
public class ImportleadFacade {
    
    public List<Importlead> listar() {
        ImportleadDao importLeadDao = new ImportleadDao();
        return importLeadDao.listar();
    }
    
}
