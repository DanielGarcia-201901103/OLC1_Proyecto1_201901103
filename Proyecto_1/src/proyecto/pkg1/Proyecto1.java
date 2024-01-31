package proyecto.pkg1;

import java.io.StringReader;

public class Proyecto1 {

  
    public static void main(String[] args) {
        //analizadores("src/analizadorDF/", "Lexer.jflex", "Parser.cup");
        ventanaG.InterfazPrincipal.main(args);
    }
    
    public static void analizadores(String ruta, String jflexFile, String cupFile) {
        try {
            String opcionesJflex[] = {ruta + jflexFile, "-d", ruta};
            jflex.Main.generate(opcionesJflex);

            String opcionesCup[] = {"-destdir", ruta, "-parser", "Parser", ruta + cupFile};
            java_cup.Main.main(opcionesCup);

        } catch (Exception e) {
            System.out.println("No se ha podido generar los analizadores");
            System.out.println(e);
        }
    }
    /*
    public static void analizar(String entrada){
        try{
            
            analizadorDF.Lexer lexer = new analizadorDF.Lexer(new StringReader(entrada));
            analizadorDF.Parser parser = new analizadorDF.Parser(lexer);
            parser.parse();
        }catch(Exception e){
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println(e);
        }
    }*/
}
