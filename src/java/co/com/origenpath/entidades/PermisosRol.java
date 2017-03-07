/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "permisos_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisosRol.findAll", query = "SELECT p FROM PermisosRol p")
    , @NamedQuery(name = "PermisosRol.findByCodigoMenu", query = "SELECT p FROM PermisosRol p WHERE p.permisosRolPK.codigoMenu = :codigoMenu")
    , @NamedQuery(name = "PermisosRol.findByCodigoRol", query = "SELECT p FROM PermisosRol p WHERE p.permisosRolPK.codigoRol = :codigoRol")
    , @NamedQuery(name = "PermisosRol.findByInsertar", query = "SELECT p FROM PermisosRol p WHERE p.insertar = :insertar")
    , @NamedQuery(name = "PermisosRol.findByBuscar", query = "SELECT p FROM PermisosRol p WHERE p.buscar = :buscar")
    , @NamedQuery(name = "PermisosRol.findByActualizar", query = "SELECT p FROM PermisosRol p WHERE p.actualizar = :actualizar")
    , @NamedQuery(name = "PermisosRol.findByEliminar", query = "SELECT p FROM PermisosRol p WHERE p.eliminar = :eliminar")})
public class PermisosRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermisosRolPK permisosRolPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "INSERTAR")
    private Float insertar;
    @Column(name = "BUSCAR")
    private Float buscar;
    @Column(name = "ACTUALIZAR")
    private Float actualizar;
    @Column(name = "ELIMINAR")
    private Float eliminar;
    @JoinColumn(name = "CODIGO_MENU", referencedColumnName = "CODIGO_MENU", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;
    @JoinColumn(name = "CODIGO_ROL", referencedColumnName = "ID_ROL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol;

    public PermisosRol() {
    }

    public PermisosRol(PermisosRolPK permisosRolPK) {
        this.permisosRolPK = permisosRolPK;
    }

    public PermisosRol(int codigoMenu, int codigoRol) {
        this.permisosRolPK = new PermisosRolPK(codigoMenu, codigoRol);
    }

    public PermisosRolPK getPermisosRolPK() {
        return permisosRolPK;
    }

    public void setPermisosRolPK(PermisosRolPK permisosRolPK) {
        this.permisosRolPK = permisosRolPK;
    }

    public Float getInsertar() {
        return insertar;
    }

    public void setInsertar(Float insertar) {
        this.insertar = insertar;
    }

    public Float getBuscar() {
        return buscar;
    }

    public void setBuscar(Float buscar) {
        this.buscar = buscar;
    }

    public Float getActualizar() {
        return actualizar;
    }

    public void setActualizar(Float actualizar) {
        this.actualizar = actualizar;
    }

    public Float getEliminar() {
        return eliminar;
    }

    public void setEliminar(Float eliminar) {
        this.eliminar = eliminar;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisosRolPK != null ? permisosRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisosRol)) {
            return false;
        }
        PermisosRol other = (PermisosRol) object;
        if ((this.permisosRolPK == null && other.permisosRolPK != null) || (this.permisosRolPK != null && !this.permisosRolPK.equals(other.permisosRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenpath.entidades.PermisosRol[ permisosRolPK=" + permisosRolPK + " ]";
    }
    
}
