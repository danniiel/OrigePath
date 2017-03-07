/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.dao;

import co.com.origenpath.entidades.PermisosRol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface PermisosRolFacadeLocal {

    void create(PermisosRol permisosRol);

    void edit(PermisosRol permisosRol);

    void remove(PermisosRol permisosRol);

    PermisosRol find(Object id);

    List<PermisosRol> findAll();

    List<PermisosRol> findRange(int[] range);

    int count();
    
}
