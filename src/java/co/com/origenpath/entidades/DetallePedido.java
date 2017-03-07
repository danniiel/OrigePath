/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "detalle_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d")
    , @NamedQuery(name = "DetallePedido.findByCodigoDetallePedido", query = "SELECT d FROM DetallePedido d WHERE d.codigoDetallePedido = :codigoDetallePedido")
    , @NamedQuery(name = "DetallePedido.findByCantidadProducto", query = "SELECT d FROM DetallePedido d WHERE d.cantidadProducto = :cantidadProducto")
    , @NamedQuery(name = "DetallePedido.findByCantidadDespachada", query = "SELECT d FROM DetallePedido d WHERE d.cantidadDespachada = :cantidadDespachada")})
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_DETALLE_PEDIDO")
    private Integer codigoDetallePedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_PRODUCTO")
    private int cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_DESPACHADA")
    private int cantidadDespachada;
    @JoinColumn(name = "CODIGO_FACTURA", referencedColumnName = "CODIGO_FACTURA")
    @ManyToOne(optional = false)
    private Facturas codigoFactura;
    @JoinColumn(name = "CODIGO_PEDIDO", referencedColumnName = "CODIGO_PEDIDO")
    @ManyToOne(optional = false)
    private Pedidos codigoPedido;
    @JoinColumn(name = "CODIGO_PRODUCTO", referencedColumnName = "REFERENCIA_PRODUCTO")
    @ManyToOne(optional = false)
    private Productos codigoProducto;

    public DetallePedido() {
    }

    public DetallePedido(Integer codigoDetallePedido) {
        this.codigoDetallePedido = codigoDetallePedido;
    }

    public DetallePedido(Integer codigoDetallePedido, int cantidadProducto, int cantidadDespachada) {
        this.codigoDetallePedido = codigoDetallePedido;
        this.cantidadProducto = cantidadProducto;
        this.cantidadDespachada = cantidadDespachada;
    }

    public Integer getCodigoDetallePedido() {
        return codigoDetallePedido;
    }

    public void setCodigoDetallePedido(Integer codigoDetallePedido) {
        this.codigoDetallePedido = codigoDetallePedido;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getCantidadDespachada() {
        return cantidadDespachada;
    }

    public void setCantidadDespachada(int cantidadDespachada) {
        this.cantidadDespachada = cantidadDespachada;
    }

    public Facturas getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Facturas codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Pedidos getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Pedidos codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Productos getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Productos codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDetallePedido != null ? codigoDetallePedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedido)) {
            return false;
        }
        DetallePedido other = (DetallePedido) object;
        if ((this.codigoDetallePedido == null && other.codigoDetallePedido != null) || (this.codigoDetallePedido != null && !this.codigoDetallePedido.equals(other.codigoDetallePedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenpath.entidades.DetallePedido[ codigoDetallePedido=" + codigoDetallePedido + " ]";
    }
    
}
