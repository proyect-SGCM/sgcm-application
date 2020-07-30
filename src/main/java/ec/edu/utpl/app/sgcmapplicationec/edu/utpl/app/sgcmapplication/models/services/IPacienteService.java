package ec.edu.utpl.app.sgcmapplicationec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import ec.edu.utpl.app.sgcmapplication.models.entity.Paciente;

public interface IPacienteService {

	public List<Paciente> listAll();

	public Paciente save(Paciente paciente);

	public Paciente findById(Long id);

	public void delete(Long id);

}
