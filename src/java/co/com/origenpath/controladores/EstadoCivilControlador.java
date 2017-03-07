/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.EstadoCivilFacadeLocal;
import co.com.origenpath.entidades.EstadoCivil;
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
public class EstadoCivilControlador {

    @EJB
    EstadoCivilFacadeLocal estadoCivilFacadeLocal;
    private EstadoCivil estadoCivil;

    @PostConstruct
    public void init() {
        estadoCivil = new EstadoCivil();
        estadoCivil.setIdEstadoCivil(buscarId()+1);
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void gurdarEstadoCivil() {
        try {
            estadoCivilFacadeLocal.create(estadoCivil);
            jsfUtils.addSuccessMessage("Registro Guardado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al guardar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public List<EstadoCivil> listarEstadoCivil() {
        return estadoCivilFacadeLocal.findAll();
    }

    public void buscarEstadoCivil(Integer id) {
        EstadoCivil ec = estadoCivilFacadeLocal.find(id);
        estadoCivil.setIdEstadoCivil(ec.getIdEstadoCivil());
        estadoCivil.setNombreEstadoCivil(ec.getNombreEstadoCivil());
    }

    public void editarEstadoCivil(EstadoCivil ec) {
        try {
            EstadoCivil e = new EstadoCivil();
            e.setIdEstadoCivil(ec.getIdEstadoCivil());
            e.setNombreEstadoCivil(ec.getNombreEstadoCivil());
            estadoCivilFacadeLocal.edit(e);
            jsfUtils.addSuccessMessage("Registro Editado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al editar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public void eliminarBarrio(Integer id) {
        try {
            EstadoCivil ec = estadoCivilFacadeLocal.find(id);
            estadoCivilFacadeLocal.remove(ec);
            jsfUtils.addSuccessMessage("Registro Eliminado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al eliminar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }
    
    public Integer buscarId(){
         int id = estadoCivilFacadeLocal.count();
         return id;
    }

    /**
     * Creates a new instance of EstadoCivilControlador
     */
    public EstadoCivilControlador() {
    }

}
