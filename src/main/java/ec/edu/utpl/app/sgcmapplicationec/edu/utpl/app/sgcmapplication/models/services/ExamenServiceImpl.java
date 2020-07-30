package ec.edu.utpl.app.sgcmapplicationec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.utpl.app.sgcmapplication.models.dao.IExamenDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.Examen;

@Service
public class ExamenServiceImpl implements IExamenService {

	@Autowired
	private IExamenDao examenDao;

	@Override
	@Transactional(readOnly = true)
	public List<Examen> listAll() {
		// TODO Auto-generated method stub
		return (List<Examen>) examenDao.findAll();
	}

	@Override
	@Transactional
	public Examen save(Examen examen) {
		// TODO Auto-generated method stub
		return examenDao.save(examen);
	}

	@Override
	@Transactional(readOnly = true)
	public Examen findById(Long id) {
		// TODO Auto-generated method stub
		return examenDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		examenDao.deleteById(id);
	}

}
