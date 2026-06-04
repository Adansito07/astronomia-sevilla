package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import dto.EstadoMaterial;
import dto.MaterialAstronomico;
import dto.TipoMaterial;

/**
 * Clase DAO encargada de gestionar las operaciones de acceso a datos
 * relacionadas con la entidad MaterialAstronomico.
 * <p>
 * Permite realizar consultas, inserciones, modificaciones y eliminaciones
 * sobre la tabla material_astronomico de la base de datos.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class DaoMateriales {

	/**
	 * Obtiene todos los materiales astronómicos registrados en la base de datos.
	 *
	 * @return Lista con todos los materiales almacenados.
	 * @throws SQLException Si se produce un error durante la consulta.
	 */
	public ArrayList<MaterialAstronomico> listar() throws SQLException {

		ArrayList<MaterialAstronomico> materiales = new ArrayList<>();

		String sql = "SELECT * FROM material_astronomico";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while(rs.next()) {

				MaterialAstronomico m = new MaterialAstronomico(
						rs.getInt("Codigo_material"),
						rs.getString("Nombre"),
						TipoMaterial.valueOf(rs.getString("Tipo")),
						EstadoMaterial.valueOf(rs.getString("Estado"))
				);

				materiales.add(m);
			}
		}

		return materiales;
	}

	/**
	 * Inserta un nuevo material astronómico en la base de datos.
	 *
	 * @param material Material que se desea registrar.
	 * @throws SQLException Si ocurre un error durante la inserción.
	 */
	public void insertar(MaterialAstronomico material) throws SQLException {

		String sql = "INSERT INTO material_astronomico (Nombre, Tipo, Estado) VALUES (?, ?, ?)";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, material.getNombre());
			ps.setString(2, material.getTipo().name());
			ps.setString(3, material.getEstado().name());

			ps.executeUpdate();
		}
	}

	/**
	 * Modifica los datos de un material astronómico existente.
	 *
	 * @param material Material con los nuevos datos a actualizar.
	 * @throws SQLException Si ocurre un error durante la modificación.
	 */
	public void modificar(MaterialAstronomico material) throws SQLException {

		String sql = "UPDATE material_astronomico SET Nombre = ?, Tipo = ?, Estado = ? WHERE Codigo_material = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, material.getNombre());
			ps.setString(2, material.getTipo().name());
			ps.setString(3, material.getEstado().name());
			ps.setInt(4, material.getCodigoMaterial());

			ps.executeUpdate();
		}
	}

	/**
	 * Elimina un material astronómico de la base de datos.
	 *
	 * @param codigoMaterial Código identificador del material a eliminar.
	 * @throws SQLException Si ocurre un error durante la eliminación.
	 */
	public void eliminar(int codigoMaterial) throws SQLException {

		String sql = "DELETE FROM material_astronomico WHERE Codigo_material = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, codigoMaterial);

			ps.executeUpdate();
		}
	}

	/**
	 * Obtiene todos los materiales cuyo estado es DISPONIBLE.
	 *
	 * @return Lista de materiales disponibles para su utilización.
	 * @throws SQLException Si ocurre un error durante la consulta.
	 */
	public ArrayList<MaterialAstronomico> listarDisponibles() throws SQLException {

		ArrayList<MaterialAstronomico> materiales = new ArrayList<>();

		String sql = "SELECT * FROM material_astronomico WHERE Estado = ?";

		try(Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, EstadoMaterial.DISPONIBLE.name());

			try(ResultSet rs = ps.executeQuery()) {

				while(rs.next()) {

					MaterialAstronomico m = new MaterialAstronomico(
							rs.getInt("Codigo_material"),
							rs.getString("Nombre"),
							TipoMaterial.valueOf(rs.getString("Tipo")),
							EstadoMaterial.valueOf(rs.getString("Estado"))
					);

					materiales.add(m);
				}
			}
		}

		return materiales;
	}
}