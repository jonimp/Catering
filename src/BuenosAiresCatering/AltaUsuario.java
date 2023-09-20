package BuenosAiresCatering;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta clase es la encargada de dar de alta los distintos tipos de usuario
 *
 * @author Alumno Franco Vilaseco
 */
public class AltaUsuario implements Serializable {

    /**
     * Este metodo es el encargado de dar de alta a un usuario de tipo Cliente
     *
     * @param sistemaDeReserva se pasa el sistema para poder acceder a los
     * clientes
     */
    public void darAltaCliente(SistemaDeReserva sistemaDeReserva) {

        String usClien = EntradaSalida.leerString("ALTA DE CLIENTE\nIngrese el usuario:");
        if (usClien.equals("")) {
            EntradaSalida.mostrarString("ERROR: usuario no valido\n");
        } else {
            String paClien = EntradaSalida.leerString("Ingrese la password:");
            if (paClien.equals("")) {
                EntradaSalida.mostrarString("ERROR: password no valida\n");
            } else {
                Usuario u = sistemaDeReserva.buscarUsuario(usClien + ":" + paClien);
                if (u != null) {
                    EntradaSalida.mostrarString("ERROR: El usuario ya figura en el sistema\n");
                } else {

                    ArrayList<Cliente> ListadoClientes = sistemaDeReserva.getClientes();
                    ArrayList<String> ListadoCodigosC = new ArrayList<>();
                    for (int i = 0; i < ListadoClientes.size(); i++) {
                        ListadoCodigosC.add(ListadoClientes.get(i).getCodigoC());
                    }
                    String codigoC = EntradaSalida.leerString("Ingrese codigo unico de cliente:");
                    if (codigoC.equals("")) {
                        EntradaSalida.mostrarString("ERROR: codigo no valido");
                    } else {
                        if (ListadoCodigosC.contains(codigoC)) {
                            EntradaSalida.mostrarString("ERROR: El codigo ya figura en el sistema");
                        } else {
                            u = new Cliente(usClien, paClien);
                            u.setCodigoC(codigoC);
                            sistemaDeReserva.getUsuarios().add(u);
                            sistemaDeReserva.getClientes().add((Cliente) u);
                            EntradaSalida.mostrarString("Se ha incorporado el Cliente al sistema");
                        }
                    }
                }
            }
        }

    }

    /**
     * Este metodo es el encargado de dar de alta a un usuario de tipo
     * Coordinador
     *
     * @param sistemaDeReserva se pasa el sistema para poder acceder a los
     * coordinadores
     */
    public void darAltaCoordinador(SistemaDeReserva sistemaDeReserva) {

        String usCoord = EntradaSalida.leerString("ALTA DE COORDINADOR DE EVENTOS\nIngrese el usuario:");
        if (usCoord.equals("")) {
            EntradaSalida.mostrarString("ERROR: usuario no valido");
        } else {
            String paCoord = EntradaSalida.leerString("Ingrese la password:");
            if (paCoord.equals("")) {
                EntradaSalida.mostrarString("ERROR: password no valida");
            } else {
                Usuario u = sistemaDeReserva.buscarUsuario(usCoord + ":" + paCoord);
                if (u != null) {
                    EntradaSalida.mostrarString("ERROR: El usuario ya figura en el sistema");
                } else {
                    u = new Coordinador(usCoord, paCoord);
                    sistemaDeReserva.getUsuarios().add(u);
                    EntradaSalida.mostrarString("Se ha incorporado el Coordinador al sistema");
                }
            }
        }

    }
}
