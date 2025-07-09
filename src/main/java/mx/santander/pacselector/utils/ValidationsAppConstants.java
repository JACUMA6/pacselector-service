package mx.santander.pacselector.utils;

public final class ValidationsAppConstants {

    /**
     * Nombre: ALFANUMERICO_ESP
     * Tipo: String
     * Descripcion: Expresion regular validacion formato alfanumerico con caracteres especiales*/
    public static final String ALFANUMERICO_ESP = "^[áéíóúÁÉÍÚÓA-Za-z0-9 -.*°|!\\\"#$%&/=?¡´+;:_,<>\\@]";
    /**
     * Nombre: NUMERICO
     * Tipo: String
     * Descripcion: Expresion regular validacion formato Numerico*/
    public static final String NUMERICO = "\\d";
    /**
     * Constructor de clase privado
     */
    private ValidationsAppConstants() {
        // Constructor privado
    }
}
