package dto;

import java.util.Objects;

/**
 * Clase que representa a un socio registrado en la asociación astronómica.
 * <p>
 * Los socios pueden consultar actividades, realizar inscripciones
 * y participar en los eventos organizados por el club.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Socio {

	private int idSocio;
	private String nombre;
	private String telefono;
	private String correo;

	/**
	 * Constructor vacío de la clase Socio.
	 */
	public Socio() {}

	/**
	 * Constructor con todos los atributos de la clase.
	 *
	 * @param idSocio Identificador del socio.
	 * @param nombre Nombre completo del socio.
	 * @param telefono Número de teléfono del socio.
	 * @param correo Correo electrónico del socio.
	 */
	public Socio(int idSocio, String nombre, String telefono, String correo) {

		this.idSocio = idSocio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}

	/**
	 * Obtiene el identificador del socio.
	 *
	 * @return Identificador del socio.
	 */
	public int getIdSocio() {
		return idSocio;
	}

	/**
	 * Modifica el identificador del socio.
	 *
	 * @param idSocio Nuevo identificador del socio.
	 */
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	/**
	 * Obtiene el nombre del socio.
	 *
	 * @return Nombre del socio.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del socio.
	 *
	 * @param nombre Nuevo nombre del socio.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el teléfono del socio.
	 *
	 * @return Teléfono del socio.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Modifica el teléfono del socio.
	 *
	 * @param telefono Nuevo teléfono del socio.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene el correo electrónico del socio.
	 *
	 * @return Correo electrónico del socio.
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Modifica el correo electrónico del socio.
	 *
	 * @param correo Nuevo correo electrónico del socio.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Genera el código hash del socio.
	 *
	 * @return Código hash calculado.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idSocio, nombre, telefono, correo);
	}

	/**
	 * Compara dos socios para determinar si son iguales.
	 *
	 * @param obj Objeto a comparar.
	 * @return true si ambos socios son iguales; false en caso contrario.
	 */
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

	/**
	 * Devuelve una representación en formato texto del socio.
	 *
	 * @return Cadena con los datos del socio.
	 */
	@Override
	public String toString() {
		return idSocio + " | " + nombre + " | " + telefono + " | " + correo;
	}
}