package ec.edu.utpl.app.sgcmapplication.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_rol;
	private String nombre;
	private String descripcion;

	/*
	 * @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER, cascade =
	 * CascadeType.ALL) private List<Usuario> usuarios;
	 */

	public Rol() {
		// Medicos = new ArrayList<Medico>();
	}

	public Long getId_rol() {
		return id_rol;
	}

	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/*
	 * public List<Medico> getMedicos() { return Medicos; }
	 * 
	 * public void setMedicos(List<Medico> medicos) { Medicos = medicos; }
	 */

	/*
	 * public List<Usuario> getUsuarios() { return usuarios; }
	 * 
	 * public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }
	 */

	private static final long serialVersionUID = 1L;
}
