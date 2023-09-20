package BuenosAiresCatering;

import java.io.Serializable;

/**
 * Esta clase se encarga de cargar menus ya preestablecidos en el arranque
 * inicial del sistema para que venga con menus
 *
 * @author Alumno Franco Vilaseco
 */
public class Menu implements Serializable {

    /**
     * Metodo que carga 4 Menus en el sistema
     * @param  sistemaDeReserva se pasa el sistema para cargar los servicios
     */
    public void cargar(SistemaDeReserva sistemaDeReserva) {
        String titulo = "LUNCH TRADICIONAL";
        String descripcion = "\t40 Sandwiches triples\n"
                + "\t20 Pizzetas\n"
                + "\t20 Empanaditas de copetin\n"
                + "\t20 Morenitos de lomito y cheddar\n"
                + "\t20 Chips de pollo con queso crema y ciboulette\n"
                + "\t20 Chips de jamon y tomate\n"
                + "\t20 Salchichitas encamisadas\n"
                + "\t20 Fosforitos\n"
                + "\t20 Medialunas de jamon y queso\n"
                + "\t02 Tarta dulce\n";
        int p = 28000;

        Servicio servicio = new Servicio();
        servicio.setNombre(titulo);
        servicio.setMenu(descripcion);
        servicio.setPrecio(p);
        sistemaDeReserva.getServicios().add(servicio);

        titulo = "MENU PERNIL DE CERDO";
        descripcion = "\t24 sandwiches de miga triples\n"
                + "\t20 empanadas copetin variada\n"
                + "\t20 salchichitas encaminadas\n"
                + "\t20 medialunas con jamon y queso\n"
                + "\tPernil de cerdo 7/8 kg (incluye 80 panes y 3 salsas)\n";
        p = 40000;
        Servicio servicio1 = new Servicio();
        servicio1.setNombre(titulo);
        servicio1.setMenu(descripcion);
        servicio1.setPrecio(p);
        sistemaDeReserva.getServicios().add(servicio1);

        titulo = "LUNCH GOURMET";
        descripcion = "\t20 Sandwich de miga especiales\n"
                + "\t20 Pinchos de serrano y gruyere\n"
                + "\t40 Empanaditas de copetin variadas\n"
                + "\t20 Negritos de lomito y cheddar\n"
                + "\t20 Pinchos crispy de pollo\n"
                + "\t20 Salchichitas encamisadas\n"
                + "\t20 Sandwich de bondiola en pan saborizado\n"
                + "\t20 Tortilla de papa\n"
                + "\t20 Mini hamburguesas bacon\n"
                + "\t02 Tartas dulce\n";
        p = 30000;
        Servicio servicio2 = new Servicio();
        servicio2.setNombre(titulo);
        servicio2.setMenu(descripcion);
        servicio2.setPrecio(p);
        sistemaDeReserva.getServicios().add(servicio2);

        titulo = "LUNCH EXPRESS";
        descripcion = "\t32 Sandwich triples\n"
                + "\t30 Pizzetas\n"
                + "\t30 Fosforitos\n"
                + "\t30 Emapanaditas de copetin\n"
                + "\t30 Salchichitas\n"
                + "\t30 Medialunas de jamon y queso\n";
        p = 12000;

        Servicio servicio3 = new Servicio();
        servicio3.setNombre(titulo);
        servicio3.setMenu(descripcion);
        servicio3.setPrecio(p);
        sistemaDeReserva.getServicios().add(servicio3);
    }//Cierre del metodo
}//Cierre de la Clase
