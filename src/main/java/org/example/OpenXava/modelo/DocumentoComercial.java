package org.example.OpenXava.modelo;

import lombok.Getter;
import lombok.Setter;
import org.example.OpenXava.calculadores.CalculadorSiguienteNumeroParaAnyo;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity @Getter @Setter

@View(members=
        "anyo, numero, fecha," + // Los miembros para la cabecera en una línea
                "datos {" + // Una pestaña 'datos' para los datos principales del documento
                "cliente;" +
                "detalles;" +
                "observaciones" +
                "}"
)

public class DocumentoComercial extends Identificable{

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(length = 32)
    String oid;

    @DefaultValueCalculator(CurrentYearCalculator.class)
    @Column(length = 4)
    int anyo;

    @Column(length = 6)
    @DefaultValueCalculator(value = CalculadorSiguienteNumeroParaAnyo.class,
                           properties = @PropertyValue(name="anyo"))
    int numero;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Cliente cliente;

    @ElementCollection @ListProperties("producto.numero, producto.descripcion, cantidad")
    Collection<Detalle> detalles;

    @Stereotype("MEMO")
    String Observaciones;
}
