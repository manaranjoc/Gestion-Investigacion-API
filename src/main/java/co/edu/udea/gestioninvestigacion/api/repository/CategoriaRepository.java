package co.edu.udea.gestioninvestigacion.api.repository;

import co.edu.udea.gestioninvestigacion.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
