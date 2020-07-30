package ec.edu.utpl.app.sgcmapplicationec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.utpl.app.sgcmapplication.models.dao.IMedicoDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.Medico;

@Service
public class MedicoServiceImpl implements IMedicoService {

	@Autowired
	private IMedicoDao medicoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Medico> listAll() {
		// TODO Auto-generated method stub
		return (List<Medico>) medicoDao.findAll();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		medicoDao.deleteById(id);

	}

	@Override
	@Transactional
	public Medico save(Medico medico) {
		// TODO Auto-generated method stub
		return medicoDao.save(medico);
	}

	@Override
	@Transactional(readOnly = true)
	public Medico findById(Long id) {
		// TODO Auto-generated method stub
		return medicoDao.findById(id).orElse(null);
	}

}
