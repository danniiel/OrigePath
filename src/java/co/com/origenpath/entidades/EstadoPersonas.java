/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "estado_personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPersonas.findAll", query = "SELECT e FROM EstadoPersonas e")
    , @NamedQuery(name = "EstadoPersonas.findByIdEstadoPersonas", query = "SELECT e FROM EstadoPersonas e WHERE e.idEstadoPersonas = :idEstadoPersonas")
    , @NamedQuery(name = "EstadoPersonas.findByNombreEstadoPersonas", query = "SELECT e FROM EstadoPersonas e WHERE e.nombreEstadoPersonas = :nombreEstadoPersonas")})
public class EstadoPersonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_PERSONAS")
    private Integer idEstadoPersonas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_ESTADO_PERSONAS")
    private String nombreEstadoPersonas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoPersona")
    private List<Personas> personasList;

    public EstadoPersonas() {
    }

    public EstadoPersonas(Integer idEstadoPersonas) {
        this.idEstadoPersonas = idEstadoPersonas;
    }

    public EstadoPersonas(Integer idEstadoPersonas, String nombreEstadoPersonas) {
        this.idEstadoPersonas = idEstadoPersonas;
        this.nombreEstadoPersonas = nombreEstadoPersonas;
    }

    public Integer getIdEstadoPersonas() {
        return idEstadoPersonas;
    }

    public void setIdEstadoPersonas(Integer idEstadoPersonas) {
        this.idEstadoPersonas = idEstadoPersonas;
    }

    public String getNombreEstadoPersonas() {
        return nombreEstadoPersonas;
    }

    public void setNombreEstadoPersonas(String nombreEstadoPersonas) {
        this.nombreEstadoPersonas = nombreEstadoPersonas;
    }

    @XmlTransient
    public List<Personas> getPersonasList() {
        return personasList;
    }

    public void setPersonasList(List<Personas> personasList) {
        this.personasList = personasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPersonas != null ? idEstadoPersonas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPersonas)) {
            return false;
        }
        EstadoPersonas other = (EstadoPersonas) object;
        if ((this.idEstadoPersonas == null && other.idEstadoPersonas != null) || (this.idEstadoPersonas != null && !this.idEstadoPersonas.equals(other.idEstadoPersonas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenpath.entidades.EstadoPersonas[ idEstadoPersonas=" + idEstadoPersonas + " ]";
    }
    
}
