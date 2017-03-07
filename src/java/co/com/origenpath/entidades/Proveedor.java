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
import javax.persistence.JoinColumn;
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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByCodigoProveedor", query = "SELECT p FROM Proveedor p WHERE p.codigoProveedor = :codigoProveedor")
    , @NamedQuery(name = "Proveedor.findByNitProveedor", query = "SELECT p FROM Proveedor p WHERE p.nitProveedor = :nitProveedor")
    , @NamedQuery(name = "Proveedor.findByNombreEmpresa", query = "SELECT p FROM Proveedor p WHERE p.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "Proveedor.findByTelefono", query = "SELECT p FROM Proveedor p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Proveedor.findByExt", query = "SELECT p FROM Proveedor p WHERE p.ext = :ext")
    , @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT p FROM Proveedor p WHERE p.direccion = :direccion")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_PROVEEDOR")
    private Integer codigoProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "NIT_PROVEEDOR")
    private String nitProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "NOMBRE_EMPRESA")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "EXT")
    private String ext;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @JoinColumn(name = "ESTADO_PROVEEDOR", referencedColumnName = "ID_ESTADO_PROVEEDOR")
    @ManyToOne(optional = false)
    private EstadoProveedor estadoProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private List<Productos> productosList;

    public Proveedor() {
    }

    public Proveedor(Integer codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public Proveedor(Integer codigoProveedor, String nitProveedor, String nombreEmpresa, String telefono, String ext, String direccion) {
        this.codigoProveedor = codigoProveedor;
        this.nitProveedor = nitProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.ext = ext;
        this.direccion = direccion;
    }

    public Integer getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Integer codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public EstadoProveedor getEstadoProveedor() {
        return estadoProveedor;
    }

    public void setEstadoProveedor(EstadoProveedor estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProveedor != null ? codigoProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.codigoProveedor == null && other.codigoProveedor != null) || (this.codigoProveedor != null && !this.codigoProveedor.equals(other.codigoProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenpath.entidades.Proveedor[ codigoProveedor=" + codigoProveedor + " ]";
    }
    
}
