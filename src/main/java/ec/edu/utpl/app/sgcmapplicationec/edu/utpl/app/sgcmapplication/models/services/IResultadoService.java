package ec.edu.utpl.app.sgcmapplicationec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import ec.edu.utpl.app.sgcmapplication.models.entity.Resultado;

public interface IResultadoService {

	public List<Resultado> listAll();

	public Resultado save(Resultado resultado);

	public Resultado findById(Long id);

	public void delete(Long id);

}
