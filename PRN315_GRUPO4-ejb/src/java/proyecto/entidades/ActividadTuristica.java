/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author diani
 */
@Entity
@Table(name = "ActividadTuristica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadTuristica.findAll", query = "SELECT a FROM ActividadTuristica a")
    , @NamedQuery(name = "ActividadTuristica.findByActividadTuristicaid", query = "SELECT a FROM ActividadTuristica a WHERE a.actividadTuristicaid = :actividadTuristicaid")
    , @NamedQuery(name = "ActividadTuristica.findByNombreActividad", query = "SELECT a FROM ActividadTuristica a WHERE a.nombreActividad = :nombreActividad")
    , @NamedQuery(name = "ActividadTuristica.findByDescripcion", query = "SELECT a FROM ActividadTuristica a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "ActividadTuristica.findByPrecio", query = "SELECT a FROM ActividadTuristica a WHERE a.precio = :precio")})
public class ActividadTuristica implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "actividadTuristica_id")
    private BigDecimal actividadTuristicaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreActividad")
    private String nombreActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @OneToMany(mappedBy = "actividadTuristicaid", fetch = FetchType.LAZY)
    private List<Reserva> reservaList;

    public ActividadTuristica() {
    }

    public ActividadTuristica(BigDecimal actividadTuristicaid) {
        this.actividadTuristicaid = actividadTuristicaid;
    }

    public ActividadTuristica(BigDecimal actividadTuristicaid, String nombreActividad, String descripcion, BigDecimal precio) {
        this.actividadTuristicaid = actividadTuristicaid;
        this.nombreActividad = nombreActividad;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public BigDecimal getActividadTuristicaid() {
        return actividadTuristicaid;
    }

    public void setActividadTuristicaid(BigDecimal actividadTuristicaid) {
        this.actividadTuristicaid = actividadTuristicaid;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actividadTuristicaid != null ? actividadTuristicaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadTuristica)) {
            return false;
        }
        ActividadTuristica other = (ActividadTuristica) object;
        if ((this.actividadTuristicaid == null && other.actividadTuristicaid != null) || (this.actividadTuristicaid != null && !this.actividadTuristicaid.equals(other.actividadTuristicaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.ActividadTuristica[ actividadTuristicaid=" + actividadTuristicaid + " ]";
    }
    
}
