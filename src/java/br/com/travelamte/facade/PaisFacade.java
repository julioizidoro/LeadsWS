/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.facade;

import br.com.travelamte.dao.PaisDao;
import br.com.travelamte.model.Pais;

/**
 *
 * @author julioizidoro
 */
public class PaisFacade {
    
    public Pais consultarNome(String nome) {
        PaisDao paisDao = new PaisDao();
        return paisDao.consultarNome(nome);
    }
    
}
