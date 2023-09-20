package BuenosAiresCatering;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase se encarga de gestionar todas las entradas y salidas de la consola
 * tanto como ingresar o mostrar datos por consola
 *
 * @author Alumno Franco Vilaseco
 */
public class EntradaSalida {

    /**
     * Este metodo se encarga de mostrar por consola un string y leer un
     * caracter por teclado
     *
     * @param texto El parametro texto es el string que se desea mostrar por
     * consola
     * @return devuelve el caracter leido, si no se ingreso nada devuelve 0
     */
    public static char leerChar(String texto) {
        String st;
        Scanner teclado = new Scanner(System.in);
        System.out.print(texto);
        st = teclado.nextLine();
        return (st == null || st.length() == 0 ? '0' : st.charAt(0));
    }

    /**
     * Este metodo se encarga de mostrar por consola un string y leer un string
     * por teclado
     *
     * @param s El parametro s es el string que se desea mostrar por consola
     * @return devuelve el string leido, si no se ingreso nada devuelve ""
     */
    public static String leerString(String s) {
        String st;
        Scanner teclado = new Scanner(System.in);
        System.out.print(s);
        st = teclado.nextLine();
        return (st == null ? "" : st);
    }

    /**
     * Este metodo se encarga de mostrar por consola un string y leer un entero
     * por teclado
     *
     * @param s El parametro s es el string que se desea mostrar por consola
     * @return devuelve el entero leido
     */
    public static int leerEntero(String s) {
        int i = 0;
        try {
            Scanner teclado = new Scanner(System.in);
            System.out.print(s);
            i = teclado.nextInt();
        } catch (InputMismatchException e) {
            EntradaSalida.mostrarString("ERROR: no colocaste un numero");
        }
        return i;
    }

    /**
     * Este metodo se encarga de mostrar un string por consola
     *
     * @param s El parametro s es el string que se desea mostrar por consola
     */
    public static void mostrarString(String s) {
        System.out.println("\t" + s);
    }

}
