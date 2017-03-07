/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.converter;

import co.com.origenpath.dao.TipoProductoFacadeLocal;
import co.com.origenpath.entidades.TipoProducto;
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
public class TipoProductoConverter implements Converter{

    /**
     * Creates a new instance of TipoProductoConverter
     */
    public TipoProductoConverter() {
    }
    
    @EJB
    TipoProductoFacadeLocal tipoProductoFacadeLocal;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()){
            return null;
        }
        try{
        return tipoProductoFacadeLocal.find(Integer.valueOf(value));
        }catch(NumberFormatException e){
            throw new ConverterException(new FacesMessage(String.format("%s no es un valor valido", value)),e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        if(value instanceof TipoProducto){
            return String.valueOf(((TipoProducto)value).getIdTipoProducto());
        }else{
            throw new ConverterException(new FacesMessage(String.format("%s no es un tipo de producto valido", value)));
        }
    }
    
}
