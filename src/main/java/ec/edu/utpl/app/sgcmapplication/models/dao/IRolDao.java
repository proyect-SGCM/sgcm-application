/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.app.sgcmapplication.models.dao;

import ec.edu.utpl.app.sgcmapplication.models.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRolDao extends JpaRepository<Rol, Integer> {
    
}
