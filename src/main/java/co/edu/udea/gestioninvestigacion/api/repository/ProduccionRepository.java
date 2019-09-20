package co.edu.udea.gestioninvestigacion.api.repository;

import co.edu.udea.gestioninvestigacion.api.model.PagingResult;
import co.edu.udea.gestioninvestigacion.api.model.Produccion;
import co.edu.udea.gestioninvestigacion.api.model.TipoProduccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduccionRepository extends JpaRepository<Produccion, Integer> {

    Page<Produccion> findByTituloContaining(String titulo, Pageable pageableRequest);
    List<Produccion> findByTituloContaining(String titulo);
    Page<Produccion> findByResumenContaining(String resumen, Pageable pageableRequest);
    List<Produccion> findByResumenContaining(String resumen);
}
