package co.edu.udea.gestioninvestigacion.api.controller;

import co.edu.udea.gestioninvestigacion.api.model.PagingResult;
import co.edu.udea.gestioninvestigacion.api.model.Produccion;
import co.edu.udea.gestioninvestigacion.api.service.impl.ProduccionServiceInt;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Produccion> addProduccion(@RequestBody Produccion newProduccion){
        return ResponseEntity.ok(produccionService.addProduccion(newProduccion));
    }

    @DeleteMapping("/{id}")
    public void deleteProduccion(@PathVariable Integer id){
        produccionService.deleteProduccion(id);
    }

    @PutMapping()
    public ResponseEntity<Produccion> updateProduccion(Produccion produccion){
        return ResponseEntity.ok(produccionService.updateProduccion(produccion));
    }

    @GetMapping(value = "consultar/{id}")
    public ResponseEntity<Produccion> getProduccion(@PathVariable("id") Integer id){
        return ResponseEntity.ok(produccionService.getProduccion(id));
    }

    @GetMapping("produccionesPagina")
    @ApiOperation(value = "Lista todas las producciones por paginacion", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Las producciones fueron listadas", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<PagingResult<Produccion>> getProduccionesPagina(
            @RequestParam(value = "pageIndex", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "30") int limit){
        return ResponseEntity.ok(produccionService.getProduccionesPagina(page, limit));
    }

    @GetMapping("produccionesPagina2")
    public ResponseEntity<PagingResult<Produccion>> getProduccionesPagina2(
            @RequestParam(value = "pageIndex", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "30") int limit,
            @RequestParam(value = "sortActive", defaultValue = "titulo") String sortActive,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection){
        return ResponseEntity.ok(produccionService.getProduccionesPagina2(page, limit, sortActive, sortDirection));
    }

    @GetMapping("produccionesPaginaTitulo")
    public ResponseEntity<PagingResult<Produccion>> getProduccionesPaginaTitulo(
            @RequestParam(value = "pageIndex", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "30") int limit,
            @RequestParam(value = "sortActive", defaultValue = "titulo") String sortActive,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            @RequestParam(value = "term", defaultValue = " ") String term){
        return ResponseEntity.ok(produccionService.getProduccionesPaginaTitulo(page, limit, sortActive, sortDirection, term));
    }

    @GetMapping("produccionesPaginaResumen")
    public ResponseEntity<PagingResult<Produccion>> getProduccionesPaginaResumen(
            @RequestParam(value = "pageIndex", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "30") int limit,
            @RequestParam(value = "sortActive", defaultValue = "titulo") String sortActive,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            @RequestParam(value = "term", defaultValue = " ") String term){
        return ResponseEntity.ok(produccionService.getProduccionesPaginaResumen(page, limit, sortActive, sortDirection, term));
    }

}
