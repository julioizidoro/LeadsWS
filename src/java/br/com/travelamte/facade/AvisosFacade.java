/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.facade;

import br.com.travelamte.dao.AvisosDao;
import br.com.travelamte.model.Avisos;
import br.com.travelamte.model.Avisousuario;


/**
 *
 * @author wolverine
 */
public class AvisosFacade {
    
    public Avisos salvar(Avisos aviso) {
        AvisosDao avisosDao = new AvisosDao();
        return avisosDao.salvar(aviso);
    }
    
    public Avisousuario salvar(Avisousuario avisoUsuario) {
        AvisosDao avisosDao = new AvisosDao();
        return avisosDao.salvar(avisoUsuario);
    }
    
}
