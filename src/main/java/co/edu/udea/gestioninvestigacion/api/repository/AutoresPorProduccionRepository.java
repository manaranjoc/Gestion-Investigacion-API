package co.edu.udea.gestioninvestigacion.api.repository;

import co.edu.udea.gestioninvestigacion.api.model.AutoresPorProducciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresPorProduccionRepository extends JpaRepository<AutoresPorProducciones, Integer> {
}
