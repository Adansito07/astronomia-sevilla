package dto;

import java.sql.Date;
import java.util.Objects;

/**
 * Clase que representa la inscripción de un socio en una actividad.
 * <p>
 * Permite registrar la participación de un socio en una actividad
 * concreta, así como la fecha en la que se realizó la inscripción.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Inscripcion {

	private int idInscripcion;
	private int idSocio;
	private int codigoActividad;
	private Date fechaInscripcion;

	/**
	 * Constructor vacío de la clase Inscripcion.
	 */
	public Inscripcion() {}

	/**
	 * Constructor con todos los atributos de la clase.
	 *
	 * @param idInscripcion Identificador de la inscripción.
	 * @param idSocio Identificador del socio inscrito.
	 * @param codigoActividad Código de la actividad.
	 * @param fechaInscripcion Fecha en la que se realizó la inscripción.
	 */
	public Inscripcion(int idInscripcion, int idSocio, int codigoActividad, Date fechaInscripcion) {

		this.idInscripcion = idInscripcion;
		this.idSocio = idSocio;
		this.codigoActividad = codigoActividad;
		this.fechaInscripcion = fechaInscripcion;
	}

	/**
	 * Obtiene el identificador de la inscripción.
	 *
	 * @return Identificador de la inscripción.
	 */
	public int getIdInscripcion() {
		return idInscripcion;
	}

	/**
	 * Modifica el identificador de la inscripción.
	 *
	 * @param idInscripcion Nuevo identificador.
	 */
	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
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
	 * Obtiene el código de la actividad.
	 *
	 * @return Código de la actividad.
	 */
	public int getCodigoActividad() {
		return codigoActividad;
	}

	/**
	 * Modifica el código de la actividad.
	 *
	 * @param codigoActividad Nuevo código de la actividad.
	 */
	public void setCodigoActividad(int codigoActividad) {
		this.codigoActividad = codigoActividad;
	}

	/**
	 * Obtiene la fecha de inscripción.
	 *
	 * @return Fecha de inscripción.
	 */
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	/**
	 * Modifica la fecha de inscripción.
	 *
	 * @param fechaInscripcion Nueva fecha de inscripción.
	 */
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	/**
	 * Genera el código hash de la inscripción.
	 *
	 * @return Código hash calculado.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idInscripcion, idSocio, codigoActividad, fechaInscripcion);
	}

	/**
	 * Compara dos inscripciones para determinar si son iguales.
	 *
	 * @param obj Objeto a comparar.
	 * @return true si ambas inscripciones son iguales; false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {

		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;

		Inscripcion other = (Inscripcion) obj;

		return idInscripcion == other.idInscripcion
				&& idSocio == other.idSocio
				&& codigoActividad == other.codigoActividad
				&& Objects.equals(fechaInscripcion, other.fechaInscripcion);
	}

	/**
	 * Devuelve una representación en formato texto de la inscripción.
	 *
	 * @return Cadena con los datos de la inscripción.
	 */
	@Override
	public String toString() {
		return idInscripcion + " | Socio: " + idSocio
				+ " | Actividad: " + codigoActividad
				+ " | " + fechaInscripcion;
	}
}