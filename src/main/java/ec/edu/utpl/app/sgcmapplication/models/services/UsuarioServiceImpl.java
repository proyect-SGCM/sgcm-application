/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.app.sgcmapplication.models.services;

import ec.edu.utpl.app.sgcmapplication.models.dao.IUsuarioDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Axel
 */
public class UsuarioServiceImpl  implements IUsuarioService{
    @Autowired
    private IUsuarioDao userDao;

    @Override
    public List<Usuario> getUsuarios() {
        return (List<Usuario>) userDao.findAll();
    }

    @Override
    public Usuario addUsuario(Usuario usuario) {
        return userDao.save(usuario);
    }

    @Override
    public Usuario findById(int id) {
         return userDao.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }
    
   
}
