package ec.edu.utpl.app.sgcmapplicationec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import ec.edu.utpl.app.sgcmapplication.models.entity.Examen;

public interface IExamenService {

	public List<Examen> listAll();

	public Examen save(Examen examen);

	public Examen findById(Long id);

	public void delete(Long id);

}
