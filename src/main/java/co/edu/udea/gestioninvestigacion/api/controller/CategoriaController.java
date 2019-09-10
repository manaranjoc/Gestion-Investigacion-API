package co.edu.udea.gestioninvestigacion.api.controller;

import co.edu.udea.gestioninvestigacion.api.model.Categoria;
import co.edu.udea.gestioninvestigacion.api.service.impl.CategoriaServiceInt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaServiceInt categoriaService;

    public CategoriaController(CategoriaServiceInt categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias(){
        return ResponseEntity.ok(categoriaService.getCategorias());
    }

}
