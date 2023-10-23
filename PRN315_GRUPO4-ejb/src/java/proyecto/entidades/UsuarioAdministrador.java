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
import javax.persistence.CascadeType;
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
@Table(name = "UsuarioAdministrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioAdministrador.findAll", query = "SELECT u FROM UsuarioAdministrador u")
    , @NamedQuery(name = "UsuarioAdministrador.findByUsuarioId", query = "SELECT u FROM UsuarioAdministrador u WHERE u.usuarioId = :usuarioId")
    , @NamedQuery(name = "UsuarioAdministrador.findByUsuario", query = "SELECT u FROM UsuarioAdministrador u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "UsuarioAdministrador.findByContrasenia", query = "SELECT u FROM UsuarioAdministrador u WHERE u.contrasenia = :contrasenia")})
public class UsuarioAdministrador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id")
    private BigDecimal usuarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrasenia")
    private String contrasenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private List<Reserva> reservaList;

    public UsuarioAdministrador() {
    }

    public UsuarioAdministrador(BigDecimal usuarioId) {
        this.usuarioId = usuarioId;
    }

    public UsuarioAdministrador(BigDecimal usuarioId, String usuario, String contrasenia) {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public BigDecimal getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(BigDecimal usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioAdministrador)) {
            return false;
        }
        UsuarioAdministrador other = (UsuarioAdministrador) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.UsuarioAdministrador[ usuarioId=" + usuarioId + " ]";
    }
    
}
