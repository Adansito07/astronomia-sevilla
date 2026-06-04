package vista;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import dao.DaoActividades;
import dao.DaoInscripciones;
import dto.Actividad;
import dto.Inscripcion;

/**
 * Clase encargada de mostrar el menú principal del socio.
 * <p>
 * Desde esta vista el socio puede consultar actividades disponibles,
 * inscribirse en una actividad y consultar sus inscripciones.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class VistaSocio {

	/**
	 * Muestra el menú del socio y permite acceder a las opciones
	 * disponibles para este tipo de usuario.
	 * <p>
	 * El menú permanece activo hasta que el socio decide volver.
	 * </p>
	 */
	public static void mostrarMenu() {

		Scanner a = new Scanner(System.in);
		DaoActividades daoActividades = new DaoActividades();
		DaoInscripciones daoInscripciones = new DaoInscripciones();
		int opcion;

		do {
			System.out.println();
			System.out.println("================================");
			System.out.println("           MENU SOCIO");
			System.out.println("================================");
			System.out.println("1. Consultar actividades");
			System.out.println("2. Inscribirse en actividad");
			System.out.println("3. Ver mis inscripciones");
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
						for(Actividad actividad : daoActividades.listar()) {
							System.out.println(actividad);
						}
						break;

					case 2:
						Inscripcion inscripcion = new Inscripcion();

						System.out.print("Introduce tu ID de socio: ");
						inscripcion.setIdSocio(Integer.parseInt(a.nextLine()));

						System.out.print("Codigo de la actividad: ");
						inscripcion.setCodigoActividad(Integer.parseInt(a.nextLine()));

						inscripcion.setFechaInscripcion(Date.valueOf(LocalDate.now()));

						daoInscripciones.insertar(inscripcion);

						System.out.println("Inscripcion realizada correctamente");
						break;

					case 3:
						System.out.print("Introduce tu ID de socio: ");
						int idSocio = Integer.parseInt(a.nextLine());

						for(Inscripcion i : daoInscripciones.listarPorSocio(idSocio)) {
							System.out.println(i);
						}
						break;

					case 0:
						System.out.println("Volviendo...");
						break;

					default:
						System.out.println("Opcion no valida");
				}

			} catch(NumberFormatException e) {

				System.out.println("Debe introducir un numero valido");

			} catch(Exception e) {

				if(e.getMessage() != null && e.getMessage().contains("foreign key constraint fails")) {
					System.out.println("El socio o la actividad introducida no existe");
				} else {
					System.out.println("Error en el menu de socio");
					System.out.println(e.getMessage());
				}
			}

		} while(opcion != 0);
	}
}