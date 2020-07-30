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

import ec.edu.utpl.app.sgcmapplication.models.entity.Receta;
import ec.edu.utpl.app.sgcmapplication.models.services.IRecetaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/gst_receta")
public class RecetaController {

	@Autowired
	private IRecetaService recetaService;

	/* -------------- Crear Receta -------------- */

	@PostMapping("/crear_receta")
	@ResponseStatus(HttpStatus.CREATED)
	public Receta crearReceta(@RequestBody Receta receta) {

		return recetaService.save(receta);
	}

	/* -------------- Listar Receta -------------- */

	@GetMapping("/listar_receta")
	public List<Receta> listarReceta() {

		return recetaService.listAll();
	}

	/* -------------- Ver Paciente -------------- */

	@GetMapping("/receta/{id}")
	public ResponseEntity<?> verReceta(@PathVariable Long id) {

		Receta receta = null;
		Map<String, Object> response = new HashMap<>();

		try {
			receta = recetaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje",
					"La Receta con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (receta == null) {
			response.put("mensaje",
					"La Receta con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Receta>(receta, HttpStatus.OK);
	}

	/* -------------- Editar Receta -------------- */

	@PutMapping("/receta/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Receta editarReceta(@RequestBody Receta receta, @PathVariable Long id) {

		Receta recetaActual = recetaService.findById(id);

		recetaActual.setId_paciente(receta.getId_paciente());
		recetaActual.setDescripcion(receta.getDescripcion());
		recetaActual.setFecha(receta.getFecha());

		return recetaService.save(recetaActual);
	}

	/* -------------- Eliminar Receta -------------- */

	@DeleteMapping("/receta/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarReceta(@PathVariable Long id) {

		recetaService.delete(id);
	}

}
