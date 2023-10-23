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
@Table(name = "DestinoTuristico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DestinoTuristico.findAll", query = "SELECT d FROM DestinoTuristico d")
    , @NamedQuery(name = "DestinoTuristico.findByDestinoTuristicoid", query = "SELECT d FROM DestinoTuristico d WHERE d.destinoTuristicoid = :destinoTuristicoid")
    , @NamedQuery(name = "DestinoTuristico.findByNombre", query = "SELECT d FROM DestinoTuristico d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DestinoTuristico.findByDescripcion", query = "SELECT d FROM DestinoTuristico d WHERE d.descripcion = :descripcion")})
public class DestinoTuristico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "destinoTuristico_id")
    private BigDecimal destinoTuristicoid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "destinoTuristicoid", fetch = FetchType.LAZY)
    private List<Reserva> reservaList;

    public DestinoTuristico() {
    }

    public DestinoTuristico(BigDecimal destinoTuristicoid) {
        this.destinoTuristicoid = destinoTuristicoid;
    }

    public DestinoTuristico(BigDecimal destinoTuristicoid, String nombre, String descripcion) {
        this.destinoTuristicoid = destinoTuristicoid;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public BigDecimal getDestinoTuristicoid() {
        return destinoTuristicoid;
    }

    public void setDestinoTuristicoid(BigDecimal destinoTuristicoid) {
        this.destinoTuristicoid = destinoTuristicoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (destinoTuristicoid != null ? destinoTuristicoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DestinoTuristico)) {
            return false;
        }
        DestinoTuristico other = (DestinoTuristico) object;
        if ((this.destinoTuristicoid == null && other.destinoTuristicoid != null) || (this.destinoTuristicoid != null && !this.destinoTuristicoid.equals(other.destinoTuristicoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.DestinoTuristico[ destinoTuristicoid=" + destinoTuristicoid + " ]";
    }
    
}
