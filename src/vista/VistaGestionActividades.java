package vista;

import java.sql.Date;
import java.util.Scanner;

import dao.DaoActividades;
import dao.DaoMonitores;
import dto.Actividad;
import dto.CategoriaActividad;
import excepciones.DatosInvalidosException;
import util.Validador;

/**
 * Clase encargada de mostrar el menú de gestión de actividades.
 * <p>
 * Desde esta vista el administrador puede listar, crear, modificar,
 * eliminar y buscar actividades por categoría.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class VistaGestionActividades {

	/**
	 * Muestra el menú de gestión de actividades y permite realizar
	 * las operaciones principales sobre las actividades del sistema.
	 * <p>
	 * También valida los datos introducidos por el usuario, como el
	 * nombre, el lugar, la categoría, la fecha y el DNI del monitor.
	 * </p>
	 */
	public static void mostrarMenu() {

		Scanner a = new Scanner(System.in);
		DaoActividades daoActividades = new DaoActividades();
		DaoMonitores daoMonitores = new DaoMonitores();
		int opcion;

		do {
			System.out.println();
			System.out.println("================================");
			System.out.println("      GESTION DE ACTIVIDADES");
			System.out.println("================================");
			System.out.println("1. Listar actividades");
			System.out.println("2. Nueva actividad");
			System.out.println("3. Modificar actividad");
			System.out.println("4. Eliminar actividad");
			System.out.println("5. Listar por categoria");
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
						Actividad nueva = new Actividad();

						System.out.print("Nombre: ");
						nueva.setNombre(a.nextLine());

						System.out.print("Fecha (YYYY-MM-DD): ");
						nueva.setFecha(Date.valueOf(a.nextLine()));

						System.out.print("Lugar: ");
						nueva.setLugar(a.nextLine());

						System.out.print("Categoria (OBSERVACION, CHARLA, TALLER, ASTROFOTOGRAFIA, SALIDA): ");
						nueva.setCategoria(CategoriaActividad.valueOf(a.nextLine().toUpperCase()));

						System.out.print("DNI monitor: ");
						String dniMonitor = a.nextLine();

						Validador.validarTexto(nueva.getNombre(), "nombre");
						Validador.validarTexto(nueva.getLugar(), "lugar");
						Validador.validarDni(dniMonitor);

						if(!daoMonitores.existeMonitor(dniMonitor)) {
							throw new DatosInvalidosException("El monitor introducido no existe");
						}

						nueva.setDniMonitor(dniMonitor);

						daoActividades.insertar(nueva);

						System.out.println("Actividad insertada correctamente");
						break;

					case 3:
						Actividad modificada = new Actividad();

						System.out.print("Codigo de la actividad a modificar: ");
						modificada.setCodigo(Integer.parseInt(a.nextLine()));

						System.out.print("Nuevo nombre: ");
						modificada.setNombre(a.nextLine());

						System.out.print("Nueva fecha (YYYY-MM-DD): ");
						modificada.setFecha(Date.valueOf(a.nextLine()));

						System.out.print("Nuevo lugar: ");
						modificada.setLugar(a.nextLine());

						System.out.print("Nueva categoria (OBSERVACION, CHARLA, TALLER, ASTROFOTOGRAFIA, SALIDA): ");
						modificada.setCategoria(CategoriaActividad.valueOf(a.nextLine().toUpperCase()));

						System.out.print("Nuevo DNI monitor: ");
						String nuevoDniMonitor = a.nextLine();

						Validador.validarTexto(modificada.getNombre(), "nombre");
						Validador.validarTexto(modificada.getLugar(), "lugar");
						Validador.validarDni(nuevoDniMonitor);

						if(!daoMonitores.existeMonitor(nuevoDniMonitor)) {
							throw new DatosInvalidosException("El monitor introducido no existe");
						}

						modificada.setDniMonitor(nuevoDniMonitor);

						daoActividades.modificar(modificada);

						System.out.println("Actividad modificada correctamente");
						break;

					case 4:
						System.out.print("Codigo de la actividad a eliminar: ");
						int codigo = Integer.parseInt(a.nextLine());

						daoActividades.eliminar(codigo);

						System.out.println("Actividad eliminada correctamente");
						break;

					case 5:
						System.out.print("Categoria (OBSERVACION, CHARLA, TALLER, ASTROFOTOGRAFIA, SALIDA): ");
						CategoriaActividad categoria = CategoriaActividad.valueOf(a.nextLine().toUpperCase());

						for(Actividad actividad : daoActividades.listarPorCategoria(categoria)) {
							System.out.println(actividad);
						}
						break;

					case 0:
						System.out.println("Volviendo...");
						break;

					default:
						System.out.println("Opcion no valida");
				}

			} catch(DatosInvalidosException e) {

				System.out.println(e.getMessage());

			} catch(IllegalArgumentException e) {

				System.out.println("La fecha o la categoria introducida no es valida");

			} catch(Exception e) {

				System.out.println("Error en la gestion de actividades");
				System.out.println(e.getMessage());
			}

		} while(opcion != 0);
	}
}