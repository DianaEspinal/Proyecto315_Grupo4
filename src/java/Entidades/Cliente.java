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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diani
 */
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long clienteId;
    @Basic(optional = false)
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="apellidos")
    private String apellidos;
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="correoElectronico")
    private String correoElectronico;
    
    @NotNull
    @Column(name="identificacion")
    private Integer identificacion;
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="nombres")
    private String nombres;
    
    @NotNull
    @Column(name="numeroTelefonico")
    private Integer numeroTelefonico;

    public Cliente() {
    }

    public Cliente(long clienteId, String apellidos, String correoElectronico, Integer identificacion, String nombres, Integer numeroTelefonico) {
        this.clienteId = clienteId;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.numeroTelefonico = numeroTelefonico;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(Integer numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    
}
