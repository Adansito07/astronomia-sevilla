package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import dto.Socio;

/**
 * Clase DAO encargada de gestionar las operaciones de acceso a datos
 * relacionadas con la entidad Socio.
 * <p>
 * Permite realizar consultas, inserciones, modificaciones y eliminaciones
 * sobre la tabla socio de la base de datos.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class DaoSocios {

	/**
	 * Obtiene todos los socios registrados en la base de datos.
	 *
	 * @return Lista con todos los socios almacenados.
	 * @throws SQLException Si se produce un error durante la consulta.
	 */
	public ArrayList<Socio> listar() throws SQLException {

		ArrayList<Socio> socios = new ArrayList<>();

		String sql = "SELECT * FROM socio";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while(rs.next()) {

				Socio s = new Socio(
						rs.getInt("Id_socio"),
						rs.getString("Nombre"),
						rs.getString("Telefono"),
						rs.getString("Correo")
				);

				socios.add(s);
			}
		}

		return socios;
	}

	/**
	 * Inserta un nuevo socio en la base de datos.
	 *
	 * @param socio Socio que se desea registrar.
	 * @throws SQLException Si ocurre un error durante la inserción.
	 */
	public void insertar(Socio socio) throws SQLException {

		String sql = "INSERT INTO socio (Nombre, Telefono, Correo) VALUES (?, ?, ?)";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, socio.getNombre());
			ps.setString(2, socio.getTelefono());
			ps.setString(3, socio.getCorreo());

			ps.executeUpdate();
		}
	}

	/**
	 * Modifica los datos de un socio existente.
	 *
	 * @param socio Socio con los nuevos datos a actualizar.
	 * @throws SQLException Si ocurre un error durante la modificación.
	 */
	public void modificar(Socio socio) throws SQLException {

		String sql = "UPDATE socio SET Nombre = ?, Telefono = ?, Correo = ? WHERE Id_socio = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, socio.getNombre());
			ps.setString(2, socio.getTelefono());
			ps.setString(3, socio.getCorreo());
			ps.setInt(4, socio.getIdSocio());

			ps.executeUpdate();
		}
	}

	/**
	 * Elimina un socio de la base de datos a partir de su identificador.
	 *
	 * @param idSocio Identificador del socio que se desea eliminar.
	 * @throws SQLException Si ocurre un error durante la eliminación.
	 */
	public void eliminar(int idSocio) throws SQLException {

		String sql = "DELETE FROM socio WHERE Id_socio = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, idSocio);

			ps.executeUpdate();
		}
	}
}