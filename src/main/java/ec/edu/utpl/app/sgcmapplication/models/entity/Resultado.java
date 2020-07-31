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
	private Long id_resultado;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_examen")
	private Examen id_examen;
	private String resultado;

	public Resultado() {

	}

	public Long getId_resultado() {
		return id_resultado;
	}

	public void setId_resultado(Long id_resultado) {
		this.id_resultado = id_resultado;
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
