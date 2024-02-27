package funcionalidad;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

public class Grafica {
    
    //ALMACENANDO NOMBRES DE IMAGENES
    public static LinkedList<String> listImagenes = new LinkedList<String>();
    //PARA GRAFICA DE BARRAS
    public static String tituloBarras;
    public static String tituloxBarras;
    public static String tituloyBarras;
    static LinkedList<Object> listEjexBarras = new LinkedList<Object>();
    static LinkedList<Object> listEjeyBarras = new LinkedList<Object>();
    static int contadorBarras = 0;
    
    //PARA GRAFICA DE PIE
    public static String tituloPie;
    static LinkedList<Object> listValuesPie = new LinkedList<Object>();
    static LinkedList<Object> listLabelPie = new LinkedList<Object>();
    static int contadorPIE = 0;
    
    //PARA GRAFICA DE LINE
    public static String tituloLine;
    public static String tituloxLine;
    public static String tituloyLine;
    static LinkedList<Object> listEjexLine = new LinkedList<Object>();
    static LinkedList<Object> listEjeyLine = new LinkedList<Object>();
    static int contadorLine = 0;
    
    //PARA HISTOGRAMA
    public static String tituloHisto;
    static LinkedList<Object> listValuesHisto = new LinkedList<Object>();
    static int contadorHistograma = 0;
    
    public static void igualarExb(LinkedList<Object> limpresiones) {
        listEjexBarras = limpresiones;
    }

    public static void igualarEyb(LinkedList<Object> limpresiones) {
        listEjeyBarras = limpresiones;
    }

