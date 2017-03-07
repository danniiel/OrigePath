/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.RolFacadeLocal;
import co.com.origenpath.entidades.Rol;
import co.com.origenpath.utils.jsfUtils;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author daniel
 */
@ManagedBean
@RequestScoped
public class RolControlador {

    @EJB
    RolFacadeLocal rolFacadeLocal;
    private Rol rol;

    @PostConstruct
    public void init() {
        rol = new Rol();
        rol.setIdRol(buscarId()+1);
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void guardarRol() {
        try {
            rolFacadeLocal.create(rol);
            jsfUtils.addSuccessMessage("Registro Guardado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al guardar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public List<Rol> listarRoles() {
        return rolFacadeLocal.findAll();
    }

    public void buscarRol(Integer id) {
        Rol r = rolFacadeLocal.find(id);
        rol.setIdRol(r.getIdRol());
        rol.setNombreRol(r.getNombreRol());
    }

    public void editarRol(Rol rol) {
        try {
            Rol r = new Rol();
            r.setIdRol(rol.getIdRol());
            r.setNombreRol(rol.getNombreRol());
            rolFacadeLocal.edit(r);
            jsfUtils.addSuccessMessage("Registro Editado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al editar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public void eliminarRol(Integer id) {
        Rol r = rolFacadeLocal.find(id);
        rolFacadeLocal.remove(r);
        try {
            jsfUtils.addSuccessMessage("Registro Eliminado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al eliminar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public Integer buscarId() {
        int id = rolFacadeLocal.count();
        return id;
    }

    /**
     * Creates a new instance of RolControlador
     */
    public RolControlador() {
    }

}
