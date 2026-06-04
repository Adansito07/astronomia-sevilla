package vista;

import java.util.Scanner;

/**
 * Clase encargada de gestionar el inicio de sesión de los usuarios
 * de la aplicación.
 * <p>
 * Permite el acceso al sistema mediante tres perfiles:
 * administrador, socio y monitor.
 * Cada perfil dispone de unas credenciales específicas y acceso
 * a diferentes funcionalidades de la aplicación.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class InicioSesion {

	/**
	 * Nombre de usuario del administrador.
	 */
	private static final String USUARIO_ADMIN = "admin";

	/**
	 * Contraseña del administrador.
	 */
	private static final String CLAVE_ADMIN = "Admin123";

	/**
	 * Nombre de usuario del socio.
	 */
	private static final String USUARIO_SOCIO = "socio";

	/**
	 * Contraseña del socio.
	 */
	private static final String CLAVE_SOCIO = "Socio123";

	/**
	 * Nombre de usuario del monitor.
	 */
	private static final String USUARIO_MONITOR = "monitor";

	/**
	 * Contraseña del monitor.
	 */
	private static final String CLAVE_MONITOR = "Monitor123";

	/**
	 * Número máximo de intentos permitidos para iniciar sesión.
	 */
	private static final int MAX_INTENTOS = 3;

	/**
	 * Inicia el proceso de autenticación del usuario.
	 * <p>
	 * Solicita las credenciales de acceso y verifica si corresponden
	 * a un administrador, socio o monitor. Si las credenciales son
	 * correctas, se muestra el menú correspondiente al perfil.
	 * </p>
	 * <p>
	 * El usuario dispone de un número limitado de intentos. Si se supera
	 * el máximo permitido, la aplicación finaliza su ejecución.
	 * </p>
	 */
	public void iniciar() {

		Scanner a = new Scanner(System.in);

		int intentos = 0;
		boolean accesoConcedido = false;

		System.out.println("========================================");
		System.out.println("         ASTRONOMIA SEVILLA");
		System.out.println("========================================");

		while(!accesoConcedido && intentos < MAX_INTENTOS) {

			System.out.print("Usuario: ");
			String usuario = a.nextLine();

			System.out.print("Contrasena: ");
			String clave = a.nextLine();

			if(usuario.equals(USUARIO_ADMIN) && clave.equals(CLAVE_ADMIN)) {

				System.out.println("\nAcceso concedido como Administrador\n");
				accesoConcedido = true;
				VistaAdmin.mostrarMenu();

			} else if(usuario.equals(USUARIO_SOCIO) && clave.equals(CLAVE_SOCIO)) {

				System.out.println("\nAcceso concedido como Socio\n");
				accesoConcedido = true;
				VistaSocio.mostrarMenu();

			} else if(usuario.equals(USUARIO_MONITOR) && clave.equals(CLAVE_MONITOR)) {

				System.out.println("\nAcceso concedido como Monitor\n");
				accesoConcedido = true;
				VistaMonitor.mostrarMenu();

			} else {

				intentos++;

				System.out.println("\n========================================");
				System.out.println("ERROR: Usuario o contrasena incorrectos");
				System.out.println("Intentos restantes: " + (MAX_INTENTOS - intentos));
				System.out.println("========================================\n");
			}
		}

		if(!accesoConcedido) {

			System.out.println("========================================");
			System.out.println("Demasiados intentos fallidos");
			System.out.println("La aplicacion se cerrara");
			System.out.println("========================================");
		}
	}
}