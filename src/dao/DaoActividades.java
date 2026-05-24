package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import dto.Actividad;

public class DaoActividades {

	private Connection con;

	public DaoActividades() throws SQLException {con = ConexionBD.getConnection();}
	public ArrayList<Actividad> findAll() {return new ArrayList<Actividad>();}
	public void insert(Actividad a) {System.out.println("Insertando actividad...");}
}