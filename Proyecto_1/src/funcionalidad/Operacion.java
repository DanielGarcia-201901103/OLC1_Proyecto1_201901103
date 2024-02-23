package funcionalidad;
    
import java.util.LinkedList;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.Frequency;
import java.util.Iterator;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;

public class Operacion {
    
    public static double Suma(double a, double b){
        return a + b;
    }
    public static double Resta(double a, double b){
        return a - b;
    }
    public static double Multiplicacion(double a, double b){
        return a * b;
    }
    public static double Division(double a, double b){
            return a/b;
    }
    public static double Modulo(double a, double b){
            return a%b;
    }
    
    public static double Media(LinkedList<Object> recListaD){
        /*
        1. recibe un arreglo
        2. hace la suma de cada uno de los datos del arreglo
        3. divide la suma entre la cantidad de datos del arreglo
        4. retorna la respuesta
        */
        double cantiV = recListaD.size();
        
        double suma = 0;
        for (int i=0; i< recListaD.size();i++){
            suma += Double.parseDouble(recListaD.get(i).toString());
        }
        double resultado = suma/cantiV;
        return resultado;
    }
    
    public static double Mediana(LinkedList<Object> recListaD){
        double [] temp = new double[recListaD.size()];
        for (int i = 0; i < recListaD.size(); i++){
            temp[i]= Double.parseDouble(recListaD.get(i).toString());
        }
        Median mediana = new Median();
        double resultado = mediana.evaluate(temp);
        return resultado;
    }
    public static double Moda(LinkedList<Object> recListaD){
        double [] temp = new double[recListaD.size()];
        for (int i = 0; i < recListaD.size(); i++){
            temp[i]= Double.parseDouble(recListaD.get(i).toString());
        }
        Frequency frequency = new Frequency();
        for (double d : temp) {
            frequency.addValue(d);
        }

        // Encuentra el valor más frecuente (moda)
        double resultado = 0;
        long maxFrequency = 0;
        Iterator<Comparable<?>> iterator = frequency.valuesIterator();
        while (iterator.hasNext()) {
            Comparable<?> value = iterator.next();
            long currentFrequency = frequency.getCount(value);
            if (currentFrequency > maxFrequency) {
                resultado = (Double) value;
                maxFrequency = currentFrequency;
            }
        }
        return resultado;
    }
    
    public static double Varianza(LinkedList<Object> recListaD){
        double [] temp = new double[recListaD.size()];
        for (int i = 0; i < recListaD.size(); i++){
            temp[i]= Double.parseDouble(recListaD.get(i).toString());
        }
        Variance variance = new Variance();
        double resultado = variance.evaluate(temp);
        return resultado;
    }
    public static double Max(LinkedList<Object> recListaD){
        double [] temp = new double[recListaD.size()];
        for (int i = 0; i < recListaD.size(); i++){
            temp[i]= Double.parseDouble(recListaD.get(i).toString());
        }
        Max max = new Max();
        double resultado = max.evaluate(temp);
        return resultado;
    }
    public static double Min(LinkedList<Object> recListaD){
     double [] temp = new double[recListaD.size()];
        for (int i = 0; i < recListaD.size(); i++){
            temp[i]= Double.parseDouble(recListaD.get(i).toString());
        }
        Min min = new Min();
        double resultado = min.evaluate(temp);
        return resultado;
    }
    
}
