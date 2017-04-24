/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.dao;

import co.com.origenpath.entidades.PermisosRol;
import co.com.origenpath.entidades.Personas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author danie
 */
@Stateless
public class PersonasFacade extends AbstractFacade<Personas> implements PersonasFacadeLocal {

    @PersistenceContext(unitName = "OrigenPathPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public Personas iniciarSesion(Personas p) {
        Personas usuario = null;
        String consulta;
        try {
            consulta = "SELECT p FROM Personas p WHERE p.usuario = ?1 and p.contrasena = ?2";
            Query q = em.createQuery(consulta);
            q.setParameter(1, p.getUsuario());
            q.setParameter(2, p.getContrasena());
            List<Personas> lista = q.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }
    
    @Override
    public PermisosRol obtenerPermisos(Personas p){
        PermisosRol pr = null;
        String consulta;
        try{
            consulta = "SELECT r,p,m FROM permisos_rol m,personas p,rol r WHERE m.codigo_rol = r.id_rol and p.rol = r.id_rol and p.usuario = ?1";
            System.out.println(consulta);
            Query q = em.createQuery(consulta);
                  q.setParameter(1, p.getUsuario());
                  pr = (PermisosRol)q.getSingleResult();
        }catch(Exception e){
            throw e;
        }
        return pr;
    }

    public PersonasFacade() {
        super(Personas.class);
    }
    
}
