package com.pacifico.examen.dominio.services;

import com.pacifico.examen.dominio.Persona;

import java.util.List;

public interface CalculadoraService {

    Persona calcularIMB(Persona persona);

    List<Persona> consular(String nombre);

}
