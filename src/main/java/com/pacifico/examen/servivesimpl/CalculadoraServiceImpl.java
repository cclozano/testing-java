package com.pacifico.examen.servivesimpl;

import com.pacifico.examen.dominio.Persona;
import com.pacifico.examen.dominio.repositories.PersonaRepository;
import com.pacifico.examen.dominio.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CalculadoraServiceImpl implements CalculadoraService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona calcularIMB(Persona persona) {
        persona.setImb(persona.calcularIndiceMetabolicoBasal());
        this.personaRepository.save(persona);
        return persona;
    }

    @Override
    public List<Persona> consular(String nombre) {
        return this.personaRepository.findByNombreLike(nombre);
    }
}
