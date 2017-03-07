/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByReferenciaProducto", query = "SELECT p FROM Productos p WHERE p.referenciaProducto = :referenciaProducto")
    , @NamedQuery(name = "Productos.findByNombreProducto", query = "SELECT p FROM Productos p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Productos.findByCantidadProducto", query = "SELECT p FROM Productos p WHERE p.cantidadProducto = :cantidadProducto")
    , @NamedQuery(name = "Productos.findByPrecioVenta", query = "SELECT p FROM Productos p WHERE p.precioVenta = :precioVenta")
    , @NamedQuery(name = "Productos.findByPrecioCompra", query = "SELECT p FROM Productos p WHERE p.precioCompra = :precioCompra")
    , @NamedQuery(name = "Productos.findByGramos", query = "SELECT p FROM Productos p WHERE p.gramos = :gramos")
    , @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "REFERENCIA_PRODUCTO")
    private String referenciaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "IMAGEN_PRODUCTO")
    private byte[] imagenProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_PRODUCTO")
    private int cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_VENTA")
    private int precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_COMPRA")
    private int precioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRAMOS")
    private int gramos;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenciaProducto")
    private List<DetalleKit> detalleKitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProducto")
    private List<DetallePedido> detallePedidoList;
    @JoinColumn(name = "PROVEEDOR", referencedColumnName = "CODIGO_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor proveedor;
    @JoinColumn(name = "ESTADO_PRODUCTO", referencedColumnName = "ID_ESTADO_PRODUCTO")
    @ManyToOne(optional = false)
    private EstadoProducto estadoProducto;
    @JoinColumn(name = "TIPO_PRODUCTO", referencedColumnName = "ID_TIPO_PRODUCTO")
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;

    public Productos() {
    }

    public Productos(String referenciaProducto) {
        this.referenciaProducto = referenciaProducto;
    }

    public Productos(String referenciaProducto, String nombreProducto, byte[] imagenProducto, int cantidadProducto, int precioVenta, int precioCompra, int gramos) {
        this.referenciaProducto = referenciaProducto;
        this.nombreProducto = nombreProducto;
        this.imagenProducto = imagenProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.gramos = gramos;
    }

    public String getReferenciaProducto() {
        return referenciaProducto;
    }

    public void setReferenciaProducto(String referenciaProducto) {
        this.referenciaProducto = referenciaProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public byte[] getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(byte[] imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<DetalleKit> getDetalleKitList() {
        return detalleKitList;
    }

    public void setDetalleKitList(List<DetalleKit> detalleKitList) {
        this.detalleKitList = detalleKitList;
    }

    @XmlTransient
    public List<DetallePedido> getDetallePedidoList() {
        return detallePedidoList;
    }

    public void setDetallePedidoList(List<DetallePedido> detallePedidoList) {
        this.detallePedidoList = detallePedidoList;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referenciaProducto != null ? referenciaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.referenciaProducto == null && other.referenciaProducto != null) || (this.referenciaProducto != null && !this.referenciaProducto.equals(other.referenciaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenpath.entidades.Productos[ referenciaProducto=" + referenciaProducto + " ]";
    }
    
}
