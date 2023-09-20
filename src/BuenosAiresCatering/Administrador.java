package BuenosAiresCatering;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta clase es un tipo de usuario que tiene permisos de Administrador
 *
 * @author Alumno Franco Vilaseco
 */
public class Administrador extends Usuario implements Serializable {

    /**
     * Constructor del Administrador
     *
     * @param u nombre de usuario
     * @param p contraseña del usuario
     */
    public Administrador(String u, String p) {
        setUsuario(u);
        setPassword(p);
    }//cierre constructor

    /**
     * Metodo heredado de usuario muestra los datos del usuario de tipo
     * administrador.
     */
    @Override
    public void mostrar() {
        EntradaSalida.mostrarString("Administrador - Usuario: " + this.getUsuario());
        EntradaSalida.mostrarString("Password: " + this.getPassword());
        EntradaSalida.mostrarString("--------------------\n");
    }
    /**
     * Metodo heredado de usuario es el encargado de dar las opciones al
     * administrador, dar de alta servicios, clientes y coordinadores,
     * tambien permite ver los usuarios y servicios en el sistema.
     */
    @Override
    public boolean proceder(SistemaDeReserva sistemaDeReserva) {
        char opc;
        boolean seguir = true;
        AltaUsuario alta = new AltaUsuario();
        do {
            opc = EntradaSalida.leerChar(
                    "\n\t\tOPCIONES DEL ADMINISTRADOR\n"
                    + "\t[1] Dar de alta un servicio\n"
                    + "\t[2] Dar de alta un coordinador de eventos\n"
                    + "\t[3] Dar de alta un cliente\n"
                    + "\t[4] Listar usuarios\n"
                    + "\t[5] Listar servicios\n"
                    + "\t[6] Cerrar Sesion\n"
                    + "\t[7] Cerrar Sesion y Salir del sistema\n");
            switch (opc) {
                case '1':
                    String nombre = EntradaSalida.leerString("ALTA DE SERVICIO\nNombre del servicio:");
                    if (nombre.equals("")) {
                        EntradaSalida.mostrarString("ERROR: nombre no valido");
                    } else {
                        String menu = EntradaSalida.leerString("Menu que incluye el servicio:");
                        if (menu.equals("")) {
                            EntradaSalida.mostrarString("ERROR: entrada invalida");
                        }
                        int precio = EntradaSalida.leerEntero("Precio del servicio:");

                        if (menu.equals("") || precio == 0) {
                            EntradaSalida.mostrarString("ERROR: entrada invalida");
                        } else {
                            Servicio servicio = new Servicio();
                            servicio.setNombre(nombre);
                            servicio.setMenu(menu);
                            servicio.setPrecio(precio);
                            sistemaDeReserva.getServicios().add(servicio);
                            EntradaSalida.mostrarString("Se ha incorporado el servicio al sistema");
                        }

                    }

                    break;

                case '2':
                    alta.darAltaCoordinador(sistemaDeReserva);
                    break;

                case '3':
                    alta.darAltaCliente(sistemaDeReserva);
                    break;

                case '4':
                    EntradaSalida.mostrarString("\t\n====================================");
                    EntradaSalida.mostrarString("\tUsuarios\n");
                    ArrayList<Usuario> vecUsua = sistemaDeReserva.getUsuarios();
                    for (int i = 0; i < vecUsua.size(); i++) {
                        vecUsua.get(i).mostrar();
                    }
                    EntradaSalida.mostrarString("\t\n====================================");
                    break;
                case '5':
                    EntradaSalida.mostrarString("\t\n====================================");
                    EntradaSalida.mostrarString("\tServicios\n");
                    ArrayList<Servicio> vecSer = sistemaDeReserva.getServicios();
                    if (vecSer.isEmpty()) {
                        EntradaSalida.mostrarString("\tNo hay servicios registrados en el sistema.");
                    } else {
                        for (int i = 0; i < vecSer.size(); i++) {
                            vecSer.get(i).mostrar();
                        }
                    }
                    EntradaSalida.mostrarString("\t\n====================================");
                    break;

                case '6':
                    EntradaSalida.mostrarString("Gracias por Utilizar el Sistema");
                    seguir = false;
                    break;
                case '7':
                    EntradaSalida.mostrarString("Gracias por Utilizar el Sistema");
                    seguir = true;
                    break;
                default:
                    EntradaSalida.mostrarString("ERROR: Opcion invalida");
                    opc = '*';
            }
            if (opc >= '1' && opc <= '3') {
                try {
                    sistemaDeReserva.serializar("catering.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } while (opc != '6' && opc != '7');

        return seguir;
    }
}
