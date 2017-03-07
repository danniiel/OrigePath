/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author danie
 */
@Embeddable
public class PermisosUsuarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_MENU")
    private int codigoMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CODIGO_USUARIO")
    private String codigoUsuario;

    public PermisosUsuarioPK() {
    }

    public PermisosUsuarioPK(int codigoMenu, String codigoUsuario) {
        this.codigoMenu = codigoMenu;
        this.codigoUsuario = codigoUsuario;
    }

    public int getCodigoMenu() {
        return codigoMenu;
    }

    public void setCodigoMenu(int codigoMenu) {
        this.codigoMenu = codigoMenu;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoMenu;
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisosUsuarioPK)) {
            return false;
        }
        PermisosUsuarioPK other = (PermisosUsuarioPK) object;
        if (this.codigoMenu != other.codigoMenu) {
            return false;
        }
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenpath.entidades.PermisosUsuarioPK[ codigoMenu=" + codigoMenu + ", codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
