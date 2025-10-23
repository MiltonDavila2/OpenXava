package org.example.OpenXava.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.ReferenceView;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity @Getter @Setter
@View(extendsView="super.DEFAULT", // Extiende de la vista de DocumentoComercial
        members="factura { factura } " // Añadimos factura dentro de una pestaña
)
@View( name="SinClienteNiFactura", // Una vista llamada SinClienteNiFactura
        members=                       // que no incluye cliente ni factura
                "anyo, numero, fecha;" +   // Ideal para ser usada desde Factura
                        "detalles;" +
                        "observaciones"
)
public class Pedido extends DocumentoComercial {
    @ManyToOne
    @ReferenceView("SinClienteNiPedidos")
    Factura factura;
}
