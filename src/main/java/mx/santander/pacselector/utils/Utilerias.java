package mx.santander.pacselector.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * Clase Utilerias que contiene metodos utilizados en la aplicacion.
 *
 */
public final class Utilerias {

    /**
     * Constructor creado para evitar que se pueda crear una instancia de esta
     * clase
     */
    private Utilerias() {
        throw new UnsupportedOperationException("No instanciar la clase");
    }

    /**
     * Obtiene el entero indicado, si el valor indicado es nulo entonces se
     * regresa el entero por defecto indicado.
     *
     * @param integer
     *            el entero.
     * @param defaultValue
     *            el valor por defecto.
     * @return el entero indicado, si el valor indicado es nulo entonces se
     *         regresa el entero por defecto indicado.
     **/
    public static int defaultInteger(Integer integer, int defaultValue) {
        if (integer == null) {
            return defaultValue;
        }
        return integer;
    }

    /**
     * Obtiene el entero indicado, si el valor indicado es nulo entonces se
     * regresa 0.
     *
     * @param integer
     *            el entero.
     * @return el entero indicado, si el valor indicado es nulo entonces se
     *         regresa 0.
     **/
    public static int defaultInteger(Integer integer) {
        return defaultInteger(integer, 0);
    }

    /**
     * Obtiene el valor entero indicado, si el valor indicado no puede ser
     * convertido a entero entonces se regresa el valor por defecto indicado.
     *
     * @param integer
     *            el valor entero que se ha de obtener.
     * @param defaultValue
     *            el valor por defecto.
     * @return el valor entero indicado, si el valor indicado no puede ser
     *         convertido a entero entonces se regresa el valor por defecto
     *         indicado.
     **/
    public static Integer defaultInteger(Object integer, Integer defaultValue) {
        if (integer == null) {
            return defaultValue;
        }
        String intStr = integer.toString().trim();
        if (!NumberUtils.isCreatable(intStr)) {
            return defaultValue;
        }
        return Integer.valueOf(intStr);
    }

    /**
     * Obtiene el valor long indicado, si el valor indicado no puede ser convertido
     * a long entonces se regresa 0.
     *
     * @param longValue
     *            el valor long que se ha de obtener.
     * @param defaultValue
     *            el valor por defecto.
     * @return el valor long indicado, si el valor indicado no puede ser convertido
     *         a entero entonces se regresa el valor por defecto indicado.
     */
    public static Long defaultLong(Object longValue, Long defaultValue) {
        if (longValue == null) {
            return defaultValue;
        }
        String longStr = longValue.toString().trim();
        if (!NumberUtils.isCreatable(longStr)) {
            return defaultValue;
        }
        return Long.valueOf(longStr);
    }

    /**
     * Obtiene el valor BigInteger indicado, si el valor indicado no puede ser
     * convertido a BigInteger entonces se regresa 0.
     *
     * @param bigIntegerValue
     *            el valor long que se ha de obtener.
     * @param defaultValue
     *            el valor por defecto.
     * @return el valor BigInteger indicado, si el valor indicado no puede ser
     *         convertido a BigInteger entonces se regresa el valor por defecto
     *         indicado.
     */
    public static BigInteger defaultBigInteger(Object bigIntegerValue, BigInteger defaultValue) {
        if (bigIntegerValue == null) {
            return defaultValue;
        }
        String bigIntegerStr = bigIntegerValue.toString().trim();
        if (!NumberUtils.isCreatable(bigIntegerStr)) {
            return defaultValue;
        }
        return new BigInteger(bigIntegerStr);
    }

    /**
     * Obtiene el valor entero indicado, si el valor indicado no puede ser
     * convertido a entero entonces se regresa 0.
     *
     * @param integer
     *            el valor entero que se ha de obtener.
     * @return el valor entero indicado, si el valor indicado no puede ser
     *         convertido a entero entonces se regresa 0.
     **/
    public static Integer defaultInteger(Object integer) {
        return defaultInteger(integer, NumberUtils.INTEGER_ZERO);
    }

    /**
     * Obtiene el valor del registro en {@link BigDecimal} para el valor
     * indicado
     *
     * @param valor
     *            el valor que se quiere convertir.
     * @return el valor en {@link BigDecimal}
     */
    public static BigDecimal getBigDecimalValue(String valor) {
        if (StringUtils.isBlank(valor)) {
            throw new IllegalArgumentException("El Valor es nulo");
        }
        Object data = valor;

        if (StringUtils.isBlank(data.toString())) {
            return null;
        }
        if (!(data instanceof BigDecimal)) {
            throw new UnsupportedOperationException(String.format(
                    "No se puede convertir %s a BigDecimal", data.toString()));
        }
        return (BigDecimal) data;
    }
    /**
     * Clona una lista
     * @param list Listado generico
     * @return Regresa una lista generica
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> clone(List<T> list){
        if (list!=null){
            return list;
        } else {
            return (List<T>)(new ArrayList<T>()).clone();
        }
    }

    /**
     * Descripcion   : Metodo para unificar mensajes de incidencias del PAC para guardarlo en BD
     * Creado por    : Diego Colchado S.
     * Fecha Creacion: 13 sep. 2020
     * @param incidentes Lista de incidentes
     * @return String con los incidentes
     */
    public static String unifyListStringIncidentes(List<String> incidentes) {
        StringBuilder sb = new StringBuilder();
        incidentes.forEach(s -> sb.append(s).append("|"));
        return sb.toString();
    }
}
