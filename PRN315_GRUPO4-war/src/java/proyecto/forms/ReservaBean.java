/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.forms;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import proyecto.entidades.Reserva;

@Stateless
public class ReservaBean {

    @PersistenceContext
    private EntityManager entityManager;

    public void crearReserva(Reserva reserva) {
        entityManager.persist(reserva);
    }

    public Reserva obtenerReservaPorId(Long reservaId) {
        return entityManager.find(Reserva.class, reservaId);
    }

    public List<Reserva> obtenerReservas() {
        TypedQuery<Reserva> query = entityManager.createQuery("SELECT r FROM Reserva r", Reserva.class);
        return query.getResultList();
    }

    public void actualizarReserva(Reserva reserva) {
        entityManager.merge(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reserva = entityManager.find(Reserva.class, reserva.getReservaId());
        entityManager.remove(reserva);
    }

}
