/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.DetalleKitFacadeLocal;
import co.com.origenpath.dao.EstadoProductoFacadeLocal;
import co.com.origenpath.dao.ProductosFacadeLocal;
import co.com.origenpath.dao.ProveedorFacadeLocal;
import co.com.origenpath.dao.TipoProductoFacadeLocal;
import co.com.origenpath.entidades.DetalleKit;
import co.com.origenpath.entidades.EstadoProducto;
import co.com.origenpath.entidades.Productos;
import co.com.origenpath.entidades.Proveedor;
import co.com.origenpath.entidades.TipoProducto;
import co.com.origenpath.utils.jsfUtils;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author daniel
 */
@ManagedBean
@SessionScoped
public class ProductoCotrolador implements Serializable {

    @EJB
    TipoProductoFacadeLocal tipoProductoFacadeLocal;
    @EJB
    EstadoProductoFacadeLocal estadoProductoFacadeLocal;
    @EJB
    ProveedorFacadeLocal proveedorFacadeLocal;
    @EJB
    ProductosFacadeLocal productosFacadeLocal;
    @EJB
    DetalleKitFacadeLocal detalleKitFacadeLocal;

    private Productos productos;
    private DetalleKit detalleKit;
    private List<TipoProducto> tipoProductos;
    private List<EstadoProducto> estadoProductos;
    private List<Proveedor> proveedores;
    private List<DetalleKit> listaDetalle = new ArrayList<>();

    private String imagenProducto;
    private StreamedContent imganeP;
    private String accion;
    
    private boolean display;
    
    

    @PostConstruct
    public void init() {
        productos = new Productos();
        detalleKit = new DetalleKit();
        tipoProductos = listarTipoProductos();
        estadoProductos = listarEstadoProductos();
        proveedores = listarProveedores();
        display = false;
    }
    
//    public boolean show(){
//        return display;
//    }
    
    public void change(javax.faces.event.AjaxBehaviorEvent changeEvent){
        if(productos.getTipoProducto().getIdTipoProducto().equals(2)){
        setDisplay(true);    
        }else{
            setDisplay(false);
        }
        
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
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

    
    public List<DetalleKit> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetalleKit> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public DetalleKit getDetalleKit() {
        return detalleKit;
    }

    public void setDetalleKit(DetalleKit detalleKit) {
        this.detalleKit = detalleKit;
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

        

    public void setImganeP(StreamedContent imganeP) {
        this.imganeP = imganeP;
    }
    
    public void reset(){
        
            productos = new Productos();
            setAccion(null);
            productos.getImagenProducto();
        
    }
    public List<Productos> completeStrin(String ref) {
        List<Productos> results = productosFacadeLocal.findByRef(ref);
        return results;
    }
    
    public void onRowEdit(RowEditEvent event) {
        jsfUtils.addSuccessMessage("Cantidad Modificada Con Exito");
    }
     
    public void onRowCancel(RowEditEvent event) {
        jsfUtils.addSuccessMessage("Cantidad No Modificada");
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void operar() {
        switch (accion) {
            case "Guardar":
                this.guardarProducto();
                reset();
                break;
            case "Actualizar":
                this.modificarProducto();
                break;
        }
    }
    
    public int totalKit(){
        int cant = detalleKit.getCantidadProducto();        
        int precio = productos.getPrecioVenta();        
        return cant * precio;
    }
    
    public void agregar(){
        try{
            DetalleKit detalle = new DetalleKit();
            detalle.setCantidadProducto(detalleKit.getCantidadProducto());
            detalle.setReferenciaProducto(productos);
            detalle.setValorTotal(totalKit());
            this.listaDetalle.add(detalle);
            jsfUtils.addSuccessMessage("Producto Agregado Correctamente");            
        }catch(Exception e){
           jsfUtils.addErrorMessage("Error al agregar el producto verifique los datos o pongase en contacto con el adminstrador del sistema"); 
        }
    }

    public void guardarProducto() {
        try {
            productosFacadeLocal.create(productos);
            for (DetalleKit det: listaDetalle) {
                DetalleKit detalleList = new DetalleKit();
                detalleList.setCantidadProducto(det.getCantidadProducto());
                detalleList.setReferenciaProducto(det.getReferenciaProducto());
                detalleList.setValorTotal(det.getValorTotal());
                detalleKitFacadeLocal.create(detalleList);
            }
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

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String id = request.getParameter("id");
//        String id = context.getExternalContext().getRequestParameterMap().get("id");
            byte[] img = obtenerImagen(id);
            return new DefaultStreamedContent(new ByteArrayInputStream(img));
        }
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
