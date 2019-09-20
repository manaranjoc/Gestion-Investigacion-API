package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.AutoresPorProduccion;

import java.util.List;

public interface AutoresPorProduccionServiceInt {
    public List<AutoresPorProduccion> findByProduccionId(int produccionId);
    public AutoresPorProduccion addAutoresPorProduccion(AutoresPorProduccion autoresPorProduccion, int produccionId);
}
