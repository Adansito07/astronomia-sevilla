package vista;

import java.util.Scanner;

import dao.DaoMonitores;
import dto.Monitor;
import excepciones.DatosInvalidosException;
import util.Validador;

/**
 * Clase encargada de mostrar el menú de gestión de monitores.
 * <p>
 * Desde esta vista el administrador puede listar, crear, modificar
 * y eliminar monitores de la asociación astronómica.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class VistaGestionMonitores {

	/**
	 * Muestra el menú de gestión de monitores y permite realizar
	 * las operaciones principales sobre los monitores del sistema.
	 * <p>
	 * También valida los datos introducidos por el usuario, como el
	 * DNI, el nombre y la especialidad del monitor.
	 * </p>
	 */
	public static void mostrarMenu() {

		Scanner a = new Scanner(System.in);
		DaoMonitores daoMonitores = new DaoMonitores();
		int opcion;

		do {
			System.out.println();
			System.out.println("================================");
			System.out.println("       GESTION DE MONITORES");
			System.out.println("================================");
			System.out.println("1. Listar monitores");
			System.out.println("2. Nuevo monitor");
			System.out.println("3. Modificar monitor");
			System.out.println("4. Eliminar monitor");
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
						for(Monitor monitor : daoMonitores.listar()) {
							System.out.println(monitor);
						}
						break;

					case 2:
						Monitor nuevo = new Monitor();

						System.out.print("DNI: ");
						nuevo.setDni(a.nextLine());

						System.out.print("Nombre: ");
						nuevo.setNombre(a.nextLine());

						System.out.print("Especialidad: ");
						nuevo.setEspecialidad(a.nextLine());

						Validador.validarDni(nuevo.getDni());
						Validador.validarTexto(nuevo.getNombre(), "nombre");
						Validador.validarTexto(nuevo.getEspecialidad(), "especialidad");

						daoMonitores.insertar(nuevo);

						System.out.println("Monitor insertado correctamente");
						break;

					case 3:
						Monitor modificado = new Monitor();

						System.out.print("DNI del monitor a modificar: ");
						modificado.setDni(a.nextLine());

						System.out.print("Nuevo nombre: ");
						modificado.setNombre(a.nextLine());

						System.out.print("Nueva especialidad: ");
						modificado.setEspecialidad(a.nextLine());

						Validador.validarDni(modificado.getDni());
						Validador.validarTexto(modificado.getNombre(), "nombre");
						Validador.validarTexto(modificado.getEspecialidad(), "especialidad");

						daoMonitores.modificar(modificado);

						System.out.println("Monitor modificado correctamente");
						break;

					case 4:
						System.out.print("DNI del monitor a eliminar: ");
						String dni = a.nextLine();

						Validador.validarDni(dni);

						daoMonitores.eliminar(dni);

						System.out.println("Monitor eliminado correctamente");
						break;

					case 0:
						System.out.println("Volviendo...");
						break;

					default:
						System.out.println("Opcion no valida");
				}

			} catch(DatosInvalidosException e) {

				System.out.println(e.getMessage());

			} catch(Exception e) {

				System.out.println("Error en la gestion de monitores");
				System.out.println(e.getMessage());
			}

		} while(opcion != 0);
	}
}