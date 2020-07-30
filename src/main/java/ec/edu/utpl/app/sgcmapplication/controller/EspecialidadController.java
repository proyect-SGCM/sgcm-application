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

import ec.edu.utpl.app.sgcmapplication.models.entity.Especialidad;
import ec.edu.utpl.app.sgcmapplication.models.services.IEspecialidadService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/gst_especialidad")
public class EspecialidadController {

	@Autowired
	private IEspecialidadService especialidadService;

	/* -------------- Crear Especialidad -------------- */

	@PostMapping("/crear_especialidad")
	@ResponseStatus(HttpStatus.CREATED)
	public Especialidad crearEspecialidad(@RequestBody Especialidad especialidad) {

		return especialidadService.save(especialidad);
	}

	/* -------------- Listar Especialidades -------------- */

	@GetMapping("/listar_especialidades")
	public List<Especialidad> listarEspecialidad() {

		return especialidadService.listAll();
	}

	/* -------------- Ver Especialidad -------------- */

	@GetMapping("/especialidad/{id}")
	public ResponseEntity<?> verEspecialidad(@PathVariable Long id) {

		Especialidad especialidad = null;
		Map<String, Object> response = new HashMap<>();

		try {
			especialidad = especialidadService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje",
					"La Especialidad con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (especialidad == null) {
			response.put("mensaje",
					"La Especialidad con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Especialidad>(especialidad, HttpStatus.OK);
	}

	/* -------------- Editar Especialidad -------------- */

	@PutMapping("/especialidad/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Especialidad editarEspecialidad(@RequestBody Especialidad especialidad, @PathVariable Long id) {

		Especialidad especialidadActual = especialidadService.findById(id);

		especialidadActual.setCodigo(especialidad.getCodigo());
		especialidadActual.setNombre(especialidad.getNombre());

		return especialidadService.save(especialidadActual);
	}

	/* -------------- Eliminar Especialidad -------------- */

	@DeleteMapping("/especialidad/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarEspecialidad(@PathVariable Long id) {

		especialidadService.delete(id);
	}

}
