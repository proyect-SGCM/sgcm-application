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
	private int cedula;
	private String nombre;
	private String apellido;
	private int nro_consultorio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuarios")
	private Usuario id_usuario;

	public Medico() {

	}

	public Long getId_medico() {
		return id_medico;
	}

	public void setId_medico(Long id_medico) {
		this.id_medico = id_medico;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
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

	public int getNro_consultorio() {
		return nro_consultorio;
	}

	public void setNro_consultorio(int nro_consultorio) {
		this.nro_consultorio = nro_consultorio;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	private static final long serialVersionUID = 1L;

}
