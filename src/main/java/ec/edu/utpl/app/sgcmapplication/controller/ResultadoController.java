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

import ec.edu.utpl.app.sgcmapplication.models.entity.Resultado;
import ec.edu.utpl.app.sgcmapplication.models.services.IResultadoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/gst_resultado")
public class ResultadoController {

	@Autowired
	private IResultadoService resultadoService;

	/* -------------- Crear Resultado -------------- */

	@PostMapping("/crear_resultado")
	@ResponseStatus(HttpStatus.CREATED)
	public Resultado crearResultado(@RequestBody Resultado resultado) {

		return resultadoService.save(resultado);
	}

	/* -------------- Listar Exámen -------------- */

	@GetMapping("/listar_resultado")
	public List<Resultado> listarResultado() {

		return resultadoService.listAll();
	}

	/* -------------- Ver Resultado -------------- */

	@GetMapping("/eresultado/{id}")
	public ResponseEntity<?> verResultado(@PathVariable Long id) {

		Resultado resultado = null;
		Map<String, Object> response = new HashMap<>();

		try {
			resultado = resultadoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje",
					"El Resultado con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (resultado == null) {
			response.put("mensaje",
					"El Resultado con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Resultado>(resultado, HttpStatus.OK);
	}

	/* -------------- Editar Resultado -------------- */

	@PutMapping("/resultado/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Resultado editarExamen(@RequestBody Resultado resultado, @PathVariable Long id) {

		Resultado resultadoActual = resultadoService.findById(id);

		resultadoActual.setId_examen(resultado.getId_examen());
		resultadoActual.setResultado(resultado.getResultado());

		return resultadoService.save(resultadoActual);
	}

	/* -------------- Eliminar Resultado -------------- */

	@DeleteMapping("/resultado/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarResultado(@PathVariable Long id) {

		resultadoService.delete(id);
	}

}
