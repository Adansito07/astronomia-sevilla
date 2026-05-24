package vista;

import java.sql.Connection;
import java.sql.SQLException;

import conexion.ConexionBD;

public class PruebaConexion {

	public static void main(String[] args) {

		try {
			Connection con = ConexionBD.getConnection();

			System.out.println("Conexión realizada correctamente");

			con.close();

		} catch(SQLException e) {

			System.out.println("Error al conectar con la base de datos");
			e.printStackTrace();
		}
	}
}