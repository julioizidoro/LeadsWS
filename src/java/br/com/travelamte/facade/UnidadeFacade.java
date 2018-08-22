/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.facade;

import br.com.travelamte.dao.UnidadeDao;
import br.com.travelamte.model.Unidadenegocio;

/**
 *
 * @author jizid
 */
public class UnidadeFacade {
    
    public Unidadenegocio getUsuarioResponsavel(int idUnidade){
        UnidadeDao unidadeDao = new UnidadeDao();
        return unidadeDao.getUsuarioResponsavel(idUnidade);
    }
    
    public Unidadenegocio getUnidade(int idUnidade){
        UnidadeDao unidadeDao = new UnidadeDao();
        return unidadeDao.getUnidade(idUnidade);
    }
    
    public void salvar(Unidadenegocio unidade){
        UnidadeDao unidadeDao = new UnidadeDao();
        unidadeDao.salvar(unidade);
    }
    
    public Unidadenegocio getUnidade(String nome){
         UnidadeDao unidadeDao = new UnidadeDao();
         return unidadeDao.getUnidade(nome);
    }
    
}
