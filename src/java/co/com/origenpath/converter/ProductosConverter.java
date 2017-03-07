/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.converter;

import co.com.origenpath.dao.ProductosFacadeLocal;
import co.com.origenpath.entidades.Productos;
import javax.ejb.EJB;
import javax.faces.FacesException;
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
public class ProductosConverter implements Converter{

    /**
     * Creates a new instance of ProductosConverter
     */
    public ProductosConverter() {
    }
    @EJB
    ProductosFacadeLocal productosFacadeLocal;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()){
            return null;
        }
        try{
            return productosFacadeLocal.find(value);
        }catch(NumberFormatException e){
            throw new ConverterException(new FacesMessage(String.format("%s no es un valor valido", value)),e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }else{
            if(value instanceof Productos){
                return String.valueOf(((Productos)value).getReferenciaProducto());
            }else{
                throw new ConverterException(new FacesMessage(String.format("%s no es un producto valido", value)));
            }
        }
    }    
}
