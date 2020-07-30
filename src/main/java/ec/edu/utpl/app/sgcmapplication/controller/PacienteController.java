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

import ec.edu.utpl.app.sgcmapplication.models.entity.Paciente;
import ec.edu.utpl.app.sgcmapplicationec.edu.utpl.app.sgcmapplication.models.services.IPacienteService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/gst_paciente")
public class PacienteController {

	@Autowired
	private IPacienteService pacienteService;

	/* -------------- Crear Paciente -------------- */

	@PostMapping("/crear_paciente")
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente crearPaciente(@RequestBody Paciente paciente) {

		return pacienteService.save(paciente);
	}

	/* -------------- Listar Paciente -------------- */

	@GetMapping("/listar_paciente")
	public List<Paciente> listarPaciente() {

		return pacienteService.listAll();
	}

	/* -------------- Ver Paciente -------------- */

	@GetMapping("/paciente/{id}")
	public ResponseEntity<?> verPaciente(@PathVariable Long id) {

		Paciente paciente = null;
		Map<String, Object> response = new HashMap<>();

		try {
			paciente = pacienteService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje",
					"El Paciente con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (paciente == null) {
			response.put("mensaje",
					"El Paciente con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
	}

	/* -------------- Editar Paciente -------------- */

	@PutMapping("/paciente/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente editarExamen(@RequestBody Paciente paciente, @PathVariable Long id) {

		Paciente pacienteActual = pacienteService.findById(id);

		pacienteActual.setNombre(paciente.getNombre());
		pacienteActual.setApellido(paciente.getApellido());
		pacienteActual.setFecha_nacimiento(paciente.getFecha_nacimiento());
		pacienteActual.setSexo(paciente.getSexo());
		pacienteActual.setEstado_civil(paciente.getEstado_civil());
		pacienteActual.setOcupacion(paciente.getOcupacion());
		pacienteActual.setDireccion(paciente.getDireccion());
		pacienteActual.setTelefono(paciente.getTelefono());
		pacienteActual.setTipo_sangre(paciente.getTipo_sangre());
		pacienteActual.setUsername(paciente.getUsername());
		pacienteActual.setPassword(paciente.getPassword());
		pacienteActual.setId_rol(paciente.getId_rol());

		return pacienteService.save(pacienteActual);
	}

	/* -------------- Eliminar Paciente -------------- */

	@DeleteMapping("/paciente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarPaciente(@PathVariable Long id) {

		pacienteService.delete(id);
	}

}
