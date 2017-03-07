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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "estado_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoProveedor.findAll", query = "SELECT e FROM EstadoProveedor e")
    , @NamedQuery(name = "EstadoProveedor.findByIdEstadoProveedor", query = "SELECT e FROM EstadoProveedor e WHERE e.idEstadoProveedor = :idEstadoProveedor")
    , @NamedQuery(name = "EstadoProveedor.findByNombreEstadoProveedor", query = "SELECT e FROM EstadoProveedor e WHERE e.nombreEstadoProveedor = :nombreEstadoProveedor")})
public class EstadoProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_PROVEEDOR")
    private Integer idEstadoProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NOMBRE_ESTADO_PROVEEDOR")
    private String nombreEstadoProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoProveedor")
    private List<Proveedor> proveedorList;

    public EstadoProveedor() {
    }

    public EstadoProveedor(Integer idEstadoProveedor) {
        this.idEstadoProveedor = idEstadoProveedor;
    }

    public EstadoProveedor(Integer idEstadoProveedor, String nombreEstadoProveedor) {
        this.idEstadoProveedor = idEstadoProveedor;
        this.nombreEstadoProveedor = nombreEstadoProveedor;
    }

    public Integer getIdEstadoProveedor() {
        return idEstadoProveedor;
    }

    public void setIdEstadoProveedor(Integer idEstadoProveedor) {
        this.idEstadoProveedor = idEstadoProveedor;
    }

    public String getNombreEstadoProveedor() {
        return nombreEstadoProveedor;
    }

    public void setNombreEstadoProveedor(String nombreEstadoProveedor) {
        this.nombreEstadoProveedor = nombreEstadoProveedor;
    }

    @XmlTransient
    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoProveedor != null ? idEstadoProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoProveedor)) {
            return false;
        }
        EstadoProveedor other = (EstadoProveedor) object;
        if ((this.idEstadoProveedor == null && other.idEstadoProveedor != null) || (this.idEstadoProveedor != null && !this.idEstadoProveedor.equals(other.idEstadoProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenpath.entidades.EstadoProveedor[ idEstadoProveedor=" + idEstadoProveedor + " ]";
    }
    
}
