/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findByCodigoPedido", query = "SELECT p FROM Pedidos p WHERE p.codigoPedido = :codigoPedido")
    , @NamedQuery(name = "Pedidos.findByFechaPedido", query = "SELECT p FROM Pedidos p WHERE p.fechaPedido = :fechaPedido")
    , @NamedQuery(name = "Pedidos.findByValorTotalPedido", query = "SELECT p FROM Pedidos p WHERE p.valorTotalPedido = :valorTotalPedido")})
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CODIGO_PEDIDO")
    private String codigoPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_PEDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_TOTAL_PEDIDO")
    private int valorTotalPedido;
    @JoinColumn(name = "ESTADO_PEDIDO", referencedColumnName = "ID_ESTADO_PEDIDO")
    @ManyToOne(optional = false)
    private EstadoPedido estadoPedido;
    @JoinColumn(name = "VENDEDOR_PEDIDO", referencedColumnName = "CEDULA")
    @ManyToOne(optional = false)
    private Personas vendedorPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPedido")
    private List<DetallePedido> detallePedidoList;

    public Pedidos() {
    }

    public Pedidos(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Pedidos(String codigoPedido, Date fechaPedido, int valorTotalPedido) {
        this.codigoPedido = codigoPedido;
        this.fechaPedido = fechaPedido;
        this.valorTotalPedido = valorTotalPedido;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(int valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Personas getVendedorPedido() {
        return vendedorPedido;
    }

    public void setVendedorPedido(Personas vendedorPedido) {
        this.vendedorPedido = vendedorPedido;
    }

    @XmlTransient
    public List<DetallePedido> getDetallePedidoList() {
        return detallePedidoList;
    }

    public void setDetallePedidoList(List<DetallePedido> detallePedidoList) {
        this.detallePedidoList = detallePedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPedido != null ? codigoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.codigoPedido == null && other.codigoPedido != null) || (this.codigoPedido != null && !this.codigoPedido.equals(other.codigoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenpath.entidades.Pedidos[ codigoPedido=" + codigoPedido + " ]";
    }
    
}
