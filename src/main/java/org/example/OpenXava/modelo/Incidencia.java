package org.example.OpenXava.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Incidencia {

    @Getter @Setter
    int precio;
    // Propiedad persistente
    @Getter @Setter // Tiene getter y setter
    int cantidad; // Tiene un campo, por tanto es persistente

    // Propiedad calculada
    public int getImporte() { // No tiene campo, ni setter, solo un getter
        return cantidad * precio; // con un cálculo
    }

}
