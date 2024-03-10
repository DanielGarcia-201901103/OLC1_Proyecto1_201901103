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
    public static String txtSalida = "";
    //Para almacenar los datos para las impresiones
    static LinkedList<String> listImprimir = new LinkedList<String>();

    //METODO PARA OBTENER LA LISTA DE IMPRESION
    public static void obtenerLImpresion() {
        try {
            if (listImprimir != null) {
                for (int i = 0; i < listImprimir.size(); i++) {
                    txtSalida += listImprimir.get(i);
                    txtSalida += "\n";
                }
            } else {
                txtSalida = "";
            }
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

    //METODO PARA ALMACENAR LAS IMPRESIONES
    public static void addImpresiones(LinkedList<Object> limpresiones) {
        try {
            if (limpresiones != null) {
                String texto = "!Salida: ";
                for (int i = 0; i < limpresiones.size(); i++) {
                    texto += limpresiones.get(i).toString() + " , ";
                }
                if (texto.lastIndexOf(",") != -1) {
                    // Encontrar la posición de la última coma
                    int indiceUltimaComa = texto.lastIndexOf(",");

                    // Crear una subcadena que excluya la última coma
                    texto = texto.substring(0, indiceUltimaComa) + texto.substring(indiceUltimaComa + 1);
                }
//        System.out.println(texto);
                listImprimir.add(texto);
            }

        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

    public static void addImpresionesCol(String stitulo, LinkedList<Object> limpresiones) {
        try {
            if (limpresiones != null) {
                String texto = "------------------------------------------------\n\t";
                texto += stitulo + "\n------------------------------------------------\n";
                for (int i = 0; i < limpresiones.size(); i++) {
                    texto += limpresiones.get(i).toString() + "\n";
                }
                listImprimir.add(texto);

            }

        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

    public static void addImpresionSimpleH(String txtHisto) {
        try {
            listImprimir.add(txtHisto);
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

    //METODO PARA AGREGAR UNA DECLARACIÓN A LA TABLA DE SIMBOLOS
    public static void addHMSimbolos(String nombrelista, String nombre, Object valor, String tipo, int linea, int columna) {
        try {
            Simbolos sim = new Simbolos();
            sim.addSimbolos(nombre.toLowerCase(), valor, tipo, linea, columna);
            hashMapSimbolos.computeIfAbsent(nombrelista, key -> new LinkedList<>()).add(sim);
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

    //METODO PARA AGREGAR UNA DECLARACION DE ARREGLOS A LA TABLA DE SIMBOLOS
    public static void addHMSimbolosA(String nombrelista, String nombre, LinkedList<Object> recListainterna, String tipo, int linea, int columna) {
        try {
            if (recListainterna != null) {
                SimbolosArreglo sim = new SimbolosArreglo(recListainterna);
                sim.setNombre(nombre.toLowerCase());
                sim.setTipo(tipo);
                sim.setLinea(linea);
                sim.setColumna(columna);
                hashMapSimbolos.computeIfAbsent(nombrelista, key -> new LinkedList<>()).add(sim);
            }
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

    // METODO PARA OBTENER EL VALOR DE UNA DECLARACION
    public static Object buscarValordId(String nombrelista, String nombreid) {
        LinkedList<Object> listasimbolos1 = new LinkedList<Object>();
        listasimbolos1 = hashMapSimbolos.get(nombrelista);
        if (listasimbolos1 != null) {
            try {
                for (int i = 0; i < listasimbolos1.size(); i++) {
                    Simbolos simRecorrer = (Simbolos) listasimbolos1.get(i);
                    if (nombreid.equals(simRecorrer.getNombre())) {
                        //System.out.println(i + ". " + simRecorrer.getNombre() + " - " +simRecorrer.getTipo()+ " - " + simRecorrer.getValor() + " - " + simRecorrer.getLinea()+ " - " + simRecorrer.getColumna());
                        return simRecorrer.getValor();
                    }
                }
            } catch (Error e) {
                System.out.println("Error: " + e);
            }
        }
        return "Valor no encontrado";
    }

    //METODO PARA OBTENER EL VALOR DE UNA DECLARACION DE UN ARREGLO
    public static LinkedList<Object> buscarValordIdArr(String nombrelista, String nombreid) {
        LinkedList<Object> listasimbolos1 = new LinkedList<Object>();
        listasimbolos1 = hashMapSimbolos.get(nombrelista);
        if (listasimbolos1 != null) {
            try {
                for (int i = 0; i < listasimbolos1.size(); i++) {
                    SimbolosArreglo simRecorrer1 = (SimbolosArreglo) listasimbolos1.get(i);
                    if (nombreid.equals(simRecorrer1.getNombre())) {
                        LinkedList<Object> listaaux = new LinkedList<Object>();
                        listaaux = simRecorrer1.getDatoslistas();
                        return listaaux;
                    }
                }
            } catch (Error e) {
                System.out.println("Error: " + e);
            }
        }
        return null;
    }

    //METODO PARA IMPRIMIR LOS DATOS DE LA TABLA DE SIMBOLOS
    public static void imprimirValordIdA(String nombrelista, String nombreid) {
        LinkedList<Object> listasimbolos1 = new LinkedList<Object>();
        listasimbolos1 = hashMapSimbolos.get(nombrelista);
        if (listasimbolos1 != null) {
            try {
                for (int i = 0; i < listasimbolos1.size(); i++) {
                    SimbolosArreglo simRecorrer = (SimbolosArreglo) listasimbolos1.get(i);
                    if (nombreid.equals(simRecorrer.getNombre())) {
                        //System.out.println(i + ". " + simRecorrer.getNombre() + " - " +simRecorrer.getTipo()+ " - " + simRecorrer.getValor() + " - " + simRecorrer.getLinea()+ " - " + simRecorrer.getColumna());
                        //System.out.println("Coincidencia, obteniendo el valor");    
                        System.out.println(simRecorrer.getNombre() + " : " + simRecorrer.getDatoslistas());
                    }
                }
            } catch (Error e) {
                System.out.println("Error: " + e);
            }
        }
    }

    //METODO PARA IMPRIMIR LOS DATOS DE LA TABLA DE SIMBOLOS
    public static void imprimirValordId(String nombrelista, String nombreid) {
        LinkedList<Object> listasimbolos1 = new LinkedList<Object>();
        if (listasimbolos1 != null) {
            try {
                listasimbolos1 = hashMapSimbolos.get(nombrelista);
                for (int i = 0; i < listasimbolos1.size(); i++) {
                    Simbolos simRecorrer = (Simbolos) listasimbolos1.get(i);
                    if (nombreid.equals(simRecorrer.getNombre())) {
                        //System.out.println(i + ". " + simRecorrer.getNombre() + " - " +simRecorrer.getTipo()+ " - " + simRecorrer.getValor() + " - " + simRecorrer.getLinea()+ " - " + simRecorrer.getColumna());
                        //System.out.println("Coincidencia, obteniendo el valor");    
                        System.out.println(simRecorrer.getNombre() + " : " + simRecorrer.getValor());
                    }
                }
            } catch (Error e) {
                System.out.println("Error: " + e);
            }
        }
    }

    public static void addTokensDataF(String lexema, String token, int linea, int columna) {
        try {
            Tokens objToken = new Tokens();
            objToken.addTokens(lexema, token, linea, columna);
            listaTokensDataF.add(objToken);
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

    public static void crearReporteTokensDataF() throws FileNotFoundException {
        try {
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
                  th{
                  background-color: #a2ab58;
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
            if (listaTokensDataF != null) {
                for (int i = 0; i < listaTokensDataF.size(); i++) {
                    Tokens simRecorrer = (Tokens) listaTokensDataF.get(i);
                    t.println("""
                      <tr>
                      <td>""" + Integer.toString(contador) + "</td>\n"
                            + "<td>" + simRecorrer.getLexema() + "</td>\n"
                            + "<td>" + simRecorrer.getToken() + "</td>\n"
                            + "<td>" + simRecorrer.getLinea() + "</td>\n"
                            + "<td>" + simRecorrer.getColumna() + "</td>\n"
                            + "</tr>\n");
                    contador = contador + 1;
                }
            }
            t.println("""
                   </table>
   
                   </body>
                   </html>""");
            t.close();
            listaTokensDataF.clear();
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

    public static void addErroresLista(String tipo, String descripcion, int linea, int columna) {
        try {
            Errores errorL = new Errores();
            errorL.addErrores(tipo, descripcion, linea, columna);
            listaErrores.add(errorL);
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

    public static void recorrerListaErrores() throws FileNotFoundException {
        try {
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
                  th{
                                    background-color: #a2ab58;
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
            if (listaErrores != null) {
                for (int i = 0; i < listaErrores.size(); i++) {
                    Errores simRecorrer = (Errores) listaErrores.get(i);
                    t.println("""
                      <tr> 
                      <td>""" + Integer.toString(contador) + "</td>\n"
                            + "<td>" + simRecorrer.getTipo() + "</td>\n"
                            + "<td>" + simRecorrer.getDescripcion() + "</td>\n"
                            + "<td>" + simRecorrer.getLinea() + "</td>\n"
                            + "<td>" + simRecorrer.getColumna() + "</td>\n"
                            + "</tr>\n");
                    //System.out.println(i + ". "+ simRecorrer.getLexema() + " - "+ simRecorrer.getDescripcion() + " - " + simRecorrer.getLinea() + " c: " + simRecorrer.getColumna());
                    contador = contador + 1;
                }
            }
            t.println("""
                   </table>
   
                   </body>
                   </html>""");
            t.close();
            listaErrores.clear();
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

    public static void crearReporteSimbolosDataF() throws FileNotFoundException {
        try {
            FileOutputStream rep = new FileOutputStream("ReporteSimbolos.html");
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
                  th{
                                    background-color: #a2ab58;
                                    }
                   </style>
                   <body>
                   
                   <h2> *************** Reporte Tabla de Simbolos ***************</h2>
                   
                   <table style="width:100%">
                     <tr>
                       <th>#</th>
                       <th>Nombre</th>
                       <th>Tipo</th>
                       <th>Valor</th>
                       <th>Linea</th>
                       <th>Columna</th>
                     </tr>\n
                   """);
            int contador = 1;
            LinkedList<Object> listasimbolos1 = hashMapSimbolos.get("decVariables");
            if (listasimbolos1 != null) {
                for (int i = 0; i < listasimbolos1.size(); i++) {
                    Simbolos simRecorrer = (Simbolos) listasimbolos1.get(i);
                    t.println("""
                          <tr>
                          <td>""" + Integer.toString(contador) + "</td>\n"
                            + "<td>" + simRecorrer.getNombre() + "</td>\n"
                            + "<td>" + simRecorrer.getTipo() + "</td>\n"
                            + "<td>" + simRecorrer.getValor() + "</td>\n"
                            + "<td>" + simRecorrer.getLinea() + "</td>\n"
                            + "<td>" + simRecorrer.getColumna() + "</td>\n"
                            + "</tr>\n");
                    contador++;
                }

            }
            LinkedList<Object> listasimbolos2 = hashMapSimbolos.get("decArreglos");
            if (listasimbolos2 != null) {
                for (int i = 0; i < listasimbolos2.size(); i++) {
                    SimbolosArreglo simRecorrer1 = (SimbolosArreglo) listasimbolos2.get(i);
                    t.println("""
                          <tr>
                          <td>""" + Integer.toString(contador) + "</td>\n"
                            + "<td>" + simRecorrer1.getNombre() + "</td>\n"
                            + "<td>" + simRecorrer1.getTipo() + "</td>\n"
                            + "<td>" + simRecorrer1.getDatoslistas() + "</td>\n"
                            + "<td>" + simRecorrer1.getLinea() + "</td>\n"
                            + "<td>" + simRecorrer1.getColumna() + "</td>\n"
                            + "</tr>\n");
                    contador++;
                }
            }

            t.println("""
                   </table>
                   </body>
                   </html>""");
            t.close();
            hashMapSimbolos.clear();
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

    public static void limpiarDatos() {
        try {
            listaTokensDataF.clear();
            listaErrores.clear();
            hashMapSimbolos.clear();
            txtSalida = "";
            listImprimir.clear();
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }

}
