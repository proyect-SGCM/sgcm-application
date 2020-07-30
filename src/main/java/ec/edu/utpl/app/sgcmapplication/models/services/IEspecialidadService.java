package ec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import ec.edu.utpl.app.sgcmapplication.models.entity.Especialidad;

public interface IEspecialidadService {

	public List<Especialidad> listAll();

	public Especialidad save(Especialidad especialidad);

	public Especialidad findById(Long id);

	public void delete(Long id);

}
