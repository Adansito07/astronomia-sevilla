package util;

import excepciones.DatosInvalidosException;

/**
 * Clase utilitaria encargada de validar los datos introducidos
 * por los usuarios de la aplicación.
 * <p>
 * Contiene métodos estáticos para comprobar la validez de campos
 * como texto, correo electrónico, teléfono y DNI.
 * </p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Validador {

	/**
	 * Comprueba que un campo de texto no esté vacío.
	 *
	 * @param texto Texto que se desea validar.
	 * @param campo Nombre del campo que se está validando.
	 * @throws DatosInvalidosException Si el texto es nulo o está vacío.
	 */
	public static void validarTexto(String texto, String campo) throws DatosInvalidosException {

		if(texto == null || texto.trim().isEmpty()) {
			throw new DatosInvalidosException("El campo " + campo + " no puede estar vacio");
		}
	}

	/**
	 * Comprueba que un correo electrónico tenga un formato válido.
	 *
	 * @param correo Correo electrónico a validar.
	 * @throws DatosInvalidosException Si el correo no cumple el formato requerido.
	 */
	public static void validarCorreo(String correo) throws DatosInvalidosException {

		if(correo == null || !correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
			throw new DatosInvalidosException("El correo no es valido");
		}
	}

	/**
	 * Comprueba que un número de teléfono tenga exactamente 9 dígitos.
	 *
	 * @param telefono Número de teléfono a validar.
	 * @throws DatosInvalidosException Si el teléfono no contiene 9 dígitos.
	 */
	public static void validarTelefono(String telefono) throws DatosInvalidosException {

		if(telefono == null || !telefono.matches("[0-9]{9}")) {
			throw new DatosInvalidosException("El telefono debe tener 9 numeros");
		}
	}

	/**
	 * Comprueba que un DNI tenga el formato correcto.
	 * <p>
	 * El formato válido es:
	 * ocho números seguidos de una letra.
	 * </p>
	 *
	 * @param dni DNI que se desea validar.
	 * @throws DatosInvalidosException Si el DNI no cumple el formato requerido.
	 */
	public static void validarDni(String dni) throws DatosInvalidosException {

		if(dni == null || !dni.matches("[0-9]{8}[A-Za-z]")) {
			throw new DatosInvalidosException("El DNI no tiene el formato correcto");
		}
	}
}