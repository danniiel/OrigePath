/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.dao;

import co.com.origenpath.entidades.DetallePedido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface DetallePedidoFacadeLocal {

    void create(DetallePedido detallePedido);

    void edit(DetallePedido detallePedido);

    void remove(DetallePedido detallePedido);

    DetallePedido find(Object id);

    List<DetallePedido> findAll();

    List<DetallePedido> findRange(int[] range);

    int count();
    
}
