/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.facade;

import br.com.travelamte.dao.PublicidadeDao;
import br.com.travelamte.model.Publicidade;

/**
 *
 * @author julioizidoro
 */
public class PublicidadeFacade {
    
    public Publicidade getPublicidade(String nome) {
        PublicidadeDao publicidadeDao = new PublicidadeDao();
        return publicidadeDao.getPublicidade(nome);
    }
    
}
