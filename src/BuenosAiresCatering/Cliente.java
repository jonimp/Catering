package BuenosAiresCatering;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta clase es un tipo de usuario que tiene permisos de Cliente
 *
 * @author Alumno Franco Vilaseco
 */
public class Cliente extends Usuario implements Serializable {

    private String nombre;
    private String direccion;
    private String eMail;
    private String telefono;

    /**
     * Constructor del cliente
     *
     * @param u nombre de usuario
     * @param p contraseña del usuario
     */
    public Cliente(String u, String p) {
        setUsuario(u);
        setPassword(p);
    }//cierre constructor

    /**
     * Metodo que guarda un string con el nombre del cliente
     *
     * @param nombre es el String que se va a guardar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que guarda un string con la direccion del cliente
     *
     * @param direccion es el String que se va a guardar
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo que guarda un string con el email del cliente
     *
     * @param eMail es el String que se va a guardar
     */
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * Metodo que guarda un string con el telefono del cliente (se utiliza un
     * string por si se quiere agregar simbolos por ejemplo "+")
     *
     * @param telefono es el String que se va a guardar
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo heredado de usuario es el encargado de dar las opciones al
     * cliente, para poder ver sus reservas.
     */
    @Override
    public boolean proceder(SistemaDeReserva sistemaDeReserva) {
        char opc;
        boolean seguir = true;
        EntradaSalida.mostrarString("\n\tBienvenido/a al sistema, Sr(a) Cliente(a)");
        do {
            opc = EntradaSalida.leerChar(
                    "\n\t\tOPCIONES DEL CLIENTE\n"
                    + "\t[1] Ver reservas pendientes\n"
                    + "\t[2] Cerrar Sesion\n"
                    + "\t[3] Cerrar Sesion y Salir del sistema\n");
            switch (opc) {
                case '1':
                    if (!sistemaDeReserva.getReservas().isEmpty()) {
                        ArrayList<Reserva> vecRese = sistemaDeReserva.getReservas();
                        for (int i = 0; i < vecRese.size(); i++) {
                            if (vecRese.get(i).getCodigoClienteR().equals(getCodigoC())) {
                                vecRese.get(i).verReservasClien();
                            }
                        }
                        EntradaSalida.mostrarString("No hay mas reservas pendientes registradas a su nombre en el sistema.");
                        try {
                            sistemaDeReserva.serializar("catering.txt");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        EntradaSalida.mostrarString("Bienvenido/a al sistema, Sr(a) Cliente(a)\n\tNo hay reservas pendientes en el sistema ");
                    }
                    EntradaSalida.mostrarString("Muchas gracias, Sr(a) Cliente(a). Eso ha sido todo por ahora...");
                    break;
                case '2':
                    EntradaSalida.mostrarString("Gracias por Utilizar el Sistema");
                    seguir = false;
                    break;
                case '3':
                    EntradaSalida.mostrarString("Gracias por Utilizar el Sistema");
                    seguir = true;
                    break;

                default:
                    EntradaSalida.mostrarString("ERROR: Opcion invalida");
                    opc = '*';
            }
        } while (opc != '2' && opc != '3');

        return seguir;
    }

    /**
     * Metodo heredado de usuario muestra los datos del usuario de tipo cliente.
     */
    @Override
    public void mostrar() {
        EntradaSalida.mostrarString("Cliente - Usuario: " + getUsuario());
        EntradaSalida.mostrarString("Password: " + getPassword());
        EntradaSalida.mostrarString("Codigo unico de cliente: " + getCodigoC());
        EntradaSalida.mostrarString("--------------------\n");
    }

    /**
     * Este metodo es el encargado de mostrar los datos del cliente ingresados
     * por el coordinador.
     */
    public void mostrarData() {
        if (nombre == null) {
            EntradaSalida.mostrarString("Nombre del cliente:");
        } else {
            EntradaSalida.mostrarString("Nombre del cliente: " + nombre);
        }
        if (direccion == null) {
            EntradaSalida.mostrarString("Direccion de entrega:");
        } else {
            EntradaSalida.mostrarString("Direccion de entrega: " + direccion);
        }
        if (eMail == null) {
            EntradaSalida.mostrarString("Correo electronico:");
        } else {
            EntradaSalida.mostrarString("Correo electronico: " + eMail);
        }
        if (telefono == null) {
            EntradaSalida.mostrarString("Telefono:");
        } else {
            EntradaSalida.mostrarString("Telefono: " + telefono);
        }
        EntradaSalida.mostrarString("Codigo unico de cliente: " + getCodigoC());
        EntradaSalida.mostrarString("--------------------\n");
    }

}
