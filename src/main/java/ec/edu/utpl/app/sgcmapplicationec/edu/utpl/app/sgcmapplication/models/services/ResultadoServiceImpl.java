package ec.edu.utpl.app.sgcmapplicationec.edu.utpl.app.sgcmapplication.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.utpl.app.sgcmapplication.models.dao.IResultadoDao;
import ec.edu.utpl.app.sgcmapplication.models.entity.Resultado;

@Service
public class ResultadoServiceImpl implements IResultadoService {

	@Autowired
	private IResultadoDao resultadorepo;

	@Override
	@Transactional(readOnly = true)
	public List<Resultado> listAll() {
		// TODO Auto-generated method stub
		return (List<Resultado>) resultadorepo.findAll();
	}

	@Override
	@Transactional
	public Resultado save(Resultado resultado) {
		// TODO Auto-generated method stub
		return resultadorepo.save(resultado);
	}

	@Override
	@Transactional(readOnly = true)
	public Resultado findById(Long id) {
		// TODO Auto-generated method stub
		return resultadorepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		resultadorepo.deleteById(id);
	}

}
