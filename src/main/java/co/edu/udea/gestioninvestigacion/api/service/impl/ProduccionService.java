package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.Produccion;
import co.edu.udea.gestioninvestigacion.api.repository.AutoresPorProduccionRepository;
import co.edu.udea.gestioninvestigacion.api.repository.CategoriasPorProduccionRepository;
import co.edu.udea.gestioninvestigacion.api.repository.ProduccionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduccionService implements ProduccionServiceInt{

    private ProduccionRepository produccionRepository;

    public ProduccionService(ProduccionRepository produccionRepository){
        this.produccionRepository = produccionRepository;
    }

    //public List<Produccion> getProducciones(){return produccionRepository.findAll();}

    public Produccion addProduccion(Produccion produccion){
        return produccionRepository.save(produccion);
    };

    public Produccion getProduccion(int id){
        Optional<Produccion> posibleProduccion = produccionRepository.findById(id);
        if(posibleProduccion.isPresent()){
            return posibleProduccion.get();
        }else{
            //Todo: Cambiar por la Excepción correspondiente.
            return new Produccion();
        }
    }

    @Override
    public Page<Produccion> findPaginated(int page, int size) {
        Pageable searchPage = PageRequest.of(page,size);
        return produccionRepository.findAll(searchPage);

    }
}
