package excepciones;

/**
 * Excepción personalizada utilizada para indicar que los datos
 * introducidos por el usuario no cumplen las validaciones establecidas.
 * <p>
 * Esta excepción se lanza cuando se detectan errores en campos como
 * DNI, teléfono, correo electrónico o cualquier otro dato que no
 * cumpla los requisitos definidos por la aplicación.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class DatosInvalidosException extends Exception {

	/**
	 * Identificador de versión de la clase serializable.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construye una nueva excepción con el mensaje especificado.
	 *
	 * @param mensaje Descripción del error producido.
	 */
	public DatosInvalidosException(String mensaje) {
		super(mensaje);
	}
}