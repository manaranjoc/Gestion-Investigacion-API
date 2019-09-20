package co.edu.udea.gestioninvestigacion.api.controller;

import co.edu.udea.gestioninvestigacion.api.model.Produccion;
import co.edu.udea.gestioninvestigacion.api.service.impl.ProduccionServiceInt;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

//TODO: Cambiar ruta de la API, completar operaciones CRUD
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/producciones")
public class ProduccionController {

    private ProduccionServiceInt produccionService;

    public ProduccionController(ProduccionServiceInt produccionService){
        this.produccionService = produccionService;
    }

    //@GetMapping
    //public ResponseEntity<List<Produccion>> getProducciones(){return ResponseEntity.ok(produccionService.getProducciones());}

    @PostMapping
    public ResponseEntity<Produccion> addProduccion(@RequestBody Produccion newProduccion){
        return ResponseEntity.ok(produccionService.addProduccion(newProduccion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produccion> getProduccion(@PathVariable int id){
        return ResponseEntity.ok(produccionService.getProduccion(id));
    }

    @GetMapping(params = {"page","size"})
    public ResponseEntity<List<Produccion>> findPaginatedProduccion(@RequestParam("page") int page, @RequestParam("size") int size){
        Page<Produccion> resultPage = produccionService.findPaginated(page,size);
        return ResponseEntity.ok(resultPage.getContent());
    }
}
