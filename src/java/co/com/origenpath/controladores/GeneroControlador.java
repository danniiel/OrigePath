/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.GeneroFacadeLocal;
import co.com.origenpath.entidades.Genero;
import co.com.origenpath.utils.jsfUtils;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author daniel
 */
@ManagedBean
@ViewScoped
public class GeneroControlador {

    @EJB
    GeneroFacadeLocal generoFacadeLocal;
    private Genero genero;
    private String accion;

    @PostConstruct
    public void init() {
        genero = new Genero();
        genero.setIdGenero(buscarId()+1);
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void operar(){
        switch (accion) {
            case "Guardar":
                this.guardarGenero();
                break;
            case "Actualizar":
                this.editarGenero();
                break;
        }
    }
    
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void guardarGenero() {
        try {
        generoFacadeLocal.create(genero);
            jsfUtils.addSuccessMessage("Registro Guardado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al guardar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }
    
    public void editarGenero() {
        try {
        generoFacadeLocal.edit(genero);
            jsfUtils.addSuccessMessage("Registro Editado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al guardar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public List<Genero> listarGenero() {
        return generoFacadeLocal.findAll();
    }

    public void buscarGenero(Integer id) {
        Genero g = generoFacadeLocal.find(id);
        genero.setIdGenero(g.getIdGenero());
        genero.setNombreGenero(g.getNombreGenero());
    }

//    public void editarGenero(Genero genero) {
//        try {
//        Genero g = new Genero();
//        g.setIdGenero(genero.getIdGenero());
//        g.setNombreGenero(genero.getNombreGenero());
//        generoFacadeLocal.edit(g);
//            jsfUtils.addSuccessMessage("Registro Editado Correctamente");
//        } catch (Exception e) {
//            jsfUtils.addErrorMessage("Error al editar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
//        }
//    }

    public void eliminarGenero(Integer id) {
        try {
            Genero g = generoFacadeLocal.find(id);
            generoFacadeLocal.remove(g);
            jsfUtils.addSuccessMessage("Registro Eliminado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al eliminar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }
    
    public Integer buscarId(){
        int id = generoFacadeLocal.count();
        return id;
    }

    /**
     * Creates a new instance of GeneroControlador
     */
    public GeneroControlador() {
    }

}
