/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.EstadoProveedorFacadeLocal;
import co.com.origenpath.dao.ProveedorFacadeLocal;
import co.com.origenpath.entidades.EstadoProveedor;
import co.com.origenpath.entidades.Proveedor;
import co.com.origenpath.utils.jsfUtils;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author daniel
 */
@ManagedBean
@ViewScoped
public class ProveedoresControlador {

    @EJB
    ProveedorFacadeLocal proveedorFacadeLocal;
    @EJB
    EstadoProveedorFacadeLocal estadoProveedorFacadeLocal;

    private Proveedor proveedor;
    private List<EstadoProveedor> estadoProveedores;
    private String accion;
//    private List<Proveedor> proveedores;

    @PostConstruct
    public void init() {
        proveedor = new Proveedor();
        estadoProveedores = listarEstadoProveedores();
//        proveedores = listarProveedores();
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<EstadoProveedor> getEstadoProveedores() {
        return estadoProveedores;
    }

    public void setEstadoProveedores(List<EstadoProveedor> estadoProveedores) {
        this.estadoProveedores = estadoProveedores;
    }

//    public List<Proveedor> getProveedores() {
//        return proveedores;
//    }
//
//    public void setProveedores(List<Proveedor> proveedores) {
//        this.proveedores = proveedores;
//    }
    public void guardarProveedor() {
        try {
            proveedorFacadeLocal.create(proveedor);
//            proveedores = listarProveedores();
            jsfUtils.addSuccessMessage("Registro Guardado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al guardar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public void buscarProveedor(Integer id) {
        Proveedor p = proveedorFacadeLocal.find(id);
        proveedor.setCodigoProveedor(p.getCodigoProveedor());
        proveedor.setNitProveedor(p.getNitProveedor());
        proveedor.setNombreEmpresa(p.getNombreEmpresa());
        proveedor.setTelefono(p.getTelefono());
        proveedor.setExt(p.getExt());
        proveedor.setDireccion(p.getDireccion());
        proveedor.setEstadoProveedor(p.getEstadoProveedor());
    }

    public void modificarProveedor() {
        try {

            proveedorFacadeLocal.edit(proveedor);
//            proveedores = listarProveedores();
            jsfUtils.addSuccessMessage("Registro Editado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al editar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public void eliminarProveedir(Integer id) {
        try {
            Proveedor p = proveedorFacadeLocal.find(id);
            proveedor.setCodigoProveedor(p.getCodigoProveedor());
            proveedor.setNitProveedor(p.getNitProveedor());
            proveedor.setNombreEmpresa(p.getNombreEmpresa());
            proveedor.setTelefono(p.getTelefono());
            proveedor.setExt(p.getExt());
            proveedor.setDireccion(p.getDireccion());
            proveedor.setEstadoProveedor(p.getEstadoProveedor());
            proveedorFacadeLocal.remove(p);
//            proveedores = listarProveedores();
            jsfUtils.addSuccessMessage("Registro Eliminado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al eliminar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public void operar() {
        switch (accion) {
            case "Guardar":
                this.guardarProveedor();
                break;
            case "Actualizar":
                this.modificarProveedor();
                break;
        }
    }

    public List<Proveedor> listarProveedores() {
        return proveedorFacadeLocal.findAll();
    }
    private List<EstadoProveedor> listarEstadoProveedores() {
        return estadoProveedorFacadeLocal.findAll();
    }

    /**
     * Creates a new instance of ProveedoresControlador
     */
    public ProveedoresControlador() {
    }

}
