package org.example.OpenXava.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.CollectionView;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity @Getter @Setter

@View(extendsView="super.DEFAULT", // Extiende de la vista de DocumentoComercial
        members="pedidos { pedidos }" // Añadimos pedidos dentro de una pestaña
)

@View( name="SinClienteNiPedidos", // Una vista llamada SinClienteNiPedidos
        members=                       // que no incluye cliente ni pedidos
                "anyo, numero, fecha;" +   // Ideal para usarse desde Pedido
                        "detalles;" +
                        "observaciones"
)
public class Factura extends DocumentoComercial {
    @OneToMany(mappedBy="factura")
    @CollectionView("SinClienteNiFactura")
    Collection<Pedido> pedidos;
}
