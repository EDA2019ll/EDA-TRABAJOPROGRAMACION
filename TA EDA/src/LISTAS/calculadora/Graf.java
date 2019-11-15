
package LISTAS.calculadora;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Graf {

    JFreeChart grafica;
    XYSeriesCollection data = new XYSeriesCollection();
    String titulo;
    String x;
    String y;

    public Graf(String t, String x1, String y1) {
        titulo = t;
        x = x1;
        y = y1;
        grafica = ChartFactory.createXYLineChart(titulo, x, y,
                data, PlotOrientation.VERTICAL, true, true, true);

    }

    public Graf() {
        this("", "x", "y");

    }

    public void agregarGraf(String id, double[] x, double[] y) {
        XYSeries a = new XYSeries(id);
        int n = x.length;
        for (int i = 0; i < n; i++) {
            a.add(x[i], y[i]);

        }
        data.addSeries(a);
    }

    public void crearGraf(String id, double[] x, double[] y) {
        data.removeAllSeries();
        agregarGraf(id, x, y);
    }

    public JPanel obtieneGrafica() {
        return new ChartPanel(grafica);

    }

}
