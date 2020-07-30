package ec.edu.utpl.app.sgcmapplication.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medico_especialidad")
public class Medico_especialidad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idmedico_especialidad;

	@ManyToOne
	@JoinColumn(name = "id_medico")
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "id_especialidad")
	private Especialidad especialidad;

	public Medico_especialidad() {

	}

	public long getIdmedico_especialidad() {
		return idmedico_especialidad;
	}

	public void setIdmedico_especialidad(long idmedico_especialidad) {
		this.idmedico_especialidad = idmedico_especialidad;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	private static final long serialVersionUID = 1L;

}
