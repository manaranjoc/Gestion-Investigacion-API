package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.AutoresPorProduccion;
import co.edu.udea.gestioninvestigacion.api.repository.AutoresPorProduccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresPorProduccionService implements AutoresPorProduccionServiceInt {

    private AutoresPorProduccionRepository autoresPorProduccionRepository;
    private ProduccionServiceInt produccionService;

    public AutoresPorProduccionService(AutoresPorProduccionRepository autoresPorProduccionRepository, ProduccionServiceInt produccionService) {
        this.autoresPorProduccionRepository = autoresPorProduccionRepository;
        this.produccionService = produccionService;
    }

    @Override
    public List<AutoresPorProduccion> findByProduccionId(int produccionId) {
        return autoresPorProduccionRepository.findByProduccionProduccionID(produccionId);
    }

    @Override
    public AutoresPorProduccion addAutoresPorProduccion(AutoresPorProduccion autoresPorProduccion, int produccionId) {
        /*Optional<Produccion> .getProduccion(produccionId).map(produccion -> {
            autoresPorProduccion.setProduccion(produccion);
            return autoresPorProduccionRepository.save(autoresPorProduccion);
        });*/
        return new AutoresPorProduccion();

    }
}
