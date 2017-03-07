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
@Table(name = "detalle_kit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleKit.findAll", query = "SELECT d FROM DetalleKit d")
    , @NamedQuery(name = "DetalleKit.findByIdDetalleKit", query = "SELECT d FROM DetalleKit d WHERE d.idDetalleKit = :idDetalleKit")
    , @NamedQuery(name = "DetalleKit.findByCantidadProducto", query = "SELECT d FROM DetalleKit d WHERE d.cantidadProducto = :cantidadProducto")
    , @NamedQuery(name = "DetalleKit.findByValorTotal", query = "SELECT d FROM DetalleKit d WHERE d.valorTotal = :valorTotal")})
public class DetalleKit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_KIT")
    private Integer idDetalleKit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_PRODUCTO")
    private int cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_TOTAL")
    private int valorTotal;
    @JoinColumn(name = "REFERENCIA_PRODUCTO", referencedColumnName = "REFERENCIA_PRODUCTO")
    @ManyToOne(optional = false)
    private Productos referenciaProducto;

    public DetalleKit() {
    }

    public DetalleKit(Integer idDetalleKit) {
        this.idDetalleKit = idDetalleKit;
    }

    public DetalleKit(Integer idDetalleKit, int cantidadProducto, int valorTotal) {
        this.idDetalleKit = idDetalleKit;
        this.cantidadProducto = cantidadProducto;
        this.valorTotal = valorTotal;
    }

    public Integer getIdDetalleKit() {
        return idDetalleKit;
    }

    public void setIdDetalleKit(Integer idDetalleKit) {
        this.idDetalleKit = idDetalleKit;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Productos getReferenciaProducto() {
        return referenciaProducto;
    }

    public void setReferenciaProducto(Productos referenciaProducto) {
        this.referenciaProducto = referenciaProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleKit != null ? idDetalleKit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleKit)) {
            return false;
        }
        DetalleKit other = (DetalleKit) object;
        if ((this.idDetalleKit == null && other.idDetalleKit != null) || (this.idDetalleKit != null && !this.idDetalleKit.equals(other.idDetalleKit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenpath.entidades.DetalleKit[ idDetalleKit=" + idDetalleKit + " ]";
    }
    
}
