package ec.edu.utpl.app.sgcmapplicationec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import ec.edu.utpl.app.sgcmapplication.models.entity.Medico;

public interface IMedicoService {

	public List<Medico> listAll();

	public Medico save(Medico medico);

	public Medico findById(Long id);

	public void delete(Long id);
}
