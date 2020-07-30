/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.app.sgcmapplication.controller;

import ec.edu.utpl.app.sgcmapplication.models.entity.Cita;
import ec.edu.utpl.app.sgcmapplication.models.services.ICitaService;
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

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Cita crearCita(@RequestBody Cita cita) {

        return citaService.save(cita);
    }

    @GetMapping("/get_citas")
    public List<Cita> listarCitas() {
        return citaService.listAll();
    }

    @GetMapping("/cita/{id}")
    public ResponseEntity<?> verCita(@PathVariable int id) {

        Cita cita = null;
        Map<String, Object> response = new HashMap<>();

        try {
            cita = citaService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error con citas con el ID: ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        if (cita == null) {
            response.put("mensaje", "Error con citas con el ID: ");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Cita>(cita, HttpStatus.OK);
    }

    @PutMapping("/update_cita/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cita editarCita(@RequestBody Cita cita,
            @PathVariable int id) {

        Cita citaActual = citaService.findById(id);

        citaActual.setMedico(cita.getMedico());
        citaActual.setPaciente(cita.getPaciente());

        return citaService.save(citaActual);
    }

    @DeleteMapping("/medico_especialidad/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCita(@PathVariable int id) {
        citaService.delete(id);
    }
}
