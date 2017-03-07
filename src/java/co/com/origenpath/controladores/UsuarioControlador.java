/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.PersonasFacadeLocal;
import co.com.origenpath.entidades.Personas;
import co.com.origenpath.utils.jsfUtils;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author daniel
 */
@ManagedBean
@ViewScoped
public class UsuarioControlador implements Serializable{

   @EJB
   private PersonasFacadeLocal personasFacadeLocal;
   
   private Personas persona;
   
   @PostConstruct
   public void init(){
       persona = new Personas();
   }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }
    
//    public String iniciarSesion(){
//        Personas u;
//        String redireccion = null;
//        try{
//            u = personasFacadeLocal.iniciarSesion(persona);
//            if(u != null){
//                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
//                redireccion = "/administracion/inicio?faces-redirect=true";
//            }else{
//               jsfUtils.addErrorMessage("Usuario o Contraseña Incorrectos"); 
//            }            
//        }catch(Exception e){
//            jsfUtils.addErrorMessage("Error al iniciar la sesión");
//        }
//        return redireccion;
//    }
}
