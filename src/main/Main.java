package main;

import vista.InicioSesion;

/**
 * Clase principal de la aplicación Astronomía Sevilla.
 * <p>
 * Contiene el punto de entrada del programa y se encarga de iniciar
 * el proceso de autenticación mediante la clase {@link InicioSesion}.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Main {

	/**
	 * Método principal de la aplicación.
	 * <p>
	 * Crea una instancia de la clase InicioSesion y ejecuta el proceso
	 * de acceso al sistema.
	 * </p>
	 *
	 * @param args Argumentos de línea de comandos (no utilizados).
	 */
	public static void main(String[] args) {

		InicioSesion inicioSesion = new InicioSesion();
		inicioSesion.iniciar();

	}
}