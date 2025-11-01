package org.example.OpenXava.modelo;

import lombok.Getter;
import lombok.Setter;
import org.example.OpenXava.calculadores.CalculadorPrecioPorUnidad;
import org.openxava.annotations.*;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Embeddable @Getter @Setter
public class Detalle {

    int cantidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Producto producto;

    @Money
    @Depends("precioPorUnidad, cantidad") // precioPorUnidad en vez de producto.numero
    public BigDecimal getImporte() {
        if (precioPorUnidad == null) return BigDecimal.ZERO; // precioPorUnidad en vez de producto y producto.getPrecio()
        return new BigDecimal(cantidad).multiply(precioPorUnidad); // precioPorUnidad en vez de producto.getPrecio()
    }

    @DefaultValueCalculator(
            value= CalculadorPrecioPorUnidad.class, // Esta clase calcula el valor inicial
            properties=@PropertyValue(
                    name="numeroProducto", // La propiedad numeroProducto del calculador...
                    from="producto.numero") // ... se llena con el valor de producto.numero de la entidad
    )
    @Money
    BigDecimal precioPorUnidad; // Una propiedad persistente convencional

}
