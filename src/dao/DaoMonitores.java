package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import dto.Monitor;

/**
 * Clase DAO encargada de gestionar las operaciones de acceso a datos
 * relacionadas con la entidad Monitor.
 * <p>
 * Permite realizar consultas, inserciones, modificaciones y eliminaciones
 * sobre la tabla monitor de la base de datos.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class DaoMonitores {

	/**
	 * Obtiene todos los monitores registrados en la base de datos.
	 *
	 * @return Lista con todos los monitores almacenados.
	 * @throws SQLException Si se produce un error durante la consulta.
	 */
	public ArrayList<Monitor> listar() throws SQLException {

		ArrayList<Monitor> monitores = new ArrayList<>();

		String sql = "SELECT * FROM monitor";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while(rs.next()) {

				Monitor monitor = new Monitor(
						rs.getString("Dni"),
						rs.getString("Nombre"),
						rs.getString("Especialidad")
				);

				monitores.add(monitor);
			}
		}

		return monitores;
	}

	/**
	 * Inserta un nuevo monitor en la base de datos.
	 *
	 * @param monitor Monitor que se desea registrar.
	 * @throws SQLException Si ocurre un error durante la inserción.
	 */
	public void insertar(Monitor monitor) throws SQLException {

		String sql = "INSERT INTO monitor (Dni, Nombre, Especialidad) VALUES (?, ?, ?)";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, monitor.getDni());
			ps.setString(2, monitor.getNombre());
			ps.setString(3, monitor.getEspecialidad());

			ps.executeUpdate();
		}
	}

	/**
	 * Modifica los datos de un monitor existente.
	 *
	 * @param monitor Monitor con los nuevos datos a actualizar.
	 * @throws SQLException Si ocurre un error durante la modificación.
	 */
	public void modificar(Monitor monitor) throws SQLException {

		String sql = "UPDATE monitor SET Nombre = ?, Especialidad = ? WHERE Dni = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, monitor.getNombre());
			ps.setString(2, monitor.getEspecialidad());
			ps.setString(3, monitor.getDni());

			ps.executeUpdate();
		}
	}

	/**
	 * Elimina un monitor de la base de datos a partir de su DNI.
	 *
	 * @param dni DNI del monitor que se desea eliminar.
	 * @throws SQLException Si ocurre un error durante la eliminación.
	 */
	public void eliminar(String dni) throws SQLException {

		String sql = "DELETE FROM monitor WHERE Dni = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, dni);

			ps.executeUpdate();
		}
	}

	/**
	 * Comprueba si existe un monitor registrado con el DNI indicado.
	 *
	 * @param dni DNI del monitor a comprobar.
	 * @return true si el monitor existe; false en caso contrario.
	 * @throws SQLException Si ocurre un error durante la consulta.
	 */
	public boolean existeMonitor(String dni) throws SQLException {

		String sql = "SELECT COUNT(*) FROM monitor WHERE Dni = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, dni);

			try(ResultSet rs = ps.executeQuery()) {

				if(rs.next()) {
					return rs.getInt(1) > 0;
				}
			}
		}

		return false;
	}
}