/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.dao;

import co.com.origenpath.entidades.PermisosRol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author danie
 */
@Stateless
public class PermisosRolFacade extends AbstractFacade<PermisosRol> implements PermisosRolFacadeLocal {

    @PersistenceContext(unitName = "OrigenPathPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermisosRolFacade() {
        super(PermisosRol.class);
    }
    
}
