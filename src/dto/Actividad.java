package dto;

import java.sql.Date;
import java.util.Objects;

public class Actividad {

	private int codigo;
	private String nombre;
	private Date fecha;
	private String lugar;
	private CategoriaActividad categoria;

	public Actividad() {}

	public Actividad(int codigo, String nombre, Date fecha,
			String lugar, CategoriaActividad categoria) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.categoria = categoria;
	}

	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {this.codigo = codigo;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public Date getFecha() {return fecha;}
	public void setFecha(Date fecha) {this.fecha = fecha;}
	public String getLugar() {return lugar;}
	public void setLugar(String lugar) {this.lugar = lugar;}
	public CategoriaActividad getCategoria() {return categoria;}
	public void setCategoria(CategoriaActividad categoria) {this.categoria = categoria;}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombre, fecha, lugar, categoria);
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;

		Actividad other = (Actividad) obj;

		return codigo == other.codigo
				&& Objects.equals(nombre, other.nombre)
				&& Objects.equals(fecha, other.fecha)
				&& Objects.equals(lugar, other.lugar)
				&& categoria == other.categoria;
	}
}