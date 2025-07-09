/**
 * Isban Mexico
 *   Clase: UtileriasString.java
 *   Descripcion: Componente de utilerias de IDA
 *
 *   Control de Cambios:
 *   1.0 Agosto 29, 2017 LFER - Creacion
 */
package mx.santander.pacselector.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * Clase Utilerias String que contiene los metodos para validar 
 * un String en la aplicacion.
 * 
 */
public final class UtileriasString {

    /**
     * Constructor sin par&aacute;metros creado para evitar que se
     * pueda crear una instancia de esta clase.
     */
    private UtileriasString(){
        throw new UnsupportedOperationException("No instanciar la clase");
    }

    /**
     * Rellena con los espacios a la derecha indicados la cadena indicada.
     *
     * @param str
     *            la cadena que se ha de rellenar.
     * @param size
     *            los espacios de relleno a la derecha.
     * @return la cadena indicada con los espacios de relleno.
     **/
    public static String defaultRightPad(Object str, int size) {
        final String defString = defaultStringIfBlank(str);
        if (defString.length() > size) {
            return defString.substring(0, size);
        }
        return StringUtils.rightPad(defString, size);
    }

    /**
     * Rellena con los espacios a la izquierda indicados la cadena indicada.
     *
     * @param str
     *            la cadena que se ha de rellenar.
     * @param size
     *            los espacios de relleno a la izquierda.
     * @param relleno
     *            el caracter de relleno.
     * @return la cadena indicada con los espacios de relleno.
     **/
    public static String defaultLeftPad(Object str, int size, char relleno) {
        final String defString = defaultStringIfBlank(str);
        if (defString.length() > size) {
            return defString.substring(defString.length() - size);
        }
        return StringUtils.leftPad(defString, size, relleno);
    }

    /**
     * Rellena con los espacios a la izquierda indicados la cadena indicada,
     * dependiendo si la cadena se encuentra vacia o no.
     *
     * @param str
     *            la cadena que se ha de rellenar.
     * @param size
     *            los espacios de relleno a la izquierda.
     * @param rellenoVacio
     *            el caracter de relleno si la cadena es vacia.
     * @param rellenoNoVacio
     *            el caracter de relleno si la cadena no es vacia.
     * @return la cadena indicada con los espacios de relleno.
     **/
    public static String defaultLeftPad(Object str, int size,
            char rellenoVacio, char rellenoNoVacio) {
        final String string = defaultStringIfBlank(str);
        if (StringUtils.isBlank(string)) {
            return defaultLeftPad(defaultStringIfBlank(str), size, rellenoVacio);
        }
        return defaultLeftPad(defaultStringIfBlank(str), size, rellenoNoVacio);
    }
    /**
     * Obtiene el valor {@code String} por defecto en caso de que el objeto
     * {@code String} indicado sea vacio de acuerdo a
     * {@link StringUtils#isBlank(String)}.
     *
     * @param string
     *            el valor {@code String} a evaluar.
     * @param defaultValue
     *            el valor por defecto.
     * @return el valor {@code String} por defecto en caso de que el objeto
     *         {@code String} indicado sea vacio de acuerdo a
     *         {@link StringUtils#isBlank(String)}.
     **/
    public static String defaultStringIfBlank(Object string, String defaultValue) {
        if (string == null) {
            return defaultValue;
        }
        if (StringUtils.isBlank(string.toString())) {
            return defaultValue;
        }
        return string.toString();
    }

    /**
     * Obtiene el valor de cadena vacia, {@link StringUtils#EMPTY}, en caso de
     * que el objeto {@code String} indicado sea vacio de acuerdo a
     * {@link StringUtils#isBlank(String)}.
     *
     * @param string
     *            el valor {@code String} a evaluar.
     * @return el valor de cadena vacia, {@link StringUtils#EMPTY}, en caso de
     *         que el objeto {@code String} indicado sea vacio de acuerdo a
     *         {@link StringUtils#isBlank(String)}.
     **/
    public static String defaultStringIfBlank(Object string) {
        return defaultStringIfBlank(string, StringUtils.EMPTY);
    }

    /**
     * Abrevia una cadena usando los tres puntos. Esto cambiaria "Ahora es el
     * tiempo de los hombres buenos" a "Ahora es el tiempo...".<br/>
     * Si la cadena es nula entonces se regresa una cadena vacia.<br/>
     * Si maxWidth es menor a 4 se lanza un {@code IllegalArgumentException}.
     *
     * @param str
     *            la cadena a checar.
     * @param maxWidth
     *            el tamanio maximo de la cadena, debe ser al menos 4.
     * @return la cadena abreviada, si la cadena es nula entonces se regresa una
     *         cadena vacia.
     **/
    public static String defaultAbbreviate(String str, int maxWidth) {
        return StringUtils.abbreviate(defaultStringIfBlank(str), maxWidth - 1);
    }

    /**
     * Abrevia una cadena usando los tres puntos. Esto cambiaria "Ahora es el
     * tiempo de los hombres buenos" a "Ahora es el tiempo...".<br/>
     * Si la cadena es nula entonces se regresa el valor por defecto indicado.<br/>
     * Si maxWidth es menor a 4 se lanza un {@code IllegalArgumentException}.
     *
     * @param str
     *            la cadena a checar.
     * @param maxWidth
     *            el tamanio maximo de la cadena, debe ser al menos 4.
     * @param defaultValue
     *            el valor por defecto.
     * @return la cadena abreviada, si la cadena es nula entonces se regresa el
     *         valor por defecto.
     **/
    public static String defaultAbbreviate(String str, int maxWidth, String defaultValue) {
        return StringUtils.abbreviate(defaultStringIfBlank(str, defaultValue),
                maxWidth);
    }

    /**
     * Descripcion   : Metodo que corta un String si supera la lognitud recibida
     * Creado por    : Diego Colchado S.
     * Fecha Creacion: 3 jun. 2020
     * @param str Palabra a recortar
     * @param length longitud a recortar
     * @return Palabra recortada
     */
	public static String cutString(String str, int length) {
		if (str.length() > length) {
			return str.substring(0, length);
		}
		return str;
	}

}