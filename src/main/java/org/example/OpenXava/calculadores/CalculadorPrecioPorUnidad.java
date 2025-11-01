package org.example.OpenXava.calculadores;

import lombok.Getter;
import lombok.Setter;
import org.example.OpenXava.modelo.Producto;
import org.openxava.calculators.ICalculator;
import static org.openxava.jpa.XPersistence.*;


public class CalculadorPrecioPorUnidad implements ICalculator {

    @Getter
    @Setter
    int numeroProducto;

    @Override
    public Object calculate() throws Exception {
        Producto producto = getManager() // getManager() de XPersistence
                .find(Producto.class, numeroProducto); // Busca el producto
        return producto.getPrecio();    // Retorna su precio
    }

}
