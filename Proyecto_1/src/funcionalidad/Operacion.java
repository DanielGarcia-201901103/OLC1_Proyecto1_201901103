package funcionalidad;

public class Operacion {
    
    public double Suma(double a, double b){
        return a + b;
    }
    public double Resta(double a, double b){
        return a - b;
    }
    public double Multiplicacion(double a, double b){
        return a * b;
    }
    public Object Division(double a, double b){
        if (b == 0) {
            return "Error División entre 0";
        }else{
            return a/b;
        }
    }
    public Object Modulo(double a, double b){
        if (b == 0) {
            return "Error División entre 0";
        }else{
            return a%b;
        }
    }
//    public void pruebas(){
//        String txt = "cadena de texto\"";
//        txt.replaceAll("\"", "").trim();
//    }
    /*
    public double Media(){
        
    }
    public double Mediana(){
        
    }
    public double Moda(){
        
    }
    public double Varianza(){
        
    }
    public double Max(){
        
    }
    public double Min(){
     
    }*/
    
}
