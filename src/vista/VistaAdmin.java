package vista;

import java.util.Scanner;

/**
 * Clase encargada de mostrar el menú principal del administrador.
 * <p>
 * Desde este menú el administrador puede acceder a las distintas
 * opciones de gestión de la aplicación, como socios, actividades,
 * monitores y materiales astronómicos.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class VistaAdmin {

	/**
	 * Muestra el menú de administración y gestiona la navegación
	 * hacia las diferentes vistas de gestión del sistema.
	 * <p>
	 * El menú permanece activo hasta que el administrador decide salir.
	 * </p>
	 */
	public static void mostrarMenu() {

		Scanner a = new Scanner(System.in);
		int opcion;

		do {
			System.out.println();
			System.out.println("================================");
			System.out.println("           MENU ADMIN");
			System.out.println("================================");
			System.out.println("1. Gestionar socios");
			System.out.println("2. Gestionar actividades");
			System.out.println("3. Gestionar monitores");
			System.out.println("4. Gestionar materiales");
			System.out.println("0. Volver");
			System.out.print("Opcion: ");

			try {
				opcion = Integer.parseInt(a.nextLine());
			} catch(NumberFormatException e) {
				opcion = -1;
			}

			switch(opcion) {

				case 1:
					VistaGestionSocios.mostrarMenu();
					break;

				case 2:
					VistaGestionActividades.mostrarMenu();
					break;

				case 3:
					VistaGestionMonitores.mostrarMenu();
					break;

				case 4:
					VistaGestionMateriales.mostrarMenu();
					break;

				case 0:
					System.out.println("Volviendo...");
					break;

				default:
					System.out.println("Opcion no valida");
			}

		} while(opcion != 0);
	}
}