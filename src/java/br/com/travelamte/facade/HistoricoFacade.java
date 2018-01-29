/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.facade;

import br.com.travelamte.dao.HistoricoDao;
import br.com.travelamte.model.Leadhistorico;



/**
 *
 * @author wolverine
 */
public class HistoricoFacade {
    
    public Leadhistorico salvar(Leadhistorico historico) {
        HistoricoDao historicoDao = new HistoricoDao();
        return historicoDao.salvar(historico);
    }
    
}
