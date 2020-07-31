/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.app.sgcmapplication.models.services;

import ec.edu.utpl.app.sgcmapplication.models.dao.IRolDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRolServiceImpl implements IRolService {

    @Autowired
    private IRolDao irol;

    @Override
    public List<Rol> getRoles() {
        return (List<Rol>) irol.findAll();
    }

    @Override
    public Rol addRol(Rol rol) {
        return irol.save(rol);
    }

    @Override
    public Rol findById(int id) {
        return irol.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        irol.deleteById(id);
    }

}
