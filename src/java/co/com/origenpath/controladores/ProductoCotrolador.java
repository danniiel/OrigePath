/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.EstadoProductoFacadeLocal;
import co.com.origenpath.dao.ProductosFacadeLocal;
import co.com.origenpath.dao.ProveedorFacadeLocal;
import co.com.origenpath.dao.TipoProductoFacadeLocal;
import co.com.origenpath.entidades.EstadoProducto;
import co.com.origenpath.entidades.Productos;
import co.com.origenpath.entidades.Proveedor;
import co.com.origenpath.entidades.TipoProducto;
import co.com.origenpath.utils.jsfUtils;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author daniel
 */
@ManagedBean
@ViewScoped
public class ProductoCotrolador implements Serializable {

    @EJB
    TipoProductoFacadeLocal tipoProductoFacadeLocal;
    @EJB
    EstadoProductoFacadeLocal estadoProductoFacadeLocal;
    @EJB
    ProveedorFacadeLocal proveedorFacadeLocal;
    @EJB
    ProductosFacadeLocal productosFacadeLocal;

    private Productos productos;
    private List<TipoProducto> tipoProductos;
    private List<EstadoProducto> estadoProductos;
    private List<Proveedor> proveedores;

    private String imagenProducto;
    private StreamedContent file;
    private StreamedContent imganeP;
    private String accion;

    @PostConstruct
    public void init() {
        productos = new Productos();
        tipoProductos = listarTipoProductos();
        estadoProductos = listarEstadoProductos();
        proveedores = listarProveedores();
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public List<TipoProducto> getTipoProductos() {
        return tipoProductos;
    }

    public void setTipoProductos(List<TipoProducto> tipoProductos) {
        this.tipoProductos = tipoProductos;
    }

    public List<EstadoProducto> getEstadoProductos() {
        return estadoProductos;
    }

    public void setEstadoProductos(List<EstadoProducto> estadoProductos) {
        this.estadoProductos = estadoProductos;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

//    public StreamedContent getImganeP() {
//        return imganeP;
//    }
    public void setImganeP(StreamedContent imganeP) {
        this.imganeP = imganeP;
    }

    public void operar() {
        switch (accion) {
            case "Guardar":
                this.guardarProducto();
                break;
            case "Actualizar":
                this.modificarProducto();
                break;
        }
    }

    public void guardarProducto() {
        try {
            productosFacadeLocal.create(productos);
            jsfUtils.addSuccessMessage("Registro Guardado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al guardar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public void buscarProducto(String referencia) {
        Productos pro = productosFacadeLocal.find(referencia);
        productos.setReferenciaProducto(pro.getReferenciaProducto());
        productos.setNombreProducto(pro.getNombreProducto());
        productos.setImagenProducto(pro.getImagenProducto());
        productos.setCantidadProducto(pro.getCantidadProducto());
        productos.setPrecioVenta(pro.getPrecioVenta());
        productos.setPrecioCompra(pro.getPrecioCompra());
        productos.setGramos(pro.getGramos());
        productos.setTipoProducto(pro.getTipoProducto());
        productos.setEstadoProducto(pro.getEstadoProducto());
        productos.setProveedor(pro.getProveedor());
        productos.setDescripcion(pro.getDescripcion());

    }

    public void modificarProducto() {

        productosFacadeLocal.edit(productos);
        jsfUtils.addSuccessMessage("Registro Modificado Correctamente");
    }

    /*public void consultarImagen()throws {
        
    }*/
    public void eliminarProducto(String id) {
        try {
            Productos p = productosFacadeLocal.find(id);
            productosFacadeLocal.remove(p);
            jsfUtils.addSuccessMessage("Registro Eliminado Correctamente");
        } catch (Exception e) {
            jsfUtils.addErrorMessage("Error al eliminar el registro verifique los datos o pongase en contacto con el adminstrador del sistema");
        }
    }

    public List<Productos> listarProductos() {
        return productosFacadeLocal.findAll();
    }

    private List<TipoProducto> listarTipoProductos() {
        return tipoProductoFacadeLocal.findAll();
    }

    private List<EstadoProducto> listarEstadoProductos() {
        return estadoProductoFacadeLocal.findAll();
    }

    private List<Proveedor> listarProveedores() {
        return proveedorFacadeLocal.findAll();
    }

    /*
     Metodo para subir imagen al servidor
     */
    public void subirImagen(FileUploadEvent event) {
        FacesMessage mensaje = new FacesMessage();
        try {
            productos.setImagenProducto(event.getFile().getContents());
            imagenProducto = jsfUtils.guardarImagenTemporal(productos.getImagenProducto(), event.getFile().getFileName());
            mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
            mensaje.setSummary("Imagen subida con exito!");
        } catch (Exception e) {
            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
            mensaje.setSummary("Problemas al subir la imagen");
        }
        FacesContext.getCurrentInstance().addMessage("mensaje", mensaje);
    }

    public StreamedContent getImganeP() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String id = request.getParameter("id");
        byte[] img = obtenerImagen("1956");        
        return new DefaultStreamedContent(new ByteArrayInputStream(img));

    }

    public byte[] obtenerImagen(String id) throws IOException {
        byte[] imagen = null;
        Productos p = productosFacadeLocal.find(id);
        imagen = p.getImagenProducto();
        return imagen;

    }

    /**
     * Creates a new instance of ProductoCotrolador
     */
    public ProductoCotrolador() {
    }

}
