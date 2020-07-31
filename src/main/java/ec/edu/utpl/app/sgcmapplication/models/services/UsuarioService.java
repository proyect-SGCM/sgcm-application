package ec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.utpl.app.sgcmapplication.models.dao.IUsuarioDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.Usuario;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private IUsuarioDao usuarioRepo;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepo.findByUsername(username);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario No encontrado");
		}

		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);
	}

	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return usuarioRepo.findByUsername(username);
	}

}
