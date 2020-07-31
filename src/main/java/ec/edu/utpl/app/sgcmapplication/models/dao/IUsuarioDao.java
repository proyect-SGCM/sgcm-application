
package ec.edu.utpl.app.sgcmapplication.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.utpl.app.sgcmapplication.models.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);

}