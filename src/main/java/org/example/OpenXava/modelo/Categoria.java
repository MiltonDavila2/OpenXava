package org.example.OpenXava.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity @Getter @Setter
public class Categoria extends Identificable { // Extiende de Identificable
    // por tanto no necesita tener una propiedad id
    @Column(length=50)
    String descripcion;

}