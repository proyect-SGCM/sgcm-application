/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.app.sgcmapplication.models.services;

import ec.edu.utpl.app.sgcmapplication.models.entity.Cita;
import java.util.List;

/**
 *
 * @author Axel
 */
public interface ICitaService {

    public List<Cita> listAll();

    public Cita save(Cita cita);

    public Cita findById(int id);

    public void delete(int id);
}
