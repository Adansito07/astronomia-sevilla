package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import dto.Socio;

public class DaoSocios {

	private Connection con;

	public DaoSocios() throws SQLException {

		con = ConexionBD.getConnection();
	}

	public ArrayList<Socio> findAll() {

		return new ArrayList<Socio>();
	}

	public void insert(Socio s) {

		System.out.println("Insertando socio...");
	}
}