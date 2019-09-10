package co.edu.udea.gestioninvestigacion.api.repository;

import co.edu.udea.gestioninvestigacion.api.model.CategoriasPorProduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasPorProduccionRepository extends JpaRepository<CategoriasPorProduccion, Integer> {
}
