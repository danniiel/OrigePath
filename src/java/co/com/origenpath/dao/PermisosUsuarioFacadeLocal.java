/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.dao;

import co.com.origenpath.entidades.PermisosUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface PermisosUsuarioFacadeLocal {

    void create(PermisosUsuario permisosUsuario);

    void edit(PermisosUsuario permisosUsuario);

    void remove(PermisosUsuario permisosUsuario);

    PermisosUsuario find(Object id);

    List<PermisosUsuario> findAll();

    List<PermisosUsuario> findRange(int[] range);

    int count();
    
}
