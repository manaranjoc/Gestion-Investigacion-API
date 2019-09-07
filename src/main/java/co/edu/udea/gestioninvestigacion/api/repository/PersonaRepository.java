package co.edu.udea.gestioninvestigacion.api.repository;

import co.edu.udea.gestioninvestigacion.api.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
