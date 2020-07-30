package ec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import ec.edu.utpl.app.sgcmapplication.models.entity.Medico_especialidad;

public interface IMedico_especialidadService {

	public List<Medico_especialidad> listAll();

	public Medico_especialidad save(Medico_especialidad medico_especialidad);

	public Medico_especialidad findById(Long id);

	public void delete(Long id);

}
