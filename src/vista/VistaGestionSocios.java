package vista;

import java.util.Scanner;

import dao.DaoSocios;
import dto.Socio;
import excepciones.DatosInvalidosException;
import util.Validador;

/**
 * Clase encargada de mostrar el menú de gestión de socios.
 * <p>
 * Desde esta vista el administrador puede listar, crear, modificar
 * y eliminar socios de la asociación astronómica.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class VistaGestionSocios {

	/**
	 * Muestra el menú de gestión de socios y permite realizar
	 * las operaciones principales sobre los socios del sistema.
	 * <p>
	 * También valida los datos introducidos por el usuario, como
	 * el nombre, el teléfono y el correo electrónico.
	 * </p>
	 */
	public static void mostrarMenu() {

		Scanner a = new Scanner(System.in);
		DaoSocios daoSocios = new DaoSocios();
		int opcion;

		do {
			System.out.println();
			System.out.println("================================");
			System.out.println("        GESTION DE SOCIOS");
			System.out.println("================================");
			System.out.println("1. Listar socios");
			System.out.println("2. Nuevo socio");
			System.out.println("3. Modificar socio");
			System.out.println("4. Eliminar socio");
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
						for(Socio socio : daoSocios.listar()) {
							System.out.println(socio);
						}
						break;

					case 2:
						Socio nuevo = new Socio();

						System.out.print("Nombre: ");
						nuevo.setNombre(a.nextLine());

						System.out.print("Telefono: ");
						nuevo.setTelefono(a.nextLine());

						System.out.print("Correo: ");
						nuevo.setCorreo(a.nextLine());

						Validador.validarTexto(nuevo.getNombre(), "nombre");
						Validador.validarTelefono(nuevo.getTelefono());
						Validador.validarCorreo(nuevo.getCorreo());

						daoSocios.insertar(nuevo);

						System.out.println("Socio insertado correctamente");
						break;

					case 3:
						Socio modificado = new Socio();

						System.out.print("ID del socio a modificar: ");
						modificado.setIdSocio(Integer.parseInt(a.nextLine()));

						System.out.print("Nuevo nombre: ");
						modificado.setNombre(a.nextLine());

						System.out.print("Nuevo telefono: ");
						modificado.setTelefono(a.nextLine());

						System.out.print("Nuevo correo: ");
						modificado.setCorreo(a.nextLine());

						Validador.validarTexto(modificado.getNombre(), "nombre");
						Validador.validarTelefono(modificado.getTelefono());
						Validador.validarCorreo(modificado.getCorreo());

						daoSocios.modificar(modificado);

						System.out.println("Socio modificado correctamente");
						break;

					case 4:
						System.out.print("ID del socio a eliminar: ");
						int idSocio = Integer.parseInt(a.nextLine());

						daoSocios.eliminar(idSocio);

						System.out.println("Socio eliminado correctamente");
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

				System.out.println("Error en la gestion de socios");
				System.out.println(e.getMessage());
			}

		} while(opcion != 0);
	}
}