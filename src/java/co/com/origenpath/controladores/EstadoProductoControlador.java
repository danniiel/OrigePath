/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.EstadoProductoFacadeLocal;
import co.com.origenpath.entidades.EstadoProducto;
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
public class EstadoProductoControlador {

    @EJB
    EstadoProductoFacadeLocal estadoProductoFacadeLocal;
    private EstadoProducto estadoProducto;
    private String accion;

    @PostConstruct
    public void init() {
        estadoProducto = new EstadoProducto();
        estadoProducto.setIdEstadoProducto(buscarId()+1);
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }    
    
    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public void operar(){
        switch (accion) {
            case "Guardar":
                this.guardarEstadoProducto();
                break;
            case "Actualizar":
                this.editarEstadoProducto();
                break;
        }
    }
    
    public void guardarEstadoProducto() {
        try {
            estadoProductoFacadeLocal.create(estadoProducto);
            jsfUtils.addSuccessMessage("Registro Guardado Correctamente");

        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al guardar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public List<EstadoProducto> listarEstadoProducto() {
        return estadoProductoFacadeLocal.findAll();
    }

    public void buscarEstadoProducto(Integer id) {
        EstadoProducto estprod = estadoProductoFacadeLocal.find(id);
        estadoProducto.setIdEstadoProducto(estprod.getIdEstadoProducto());
        estadoProducto.setNombreEstadoProducto(estprod.getNombreEstadoProducto());
    }

    public void editarEstadoProducto() {
        try {            
            estadoProductoFacadeLocal.edit(estadoProducto);
            jsfUtils.addSuccessMessage("Registro Editado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al editar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public void eliminarEstadoProducto(Integer id) {
        try {
            jsfUtils.addSuccessMessage("Registro Eliminado Correctamente");
            EstadoProducto ep = estadoProductoFacadeLocal.find(id);
            estadoProductoFacadeLocal.remove(ep);

        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al eliminado el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }
    
    public Integer buscarId(){
        int id = estadoProductoFacadeLocal.count();
        return id;
    }

    /**
     * Creates a new instance of EstadoProductoControlador
     */
    public EstadoProductoControlador() {
    }

}
