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
@Table(name = "historiaclinica")
public class HistoriaClinica implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_historia_clinica;
	private String codigo_historiaClinica;
	private String motivo_consulta;
	private String enfermedad_actual;
	private double estatura;
	private double peso;
	private String presion;
	private Date fecha;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pacientes")
	private Paciente id_paciente;

	public HistoriaClinica() {

	}

	public Long getId_historia_clinica() {
		return id_historia_clinica;
	}

	public void setId_historia_clinica(Long id_historia_clinica) {
		this.id_historia_clinica = id_historia_clinica;
	}

	public String getCodigo_historiaClinica() {
		return codigo_historiaClinica;
	}

	public void setCodigo_historiaClinica(String codigo_historiaClinica) {
		this.codigo_historiaClinica = codigo_historiaClinica;
	}

	public String getMotivo_consulta() {
		return motivo_consulta;
	}

	public void setMotivo_consulta(String motivo_consulta) {
		this.motivo_consulta = motivo_consulta;
	}

	public String getEnfermedad_actual() {
		return enfermedad_actual;
	}

	public void setEnfermedad_actual(String enfermedad_actual) {
		this.enfermedad_actual = enfermedad_actual;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getPresion() {
		return presion;
	}

	public void setPresion(String presion) {
		this.presion = presion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Paciente getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Paciente id_paciente) {
		this.id_paciente = id_paciente;
	}

	private static final long serialVersionUID = 1L;

}
