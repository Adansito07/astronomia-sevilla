package vista;

import java.util.Scanner;

import dao.DaoActividades;
import dao.DaoMateriales;
import dto.Actividad;
import dto.MaterialAstronomico;

/**
 * Clase encargada de mostrar el menú principal del monitor.
 * <p>
 * Desde esta vista el monitor puede consultar las actividades,
 * los materiales astronómicos registrados y los materiales disponibles.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class VistaMonitor {

	/**
	 * Muestra el menú del monitor y permite acceder a las consultas
	 * disponibles para este tipo de usuario.
	 * <p>
	 * El menú permanece activo hasta que el monitor decide volver.
	 * </p>
	 */
	public static void mostrarMenu() {

		Scanner a = new Scanner(System.in);
		DaoActividades daoActividades = new DaoActividades();
		DaoMateriales daoMateriales = new DaoMateriales();
		int opcion;

		do {
			System.out.println();
			System.out.println("================================");
			System.out.println("          MENU MONITOR");
			System.out.println("================================");
			System.out.println("1. Consultar actividades");
			System.out.println("2. Consultar materiales");
			System.out.println("3. Consultar materiales disponibles");
			System.out.println("0. Volver");
			System.out.print("Opcion: ");

			try {
				opcion = Integer.parseInt(a.nextLine());
			} catch(NumberFormatException e) {
				opcion = -1;
			}

			try {

				switch(opcion) {

					case 1:

						System.out.println();
						System.out.println("===== ACTIVIDADES DISPONIBLES =====");

						for(Actividad actividad : daoActividades.listar()) {
							System.out.println(actividad);
						}

						break;

					case 2:

						System.out.println();
						System.out.println("===== MATERIAL ASTRONOMICO =====");

						for(MaterialAstronomico material : daoMateriales.listar()) {
							System.out.println(material);
						}

						break;

					case 3:

						System.out.println();
						System.out.println("===== MATERIAL DISPONIBLE =====");

						for(MaterialAstronomico material : daoMateriales.listarDisponibles()) {
							System.out.println(material);
						}

						break;

					case 0:

						System.out.println("Volviendo...");
						break;

					default:

						System.out.println("Opcion no valida");
				}

			} catch(Exception e) {

				System.out.println("Error en el menu de monitor");
				System.out.println(e.getMessage());
			}

		} while(opcion != 0);
	}
}