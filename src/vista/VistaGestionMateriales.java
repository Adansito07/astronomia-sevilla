package vista;

import java.util.Scanner;

import dao.DaoMateriales;
import dto.EstadoMaterial;
import dto.MaterialAstronomico;
import dto.TipoMaterial;
import excepciones.DatosInvalidosException;
import util.Validador;

/**
 * Clase encargada de mostrar el menú de gestión de materiales astronómicos.
 * <p>
 * Desde esta vista el administrador puede listar, crear, modificar,
 * eliminar y consultar los materiales disponibles de la asociación.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class VistaGestionMateriales {

	/**
	 * Muestra el menú de gestión de materiales y permite realizar
	 * las operaciones principales sobre los materiales astronómicos.
	 * <p>
	 * También valida los datos introducidos por el usuario, como el
	 * nombre del material, el tipo y el estado.
	 * </p>
	 */
	public static void mostrarMenu() {

		Scanner a = new Scanner(System.in);
		DaoMateriales daoMateriales = new DaoMateriales();
		int opcion;

		do {
			System.out.println();
			System.out.println("================================");
			System.out.println("      GESTION DE MATERIALES");
			System.out.println("================================");
			System.out.println("1. Listar materiales");
			System.out.println("2. Nuevo material");
			System.out.println("3. Modificar material");
			System.out.println("4. Eliminar material");
			System.out.println("5. Listar disponibles");
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
						for(MaterialAstronomico material : daoMateriales.listar()) {
							System.out.println(material);
						}
						break;

					case 2:
						MaterialAstronomico nuevo = new MaterialAstronomico();

						System.out.print("Nombre: ");
						nuevo.setNombre(a.nextLine());

						System.out.print("Tipo (TELESCOPIO, PRISMATICOS, CAMARA, FILTRO, MONTURA): ");
						nuevo.setTipo(TipoMaterial.valueOf(a.nextLine().toUpperCase()));

						System.out.print("Estado (DISPONIBLE, PRESTADO, MANTENIMIENTO): ");
						nuevo.setEstado(EstadoMaterial.valueOf(a.nextLine().toUpperCase()));

						Validador.validarTexto(nuevo.getNombre(), "nombre");

						daoMateriales.insertar(nuevo);

						System.out.println("Material insertado correctamente");
						break;

					case 3:
						MaterialAstronomico modificado = new MaterialAstronomico();

						System.out.print("Codigo del material a modificar: ");
						modificado.setCodigoMaterial(Integer.parseInt(a.nextLine()));

						System.out.print("Nuevo nombre: ");
						modificado.setNombre(a.nextLine());

						System.out.print("Nuevo tipo (TELESCOPIO, PRISMATICOS, CAMARA, FILTRO, MONTURA): ");
						modificado.setTipo(TipoMaterial.valueOf(a.nextLine().toUpperCase()));

						System.out.print("Nuevo estado (DISPONIBLE, PRESTADO, MANTENIMIENTO): ");
						modificado.setEstado(EstadoMaterial.valueOf(a.nextLine().toUpperCase()));

						Validador.validarTexto(modificado.getNombre(), "nombre");

						daoMateriales.modificar(modificado);

						System.out.println("Material modificado correctamente");
						break;

					case 4:
						System.out.print("Codigo del material a eliminar: ");
						int codigoMaterial = Integer.parseInt(a.nextLine());

						daoMateriales.eliminar(codigoMaterial);

						System.out.println("Material eliminado correctamente");
						break;

					case 5:
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

			} catch(DatosInvalidosException e) {

				System.out.println(e.getMessage());

			} catch(IllegalArgumentException e) {

				System.out.println("El tipo o estado introducido no es valido");

			} catch(Exception e) {

				System.out.println("Error en la gestion de materiales");
				System.out.println(e.getMessage());
			}

		} while(opcion != 0);
	}
}