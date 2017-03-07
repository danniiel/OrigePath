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

/**
 *
 * @author danie
 */
@Embeddable
public class PermisosRolPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_MENU")
    private int codigoMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ROL")
    private int codigoRol;

    public PermisosRolPK() {
    }

    public PermisosRolPK(int codigoMenu, int codigoRol) {
        this.codigoMenu = codigoMenu;
        this.codigoRol = codigoRol;
    }

    public int getCodigoMenu() {
        return codigoMenu;
    }

    public void setCodigoMenu(int codigoMenu) {
        this.codigoMenu = codigoMenu;
    }

    public int getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoMenu;
        hash += (int) codigoRol;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisosRolPK)) {
            return false;
        }
        PermisosRolPK other = (PermisosRolPK) object;
        if (this.codigoMenu != other.codigoMenu) {
            return false;
        }
        if (this.codigoRol != other.codigoRol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenpath.entidades.PermisosRolPK[ codigoMenu=" + codigoMenu + ", codigoRol=" + codigoRol + " ]";
    }
    
}
