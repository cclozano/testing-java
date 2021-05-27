package com.pacifico.examen.dominio;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;



@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;

    //Annos
    @NotNull
    private int edad;

    //Kilogramos
    @NotNull
    private BigDecimal peso=BigDecimal.ZERO;

    //centimetros
    @NotNull
    private int estatura=1;


    private BigDecimal imb;


    @NotNull
    private Genero genero = Genero.MASCULINO;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public int getEstatura() {
        return estatura;
    }


    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }


    public BigDecimal getImb() {
        return imb;
    }

    public void setImb(BigDecimal imb) {
        this.imb = imb;
    }

    /**
     * Hombres TMB = (10 x peso en kg) + (6,25 × altura en cm) - (5 × edad en años) + 5
     * Mujeres TMB = (10 x peso en kg) + (6,25 × altura en cm) - (5 × edad en años) - 161
     * @return
     */
    public BigDecimal calcularIndiceMetabolicoBasal(){
        BigDecimal a =  new BigDecimal("10").multiply(this.peso);
        BigDecimal b =  new BigDecimal("6.25").multiply(new BigDecimal(this.estatura));
        BigDecimal c =  new BigDecimal("5").multiply( new BigDecimal(this.edad));

        if(this.genero == Genero.MASCULINO){
              return a.add(b).subtract(c).add(new BigDecimal("5"));
        }else{
            return a.add(b).subtract(c).subtract(new BigDecimal("161"));
        }
    }



}
