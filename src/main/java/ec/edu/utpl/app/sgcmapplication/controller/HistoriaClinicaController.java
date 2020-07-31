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

import ec.edu.utpl.app.sgcmapplication.models.entity.HistoriaClinica;
import ec.edu.utpl.app.sgcmapplication.models.services.IHistoriaClinicaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/gst_historia_clinica")
public class HistoriaClinicaController {

	@Autowired
	private IHistoriaClinicaService historiaClinicaService;

	/* -------------- Crear HistoriaClinica -------------- */

	@PostMapping("/crear_historia_clinica")
	@ResponseStatus(HttpStatus.CREATED)
	public HistoriaClinica crearHistoriaClinica(@RequestBody HistoriaClinica historiaClinica) {

		return historiaClinicaService.save(historiaClinica);
	}

	/* -------------- Listar HistoriaClinica -------------- */

	@GetMapping("/listar_historia_clinica")
	public List<HistoriaClinica> listarHistoriaClinica() {

		return historiaClinicaService.listAll();
	}

	/* -------------- Ver HistoriaClinica -------------- */

	@GetMapping("/historia_clinica/{id}")
	public ResponseEntity<?> verHistoriaClinica(@PathVariable Long id) {

		HistoriaClinica historiaClinica = null;
		Map<String, Object> response = new HashMap<>();

		try {
			historiaClinica = historiaClinicaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje",
					"La Historia Clinica con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (historiaClinica == null) {
			response.put("mensaje",
					"La Historia Clinica con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<HistoriaClinica>(historiaClinica, HttpStatus.OK);
	}

	/* -------------- Editar HistoriaClinica -------------- */

	@PutMapping("/historia_clinica/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public HistoriaClinica editarHistoriaClinica(@RequestBody HistoriaClinica historiaClinica, @PathVariable Long id) {

		HistoriaClinica historiaClinicaActual = historiaClinicaService.findById(id);

		historiaClinicaActual.setCodigo_historiaClinica(historiaClinica.getCodigo_historiaClinica());
		historiaClinicaActual.setMotivo_consulta(historiaClinica.getMotivo_consulta());
		historiaClinicaActual.setEnfermedad_actual(historiaClinica.getEnfermedad_actual());
		historiaClinicaActual.setEstatura(historiaClinica.getEstatura());
		historiaClinicaActual.setPeso(historiaClinica.getPeso());
		historiaClinicaActual.setPresion(historiaClinica.getPresion());
		historiaClinicaActual.setFecha(historiaClinica.getFecha());

		return historiaClinicaService.save(historiaClinicaActual);
	}

	/* -------------- Eliminar HistoriaClinica -------------- */

	@DeleteMapping("/historia_clinica/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarExamen(@PathVariable Long id) {

		historiaClinicaService.delete(id);
	}

}
