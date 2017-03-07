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
@Table(name = "permisos_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisosUsuario.findAll", query = "SELECT p FROM PermisosUsuario p")
    , @NamedQuery(name = "PermisosUsuario.findByCodigoMenu", query = "SELECT p FROM PermisosUsuario p WHERE p.permisosUsuarioPK.codigoMenu = :codigoMenu")
    , @NamedQuery(name = "PermisosUsuario.findByCodigoUsuario", query = "SELECT p FROM PermisosUsuario p WHERE p.permisosUsuarioPK.codigoUsuario = :codigoUsuario")
    , @NamedQuery(name = "PermisosUsuario.findByInsertar", query = "SELECT p FROM PermisosUsuario p WHERE p.insertar = :insertar")
    , @NamedQuery(name = "PermisosUsuario.findByBuscar", query = "SELECT p FROM PermisosUsuario p WHERE p.buscar = :buscar")
    , @NamedQuery(name = "PermisosUsuario.findByActualizar", query = "SELECT p FROM PermisosUsuario p WHERE p.actualizar = :actualizar")
    , @NamedQuery(name = "PermisosUsuario.findByEliminar", query = "SELECT p FROM PermisosUsuario p WHERE p.eliminar = :eliminar")})
public class PermisosUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermisosUsuarioPK permisosUsuarioPK;
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
    @JoinColumn(name = "CODIGO_USUARIO", referencedColumnName = "CEDULA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personas personas;

    public PermisosUsuario() {
    }

    public PermisosUsuario(PermisosUsuarioPK permisosUsuarioPK) {
        this.permisosUsuarioPK = permisosUsuarioPK;
    }

    public PermisosUsuario(int codigoMenu, String codigoUsuario) {
        this.permisosUsuarioPK = new PermisosUsuarioPK(codigoMenu, codigoUsuario);
    }

    public PermisosUsuarioPK getPermisosUsuarioPK() {
        return permisosUsuarioPK;
    }

    public void setPermisosUsuarioPK(PermisosUsuarioPK permisosUsuarioPK) {
        this.permisosUsuarioPK = permisosUsuarioPK;
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

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisosUsuarioPK != null ? permisosUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisosUsuario)) {
            return false;
        }
        PermisosUsuario other = (PermisosUsuario) object;
        if ((this.permisosUsuarioPK == null && other.permisosUsuarioPK != null) || (this.permisosUsuarioPK != null && !this.permisosUsuarioPK.equals(other.permisosUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenpath.entidades.PermisosUsuario[ permisosUsuarioPK=" + permisosUsuarioPK + " ]";
    }
    
}
