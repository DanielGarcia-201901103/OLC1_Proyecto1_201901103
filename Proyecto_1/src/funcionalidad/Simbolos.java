package funcionalidad;

import java.util.LinkedList;

public class Simbolos {
    private String nombre = "";
    private String valor = "";
    private String tipo = "";
    private int linea = 0;
    private int columna = 0;
    private static LinkedList<Object> datoslistas = new LinkedList<Object>();
    
    public void addSimbolos(String nombre, String valor, String tipo, int linea,int  columna){
        this.setNombre(nombre);
        this.setValor(valor);
        this.setTipo(tipo);
        this.setLinea(linea);
        this.setColumna(columna);
    }
    
    public void addSimbolos(String nombre, LinkedList datoslistas, String tipo, int linea,int  columna){
        this.setNombre(nombre);
        this.setDatoslistas(datoslistas);
        this.setTipo(tipo);
        this.setLinea(linea);
        this.setColumna(columna);
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the linea
     */
    public int getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(int linea) {
        this.linea = linea;
    }

    /**
     * @return the columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * @return the datoslistas
     */
    public static LinkedList<Object> getDatoslistas() {
        return datoslistas;
    }

    /**
     * @param aDatoslistas the datoslistas to set
     */
    public static void setDatoslistas(LinkedList<Object> aDatoslistas) {
        datoslistas = aDatoslistas;
    }
    
}
