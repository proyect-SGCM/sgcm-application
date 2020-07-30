package ec.edu.utpl.app.sgcmapplication.models.services;

import ec.edu.utpl.app.sgcmapplication.models.entity.Usuario;
import java.util.List;

/**
 *
 * @author Axel
 */
public interface IUsuarioService {

    public List<Usuario> getUsuarios();
    public Usuario addUsuario(Usuario rol);
    public Usuario findById(int id);
    public void delete(int id);
}

