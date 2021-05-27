package com.pacifico.examen.controllers;

import com.pacifico.examen.dominio.Persona;
import com.pacifico.examen.dominio.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping("/persona")
    public ResponseEntity<Persona> calcularYGuardar(@Validated @RequestBody Persona persona){
        Persona p = calculadoraService.calcularIMB(persona);
        return new ResponseEntity<>(p, HttpStatus.OK );
    }


    @GetMapping("/personas/{nombre}")
    public  ResponseEntity<List<Persona>> consultar(@PathVariable String nombre){
        return new ResponseEntity<>(calculadoraService.consular(nombre),  HttpStatus.OK    );
    }
}
