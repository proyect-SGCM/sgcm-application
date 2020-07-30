package ec.edu.utpl.app.sgcmapplicationec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.utpl.app.sgcmapplication.models.dao.IRecetaDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.Receta;

@Service
public class RecetaServiceImpl implements IRecetaService {

	@Autowired
	private IRecetaDao recetaRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Receta> listAll() {
		// TODO Auto-generated method stub
		return (List<Receta>) recetaRepo.findAll();
	}

	@Override
	@Transactional
	public Receta save(Receta receta) {
		// TODO Auto-generated method stub
		return recetaRepo.save(receta);
	}

	@Override
	@Transactional(readOnly = true)
	public Receta findById(Long id) {
		// TODO Auto-generated method stub
		return recetaRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		recetaRepo.deleteById(id);
	}

}
