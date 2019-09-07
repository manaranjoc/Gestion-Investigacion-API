package co.edu.udea.gestioninvestigacion.api.controller;

import co.edu.udea.gestioninvestigacion.api.model.Produccion;
import co.edu.udea.gestioninvestigacion.api.service.impl.ProduccionServiceInt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO: Cambiar ruta de la API, completar operaciones CRUD
@RestController
@RequestMapping("/producciones")
public class ProduccionController {

    private ProduccionServiceInt produccionService;

    public ProduccionController(ProduccionServiceInt produccionService){
        this.produccionService = produccionService;
    }

    @GetMapping
    public ResponseEntity<List<Produccion>> getProducciones(){return ResponseEntity.ok(produccionService.getProducciones());}
}
