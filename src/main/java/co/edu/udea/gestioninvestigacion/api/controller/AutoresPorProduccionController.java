package co.edu.udea.gestioninvestigacion.api.controller;

import co.edu.udea.gestioninvestigacion.api.model.AutoresPorProduccion;
import co.edu.udea.gestioninvestigacion.api.service.impl.AutoresPorProduccionServiceInt;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoresPorProduccionController {

    private AutoresPorProduccionServiceInt autoresPorProduccionService;

    public AutoresPorProduccionController(AutoresPorProduccionServiceInt autoresPorProduccionService) {
        this.autoresPorProduccionService = autoresPorProduccionService;
    }

    @GetMapping("/producciones/{produccionId}/autoresporproducciones")
    public ResponseEntity<List<AutoresPorProduccion>> getAllAutoresPorProduccionesPorProduccionId(@PathVariable (value="produccionId") int produccionId){
        return ResponseEntity.ok(autoresPorProduccionService.findByProduccionId(produccionId));
    }

    //@PostMapping("/producciones/{produccionId}/autoresporproducciones")

}
