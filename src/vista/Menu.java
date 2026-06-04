package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase utilitaria encargada de gestionar la entrada de datos
 * desde teclado en los distintos menús de la aplicación.
 * <p>
 * Proporciona métodos para leer textos y opciones numéricas,
 * controlando posibles errores de introducción de datos.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Menu {

	/**
	 * Objeto Scanner utilizado para la lectura de datos por teclado.
	 */
	private static final Scanner TECLADO = new Scanner(System.in);

	/**
	 * Solicita al usuario la introducción de un texto.
	 *
	 * @param mensaje Mensaje que se mostrará al usuario.
	 * @return Texto introducido por el usuario.
	 */
	public static String leerTexto(String mensaje) {

		System.out.print(mensaje);
		return TECLADO.nextLine();
	}

	/**
	 * Solicita al usuario la introducción de una opción numérica.
	 * <p>
	 * Si el valor introducido no es un número válido, se muestra
	 * un mensaje de error y se vuelve a solicitar la entrada.
	 * </p>
	 *
	 * @param mensaje Mensaje que se mostrará al usuario.
	 * @return Opción numérica introducida por el usuario.
	 */
	public static int leerOpcion(String mensaje) {

		while(true) {

			System.out.print(mensaje);

			try {
				int opcion = TECLADO.nextInt();
				TECLADO.nextLine();
				return opcion;
			}
			catch(InputMismatchException e) {
				System.out.println("Introduce un numero valido");
				TECLADO.nextLine();
			}
		}
	}
}