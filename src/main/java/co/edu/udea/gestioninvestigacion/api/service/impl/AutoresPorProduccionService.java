package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.AutoresPorProduccion;
import co.edu.udea.gestioninvestigacion.api.repository.AutoresPorProduccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoresPorProduccionService implements AutoresPorProduccionServiceInt {

    private AutoresPorProduccionRepository autoresPorProduccionRepository;

    @Override
    public List<AutoresPorProduccion> findByProduccionId(int produccionId) {
        return autoresPorProduccionRepository.findByProduccionProduccionID(produccionId);
    }

    @Override
    public AutoresPorProduccion addAutoresPorProduccion(AutoresPorProduccion autoresPorProduccion) {
        return autoresPorProduccionRepository.save(autoresPorProduccion);
    }
}
