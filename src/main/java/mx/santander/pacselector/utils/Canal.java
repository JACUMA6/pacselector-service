package mx.santander.pacselector.utils;

/**
 * Clase:Canal.java
 * Clase encargada de  contener los canales de la aplicacion, contiene
 * los canales disponibles, asi como los atributos y metodos de asignacion y 
 * obtenci0n.
 */
public enum Canal {

    /**
     * Canales disponibles
     */
    CANAL_BD_ARQ("CANAL_ARQ_BD");

    /**
     * prpiedad de canal a dar de alta
     */
    private String canalDb;

    /**
     * Constructor
     * 
     * @param canal
     */
    Canal(String canal){
        this.canalDb=canal;
    }

    /**
     * Regresa el canal.
     * 
     * @return the canal
     */
    public String getCanal() {
        return canalDb;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.canalDb;
    }
}
