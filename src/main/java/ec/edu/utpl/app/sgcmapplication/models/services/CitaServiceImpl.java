/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.app.sgcmapplication.models.services;

import ec.edu.utpl.app.sgcmapplication.models.dao.ICitaDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.Cita;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    private ICitaDao citaRepo;

    @Override
    @Transactional
    public List<Cita> listAll() {
        return (List<Cita>) citaRepo.findAll();
    }

    @Override
    @Transactional
    public Cita save(Cita cita) {
        return citaRepo.save(cita);
    }

    @Override
    @Transactional
    public Cita findById(int id) {
        return citaRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(int id) {
        citaRepo.deleteById(id);
    }

}
