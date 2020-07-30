package ec.edu.utpl.app.sgcmapplication.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.utpl.app.sgcmapplication.models.entity.Medico;

public interface IMedicoDao extends JpaRepository<Medico, Long> {

}
