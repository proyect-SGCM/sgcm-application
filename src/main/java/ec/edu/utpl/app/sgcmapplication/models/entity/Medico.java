package ec.edu.utpl.app.sgcmapplication.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicos")
public class Medico implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_medico;
	private String nombre;
	private String apellido;
	private String username;
	private String password;
	private int nro_consultorio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rol")
	private Rol id_rol;

	public Medico() {

	}

	public Long getId_medico() {
		return id_medico;
	}

	public void setId_medico(Long id_medico) {
		this.id_medico = id_medico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public int getNro_consultorio() {
		return nro_consultorio;
	}

	public void setNro_consultorio(int nro_consultorio) {
		this.nro_consultorio = nro_consultorio;
	}

	public Rol getId_rol() {
		return id_rol;
	}

	public void setId_rol(Rol id_rol) {
		this.id_rol = id_rol;
	}

	private static final long serialVersionUID = 1L;

}
