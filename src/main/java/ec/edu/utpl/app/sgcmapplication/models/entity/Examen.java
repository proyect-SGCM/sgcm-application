package ec.edu.utpl.app.sgcmapplication.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "examenes")
public class Examen implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_examen;
	private Paciente id_paciente;
	private String codigo_examen;
	private String nombre;
	private String tipo;
	private String fecha;

	public Examen() {

	}

	public long getId_examen() {
		return id_examen;
	}

	public void setId_examen(long id_examen) {
		this.id_examen = id_examen;
	}

	public Paciente getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Paciente id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getCodigo_examen() {
		return codigo_examen;
	}

	public void setCodigo_examen(String codigo_examen) {
		this.codigo_examen = codigo_examen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	private static final long serialVersionUID = 1L;

}
