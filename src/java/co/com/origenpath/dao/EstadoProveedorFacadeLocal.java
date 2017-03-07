/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.dao;

import co.com.origenpath.entidades.EstadoProveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface EstadoProveedorFacadeLocal {

    void create(EstadoProveedor estadoProveedor);

    void edit(EstadoProveedor estadoProveedor);

    void remove(EstadoProveedor estadoProveedor);

    EstadoProveedor find(Object id);

    List<EstadoProveedor> findAll();

    List<EstadoProveedor> findRange(int[] range);

    int count();
    
}
