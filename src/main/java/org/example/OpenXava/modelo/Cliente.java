package org.example.OpenXava.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @Column(length = 6)
    int numero;

    @Column(length = 60)
    @Required
    String nombre;
}
