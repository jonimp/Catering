package BuenosAiresCatering;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta clase es un tipo de usuario que tiene permisos de Coordinador
 *
 * @author Alumno Franco Vilaseco
 */
public class Coordinador extends Usuario implements Serializable {

    /**
     * Constructor del coordinador
     *
     * @param u nombre de usuario
     * @param p contraseña del usuario
     */
    public Coordinador(String u, String p) {
        setUsuario(u);
        setPassword(p);
    }//cierre del constructor

    /**
     * Metodo heredado de usuario es el encargado de dar las opciones al
     * coordinador, gestionar datos y reservas clientes.
     */
    @Override
    public boolean proceder(SistemaDeReserva sistemaDeReserva) {
        char opc;
        boolean seguir = true;
        do {
            opc = EntradaSalida.leerChar(
                    "\n\t\tOPCIONES DEL COORDINADOR\n"
                    + "\t[1] Cargar datos de cliente\n"
                    + "\t[2] Crear reserva de cliente\n"
                    + "\t[3] Finalizar reserva y quitarla del sistema\n"
                    + "\t[4] Ver clientes\n"
                    + "\t[5] Cerrar Sesion\n"
                    + "\t[6] Cerrar Sesion y Salir del sistema\n");
            switch (opc) {
                case '1':
                    ArrayList<Cliente> ListadoClientes = sistemaDeReserva.getClientes();
                    if (ListadoClientes.isEmpty()) {
                        EntradaSalida.mostrarString("ERROR: Primero deben darse de alta los clientes");
                    } else {
                        ArrayList<Cliente> clienCargado = new ArrayList<>();
                        String clientesStr = "";
                        String codCliente;
                        Cliente clien = null;
                        boolean opcValida;
                        for (int i = 0; i < ListadoClientes.size(); i++) {
                            clien = ListadoClientes.get(i);
                            clientesStr = clientesStr + clien.getCodigoC() + " - " + clien.getUsuario() + '\n';
                        }
                        codCliente = EntradaSalida.leerString(clientesStr + "Elija un cliente, ingresando su codigo: ");
                        int i = 0;
                        opcValida = false;
                        while (i < ListadoClientes.size() && !opcValida) {
                            clien = ListadoClientes.get(i);
                            if (clien.getCodigoC().equals(codCliente)) {
                                opcValida = true;
                            } else {
                                i++;
                            }
                        }
                        if (!opcValida || clienCargado.contains(clien)) {
                            EntradaSalida.mostrarString("ERROR: codigo no valido");
                        } else {
                            String nombre = EntradaSalida.leerString("INGRESO DE DATOS\nNombre del cliente:");
                            if (nombre.equals("")) {
                                EntradaSalida.mostrarString("ERROR: nombre no valido");
                            } else {
                                String direcc = EntradaSalida.leerString("Direccion de entrega:");
                                if (direcc.equals("")) {
                                    EntradaSalida.mostrarString("ERROR: Direccion no valida");
                                } else {
                                    String eMail = EntradaSalida.leerString("Direccion de correo electronico:");
                                    if (eMail.equals("")) {
                                        EntradaSalida.mostrarString("ERROR: Direccion no valida");
                                    } else {
                                        String tel = EntradaSalida.leerString("Numero de telefono:");
                                        if (tel.equals("")) {
                                            EntradaSalida.mostrarString("ERROR: Direccion no valida");
                                        } else {
                                            clien.setNombre(nombre);
                                            clien.setDireccion(direcc);
                                            clien.setEMail(eMail);
                                            clien.setTelefono(tel);
                                            clienCargado.add(clien);
                                            EntradaSalida.mostrarString("Se cargaron los datos del cliente en el sistema");

                                        }
                                    }
                                }
                            }
                        }
                    }

                    break;

                case '2':
                    ArrayList<Cliente> ListadoClientes2 = sistemaDeReserva.getClientes();
                    ArrayList<Servicio> ListadoServicios = sistemaDeReserva.getServicios();
                    if (ListadoClientes2.isEmpty()) {
                        EntradaSalida.mostrarString("ERROR: Primero deben darse de alta los clientes");
                    } else {
                        EntradaSalida.mostrarString("CREACION DE RESERVA\n");
                        String clientesStr = "";
                        String codCliente;
                        int numIden;
                        Cliente clien;
                        boolean opcValida;
                        boolean masServicios = true;
                        for (int i = 0; i < ListadoClientes2.size(); i++) {
                            clien = ListadoClientes2.get(i);
                            clientesStr = clientesStr + clien.getCodigoC() + " - " + clien.getUsuario() + '\n';
                        }

                        codCliente = EntradaSalida.leerString(clientesStr + "Elija un cliente, ingresando su codigo: ");
                        int i = 0;
                        opcValida = false;
                        while (i < ListadoClientes2.size() && !opcValida) {
                            clien = ListadoClientes2.get(i);
                            if (clien.getCodigoC().equals(codCliente)) {
                                opcValida = true;
                            } else {
                                i++;
                            }
                        }
                        if (!opcValida) {
                            EntradaSalida.mostrarString("ERROR: codigo no valido");
                        } else {
                            String tipoReserv = EntradaSalida.leerString("Indique como se realizo la reserva(telefono, email, presencial):");
                            if (tipoReserv.equals("")) {
                                EntradaSalida.mostrarString("ERROR: tipo de reserva invalido");
                            } else {
                                String fechaReserv = EntradaSalida.leerString("Indique la fecha de la reserva:");
                                if (fechaReserv.equals("")) {
                                    EntradaSalida.mostrarString("ERROR: fecha invalida");
                                } else {
                                    String horaI = EntradaSalida.leerString("Indique el horario de inicio:");
                                    if (horaI.equals("")) {
                                        EntradaSalida.mostrarString("ERROR: horario invalido");
                                    } else {
                                        String horaF = EntradaSalida.leerString("Indique el horario de finalizacion:");
                                        if (horaF.equals("")) {
                                            EntradaSalida.mostrarString("ERROR: horario invalido");
                                        } else {
                                            String tipoServ = EntradaSalida.leerString("Indique el tipo de servicio:");
                                            if (tipoServ.equals("")) {
                                                EntradaSalida.mostrarString("ERROR: tipo de servicio invalido");
                                            } else {
                                                String resDietet = EntradaSalida.leerString("Especifique las restricciones dieteticas(escribir Ninguna si no hay):");
                                                if (tipoServ.equals("")) {
                                                    EntradaSalida.mostrarString("ERROR: No puede dejarse vacio (escribir Ninguna si no hay)");
                                                } else {
                                                    String prefClien = EntradaSalida.leerString("Especifique las preferencias del cliente(escribir Ninguna si no hay):");
                                                    if (tipoServ.equals("")) {
                                                        EntradaSalida.mostrarString("ERROR: No puede dejarse vacio (escribir Ninguna si no hay)");
                                                    } else {
                                                        Reserva reserva = new Reserva();
                                                        while (masServicios) {
                                                            for (int j = 0; j < ListadoServicios.size(); j++) {
                                                                ListadoServicios.get(j).mostrar(j + 1);
                                                            }
                                                            numIden = EntradaSalida.leerEntero("Elija un servicio, ingresando el numero identificador (0 para salir): ");
                                                            if (numIden - 1 >= ListadoServicios.size() || numIden - 1 < 0) {
                                                                if (numIden != 0) {
                                                                    EntradaSalida.mostrarString("ERROR: Identificador invalido");
                                                                }
                                                                masServicios = false;
                                                            } else {
                                                                reserva.addServicio(numIden - 1, ListadoServicios);
                                                            }
                                                        }
                                                        reserva.setCodigoClienteR(codCliente);
                                                        reserva.setTipoReserva(tipoReserv);
                                                        reserva.setFechaReserva(fechaReserv);
                                                        reserva.setHoraInicio(horaI);
                                                        reserva.setHoraFin(horaF);
                                                        reserva.setRestriccionesDieteticas(resDietet);
                                                        reserva.setPreferenciasClientes(prefClien);
                                                        reserva.setTipoServicio(tipoServ);
                                                        sistemaDeReserva.getReservas().add(reserva);
                                                        EntradaSalida.mostrarString("Se incorporo la reserva al sistema ");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case '3':
                    int numIden;
                    if (!sistemaDeReserva.getReservas().isEmpty()) {
                        ArrayList<Reserva> vecRese = sistemaDeReserva.getReservas();
                        ArrayList<Cliente> vecClien = sistemaDeReserva.getClientes();
                        for (int i = 0; i < vecRese.size(); i++) {
                            vecRese.get(i).verReservasCoordi(i, vecClien);
                        }
                        numIden = EntradaSalida.leerEntero("Elija una reserva, ingresando el numero identificador (0 para cancelar): ");
                        if (numIden - 1 >= vecRese.size() || numIden - 1 < 0) {
                            if (numIden != 0) {
                                EntradaSalida.mostrarString("ERROR: Identificador invalido");
                            } else {
                                EntradaSalida.mostrarString("Operacion cancelada");
                            }
                        } else {
                            String resp = EntradaSalida.leerString("Esta seguro de que quiere dar esta reserva por finalizada y sacarla del sistema?\n\tS/N\n");
                            if (resp.equals("S")) {
                                vecRese.remove(numIden - 1);
                                EntradaSalida.mostrarString("Reserva Finalizada");
                            } else {
                                if (resp.equals("N")) {
                                    EntradaSalida.mostrarString("Operacion cancelada");
                                } else {
                                    EntradaSalida.mostrarString("ERROR: Opcion invalida\n\tOperacion cancelada");
                                }

                            }
                        }
                    } else {
                        EntradaSalida.mostrarString("No hay reservas en el sistema");
                    }
                    break;
                case '4':
                    EntradaSalida.mostrarString("\t\n=============================================");
                    EntradaSalida.mostrarString("\tClientes");
                    ArrayList<Cliente> vecClien = sistemaDeReserva.getClientes();
                    for (int i = 0; i < vecClien.size(); i++) {
                        vecClien.get(i).mostrarData();
                    }
                    break;
                case '5':
                    EntradaSalida.mostrarString("\tGracias por Utilizar el Sistema");
                    seguir = false;
                    break;
                case '6':
                    EntradaSalida.mostrarString("\tGracias por Utilizar el Sistema");
                    seguir = true;
                    break;
                default:
                    EntradaSalida.mostrarString("ERROR: Opcion invalida");
                    opc = '*';
            }

            if (opc == '1' || opc == '3') {
                try {
                    sistemaDeReserva.serializar("catering.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } while (opc != '5' && opc != '6');
        return seguir;
    }

    /**
     * Metodo heredado de usuario muestra los datos del usuario de tipo
     * coordinador.
     */
    @Override
    public void mostrar() {
        EntradaSalida.mostrarString("Coordinador - Usuario: " + this.getUsuario());
        EntradaSalida.mostrarString("Password: " + this.getPassword());
        EntradaSalida.mostrarString("--------------------\n");
    }

}
