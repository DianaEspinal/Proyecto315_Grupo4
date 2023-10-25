/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.forms;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import proyecto.ejb.ReservaFacadeLocal;
import proyecto.entidades.Reserva;

/**
 *
 * @author diani
 */
@Named(value = "reservaForm")
@SessionScoped
public class ReservaForm implements Serializable {
 @EJB
    private ReservaBean reservaBean;

    private Reserva reserva;
    private List<Reserva> reservas;

    @PostConstruct
    public void init() {
        reserva = new Reserva();
        obtenerReservas(); // Cargar la lista de reservas al iniciar la página
    }

    public void crearReserva() {
        reservaBean.crearReserva(reserva);
        reserva = new Reserva(); // Limpiar el formulario después de crear
        obtenerReservas(); // Actualizar la lista de reservas
    }

    public void obtenerReservas() {
        reservas = reservaBean.obtenerReservas();
    }

    public void actualizarReserva(Reserva reserva) {
        reservaBean.actualizarReserva(reserva);
        obtenerReservas(); // Actualizar la lista de reservas después de la actualización
    }

    public void eliminarReserva(Reserva reserva) {
        reservaBean.eliminarReserva(reserva);
        obtenerReservas(); // Actualizar la lista de reservas después de la eliminación
    }

    // Getters y Setters
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
    
    public ReservaForm() {
    }
    
}

