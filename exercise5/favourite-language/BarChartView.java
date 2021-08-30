package v1;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.entity.CategoryLabelEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import v1.Model;
import v1.event.ChartMouseAdapter;

public class BarChartView {

    public static void createAndShowGUI(Model model) {
        JFrame frame = new JFrame("Bar Chart View");

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        model.getLanguages().forEach(language -> dataset.setValue(model.calculatePercentageOf(language), "%", language));

        model.addModelListener(e -> {
            String language = (String) e.getSource();
            dataset.setValue(e.calculatePercentageOf(language), "%", language);
        });

        JFreeChart chart =
                ChartFactory.createBarChart(
                        "My favourite programming language",
                        "",
                        "Percentage (%) of KTH students",
                        dataset,
                        PlotOrientation.VERTICAL,
                        false,
                        true,
                        false);

        NumberAxis rangeAxis = (NumberAxis) chart.getCategoryPlot().getRangeAxis();
        rangeAxis.setRange(0, 100);
        rangeAxis.setTickUnit(new NumberTickUnit(5));

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        chartPanel.addChartMouseListener((ChartMouseAdapter) e -> {
            ChartEntity chartEntity = e.getEntity();
            if (chartEntity instanceof CategoryLabelEntity) {
                CategoryLabelEntity labelEntity = (CategoryLabelEntity) chartEntity;
                String language = String.valueOf(labelEntity.getKey());
                model.collectVoteFor(language);
                model.notifyListeners(language);
            }
        });
        frame.add(chartPanel);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
