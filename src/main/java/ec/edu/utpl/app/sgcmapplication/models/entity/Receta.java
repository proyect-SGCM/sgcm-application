package ec.edu.utpl.app.sgcmapplication.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recetas")
public class Receta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_receta;
	private String descripcion;
	private Date fecha;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_paciente")
	private Paciente id_pacientes;

	public Receta() {

	}

	public Long getId_receta() {
		return id_receta;
	}

	public void setId_receta(Long id_receta) {
		this.id_receta = id_receta;
	}

	public Paciente getId_pacientes() {
		return id_pacientes;
	}

	public void setId_pacientes(Paciente id_pacientes) {
		this.id_pacientes = id_pacientes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	private static final long serialVersionUID = 1L;

}
