package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.AutoresPorProducciones;
import co.edu.udea.gestioninvestigacion.api.model.CategoriasPorProduccion;
import co.edu.udea.gestioninvestigacion.api.model.Produccion;
import co.edu.udea.gestioninvestigacion.api.repository.AutoresPorProduccionRepository;
import co.edu.udea.gestioninvestigacion.api.repository.CategoriasPorProduccionRepository;
import co.edu.udea.gestioninvestigacion.api.repository.ProduccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduccionService implements ProduccionServiceInt{

    private ProduccionRepository produccionRepository;
    private AutoresPorProduccionRepository autoresPorProduccionRepository;
    private CategoriasPorProduccionRepository categoriasPorProduccionRepository;

    public ProduccionService(ProduccionRepository produccionRepository, AutoresPorProduccionRepository autoresPorProduccionRepository, CategoriasPorProduccionRepository categoriasPorProduccionRepository){
        this.produccionRepository = produccionRepository;
        this.categoriasPorProduccionRepository = categoriasPorProduccionRepository;
        this.autoresPorProduccionRepository = autoresPorProduccionRepository;
    }

    public List<Produccion> getProducciones(){return produccionRepository.findAll();}

    public Produccion addProduccion(Produccion produccion){
        if(produccion.getAutoresPorProducciones() != null) {
            for (AutoresPorProducciones autorPorProduccion : produccion.getAutoresPorProducciones()) {
                autoresPorProduccionRepository.save(autorPorProduccion);
            }
        }
        if(produccion.getCategoriasPorProduccion() != null) {
            for (CategoriasPorProduccion categoriasPorProduccion : produccion.getCategoriasPorProduccion()) {
                //categoriasPorProduccion.setProduccion();
                categoriasPorProduccionRepository.save(categoriasPorProduccion);
            }
        }
        return produccionRepository.save(produccion);
    };
}
