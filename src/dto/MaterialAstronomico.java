package dto;

import java.util.Objects;

/**
 * Clase que representa un material astronómico perteneciente a la asociación.
 * <p>
 * Los materiales pueden ser utilizados en las distintas actividades
 * organizadas por el club y poseen un tipo y un estado determinado.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class MaterialAstronomico {

	private int codigoMaterial;
	private String nombre;
	private TipoMaterial tipo;
	private EstadoMaterial estado;

	/**
	 * Constructor vacío de la clase MaterialAstronomico.
	 */
	public MaterialAstronomico() {}

	/**
	 * Constructor con todos los atributos de la clase.
	 *
	 * @param codigoMaterial Código identificador del material.
	 * @param nombre Nombre del material.
	 * @param tipo Tipo de material astronómico.
	 * @param estado Estado actual del material.
	 */
	public MaterialAstronomico(int codigoMaterial, String nombre,
			TipoMaterial tipo, EstadoMaterial estado) {

		this.codigoMaterial = codigoMaterial;
		this.nombre = nombre;
		this.tipo = tipo;
		this.estado = estado;
	}

	/**
	 * Obtiene el código del material.
	 *
	 * @return Código identificador del material.
	 */
	public int getCodigoMaterial() {
		return codigoMaterial;
	}

	/**
	 * Modifica el código del material.
	 *
	 * @param codigoMaterial Nuevo código identificador.
	 */
	public void setCodigoMaterial(int codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	/**
	 * Obtiene el nombre del material.
	 *
	 * @return Nombre del material.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del material.
	 *
	 * @param nombre Nuevo nombre del material.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el tipo de material.
	 *
	 * @return Tipo del material.
	 */
	public TipoMaterial getTipo() {
		return tipo;
	}

	/**
	 * Modifica el tipo de material.
	 *
	 * @param tipo Nuevo tipo de material.
	 */
	public void setTipo(TipoMaterial tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene el estado actual del material.
	 *
	 * @return Estado del material.
	 */
	public EstadoMaterial getEstado() {
		return estado;
	}

	/**
	 * Modifica el estado actual del material.
	 *
	 * @param estado Nuevo estado del material.
	 */
	public void setEstado(EstadoMaterial estado) {
		this.estado = estado;
	}

	/**
	 * Genera el código hash del material.
	 *
	 * @return Código hash calculado.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigoMaterial, nombre, tipo, estado);
	}

	/**
	 * Compara dos materiales para determinar si son iguales.
	 *
	 * @param obj Objeto a comparar.
	 * @return true si ambos materiales son iguales; false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {

		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;

		MaterialAstronomico other = (MaterialAstronomico) obj;

		return codigoMaterial == other.codigoMaterial
				&& Objects.equals(nombre, other.nombre)
				&& tipo == other.tipo
				&& estado == other.estado;
	}

	/**
	 * Devuelve una representación en formato texto del material.
	 *
	 * @return Cadena con los datos del material astronómico.
	 */
	@Override
	public String toString() {
		return codigoMaterial + " | " + nombre + " | " + tipo + " | " + estado;
	}
}