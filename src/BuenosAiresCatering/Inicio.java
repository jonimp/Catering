package BuenosAiresCatering;

import java.io.IOException;

/**
 * Esta clase se encarga de verificar si existe un sistema al momento de el
 * arranque del mismo, si existe valida usuario y contraseña para loguear sino
 * crea el primer usuario y contraseña (administrador)
 *
 * @author Alumno Franco Vilaseco
 */
public class Inicio {

    /**
     * Metodo que ejecuta el sistema verificando si hay serializado o no.
     */
    public void ejecutar() {

        SistemaDeReserva sistemaDeReserva = new SistemaDeReserva();
        Menu menu = new Menu();
        boolean seguir = false;
        try {
            sistemaDeReserva = sistemaDeReserva.deSerializar("catering.txt");
            EntradaSalida.mostrarString("SISTEMA DE CATERING\n");

            while (!seguir) {
                String usuario = EntradaSalida.leerString("Ingrese el usuario:");
                String password = EntradaSalida.leerString("Ingrese la password:");

                Usuario u = sistemaDeReserva.buscarUsuario(usuario + ":" + password);

                if (u == null) {
                    EntradaSalida.mostrarString("ERROR: La combinacion usuario/password ingresada no es valida.");
                } else {
                    seguir = u.proceder(sistemaDeReserva);
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            menu.cargar(sistemaDeReserva);
            String usuario = EntradaSalida.leerString("Arranque inicial del sistema.\nServicios iniciales cargados\n" + "Sr(a) Administrador(a), ingrese su nombre de usuario:");
            if (usuario.equals("")) {
                throw new NullPointerException("ERROR: El usuario no puede ser nulo.");
            }
            String password = EntradaSalida.leerString("ingrese su password:");
            if (password.equals("")) {
                throw new NullPointerException("ERROR: La password no puede ser nula.");
            }
            sistemaDeReserva.getUsuarios().add(new Administrador(usuario, password));
            try {
                sistemaDeReserva.serializar("catering.txt");
                EntradaSalida.mostrarString("El arranque ha sido exitoso. Ahora se debe reiniciar el sistema...");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }//Cierre del metodo
}//Cierre de la clase
