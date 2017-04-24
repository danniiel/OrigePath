/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.PersonasFacadeLocal;
import co.com.origenpath.entidades.PermisosRol;
import co.com.origenpath.entidades.Personas;
import co.com.origenpath.utils.jsfUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danie
 */
@Named(value = "sessionControlador")
@ManagedBean
@RequestScoped
public class SessionControlador implements Serializable{

    @EJB
   private PersonasFacadeLocal personasFacadeLocal;
   
   private Personas persona;
   List<String>menu;
    
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
   
   public String sesion(){
        Personas u;
//        PermisosRol p;
        String redireccion = null;
        try{
              u = personasFacadeLocal.iniciarSesion(persona);
              u.getRol().getIdRol();
            if(u != null){
                HttpSession  session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                menu = (List<String>) persona;
                session.setAttribute("usuario", u);
//                session.setAttribute("permiso", p);
                redireccion = "/administracion/inicio?faces-redirect=true";
            }else{
               jsfUtils.addErrorMessage("Usuario o Contraseña Incorrectos"); 
            }            
        }catch(Exception e){
            jsfUtils.addErrorMessage("Error al iniciar la sesión");
        }
        return redireccion;
    }
   
   
    /**
     * Creates a new instance of SessionControlador
     */
    public SessionControlador() {
    }
    
}
