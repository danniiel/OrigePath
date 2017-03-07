/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.EstadoPedidoFacadeLocal;
import co.com.origenpath.entidades.EstadoPedido;
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
public class EstadoPedidoControlador {

    @EJB
    EstadoPedidoFacadeLocal estadoPedidoFacadeLocal;

    EstadoPedido estadoPedido;
    private String accion;

    @PostConstruct
    public void init() {
        estadoPedido = new EstadoPedido();
        estadoPedido.setIdEstadoPedido(buscarId()+1);
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    
    
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public void operar(){
        switch (accion) {
            case "Guardar":
                this.guardarEstadoPedido();
                break;
            case "Actualizar":
                this.editarEstadoPedido();
                break;
        }
    }
    
    public void guardarEstadoPedido() {
        try{
            estadoPedidoFacadeLocal.create(estadoPedido);
            jsfUtils.addSuccessMessage("Registro Guardado Correctamente");
        }catch (Exception e){
             jsfUtils.addErrorMessage("Error al editar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
        
    }

    public List<EstadoPedido> listarEstadoPedido() {
        return estadoPedidoFacadeLocal.findAll();
    }

    public void buscarEstadoPedido(Integer id) {
        try {
            EstadoPedido ep = estadoPedidoFacadeLocal.find(id);
            estadoPedido.setIdEstadoPedido(ep.getIdEstadoPedido());
            estadoPedido.setNombreEstadoPedido(ep.getNombreEstadoPedido());
            jsfUtils.addSuccessMessage("Registro Guardado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al guardar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public void editarEstadoPedido() {
        try {
            estadoPedidoFacadeLocal.edit(estadoPedido);
            jsfUtils.addSuccessMessage("Registro Editado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al editar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public void eliminarEstadoPedido(Integer id) {
        try {
            EstadoPedido ep = estadoPedidoFacadeLocal.find(id);
            estadoPedidoFacadeLocal.remove(ep);
            jsfUtils.addSuccessMessage("Registro Eliminado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al eliminar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }

    }
    
     public Integer buscarId(){
        int id = estadoPedidoFacadeLocal.count();
        return id;
    }

    /**
     * Creates a new instance of DetallePedidoFacade
     */
    public EstadoPedidoControlador() {
    }

}
