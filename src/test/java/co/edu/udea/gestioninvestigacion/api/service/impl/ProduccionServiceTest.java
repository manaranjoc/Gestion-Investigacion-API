package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.Produccion;
import co.edu.udea.gestioninvestigacion.api.repository.ProduccionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ProduccionServiceTest {

    @Mock
    ProduccionRepository produccionRepository;

    @InjectMocks
    ProduccionService produccionService;

    Produccion mockProduccion = new Produccion();

    @Test
    public void saveProduccion(){
        mockProduccion.setProduccionID(5);

        Mockito.when(produccionRepository.save(Mockito.any(Produccion.class))).thenReturn(mockProduccion);

        Produccion result = produccionService.addProduccion(mockProduccion);

        assert(result.getProduccionID() == 5);
    }

    @Test
    public void updateProduccion(){
        mockProduccion.setProduccionID(4);

        Mockito.when(produccionRepository.save(Mockito.any(Produccion.class))).thenReturn(mockProduccion);

        Produccion result = produccionService.updateProduccion(mockProduccion);

        assert(result.getProduccionID() == 4);
    }

    @Test
    public void getProduccionExistente(){
        mockProduccion.setProduccionID(3);
        Optional<Produccion> mockOptionalProduccion = Optional.of(mockProduccion);

        Mockito.when(produccionRepository.findById(3)).thenReturn(mockOptionalProduccion);

        Produccion result = produccionService.getProduccion(3);

        assert(result.getProduccionID()==3);
    }

    @Test
    public void getProduccionInexistente(){
        Optional<Produccion> mockOptionalProduccion;

        Mockito.when(produccionRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        Produccion result = produccionService.getProduccion(5);

        assert(result==null);
    }

}
