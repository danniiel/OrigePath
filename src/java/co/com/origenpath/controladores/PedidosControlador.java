/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.DetallePedidoFacadeLocal;
import co.com.origenpath.dao.FacturasFacadeLocal;
import co.com.origenpath.dao.PedidosFacadeLocal;
import co.com.origenpath.dao.ProductosFacadeLocal;
import co.com.origenpath.entidades.DetallePedido;
import co.com.origenpath.entidades.Facturas;
import co.com.origenpath.entidades.Pedidos;
import co.com.origenpath.entidades.Productos;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author daniel
 */
@ManagedBean
@SessionScoped
public class PedidosControlador {

    /**
     * Creates a new instance of PedidosControlador
     */
    @EJB
    PedidosFacadeLocal pedidosFacadeLocal;
    @EJB
    DetallePedidoFacadeLocal detallePedidoFacadeLocal;
    @EJB
    ProductosFacadeLocal productosFacadeLocal;
    @EJB
    FacturasFacadeLocal facturasFacadeLocal;

    private Pedidos pedidos;
    private Productos pro;
    private DetallePedido detallePedido;
    private List<DetallePedido> listaDetalle;
    private Facturas facturas;

    public PedidosControlador() {
        pedidos = new Pedidos();
        detallePedido = new DetallePedido();
        facturas = new Facturas();
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

    public List<DetallePedido> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetallePedido> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public Productos getPro() {
        return pro;
    }

    public void setPro(Productos pro) {
        this.pro = pro;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }
    

    public void agregar() {
        
        DetallePedido detpedido = new DetallePedido();
        detpedido.setCodigoPedido(pedidos);
        detpedido.setCodigoFactura(facturas);
        detpedido.setCodigoProducto(pro);
        detpedido.setCantidadProducto(detallePedido.getCantidadProducto());
        //detpedido.setValorProducto(pro.getPrecioVenta());
        
        this.listaDetalle.add(detpedido);

    }

//    public List<Productos> completeString(String query) {
//        List<Productos> resultado = productosFacadeLocal.findByRef(query);
//        return resultado;
//    }
}
