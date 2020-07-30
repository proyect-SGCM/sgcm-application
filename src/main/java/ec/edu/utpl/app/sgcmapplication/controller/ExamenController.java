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

import ec.edu.utpl.app.sgcmapplication.models.entity.Examen;
import ec.edu.utpl.app.sgcmapplication.models.services.IExamenService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/gst_examenes")
public class ExamenController {

	@Autowired
	private IExamenService examenService;

	/* -------------- Crear Exámen -------------- */

	@PostMapping("/crear_examen")
	@ResponseStatus(HttpStatus.CREATED)
	public Examen crearExamen(@RequestBody Examen examen) {

		return examenService.save(examen);
	}

	/* -------------- Listar Exámen -------------- */

	@GetMapping("/listar_examen")
	public List<Examen> listarExamen() {

		return examenService.listAll();
	}

	/* -------------- Ver Exámen -------------- */

	@GetMapping("/examen/{id}")
	public ResponseEntity<?> verExamen(@PathVariable Long id) {

		Examen examen = null;
		Map<String, Object> response = new HashMap<>();

		try {
			examen = examenService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje",
					"El Examen con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (examen == null) {
			response.put("mensaje",
					"El Examen con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Examen>(examen, HttpStatus.OK);
	}

	/* -------------- Editar Exámen -------------- */

	@PutMapping("/examen/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Examen editarExamen(@RequestBody Examen examen, @PathVariable Long id) {

		Examen examenActual = examenService.findById(id);

		examenActual.setId_paciente(examen.getId_paciente());
		examenActual.setCodigo_examen(examen.getCodigo_examen());
		examenActual.setNombre(examen.getNombre());
		examenActual.setTipo(examen.getTipo());
		examenActual.setFecha(examen.getFecha());

		return examenService.save(examenActual);
	}

	/* -------------- Eliminar Exámen -------------- */

	@DeleteMapping("/examen/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarExamen(@PathVariable Long id) {

		examenService.delete(id);
	}
}
