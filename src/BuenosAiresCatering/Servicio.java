package BuenosAiresCatering;

import java.io.Serializable;

/**
 * Esta clase es la encargada de guardar todos los datos acerca de un servicio y
 * poder mostrarlos cuando se deseen
 *
 * @author Alumno Franco Vilaseco
 */
public class Servicio implements Serializable {

    private String nombre;
    private String menu;
    private int precio;

    /**
     * Metodo que guarda el String pasado por parametro en la variable nombre
     *
     * @param nombre es el string que se guardara en la variable
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable menu
     *
     * @param menu es el string que se guardara en la variable
     */
    public void setMenu(String menu) {
        this.menu = menu;
    }

    /**
     * Metodo que guarda el entero pasado por parametro en la variable precio
     *
     * @param precio es el entero que se guardara en la variable
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Metodo que muestra los datos del servicio.
     */
    public void mostrar() {
        EntradaSalida.mostrarString("\n\tNombre: " + nombre);
        EntradaSalida.mostrarString("Menu: " + menu);
        EntradaSalida.mostrarString("Precio: " + precio);
        EntradaSalida.mostrarString("********************\n");
    }

    /**
     * Metodo que muestra los datos del servicio agregando un numero
     * identificador para utilizar como indice
     *
     * @param iden es el numero de indice
     */
    public void mostrar(int iden) {
        EntradaSalida.mostrarString("\nNumero Identificador:" + iden);
        EntradaSalida.mostrarString("\n\tNombre: " + nombre);
        EntradaSalida.mostrarString("Menu: " + menu);
        EntradaSalida.mostrarString("Precio: " + precio);
        EntradaSalida.mostrarString("********************\n");
    }
}
