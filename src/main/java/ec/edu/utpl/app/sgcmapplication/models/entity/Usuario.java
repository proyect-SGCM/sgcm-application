package ec.edu.utpl.app.sgcmapplication.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuarios;
	private String username;
	private String password;

	/*
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "id_rol") private Rol id_rol;
	 */

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "id_usuarios"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private List<Rol> roles;

	public Usuario() {
	}

	public int getId_usuarios() {
		return id_usuarios;
	}

	public void setId_usuarios(int id_usuarios) {
		this.id_usuarios = id_usuarios;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public Rol getId_rol() { return id_rol; }
	 * 
	 * public void setId_rol(Rol id_rol) { this.id_rol = id_rol; }
	 */

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	private static final long serialVersionUID = 1L;
}
