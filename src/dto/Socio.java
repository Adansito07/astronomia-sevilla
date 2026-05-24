package dto;

import java.util.Objects;

public class Socio {

	private int idSocio;
	private String nombre;
	private String telefono;
	private String correo;

	public Socio() {}

	public Socio(int idSocio, String nombre, String telefono, String correo) {
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}

	public int getIdSocio() {return idSocio;}
	public void setIdSocio(int idSocio) {this.idSocio = idSocio;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getTelefono() {return telefono;}
	public void setTelefono(String telefono) {this.telefono = telefono;}
	public String getCorreo() {return correo;}
	public void setCorreo(String correo) {this.correo = correo;}

	@Override
	public int hashCode() {
		return Objects.hash(idSocio, nombre, telefono, correo);
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;

		Socio other = (Socio) obj;

		return idSocio == other.idSocio
				&& Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono)
				&& Objects.equals(correo, other.correo);
	}
}