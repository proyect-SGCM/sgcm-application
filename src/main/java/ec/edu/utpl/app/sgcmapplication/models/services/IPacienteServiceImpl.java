package ec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.utpl.app.sgcmapplication.models.dao.IPacientesDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.Paciente;

@Service
public class IPacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacientesDao pacienteRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Paciente> listAll() {
		// TODO Auto-generated method stub
		return (List<Paciente>) pacienteRepo.findAll();
	}

	@Override
	@Transactional
	public Paciente save(Paciente paciente) {
		// TODO Auto-generated method stub
		return pacienteRepo.save(paciente);
	}

	@Override
	@Transactional(readOnly = true)
	public Paciente findById(Long id) {
		// TODO Auto-generated method stub
		return pacienteRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pacienteRepo.deleteById(id);
	}

}
