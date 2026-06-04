package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión con la base de datos
 * MySQL del sistema Astronomía Sevilla.
 * <p>
 * Contiene los parámetros de conexión y un método estático para
 * obtener una conexión activa con la base de datos.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class ConexionBD {

	/**
	 * URL de conexión a la base de datos.
	 */
	private static final String URL = "jdbc:mysql://localhost:3306/astronomia_sevilla";

	/**
	 * Usuario de acceso a la base de datos.
	 */
	private static final String USUARIO = "root";

	/**
	 * Contraseña de acceso a la base de datos.
	 */
	private static final String CLAVE = "";

	/**
	 * Obtiene una conexión con la base de datos.
	 *
	 * @return Objeto Connection con la conexión establecida.
	 * @throws SQLException Si ocurre un error al conectar con la base de datos.
	 */
	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(URL, USUARIO, CLAVE);
	}
}