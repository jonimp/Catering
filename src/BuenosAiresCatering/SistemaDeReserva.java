package BuenosAiresCatering;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Esta clase es el propio Sistema de reserva que funciona como base de datos
 *
 * @author Alumno Franco Vilaseco
 */
public class SistemaDeReserva implements Serializable {

    /**
     * Constructor del sistema de reserva.
     */
    public SistemaDeReserva() {
        usuarios = new ArrayList<>();
        servicios = new ArrayList<>();
        clientes = new ArrayList<>();
        reservas = new ArrayList<>();
    }//Cierre constructor

    private ArrayList<Usuario> usuarios;
    private ArrayList<Servicio> servicios;
    private ArrayList<Cliente> clientes;
    private ArrayList<Reserva> reservas;

    /**
     * Este metodo se encarga de recuperar los datos guardados en el archivo
     * pasado por parametro
     *
     * @throws IOException
     * @throws ClassNotFoundException
     * @param a es el nombre del archivo
     * @return devuelve los datos recuperados al sistema
     */
    public SistemaDeReserva deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        SistemaDeReserva s = (SistemaDeReserva) o.readObject();
        o.close();
        f.close();
        return s;
    }

    /**
     * Este metodo se encarga de guardar los datos del sistema en el archivo
     * pasado por parametro
     *
     * @throws IOException
     * @param a es el nombre del archivo
     */
    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    /**
     * Este metodo se encarga de buscar un usuario especifico en la lista de
     * usuarios
     *
     * @param datos son los datos necesarios para encontrar al usuario
     * @return devuelve el usuario encontrado o null si no se encontro.
     */
    public Usuario buscarUsuario(String datos) {
        int i = 0;
        boolean encontrado = false;
        Usuario u = null;

        while (i < usuarios.size() && !encontrado) {
            u = usuarios.get(i);
            if (datos.equals(u.getUsuario() + ":" + u.getPassword())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            return null;
        } else {
            return u;
        }
    }

    /**
     * Metodo que obtiene los datos del Usuario
     *
     * @return devuelve los datos de la variable usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Metodo que guarda los datos del Usuario pasado por parametro en la
     * variable usuarios
     *
     * @param usuarios es el string que se guardara en la variable
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Metodo que obtiene los datos del Servicio
     *
     * @return devuelve los datos de la variable servicios
     */
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    /**
     * Metodo que guarda el Servicio pasado por parametro en la variable
     * servicios
     *
     * @param servicios es el string que se guardara en la variable
     */
    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    /**
     * Metodo que obtiene los datos del Cliente
     *
     * @return devuelve los datos de la variable clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Metodo que guarda el Cliente pasado por parametro en la variable clientes
     *
     * @param clientes es el string que se guardara en la variable
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Metodo que obtiene los datos de la reserva
     *
     * @return devuelve los datos de la variable reservas
     */
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Metodo que guarda la Reserva pasada por parametro en la variable reservas
     *
     * @param reservas es el string que se guardara en la variable
     */
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
}
