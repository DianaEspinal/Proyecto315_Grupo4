/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ejb;

import java.util.List;
import javax.ejb.Local;
import proyecto.entidades.ActividadTuristica;

/**
 *
 * @author diani
 */
@Local
public interface ActividadTuristicaFacadeLocal {

    void create(ActividadTuristica actividadTuristica);

    void edit(ActividadTuristica actividadTuristica);

    void remove(ActividadTuristica actividadTuristica);

    ActividadTuristica find(Object id);

    List<ActividadTuristica> findAll();

    List<ActividadTuristica> findRange(int[] range);

    int count();
    
}
