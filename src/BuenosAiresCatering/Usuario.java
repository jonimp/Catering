package BuenosAiresCatering;

import java.io.Serializable;

/**
 * Esta clase es la encargada de guardar todos los datos acerca de un usuario y
 * poder mostrarlos cuando se deseen, ademas se encarga de gestionar los
 * permisos de cada tipo de usuario haciendo metodos abstractos
 *
 * @author Alumno Franco Vilaseco
 */
public abstract class Usuario implements Serializable {

    private String codigoC;
    private String usuario;
    private String password;

    /**
     * Metodo que obtiene el String de codigoC
     *
     * @return el valor de la variable codigoC
     */
    public String getCodigoC() {
        return codigoC;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable codigoC
     *
     * @param codigoC es el string que se guardara en la variable
     */
    public void setCodigoC(String codigoC) {
        this.codigoC = codigoC;
    }

    /**
     * Metodo que obtiene el String de usuario
     *
     * @return devuelve el String de la variable usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable usuario
     *
     * @param usuario es el string que se guardara en la variable
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo que obtiene el String de password
     *
     * @return devuelve el String de la variable password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo que guarda el String pasado por parametro en la variable password
     *
     * @param password es el string que se guardara en la variable
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo Abstracto se encargara de gestionar el sistema para el tipo de
     * usuario logueado
     *
     * @param sistemaDeReserva es el sistema de reserva
     * @return boolean
     */
    public abstract boolean proceder(SistemaDeReserva sistemaDeReserva);

    /**
     * Metodo Abstracto se encargara de mostrar los datos del usuario.
     */
    public abstract void mostrar();
}
