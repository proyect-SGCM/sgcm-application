package ec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.utpl.app.sgcmapplication.models.dao.IMedico_especialidadDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.Medico_especialidad;

@Service
public class Medico_especialidadServiceImpl implements IMedico_especialidadService {

	@Autowired
	private IMedico_especialidadDao medico_especialidadRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Medico_especialidad> listAll() {
		// TODO Auto-generated method stub
		return (List<Medico_especialidad>) medico_especialidadRepo.findAll();
	}

	@Override
	@Transactional
	public Medico_especialidad save(Medico_especialidad medico_especialidad) {
		// TODO Auto-generated method stub
		return medico_especialidadRepo.save(medico_especialidad);
	}

	@Override
	@Transactional(readOnly = true)
	public Medico_especialidad findById(Long id) {
		// TODO Auto-generated method stub
		return medico_especialidadRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		medico_especialidadRepo.deleteById(id);

	}

}
