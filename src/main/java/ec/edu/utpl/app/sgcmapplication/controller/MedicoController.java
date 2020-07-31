package ec.edu.utpl.app.sgcmapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.utpl.app.sgcmapplication.models.entity.Medico;
import ec.edu.utpl.app.sgcmapplication.models.services.IMedicoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/gst_medico")
public class MedicoController {

	@Autowired
	private IMedicoService medicoService;

	/* -------------- Crear Médico -------------- */

	@PostMapping("/crear_medico")
	@ResponseStatus(HttpStatus.CREATED)
	public Medico crearMedico(@RequestBody Medico medico) {

		return medicoService.save(medico);
	}

	/* -------------- Listar Médico -------------- */

	@GetMapping("/listar_medico")
	public List<Medico> listarMedico() {

		return medicoService.listAll();
	}

	/* -------------- Ver Medico -------------- */

	@GetMapping("/medico/{id}")
	public ResponseEntity<?> verMedico(@PathVariable Long id) {

		Medico medico = null;
		Map<String, Object> response = new HashMap<>();

		try {
			medico = medicoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje",
					"El Médico con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (medico == null) {
			response.put("mensaje",
					"El Médico con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Medico>(medico, HttpStatus.OK);
	}

	/* -------------- Editar Médico -------------- */

	@PutMapping("/medico/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Medico editarMedico(@RequestBody Medico medico, @PathVariable Long id) {

		Medico medicoActual = medicoService.findById(id);

		medicoActual.setCedula(medico.getCedula());
		medicoActual.setNombre(medico.getNombre());
		medicoActual.setApellido(medico.getApellido());
		medicoActual.setNro_consultorio(medico.getNro_consultorio());
		medicoActual.setId_usuario(medico.getId_usuario());

		return medicoService.save(medicoActual);
	}

	/* -------------- Eliminar Médico -------------- */

	@DeleteMapping("/medico/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarMedico(@PathVariable Long id) {

		medicoService.delete(id);
	}

}
