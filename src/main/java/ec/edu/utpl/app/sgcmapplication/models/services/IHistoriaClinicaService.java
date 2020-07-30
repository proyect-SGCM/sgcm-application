package ec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import ec.edu.utpl.app.sgcmapplication.models.entity.HistoriaClinica;

public interface IHistoriaClinicaService {

	public List<HistoriaClinica> listAll();

	public HistoriaClinica save(HistoriaClinica historiaClinica);

	public HistoriaClinica findById(Long id);

	public void delete(Long id);

}
