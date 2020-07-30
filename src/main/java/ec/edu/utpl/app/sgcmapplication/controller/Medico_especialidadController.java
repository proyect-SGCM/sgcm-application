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

import ec.edu.utpl.app.sgcmapplication.models.entity.Medico_especialidad;
import ec.edu.utpl.app.sgcmapplicationec.edu.utpl.app.sgcmapplication.models.services.IMedico_especialidadService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/gst_medico_especialidad")
public class Medico_especialidadController {

	@Autowired
	private IMedico_especialidadService medico_especialidadService;

	/* -------------- Crear Medico - Especialidad -------------- */

	@PostMapping("/crear_medico_especialidad")
	@ResponseStatus(HttpStatus.CREATED)
	public Medico_especialidad crearMedicoEspecialidad(@RequestBody Medico_especialidad medico_especialidad) {

		return medico_especialidadService.save(medico_especialidad);
	}

	/* -------------- Listar Medico - Especialidad -------------- */

	@GetMapping("/listar_medico_especialidad")
	public List<Medico_especialidad> listarMedicoEspecialidad() {

		return medico_especialidadService.listAll();
	}

	/* -------------- Ver Medico - Especialidad -------------- */

	@GetMapping("/medico_especialidad/{id}")
	public ResponseEntity<?> verMedicoEspecialidad(@PathVariable Long id) {

		Medico_especialidad medico_especialidad = null;
		Map<String, Object> response = new HashMap<>();

		try {
			medico_especialidad = medico_especialidadService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "La vinculación Medico-Especialidad con el ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (medico_especialidad == null) {
			response.put("mensaje", "La vinculación Medico-Especialidad con el ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Medico_especialidad>(medico_especialidad, HttpStatus.OK);
	}

	/* -------------- Editar Medico - Especialidad -------------- */

	@PutMapping("/medico_especialidad/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Medico_especialidad editarMedicoEspecialidad(@RequestBody Medico_especialidad medico_especialidad,
			@PathVariable Long id) {

		Medico_especialidad medico_especialidadActual = medico_especialidadService.findById(id);

		medico_especialidadActual.setMedico(medico_especialidad.getMedico());
		medico_especialidadActual.setEspecialidad(medico_especialidad.getEspecialidad());

		return medico_especialidadService.save(medico_especialidadActual);
	}

	/* -------------- Eliminar Medico - Especialidad -------------- */

	@DeleteMapping("/medico_especialidad/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarMedicoEspecialidad(@PathVariable Long id) {

		medico_especialidadService.delete(id);
	}

}
