package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import dto.Actividad;
import dto.CategoriaActividad;

/**
 * Clase DAO encargada de gestionar las operaciones de acceso a datos
 * relacionadas con la entidad Actividad.
 * <p>
 * Permite realizar operaciones de consulta, inserción, modificación
 * y eliminación sobre la tabla actividad de la base de datos.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class DaoActividades {

	/**
	 * Obtiene todas las actividades registradas en la base de datos.
	 *
	 * @return Lista con todas las actividades almacenadas.
	 * @throws SQLException Si se produce un error durante el acceso a la base de datos.
	 */
	public ArrayList<Actividad> listar() throws SQLException {

		ArrayList<Actividad> actividades = new ArrayList<>();

		String sql = "SELECT * FROM actividad";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while(rs.next()) {

				Actividad a = new Actividad(
						rs.getInt("Codigo"),
						rs.getString("Nombre"),
						rs.getDate("Fecha"),
						rs.getString("Lugar"),
						CategoriaActividad.valueOf(rs.getString("Categoria")),
						rs.getString("Dni_monitor")
				);

				actividades.add(a);
			}
		}

		return actividades;
	}

	/**
	 * Inserta una nueva actividad en la base de datos.
	 *
	 * @param actividad Actividad que se desea almacenar.
	 * @throws SQLException Si ocurre un error durante la inserción.
	 */
	public void insertar(Actividad actividad) throws SQLException {

		String sql = "INSERT INTO actividad (Nombre, Fecha, Lugar, Categoria, Dni_monitor) VALUES (?, ?, ?, ?, ?)";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, actividad.getNombre());
			ps.setDate(2, actividad.getFecha());
			ps.setString(3, actividad.getLugar());
			ps.setString(4, actividad.getCategoria().name());
			ps.setString(5, actividad.getDniMonitor());

			ps.executeUpdate();
		}
	}

	/**
	 * Modifica los datos de una actividad existente.
	 *
	 * @param actividad Actividad con los nuevos datos a actualizar.
	 * @throws SQLException Si ocurre un error durante la modificación.
	 */
	public void modificar(Actividad actividad) throws SQLException {

		String sql = "UPDATE actividad SET Nombre = ?, Fecha = ?, Lugar = ?, Categoria = ?, Dni_monitor = ? WHERE Codigo = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, actividad.getNombre());
			ps.setDate(2, actividad.getFecha());
			ps.setString(3, actividad.getLugar());
			ps.setString(4, actividad.getCategoria().name());
			ps.setString(5, actividad.getDniMonitor());
			ps.setInt(6, actividad.getCodigo());

			ps.executeUpdate();
		}
	}

	/**
	 * Elimina una actividad de la base de datos a partir de su código.
	 *
	 * @param codigo Código identificador de la actividad.
	 * @throws SQLException Si ocurre un error durante la eliminación.
	 */
	public void eliminar(int codigo) throws SQLException {

		String sql = "DELETE FROM actividad WHERE Codigo = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, codigo);

			ps.executeUpdate();
		}
	}

	/**
	 * Obtiene todas las actividades pertenecientes a una categoría concreta.
	 *
	 * @param categoria Categoría por la que se desea filtrar.
	 * @return Lista de actividades pertenecientes a la categoría indicada.
	 * @throws SQLException Si ocurre un error durante la consulta.
	 */
	public ArrayList<Actividad> listarPorCategoria(CategoriaActividad categoria) throws SQLException {

		ArrayList<Actividad> actividades = new ArrayList<>();

		String sql = "SELECT * FROM actividad WHERE Categoria = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, categoria.name());

			try(ResultSet rs = ps.executeQuery()) {

				while(rs.next()) {

					Actividad a = new Actividad(
							rs.getInt("Codigo"),
							rs.getString("Nombre"),
							rs.getDate("Fecha"),
							rs.getString("Lugar"),
							CategoriaActividad.valueOf(rs.getString("Categoria")),
							rs.getString("Dni_monitor")
					);

					actividades.add(a);
				}
			}
		}

		return actividades;
	}
}