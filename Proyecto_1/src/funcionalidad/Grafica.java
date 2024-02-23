package funcionalidad;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Grafica {

    //PARA GRAFICA DE BARRAS
    public static String tituloBarras;
    public static String tituloxBarras;
    public static String tituloyBarras;
    static LinkedList<Object> listEjexBarras = new LinkedList<Object>();
    static LinkedList<Object> listEjeyBarras = new LinkedList<Object>();

    //PARA GRAFICA DE PIE
    public static String tituloPie;
    static LinkedList<Object> listValuesPie = new LinkedList<Object>();
    static LinkedList<Object> listLabelPie = new LinkedList<Object>();

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
            int width = 640;
            /* Width of the image */
            int height = 480;
            /* Height of the image */
            File archivoImagen = new File("grafica_barras.png");
            ChartUtilities.saveChartAsPNG(archivoImagen, grafica, width, height);
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
            int width = 640;
            /* Width of the image */
            int height = 480;
            /* Height of the image */
            File archivoImagen = new File("grafica_pie.png");
            ChartUtilities.saveChartAsPNG(archivoImagen, grafica, width, height);
        } catch (IOException ex) {
            Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
