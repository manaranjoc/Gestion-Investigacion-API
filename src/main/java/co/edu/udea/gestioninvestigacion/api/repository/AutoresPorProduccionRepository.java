package co.edu.udea.gestioninvestigacion.api.repository;

import co.edu.udea.gestioninvestigacion.api.model.AutoresPorProduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoresPorProduccionRepository extends JpaRepository<AutoresPorProduccion, Integer> {
    List<AutoresPorProduccion> findByProduccionProduccionID(int produccionID);
}
