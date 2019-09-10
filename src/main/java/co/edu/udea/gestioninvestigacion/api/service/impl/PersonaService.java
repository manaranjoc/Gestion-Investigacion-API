package co.edu.udea.gestioninvestigacion.api.service.impl;

import co.edu.udea.gestioninvestigacion.api.model.Persona;
import co.edu.udea.gestioninvestigacion.api.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements PersonaServiceInt {

    private PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }
}
