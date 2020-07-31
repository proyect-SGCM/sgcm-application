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
@Table(name = "resultados")
public class Resultado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roles_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_examen")
	private Examen id_examen;
	private String resultado;

	public Resultado() {

	}

	public Long getRoles_id() {
		return roles_id;
	}

	public void setRoles_id(Long roles_id) {
		this.roles_id = roles_id;
	}

	public Examen getId_examen() {
		return id_examen;
	}

	public void setId_examen(Examen id_examen) {
		this.id_examen = id_examen;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	private static final long serialVersionUID = 1L;

}
