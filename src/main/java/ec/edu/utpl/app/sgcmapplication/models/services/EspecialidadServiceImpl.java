package ec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.utpl.app.sgcmapplication.models.dao.IEspecialidadDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.Especialidad;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	@Autowired
	private IEspecialidadDao especialidadRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Especialidad> listAll() {
		// TODO Auto-generated method stub
		return (List<Especialidad>) especialidadRepo.findAll();
	}

	@Override
	@Transactional
	public Especialidad save(Especialidad especialidad) {
		// TODO Auto-generated method stub
		return especialidadRepo.save(especialidad);
	}

	@Override
	@Transactional(readOnly = true)
	public Especialidad findById(Long id) {
		// TODO Auto-generated method stub
		return especialidadRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		especialidadRepo.deleteById(id);
	}

}