    public static void barras() {
        try {
            //Ingreso de datos
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            LinkedList<Object> listasimbolos1 = new LinkedList<Object>();
            listasimbolos1 = listEjexBarras;
            LinkedList<Object> listasimbolos2 = new LinkedList<Object>();
            listasimbolos2 = listEjeyBarras;
            for (int i = 0; i < listasimbolos2.size(); i++) {
                String d = (String) listasimbolos1.get(i);
                Double c = Double.parseDouble(listasimbolos2.get(i).toString());
                dataset.addValue(c, "Valor", d);
            }

            // Creación de gráfica
            JFreeChart grafica
                    = ChartFactory.createBarChart(
                            tituloBarras, //TITULO
                            tituloxBarras, tituloyBarras,
                            dataset,
                            PlotOrientation.VERTICAL,
                            true, true, true);

            // Mostrar
//        ChartFrame frame = new ChartFrame("Grafica de Barras", grafica);
//        frame.pack();
//        frame.setVisible(true);
// Guardar la gráfica como una imagen
            int width = 580;
            /* Width of the image */
            int height = 470;
            /* Height of the image */
            File archivoImagen = new File("graficaBARRA" + contadorBarras + ".png");
            listImagenes.add("graficaBARRA" + contadorBarras + ".png");
            ChartUtilities.saveChartAsPNG(archivoImagen, grafica, width, height);
            contadorBarras +=1;
        } catch (IOException ex) {
            Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void igualarvalPie(LinkedList<Object> limpresiones) {
        listValuesPie = limpresiones;
    }

    public static void igualarLaPie(LinkedList<Object> limpresiones) {
        listLabelPie = limpresiones;
    }

    public static void gPie() {
        try {
            //Ingreso de datos
            DefaultPieDataset dataset = new DefaultPieDataset();

            LinkedList<Object> listasimbolos1 = new LinkedList<Object>();
            listasimbolos1 = listLabelPie;
            LinkedList<Object> listasimbolos2 = new LinkedList<Object>();
            listasimbolos2 = listValuesPie;
            for (int i = 0; i < listasimbolos2.size(); i++) {
                String d = (String) listasimbolos1.get(i);
                Double c = Double.valueOf(listasimbolos2.get(i).toString());
                dataset.setValue(d, c);
            }
            /*for(int i = 0; i < 5; i++){
            dataset.setValue(ejex[i], valores[i]);
            }*/
            // Creación de gráfica
            JFreeChart grafica = ChartFactory.createPieChart(tituloPie, dataset);
            PiePlot plot = (PiePlot) grafica.getPlot();
            plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1}"));
            plot.setLabelBackgroundPaint(new Color(220, 220, 220)); // Configura el color de fondo de las etiquetas
            plot.setLabelOutlinePaint(Color.BLACK); // Configura el color del borde de las etiquetas
            plot.setLabelShadowPaint(Color.WHITE); // Configura el color de la sombra de las etiquetas

            // Mostrar
            int width = 580;
            /* Width of the image */
            int height = 470;
            /* Height of the image */
            File archivoImagen = new File("graficaPIE"+contadorPIE+".png");
            listImagenes.add("graficaPIE"+contadorPIE+".png");
            ChartUtilities.saveChartAsPNG(archivoImagen, grafica, width, height);
            contadorPIE += 1;
        } catch (IOException ex) {
            Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void igualarExL(LinkedList<Object> limpresiones) {
        listEjexLine = limpresiones;
    }

    public static void igualarEyL(LinkedList<Object> limpresiones) {
        listEjeyLine = limpresiones;
    }

    public static void gLine() {
        try {
            // Ingreso de datos
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            // Agregar datos al dataset
            for (int i = 0; i < listEjexLine.size(); i++) {
                dataset.addValue(Double.parseDouble(listEjeyLine.get(i).toString()), "Datos", listEjexLine.get(i).toString());
            }

            // Creación de la gráfica de líneas
            JFreeChart chart = ChartFactory.createLineChart(tituloLine, tituloxLine, tituloyLine, dataset, PlotOrientation.VERTICAL, true, true, false);

            // Mostrar
            int width = 580;
            /* Width of the image */
            int height = 470;
            File chartFile = new File("graficaLinea"+contadorLine+".png");
            listImagenes.add("graficaLinea"+contadorLine+".png");
            ChartUtilities.saveChartAsPNG(chartFile, chart, width, height);
            contadorLine += 1;
        } catch (IOException ex) {
            Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void igualarvalHist(LinkedList<Object> limpresiones) {
        listValuesHisto = limpresiones;
    }
   
    public static void gHisto(){
         // Convertir los elementos de la lista en valores numéricos
        List<Double> valores = new ArrayList<>();
        for (Object valor : listValuesHisto) {
            valores.add(Double.parseDouble(valor.toString()));
        }

        // Ordenar la lista de valores numéricos de menor a mayor
        Collections.sort(valores);

        // Calcular la frecuencia, frecuencia acumulada y frecuencia relativa
        Map<Double, Integer> frecuenciaMap = new TreeMap<>();
        for (Double valor : valores) {
            frecuenciaMap.put(valor, frecuenciaMap.getOrDefault(valor, 0) + 1);
        }

        // Calcular la frecuencia acumulada y la frecuencia relativa
        double total = valores.size();
        double frecuenciaAcumulada = 0.0;
        String txtHisto ="";
        txtHisto += "________________________________________________________________________________________\n";
        txtHisto +="\t\tAnalisis de Arreglo\n";
        txtHisto += "________________________________________________________________________________________\n";
        txtHisto += "________________________________________________________________________________________\n";
        txtHisto += String.format("| %10s | %15s | %22s | %22s |\n", "Valor", "Frecuencia", "Frecuencia Acumulada","Frecuencia Relativa");
        txtHisto +="_________________________________________________________________________________________\n";
        double totalfrec = 0.0;
        double totalfrecAc = 0.0;
        double totalfrecRel = 0.0;
                
        for (Map.Entry<Double, Integer> entry : frecuenciaMap.entrySet()) {
            double valor = entry.getKey();
            int frecuencia = entry.getValue();
            totalfrec +=frecuencia;
            frecuenciaAcumulada += frecuencia;
            totalfrecAc = frecuenciaAcumulada;
            double frecuenciaRelativa = frecuencia / total * 100; // Calcula la frecuencia relativa en porcentaje
            totalfrecRel += frecuenciaRelativa;
            txtHisto += String.format("| %10s | %15s | %22s | %22s |\n",valor ,(int)Math.round(frecuencia) , (int)Math.round(frecuenciaAcumulada) ,(int)Math.round(frecuenciaRelativa) + "%");
        }
        txtHisto +="_________________________________________________________________________________________\n";
        txtHisto += String.format("| %10s | %15s | %22s | %22s |\n","Totales:",(int)Math.round(totalfrec),(int)Math.round(totalfrecAc),(int)Math.round(totalfrecRel) + "%");
        txtHisto +="_________________________________________________________________________________________\n";
        funcionalidad.Funcion.addImpresionSimpleH(txtHisto);
        // Calcular el histograma
        double[] valoresArray = valores.stream().mapToDouble(Double::doubleValue).toArray();
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Histograma", valoresArray, 15); // Número de bins

        // Crear la gráfica de histograma
        JFreeChart chart;
        chart = ChartFactory.createHistogram(tituloHisto, "Valor", "Frecuencia", dataset,PlotOrientation.VERTICAL,true,false,false);

        // Guardar la gráfica como imagen
        try {
            int width = 580;
            /* Width of the image */
            int height = 470;
            File chartFile = new File("Histograma"+contadorHistograma+".png");
            listImagenes.add("Histograma"+contadorHistograma+".png");
            ChartUtilities.saveChartAsPNG(chartFile, chart, width, height);
            contadorHistograma += 1;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
