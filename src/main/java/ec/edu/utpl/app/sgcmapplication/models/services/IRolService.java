/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.app.sgcmapplication.models.services;

import ec.edu.utpl.app.sgcmapplication.models.entity.Rol;
import java.util.List;


public interface IRolService {
    public List<Rol> getRoles();
    public Rol addRol(Rol rol);
    public Rol findById(int id);
    public void delete (int id);
}
