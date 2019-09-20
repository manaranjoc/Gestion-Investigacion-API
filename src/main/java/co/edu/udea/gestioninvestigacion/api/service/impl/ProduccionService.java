package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.AutoresPorProducciones;
import co.edu.udea.gestioninvestigacion.api.model.CategoriasPorProduccion;
import co.edu.udea.gestioninvestigacion.api.model.PagingResult;
import co.edu.udea.gestioninvestigacion.api.model.Produccion;
import co.edu.udea.gestioninvestigacion.api.repository.AutoresPorProduccionRepository;
import co.edu.udea.gestioninvestigacion.api.repository.CategoriasPorProduccionRepository;
import co.edu.udea.gestioninvestigacion.api.repository.ProduccionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.System.console;

@Service
public class ProduccionService implements ProduccionServiceInt{

    @Autowired
    private ProduccionRepository produccionRepository;
    private AutoresPorProduccionRepository autoresPorProduccionRepository;
    private CategoriasPorProduccionRepository categoriasPorProduccionRepository;

    public ProduccionService(ProduccionRepository produccionRepository, AutoresPorProduccionRepository autoresPorProduccionRepository, CategoriasPorProduccionRepository categoriasPorProduccionRepository){
        this.produccionRepository = produccionRepository;
        this.categoriasPorProduccionRepository = categoriasPorProduccionRepository;
        this.autoresPorProduccionRepository = autoresPorProduccionRepository;
    }

    @Override
    public List<Produccion> getProducciones(){return produccionRepository.findAll();}

    @Override
    public Produccion getProduccion(Integer id) {
        Optional<Produccion> posibleProduccion = produccionRepository.findById(id);
        if(posibleProduccion.isPresent()){
            return posibleProduccion.get();
        }else {
            return null;        }
    }

    @Override
    public PagingResult<Produccion> getProduccionesPagina(int pageIndex, int pageSize) {
        List<Produccion> returnValue = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(pageIndex, pageSize);
        Page<Produccion> producciones = produccionRepository.findAll(pageableRequest);
        List<Produccion> produccionesEntidades = producciones.getContent();

        for (Produccion produccion : producciones) {
            Produccion produccionDto = new Produccion();
            BeanUtils.copyProperties(produccion, produccionDto);
            returnValue.add(produccionDto);
        }
        return new PagingResult<Produccion>(returnValue,
                produccionRepository.findAll().size());
    }

    public PagingResult<Produccion> getProduccionesPagina2(int pageIndex, int pageSize, String sortActive, String sortDirection) {
        Sort sort = Sort.by(sortActive).ascending();
        if(sortDirection.equalsIgnoreCase("DESC")) {
            sort = Sort.by(sortActive).descending();
        }
        List<Produccion> returnValue = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(pageIndex, pageSize, sort);
        Page<Produccion> producciones = produccionRepository.findAll(pageableRequest);
        List<Produccion> produccionesEntidades = producciones.getContent();

        for (Produccion produccion : producciones) {
            Produccion produccionDto = new Produccion();
            BeanUtils.copyProperties(produccion, produccionDto);
            returnValue.add(produccionDto);
        }
        return new PagingResult<Produccion>(returnValue,
                produccionRepository.findAll().size());
    }

    public PagingResult<Produccion> getProduccionesPaginaTitulo(int pageIndex, int pageSize, String sortActive,
                                                                String sortDirection, String term) {
        Sort sort = Sort.by(sortActive).ascending();
        if(sortDirection.equalsIgnoreCase("DESC")) {
            sort = Sort.by(sortActive).descending();
        }
        List<Produccion> returnValue = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(pageIndex, pageSize, sort);
        Page<Produccion> producciones = produccionRepository.findByTituloContaining(term, pageableRequest);
        List<Produccion> produccionesEntidades = producciones.getContent();

        for (Produccion produccion : producciones) {
            Produccion produccionDto = new Produccion();
            BeanUtils.copyProperties(produccion, produccionDto);
            returnValue.add(produccionDto);
        }
        return new PagingResult<Produccion>(returnValue,
                produccionRepository.findByTituloContaining(term).size());
    }

    public PagingResult<Produccion> getProduccionesPaginaResumen(int pageIndex, int pageSize, String sortActive,
                                                                String sortDirection, String term) {
        Sort sort = Sort.by(sortActive).ascending();
        if(sortDirection.equalsIgnoreCase("DESC")) {
            sort = Sort.by(sortActive).descending();
        }
        List<Produccion> returnValue = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(pageIndex, pageSize, sort);
        Page<Produccion> producciones = produccionRepository.findByResumenContaining(term, pageableRequest);
        List<Produccion> produccionesEntidades = producciones.getContent();

        for (Produccion produccion : producciones) {
            Produccion produccionDto = new Produccion();
            BeanUtils.copyProperties(produccion, produccionDto);
            returnValue.add(produccionDto);
        }
        return new PagingResult<Produccion>(returnValue,
                produccionRepository.findByResumenContaining(term).size());
    }

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
