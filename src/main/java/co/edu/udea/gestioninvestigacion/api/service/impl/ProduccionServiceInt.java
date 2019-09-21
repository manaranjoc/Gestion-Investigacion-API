package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.PagingResult;
import co.edu.udea.gestioninvestigacion.api.model.Produccion;

import java.util.List;

public interface ProduccionServiceInt {

    public List<Produccion> getProducciones();
    public Produccion addProduccion(Produccion produccion);
    public Produccion getProduccion(Integer id);
    public PagingResult<Produccion> getProduccionesPagina(int page, int limit);
    public PagingResult<Produccion> getProduccionesPagina2(int page, int limit, String sortActive, String sortDirection);
    public PagingResult<Produccion> getProduccionesPaginaTitulo(int page, int limit, String sortActive, String sortDirection, String term);
    public PagingResult<Produccion> getProduccionesPaginaResumen(int page, int limit, String sortActive, String sortDirection, String term);
}
