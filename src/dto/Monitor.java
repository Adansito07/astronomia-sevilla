package dto;

import java.util.Objects;

public class Monitor {

	private String dni;
	private String nombre;
	private String especialidad;

	public Monitor() {}

	public Monitor(String dni, String nombre, String especialidad) {
		this.dni = dni;
		this.nombre = nombre;
		this.especialidad = especialidad;
	}

	public String getDni() {return dni;}
	public void setDni(String dni) {this.dni = dni;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getEspecialidad() {return especialidad;}
	public void setEspecialidad(String especialidad) {this.especialidad = especialidad;}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre, especialidad);
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;

		Monitor other = (Monitor) obj;

		return Objects.equals(dni, other.dni)
				&& Objects.equals(nombre, other.nombre)
				&& Objects.equals(especialidad, other.especialidad);
	}
}