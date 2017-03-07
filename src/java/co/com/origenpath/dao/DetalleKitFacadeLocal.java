/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.dao;

import co.com.origenpath.entidades.DetalleKit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface DetalleKitFacadeLocal {

    void create(DetalleKit detalleKit);

    void edit(DetalleKit detalleKit);

    void remove(DetalleKit detalleKit);

    DetalleKit find(Object id);

    List<DetalleKit> findAll();

    List<DetalleKit> findRange(int[] range);

    int count();
    
}
