package dto;

import java.sql.Date;
import java.util.Objects;

/**
 * Clase que representa una actividad organizada por la asociación astronómica.
 * <p>
 * Una actividad puede ser una observación, charla, taller,
 * sesión de astrofotografía o salida astronómica.
 * Cada actividad está asociada a un monitor responsable.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Actividad {

	private int codigo;
	private String nombre;
	private Date fecha;
	private String lugar;
	private CategoriaActividad categoria;
	private String dniMonitor;

	/**
	 * Constructor vacío de la clase Actividad.
	 */
	public Actividad() {}

	/**
	 * Constructor con todos los atributos de la clase.
	 *
	 * @param codigo Código identificador de la actividad.
	 * @param nombre Nombre de la actividad.
	 * @param fecha Fecha de realización.
	 * @param lugar Lugar donde se desarrolla la actividad.
	 * @param categoria Categoría de la actividad.
	 * @param dniMonitor DNI del monitor responsable.
	 */
	public Actividad(int codigo, String nombre, Date fecha, String lugar,
			CategoriaActividad categoria, String dniMonitor) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.categoria = categoria;
		this.dniMonitor = dniMonitor;
	}

	/**
	 * Obtiene el código de la actividad.
	 *
	 * @return Código de la actividad.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Modifica el código de la actividad.
	 *
	 * @param codigo Nuevo código de la actividad.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene el nombre de la actividad.
	 *
	 * @return Nombre de la actividad.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre de la actividad.
	 *
	 * @param nombre Nuevo nombre de la actividad.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la fecha de realización.
	 *
	 * @return Fecha de la actividad.
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Modifica la fecha de realización.
	 *
	 * @param fecha Nueva fecha de la actividad.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el lugar donde se realiza la actividad.
	 *
	 * @return Lugar de la actividad.
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Modifica el lugar donde se realiza la actividad.
	 *
	 * @param lugar Nuevo lugar de la actividad.
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	/**
	 * Obtiene la categoría de la actividad.
	 *
	 * @return Categoría de la actividad.
	 */
	public CategoriaActividad getCategoria() {
		return categoria;
	}

	/**
	 * Modifica la categoría de la actividad.
	 *
	 * @param categoria Nueva categoría de la actividad.
	 */
	public void setCategoria(CategoriaActividad categoria) {
		this.categoria = categoria;
	}

	/**
	 * Obtiene el DNI del monitor responsable.
	 *
	 * @return DNI del monitor.
	 */
	public String getDniMonitor() {
		return dniMonitor;
	}

	/**
	 * Modifica el DNI del monitor responsable.
	 *
	 * @param dniMonitor Nuevo DNI del monitor.
	 */
	public void setDniMonitor(String dniMonitor) {
		this.dniMonitor = dniMonitor;
	}

	/**
	 * Genera el código hash de la actividad.
	 *
	 * @return Código hash calculado.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombre, fecha, lugar, categoria, dniMonitor);
	}

	/**
	 * Compara dos actividades para determinar si son iguales.
	 *
	 * @param obj Objeto a comparar.
	 * @return true si ambas actividades son iguales; false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {

		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;

		Actividad other = (Actividad) obj;

		return codigo == other.codigo
				&& Objects.equals(nombre, other.nombre)
				&& Objects.equals(fecha, other.fecha)
				&& Objects.equals(lugar, other.lugar)
				&& categoria == other.categoria
				&& Objects.equals(dniMonitor, other.dniMonitor);
	}

	/**
	 * Devuelve una representación en formato texto de la actividad.
	 *
	 * @return Cadena con los datos de la actividad.
	 */
	@Override
	public String toString() {
		return codigo + " | " + nombre + " | " + fecha + " | "
				+ lugar + " | " + categoria + " | " + dniMonitor;
	}
}