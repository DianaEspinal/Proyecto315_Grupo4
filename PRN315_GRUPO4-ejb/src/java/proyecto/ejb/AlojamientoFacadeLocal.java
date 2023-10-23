/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ejb;

import java.util.List;
import javax.ejb.Local;
import proyecto.entidades.Alojamiento;

/**
 *
 * @author diani
 */
@Local
public interface AlojamientoFacadeLocal {

    void create(Alojamiento alojamiento);

    void edit(Alojamiento alojamiento);

    void remove(Alojamiento alojamiento);

    Alojamiento find(Object id);

    List<Alojamiento> findAll();

    List<Alojamiento> findRange(int[] range);

    int count();
    
}
