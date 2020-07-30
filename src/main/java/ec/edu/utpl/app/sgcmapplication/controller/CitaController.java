/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.app.sgcmapplication.controller;

import ec.edu.utpl.app.sgcmapplication.models.entity.Cita;
import ec.edu.utpl.app.sgcmapplication.models.services.ICitaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
}
