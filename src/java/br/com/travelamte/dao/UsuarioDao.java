/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.dao;

import br.com.travelamte.Singleton.ConexaoSingleton;
import br.com.travelamte.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author wolverine
 */
public class UsuarioDao {
    
    public List<Usuario> consultar(int unidade) {
        EntityManager manager = ConexaoSingleton.getConnection();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query q = manager.createQuery("SELECT u FROM Usuario u WHERE u.recebeleadautomatica=1 and u.unidadenegocio=" + unidade );
        List<Usuario> listaUsuario = null;
        if (q.getResultList().size() > 0) {
            listaUsuario = q.getResultList();
        }
        tx.commit();
        manager.close();
        return listaUsuario;
    }
    
    public void salvar(Usuario usuario){
        EntityManager manager = ConexaoSingleton.getConnection();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.merge(usuario);
        tx.commit();
        manager.close();
    }
    
}
