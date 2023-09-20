package BuenosAiresCatering;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta clase es la encargada de guardar todos los datos acerca de una reserva y
 * poder mostrarlos cuando se deseen
 *
 * @author Alumno Franco Vilaseco
 */
public class Reserva implements Serializable {

    /**
     * Constructor de la clase Reserva
     */
    public Reserva() {
        servRese = new ArrayList<>();
    }//Cierre del constructor

    private ArrayList<Servicio> servRese;
    private String codigoClienteR;
    private String tipoReserva;
    private String fechaReserva;
    private String horaInicio;
    private String horaFin;
    private String tipoServicio;
    private String restDiet;
    private String prefClien;

    /**
     * Metodo que obtiene el String de codigoClienteR
     *
     * @return el String de la variable codigoClienteR
     */
    public String getCodigoClienteR() {
        return codigoClienteR;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable
     * codigoClienteR
     *
     * @param codigoClienteR es el string que se guardara en la variable
     */
    public void setCodigoClienteR(String codigoClienteR) {
        this.codigoClienteR = codigoClienteR;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable
     * tipoReserva
     *
     * @param tipoReserva es el string que se guardara en la variable
     */
    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable
     * fechaReserva
     *
     * @param fechaReserva es el string que se guardara en la variable
     */
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable
     * horaInicio
     *
     * @param horaInicio es el string que se guardara en la variable
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable horaFin
     *
     * @param horaFin es el string que se guardara en la variable
     */
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable
     * tipoServicio
     *
     * @param tipoServicio es el string que se guardara en la variable
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable restDiet
     *
     * @param restDiet es el string que se guardara en la variable
     */
    public void setRestriccionesDieteticas(String restDiet) {
        this.restDiet = restDiet;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable prefClien
     *
     * @param prefClien es el string que se guardara en la variable
     */
    public void setPreferenciasClientes(String prefClien) {
        this.prefClien = prefClien;
    }

    /**
     * Metodo que guarda un servicio guardado en un ArrayList pasado por
     * parametro dentro de un ArrayList local
     *
     * @param numIden numero de indice en el que se encuentra el servicio que se
     * quiere guardar
     * @param ListadoServicios es el array list del que se saca el servicio a
     * guardar
     */
    public void addServicio(int numIden, ArrayList<Servicio> ListadoServicios) {
        servRese.add(ListadoServicios.get(numIden));
    }

    /**
     * Este metodo se encarga de mostrar los datos de la reserva desde el punto
     * de vista de un cliente.
     */
    public void verReservasClien() {
        EntradaSalida.mostrarString("\t\n==========================");
        EntradaSalida.mostrarString("Como se realizo la reserva: " + tipoReserva);
        EntradaSalida.mostrarString("Fecha de reserva: " + fechaReserva);
        EntradaSalida.mostrarString("Hora de inicio: " + horaInicio);
        EntradaSalida.mostrarString("Hora de fin: " + horaFin);
        EntradaSalida.mostrarString("Tipo del servicio: " + tipoServicio);
        EntradaSalida.mostrarString("~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        EntradaSalida.mostrarString("ATENCION\n\tRestricciones dieteticas: " + restDiet);
        EntradaSalida.mostrarString("Preferencias del cliente: " + prefClien);
        EntradaSalida.mostrarString("Servicios elegidos: ");
        for (int j = 0; j < servRese.size(); j++) {
            servRese.get(j).mostrar();
        }
    }

    /**
     * Este metodo se encarga de mostrar los datos de la reserva desde el punto
     * de vista de un coordinador (incluye numero identificador de resreva y
     * codigo de cliente)
     *
     * @param i se utiliza como indice para apuntar al cliente y numero de
     * reserva especifico
     * @param vecClien es un ArrayList de los clientes
     */
    public void verReservasCoordi(int i, ArrayList<Cliente> vecClien) {
        EntradaSalida.mostrarString("\t\n==========================");
        EntradaSalida.mostrarString("Numero Identificador: " + (i + 1));
        EntradaSalida.mostrarString("Codigo de cliente: " + vecClien.get(i).getCodigoC());
        EntradaSalida.mostrarString("Como se realizo la reserva: " + tipoReserva);
        EntradaSalida.mostrarString("Fecha de reserva: " + fechaReserva);
        EntradaSalida.mostrarString("Hora de inicio: " + horaInicio);
        EntradaSalida.mostrarString("Hora de fin: " + horaFin);
        EntradaSalida.mostrarString("Tipo del servicio: " + tipoServicio);
        EntradaSalida.mostrarString("~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        EntradaSalida.mostrarString("ATENCION\n\tRestricciones dieteticas: " + restDiet);
        EntradaSalida.mostrarString("Preferencias del cliente: " + prefClien);
        EntradaSalida.mostrarString("Servicios elegidos: ");
        for (int j = 0; j < servRese.size(); j++) {
            servRese.get(j).mostrar();
        }
    }
}
