package ec.edu.utpl.app.sgcmapplicationec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.utpl.app.sgcmapplication.models.dao.IHistoriaClinicaDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.HistoriaClinica;

@Service
public class HistoriaClinicaServiceImpl implements IHistoriaClinicaService {

	@Autowired
	private IHistoriaClinicaDao historiaClinicaRepo;

	@Override
	@Transactional(readOnly = true)
	public List<HistoriaClinica> listAll() {
		// TODO Auto-generated method stub
		return (List<HistoriaClinica>) historiaClinicaRepo.findAll();
	}

	@Override
	@Transactional
	public HistoriaClinica save(HistoriaClinica historiaClinica) {
		// TODO Auto-generated method stub
		return historiaClinicaRepo.save(historiaClinica);
	}

	@Override
	@Transactional(readOnly = true)
	public HistoriaClinica findById(Long id) {
		// TODO Auto-generated method stub
		return historiaClinicaRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		historiaClinicaRepo.deleteById(id);
	}

}
