package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.Categoria;
import co.edu.udea.gestioninvestigacion.api.repository.CategoriaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaServiceTest {

    @Mock
    CategoriaRepository categoriaRepository;

    @InjectMocks
    CategoriaService categoriaService;

    List<Categoria> mockCategoria = new ArrayList<>();

    @Test
    public void retrieveCategorias(){

        mockCategoria.add(new Categoria("Electronica","Agroindustria"));
        mockCategoria.add(new Categoria("Educación", "TIC"));

        Mockito.when(categoriaRepository.findAll()).thenReturn(mockCategoria);

        List<Categoria> results = categoriaService.getCategorias();

        assert(results.equals(mockCategoria));

    }

}
