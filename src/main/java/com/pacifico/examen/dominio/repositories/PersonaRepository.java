package com.pacifico.examen.dominio.repositories;

import com.pacifico.examen.dominio.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {


    List<Persona> findByNombreLike(String nombre);
}
