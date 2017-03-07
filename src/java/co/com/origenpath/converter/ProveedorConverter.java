/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.converter;

import co.com.origenpath.dao.ProveedorFacadeLocal;
import co.com.origenpath.entidades.Proveedor;
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
public class ProveedorConverter implements Converter{

    /**
     * Creates a new instance of ProveedorConverter
     */
    public ProveedorConverter() {
    }
    
    @EJB
    ProveedorFacadeLocal proveedorFacadeLocal;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()){
            return null;
        }
        try{
            return proveedorFacadeLocal.find(Integer.valueOf(value));
        }catch(NumberFormatException e){
            throw new ConverterException(new FacesMessage(String.format("%s no es un valor valido", value)),e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        if(value instanceof Proveedor){
            return String.valueOf(((Proveedor)value).getCodigoProveedor());
        }else{
            throw new ConverterException(new FacesMessage(String.format("%s no es un proveedor valido", value)));
        }
    }
    
}
