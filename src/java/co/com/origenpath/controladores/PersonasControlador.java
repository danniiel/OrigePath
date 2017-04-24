/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.controladores;

import co.com.origenpath.dao.BarriosFacadeLocal;
import co.com.origenpath.dao.EstadoCivilFacadeLocal;
import co.com.origenpath.dao.EstadoPersonasFacadeLocal;
import co.com.origenpath.dao.GeneroFacadeLocal;
import co.com.origenpath.dao.PersonasFacadeLocal;
import co.com.origenpath.dao.RolFacadeLocal;
import co.com.origenpath.entidades.Barrios;
import co.com.origenpath.entidades.EstadoCivil;
import co.com.origenpath.entidades.EstadoPersonas;
import co.com.origenpath.entidades.Genero;
import co.com.origenpath.entidades.Personas;
import co.com.origenpath.entidades.Rol;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author daniel
 */
@ManagedBean
@ViewScoped
public class PersonasControlador implements Serializable {

    @EJB
    PersonasFacadeLocal personasFacadeLocal;
    @EJB
    BarriosFacadeLocal barriosFacadeLocal;
    @EJB
    GeneroFacadeLocal generoFacadeLocal;
    @EJB
    EstadoCivilFacadeLocal estadoCivilFacadeLocal;
    @EJB
    EstadoPersonasFacadeLocal estadoPersonasFacadeLoacal;
    @EJB
    RolFacadeLocal rolFacadeLocal;

    private Personas personas;
    private List<Personas> listPersonas;
    private List<Barrios> barrios;
    private List<Genero> generos;
    private List<EstadoCivil> estadoCiviles;
    private List<EstadoPersonas> estadoPersonas;
    private List<Rol> roles;
    private String accion;

    @PostConstruct
    public void init() {
        personas = new Personas();
        barrios = listarBarrios();
        generos = listarGeneros();
        estadoCiviles = listarEstadoCivil();
        estadoPersonas = listarEstadoPersonas();
        roles = listarRoles();
        listPersonas = listarPersonas();
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public List<Barrios> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<Barrios> barrios) {
        this.barrios = barrios;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    
    
    public void operar(){
        switch (accion) {
            case "Guardar":
                this.guardarPersonas();
                break;
            case "Actualizar":
                this.modificarPersona();
                break;
        }
    }

    public List<EstadoCivil> getEstadoCiviles() {
        return estadoCiviles;
    }

    public void setEstadoCiviles(List<EstadoCivil> estadoCiviles) {
        this.estadoCiviles = estadoCiviles;
    }

    public List<EstadoPersonas> getEstadoPersonas() {
        return estadoPersonas;
    }

    public void setEstadoPersonas(List<EstadoPersonas> estadoPersonas) {
        this.estadoPersonas = estadoPersonas;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Personas> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Personas> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public void guardarPersonas() {
        personasFacadeLocal.create(personas);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Guardado Con Exito!"));
        listPersonas = listarPersonas();
    }
    

    public void buscarPersona(String id) {
        Personas per = personasFacadeLocal.find(id);
        personas.setCedula(per.getCedula());
        personas.setNombres(per.getNombres());
        personas.setPrimerApellido(per.getPrimerApellido());
        personas.setSegundoApellido(per.getSegundoApellido());
        personas.setFechaNacimiento(per.getFechaNacimiento());
        personas.setGenero(per.getGenero());
        personas.setEstadoCivil(per.getEstadoCivil());
        personas.setEstadoPersona(per.getEstadoPersona());
        personas.setOcupacion(per.getOcupacion());
        personas.setReferido(per.getReferido());
        personas.setTelefono(per.getTelefono());
        personas.setCelular(per.getCelular());
        personas.setCorreo(per.getCorreo());
        personas.setBarrio(per.getBarrio());
        personas.setDireccion(per.getDireccion());
        personas.setUsuario(per.getUsuario());
        personas.setContrasena(per.getContrasena());
        personas.setRol(per.getRol());
        personas.setNivelEducacion(per.getNivelEducacion());
    }

    public void modificarPersona() {
        
        personasFacadeLocal.edit(personas);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Modificado con Exito!"));
    }

    public void eliminarPersona(String id) {
        Personas p = personasFacadeLocal.find(id);
        personasFacadeLocal.remove(p);
        listPersonas = listarPersonas();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro eliminado con Exito!"));
    }

    public List<Personas> listarPersonas() {
        return personasFacadeLocal.findAll();
    }

    private List<Barrios> listarBarrios() {
        return barriosFacadeLocal.findAll();
    }

    private List<Genero> listarGeneros() {
        return generoFacadeLocal.findAll();
    }

    private List<EstadoCivil> listarEstadoCivil() {
        return estadoCivilFacadeLocal.findAll();
    }

    private List<EstadoPersonas> listarEstadoPersonas() {
        return estadoPersonasFacadeLoacal.findAll();
    }

    private List<Rol> listarRoles() {
        return rolFacadeLocal.findAll();
    }

    public String onFlowProcess(FlowEvent event) {
        
        return event.getNewStep();
        
    }

    /**
     * Creates a new instance of PersonasControlador
     */
    public PersonasControlador() {

    }

}
