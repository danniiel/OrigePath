/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.converter;

import co.com.origenpath.dao.EstadoProductoFacadeLocal;
import co.com.origenpath.entidades.EstadoProducto;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author daniel
 */
@ManagedBean
@RequestScoped
public class EstadoProductoConverter implements Converter{

    /**
     * Creates a new instance of EstadoProductoControler
     */
    public EstadoProductoConverter() {
    }
    
    @EJB
    EstadoProductoFacadeLocal estadoProductosFacadeLocal;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()){
            return null;
        }
        try{
            return estadoProductosFacadeLocal.find(Integer.valueOf(value));
        }catch(NumberFormatException e){
           throw new ConverterException(new FacesMessage(String.format("%S no es un valor valido", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value== null){
            return "";
        }
        if(value instanceof EstadoProducto){
            return String.valueOf(((EstadoProducto)value).getIdEstadoProducto());
        }else{
            throw new ConverterException(new FacesMessage(String.format("$ no es un estado de producto valido", value)));
        }
    }
    
}
