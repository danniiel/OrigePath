/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.dao;

import co.com.origenpath.entidades.Barrios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface BarriosFacadeLocal {

    void create(Barrios barrios);

    void edit(Barrios barrios);

    void remove(Barrios barrios);

    Barrios find(Object id);

    List<Barrios> findAll();

    List<Barrios> findRange(int[] range);

    int count();
    
}
