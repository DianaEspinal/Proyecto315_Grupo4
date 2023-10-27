/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
@Table(name = "Alojamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alojamiento.findAll", query = "SELECT a FROM Alojamiento a")
    , @NamedQuery(name = "Alojamiento.findByAlojamientoId", query = "SELECT a FROM Alojamiento a WHERE a.alojamientoId = :alojamientoId")
    , @NamedQuery(name = "Alojamiento.findByNombreHotel", query = "SELECT a FROM Alojamiento a WHERE a.nombreHotel = :nombreHotel")
    , @NamedQuery(name = "Alojamiento.findByHabitacionesRequeridas", query = "SELECT a FROM Alojamiento a WHERE a.habitacionesRequeridas = :habitacionesRequeridas")
    , @NamedQuery(name = "Alojamiento.findByPrecioHabitacion", query = "SELECT a FROM Alojamiento a WHERE a.precioHabitacion = :precioHabitacion")
    , @NamedQuery(name = "Alojamiento.findByTipoHabitacion", query = "SELECT a FROM Alojamiento a WHERE a.tipoHabitacion = :tipoHabitacion")})
public class Alojamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "alojamiento_id")
    private BigDecimal alojamientoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreHotel")
    private String nombreHotel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habitacionesRequeridas")
    private int habitacionesRequeridas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioHabitacion")
    private BigDecimal precioHabitacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipoHabitacion")
    private String tipoHabitacion;
    @OneToMany(mappedBy = "alojamientoId", fetch = FetchType.LAZY)
    private List<Reserva> reservaList;

    public Alojamiento() {
    }

    public Alojamiento(BigDecimal alojamientoId) {
        this.alojamientoId = alojamientoId;
    }

    public Alojamiento(BigDecimal alojamientoId, String nombreHotel, int habitacionesRequeridas, BigDecimal precioHabitacion, String tipoHabitacion) {
        this.alojamientoId = alojamientoId;
        this.nombreHotel = nombreHotel;
        this.habitacionesRequeridas = habitacionesRequeridas;
        this.precioHabitacion = precioHabitacion;
        this.tipoHabitacion = tipoHabitacion;
    }

    public BigDecimal getAlojamientoId() {
        return alojamientoId;
    }

    public void setAlojamientoId(BigDecimal alojamientoId) {
        this.alojamientoId = alojamientoId;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public int getHabitacionesRequeridas() {
        return habitacionesRequeridas;
    }

    public void setHabitacionesRequeridas(int habitacionesRequeridas) {
        this.habitacionesRequeridas = habitacionesRequeridas;
    }

    public BigDecimal getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(BigDecimal precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
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
        hash += (alojamientoId != null ? alojamientoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alojamiento)) {
            return false;
        }
        Alojamiento other = (Alojamiento) object;
        if ((this.alojamientoId == null && other.alojamientoId != null) || (this.alojamientoId != null && !this.alojamientoId.equals(other.alojamientoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Alojamiento[ alojamientoId=" + alojamientoId + " ]";
    }
    
}
