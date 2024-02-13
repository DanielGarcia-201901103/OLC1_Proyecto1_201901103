package funcionalidad;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Funcion {
    
    static LinkedList<Object> listaTokensDataF = new LinkedList<Object>();
    //Para guardar los errores 
    static LinkedList<Object> listaErrores = new LinkedList<Object>();
    
    //Para almacenar los datos en simbolos 
    static Map<String, LinkedList<Object>> hashMapSimbolos = new HashMap<>();
    static String nombreArchivo = ""; 
    /*
    Trabajando con el codigo siguiente
    */
    public static void addHMSimbolos(String nombrelista, String nombre, String valor, String tipo, int linea,int  columna){
        Simbolos sim = new Simbolos();
        sim.addSimbolos(nombre.toLowerCase(), valor, tipo, linea, columna);
        hashMapSimbolos.computeIfAbsent(nombrelista, key -> new LinkedList<>()).add(sim);
    }
    
    /*
    Simbolos sim = new Simbolos();
        sim.addSimbolos(simbolo.toLowerCase(), valor, tipo);
        hashMapJson.computeIfAbsent(nombreArchivo, key -> new LinkedList<>()).add(sim);

        // Acceder al valor del HashMap principal y luego al del HashMap interno
        //String valor = hashMapJson.get("clavePrincipal").get("clave1");
        //System.out.println("Valor obtenido: " + valor);
    */
    
    // METODO PARA RECORRER LOS DATOS DE LA TABLA DE SIMBOLOS DE ACUERDO AL TIPO DE INSTRUCCION QUE SE BUSQUE RECORRER
    public static String buscarValordId(String nombrelista, String nombreid) {
        LinkedList<Object> listasimbolos1 = new LinkedList<Object>();
        listasimbolos1 = hashMapSimbolos.get(nombrelista);
        for (int i = 0; i < listasimbolos1.size(); i++) {
            Simbolos simRecorrer = (Simbolos) listasimbolos1.get(i);
            if (nombreid.equals(simRecorrer.getNombre())){
            //System.out.println(i + ". " + simRecorrer.getNombre() + " - " +simRecorrer.getTipo()+ " - " + simRecorrer.getValor() + " - " + simRecorrer.getLinea()+ " - " + simRecorrer.getColumna());
                //System.out.println("Coincidencia, obteniendo el valor");    
                return simRecorrer.getValor();
            }
        }
        return "Valor no encontrado";
    }
    /*
    // Crear un HashMap con claves de tipo String y listas vinculadas como valores
        Map<String, LinkedList<String>> hashMap = new HashMap<>();

        // Agregar elementos a las listas vinculadas asociadas a las claves
        hashMap.computeIfAbsent("clave1", key -> new LinkedList<>()).add("Valor 1 para clave1");
        hashMap.computeIfAbsent("clave2", key -> new LinkedList<>()).add("Valor 1 para clave2");
        hashMap.computeIfAbsent("clave2", key -> new LinkedList<>()).add("Valor 2 para clave2");

        // Recuperar elementos de las listas vinculadas
        LinkedList<String> lista1 = hashMap.get("clave1");
        LinkedList<String> lista2 = hashMap.get("clave2");

        // Imprimir los elementos de las listas vinculadas
        System.out.println("Lista para clave1: " + lista1);
        System.out.println("Lista para clave2: " + lista2);*/
    public static void addTokensDataF(String lexema, String token, int linea, int columna) {
        Tokens objToken = new Tokens();
        objToken.addTokens(lexema, token, linea, columna);
        listaTokensDataF.add(objToken);
    }

    public static void crearReporteTokensDataF() throws FileNotFoundException {
        FileOutputStream rep = new FileOutputStream("ReporteTokens.html");
        PrintStream t = new PrintStream(rep);
        t.println("""
                   <!DOCTYPE html>
                   <html>
                   <style>
                   body{
                   background: #ADA996;  /* fallback for old browsers */
                   background: -webkit-linear-gradient(to right, #EAEAEA, #DBDBDB, #F2F2F2, #ADA996);  /* Chrome 10-25, Safari 5.1-6 */
                   background: linear-gradient(to right, #EAEAEA, #DBDBDB, #F2F2F2, #ADA996); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                   }
                   table, th, td {
                     border:1px solid black;
                   }
                   </style>
                   <body>
                   
                   <h2> *************** Reporte Tabla de Tokens ***************</h2>
                   
                   <table style="width:100%">
                     <tr>
                       <th>#</th>
                       <th>Lexema</th>
                       <th>Tipo</th>
                       <th>Linea</th>
                       <th>Columna</th>
                     </tr>\n
                   """);
        //txt.concat("");
        int contador = 1;
        for (int i = 0; i < listaTokensDataF.size(); i++) {
            Tokens simRecorrer = (Tokens) listaTokensDataF.get(i);
            t.println("""
                      <tr>
                      <td>"""+  Integer.toString(contador) + "</td>\n"
                    + "<td>" + simRecorrer.getLexema() + "</td>\n"
                    + "<td>" + simRecorrer.getToken() + "</td>\n"
                    + "<td>" + simRecorrer.getLinea() + "</td>\n"
                    + "<td>" + simRecorrer.getColumna() + "</td>\n"
                    + "</tr>\n");
            contador = contador + 1 ;
        }
        t.println("""
                   </table>
   
                   </body>
                   </html>""");
        listaTokensDataF.clear();
    }
    
    public static void addErroresLista(String tipo, String descripcion, int linea, int columna) {
        Errores errorL = new Errores();
        errorL.addErrores(tipo, descripcion, linea, columna);
        listaErrores.add(errorL);
    }

    public static void recorrerListaErrores() throws FileNotFoundException {
        FileOutputStream rep = new FileOutputStream("ReporteErrores.html");
        PrintStream t = new PrintStream(rep);
        t.println("""
                   <!DOCTYPE html>
                   <html>
                   <style>
                   body{
                   background: #FFEFBA;  /* fallback for old browsers */
                   background: -webkit-linear-gradient(to right, #FFFFFF, #FFEFBA);  /* Chrome 10-25, Safari 5.1-6 */
                   background: linear-gradient(to right, #FFFFFF, #FFEFBA); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                   }
                   table, th, td {
                     border:1px solid black;
                   }
                   </style>
                   <body>
                   
                   <h2> *************** Reporte Tabla de Errores ***************</h2>
                   
                   <table style="width:100%">
                     <tr>
                       <th>#</th>
                       <th>Tipo</th>
                       <th>Descripción</th>
                       <th>Linea</th>
                       <th>Columna</th>
                     </tr>\n
                   """);
        //txt.concat("");
        int contador = 1;
        for (int i = 0; i < listaErrores.size(); i++) {
            Errores simRecorrer = (Errores) listaErrores.get(i);
            t.println("""
                      <tr> 
                      <td>""" +  Integer.toString(contador) + "</td>\n"
                    + "<td>" + simRecorrer.getTipo() + "</td>\n"
                    + "<td>" + simRecorrer.getDescripcion() + "</td>\n"
                    + "<td>" + simRecorrer.getLinea() + "</td>\n"
                    + "<td>" + simRecorrer.getColumna() + "</td>\n"
                    + "</tr>\n");
            //System.out.println(i + ". "+ simRecorrer.getLexema() + " - "+ simRecorrer.getDescripcion() + " - " + simRecorrer.getLinea() + " c: " + simRecorrer.getColumna());
        contador = contador + 1 ;
        }
        t.println("""
                   </table>
   
                   </body>
                   </html>""");
        listaErrores.clear();
    }
    
    public static void recibiendoNombreArchivo(String nombreArchivo1) {
        nombreArchivo = "\""+nombreArchivo1+"\"";
        System.out.println("nombre del archivo"+ nombreArchivo);
    }
    
    
}
