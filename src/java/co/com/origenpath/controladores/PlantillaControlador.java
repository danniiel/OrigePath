/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.entidades.Personas;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author daniel
 */
@ManagedBean
@ViewScoped
public class PlantillaControlador implements Serializable{

    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Personas p = (Personas) context.getExternalContext().getSessionMap().get("usuario");
            if (p == null) {
                context.getExternalContext().redirect("./../index.xhtml");
            }
        } catch (Exception e) {
            
        }
    }

}
