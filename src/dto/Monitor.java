package dto;

import java.util.Objects;

/**
 * Clase que representa a un monitor de la asociación astronómica.
 * <p>
 * Los monitores son los responsables de dirigir y supervisar
 * las actividades organizadas por el club.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Monitor {

	private String dni;
	private String nombre;
	private String especialidad;

	/**
	 * Constructor vacío de la clase Monitor.
	 */
	public Monitor() {}

	/**
	 * Constructor con todos los atributos de la clase.
	 *
	 * @param dni DNI del monitor.
	 * @param nombre Nombre completo del monitor.
	 * @param especialidad Especialidad o área de conocimiento del monitor.
	 */
	public Monitor(String dni, String nombre, String especialidad) {

		this.dni = dni;
		this.nombre = nombre;
		this.especialidad = especialidad;
	}

	/**
	 * Obtiene el DNI del monitor.
	 *
	 * @return DNI del monitor.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Modifica el DNI del monitor.
	 *
	 * @param dni Nuevo DNI del monitor.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Obtiene el nombre del monitor.
	 *
	 * @return Nombre del monitor.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del monitor.
	 *
	 * @param nombre Nuevo nombre del monitor.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la especialidad del monitor.
	 *
	 * @return Especialidad del monitor.
	 */
	public String getEspecialidad() {
		return especialidad;
	}

	/**
	 * Modifica la especialidad del monitor.
	 *
	 * @param especialidad Nueva especialidad del monitor.
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	/**
	 * Genera el código hash del monitor.
	 *
	 * @return Código hash calculado.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre, especialidad);
	}

	/**
	 * Compara dos monitores para determinar si son iguales.
	 *
	 * @param obj Objeto a comparar.
	 * @return true si ambos monitores son iguales; false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {

		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;

		Monitor other = (Monitor) obj;

		return Objects.equals(dni, other.dni)
				&& Objects.equals(nombre, other.nombre)
				&& Objects.equals(especialidad, other.especialidad);
	}

	/**
	 * Devuelve una representación en formato texto del monitor.
	 *
	 * @return Cadena con los datos del monitor.
	 */
	@Override
	public String toString() {
		return dni + " | " + nombre + " | " + especialidad;
	}
}