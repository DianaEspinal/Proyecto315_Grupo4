/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyecto.entidades.Alojamiento;

/**
 *
 * @author diani
 */
@Stateless
public class AlojamientoFacade extends AbstractFacade<Alojamiento> implements AlojamientoFacadeLocal {

    @PersistenceContext(unitName = "PRN315_GRUPO4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlojamientoFacade() {
        super(Alojamiento.class);
    }
    
}
