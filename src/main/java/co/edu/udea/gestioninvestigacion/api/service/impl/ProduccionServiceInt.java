package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.Produccion;

import java.util.List;

public interface ProduccionServiceInt {

    public List<Produccion> getProducciones();

    public Produccion addProduccion(Produccion produccion);

    public Produccion getProduccion(int id);
}
