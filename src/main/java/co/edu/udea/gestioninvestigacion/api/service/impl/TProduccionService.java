package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.TipoProduccion;
import co.edu.udea.gestioninvestigacion.api.repository.TProduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TProduccionService implements TProduccionServiceInt {

    @Autowired
    private TProduccionRepository tProduccionRepository;

    public TProduccionService (TProduccionRepository  tProduccionRepository){
        this.tProduccionRepository = tProduccionRepository;
    }

    public List<TipoProduccion>  getTProducciones() {
        return tProduccionRepository.findAll();
    }
}
