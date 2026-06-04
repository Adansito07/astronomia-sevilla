package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import dto.Inscripcion;

/**
 * Clase DAO encargada de gestionar las operaciones de acceso a datos
 * relacionadas con la entidad Inscripcion.
 * <p>
 * Permite realizar consultas, inserciones y eliminaciones sobre la
 * tabla inscripcion de la base de datos.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class DaoInscripciones {

	/**
	 * Obtiene todas las inscripciones registradas en la base de datos.
	 *
	 * @return Lista con todas las inscripciones almacenadas.
	 * @throws SQLException Si se produce un error durante la consulta.
	 */
	public ArrayList<Inscripcion> listar() throws SQLException {

		ArrayList<Inscripcion> inscripciones = new ArrayList<>();

		String sql = "SELECT * FROM inscripcion";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while(rs.next()) {

				Inscripcion i = new Inscripcion(
						rs.getInt("Id_inscripcion"),
						rs.getInt("Id_socio"),
						rs.getInt("Codigo_actividad"),
						rs.getDate("Fecha_inscripcion")
				);

				inscripciones.add(i);
			}
		}

		return inscripciones;
	}

	/**
	 * Inserta una nueva inscripción en la base de datos.
	 *
	 * @param inscripcion Inscripción que se desea registrar.
	 * @throws SQLException Si ocurre un error durante la inserción.
	 */
	public void insertar(Inscripcion inscripcion) throws SQLException {

		String sql = "INSERT INTO inscripcion (Id_socio, Codigo_actividad, Fecha_inscripcion) VALUES (?, ?, ?)";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, inscripcion.getIdSocio());
			ps.setInt(2, inscripcion.getCodigoActividad());
			ps.setDate(3, inscripcion.getFechaInscripcion());

			ps.executeUpdate();
		}
	}

	/**
	 * Elimina una inscripción de la base de datos a partir de su identificador.
	 *
	 * @param idInscripcion Identificador de la inscripción a eliminar.
	 * @throws SQLException Si ocurre un error durante la eliminación.
	 */
	public void eliminar(int idInscripcion) throws SQLException {

		String sql = "DELETE FROM inscripcion WHERE Id_inscripcion = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, idInscripcion);

			ps.executeUpdate();
		}
	}

	/**
	 * Obtiene todas las inscripciones asociadas a un socio concreto.
	 *
	 * @param idSocio Identificador del socio.
	 * @return Lista de inscripciones realizadas por el socio indicado.
	 * @throws SQLException Si ocurre un error durante la consulta.
	 */
	public ArrayList<Inscripcion> listarPorSocio(int idSocio) throws SQLException {

		ArrayList<Inscripcion> inscripciones = new ArrayList<>();

		String sql = "SELECT * FROM inscripcion WHERE Id_socio = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, idSocio);

			try(ResultSet rs = ps.executeQuery()) {

				while(rs.next()) {

					Inscripcion i = new Inscripcion(
							rs.getInt("Id_inscripcion"),
							rs.getInt("Id_socio"),
							rs.getInt("Codigo_actividad"),
							rs.getDate("Fecha_inscripcion")
					);

					inscripciones.add(i);
				}
			}
		}

		return inscripciones;
	}
}