package com.servlet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/generate")
public class DiagrammGenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream out = resp.getOutputStream();
        resp.setContentType("image/png");

        XYDataset  dataset = getXYDataset();

        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Line Chart",             // chart title
                "X",                      // x axis label
                "Y",                      // y axis label
                dataset,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );
        XYPlot plot = chart.getXYPlot();

        if (chart != null) {
            //resp.setContentType("image/png");
            ChartUtilities.writeChartAsPNG(out, chart, 600, 400);
        }
    }
    public DefaultCategoryDataset getCategoryDataset()
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue( 23.0, "Param1", "Object1");
        dataset.addValue( 14.0, "Param1", "Object2");
        dataset.addValue( 18.0, "Param1", "Object3");
        dataset.addValue( 19.0, "Param1", "Object4");
        dataset.addValue( -6.0, "Param2", "Object1");
        dataset.addValue( -9.0, "Param2", "Object2");
        dataset.addValue( 32.0, "Param2", "Object3");
        dataset.addValue( -5.0, "Param2", "Object4");
        dataset.addValue( 16.0, "Param3", "Object1");
        dataset.addValue( 29.0, "Param3", "Object2");
        dataset.addValue( -4.0, "Param3", "Object3");
        dataset.addValue( 14.0, "Param3", "Object4");
        dataset.addValue( 12.0, "Param4", "Object1");
        dataset.addValue( 26.0, "Param4", "Object2");
        dataset.addValue( -9.0, "Param4", "Object3");
        dataset.addValue(  9.0, "Param4", "Object4");
        dataset.addValue( -9.0, "Param5", "Object1");
        dataset.addValue( -4.0, "Param5", "Object2");
        dataset.addValue( 21.0, "Param5", "Object3");
        dataset.addValue( -3.0, "Param5", "Object4");
        dataset.addValue( 13.0, "Param6", "Object1");
        dataset.addValue( 20.0, "Param6", "Object2");
        dataset.addValue( 15.0, "Param6", "Object3");
        dataset.addValue( 17.0, "Param6", "Object4");
        dataset.addValue(-13.0, "Param7", "Object1");
        dataset.addValue( 18.0, "Param7", "Object2");
        dataset.addValue( null, "Param7", "Object3");
        dataset.addValue( 12.0, "Param7", "Object4");
        dataset.addValue( 14.0, "Param8", "Object1");
        dataset.addValue( 19.0, "Param8", "Object2");
        dataset.addValue( -8.0, "Param8", "Object3");
        dataset.addValue(  7.0, "Param8", "Object4");
        dataset.addValue(-12.0, "Param9", "Object1");
        dataset.addValue( 19.0, "Param9", "Object2");
        dataset.addValue( 21.0, "Param9", "Object3");
        dataset.addValue( -2.0, "Param9", "Object4");
        return dataset;
    }
    public XYDataset getXYDataset() {

        final XYSeries series1 = new XYSeries("First");
        series1.add ( 2.2, 1.3);
        series1.add ( 4.4, 4.2);
        series1.add ( 6.6, 5.5);
        series1.add ( 8.7, 5.8);
        series1.add (11.9, 5.6);
        series1.add ( 7.7, 7.9);
        series1.add ( 5.6, 7.1);
        series1.add ( 3.5, 8.2);

        final XYSeries series2 = new XYSeries("Second");
        series2.add (2.4, 5.5);
        series2.add (4.7, 7.7);
        series2.add (6.6, 6.9);
        series2.add (8.5, 8.8);
        series2.add (9.8, 4.6);
        series2.add (2.3, 4.4);
        series2.add (1.0, 2.2);
        series2.add (3.1, 1.0);

        final XYSeries series3 = new XYSeries("Third");
        series3.add (11.1, 4.4);
        series3.add ( 9.3, 3.6);
        series3.add ( 7.5, 2.8);
        series3.add ( 5.7, 3.9);
        series3.add ( 8.9, 6.6);
        series3.add ( 6.8, 3.4);
        series3.add (12.2, 4.3);
        series3.add (10.4, 3.2);

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);

        return dataset;
    }
}
