package v1;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.LegendItemEntity;
import org.jfree.data.general.DefaultPieDataset;

import v1.Model;
import v1.event.ChartMouseAdapter;

public class PieChartView {

    public static void createAndShowGUI(Model model) {
        JFrame frame = new JFrame("Pie Chart View");

        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        model.getLanguages().forEach(language -> dataset.setValue(language, model.calculatePercentageOf(language)));

        model.addModelListener(e -> {
            String language = (String) e.getSource();
            dataset.setValue(language, e.calculatePercentageOf(language));
        });

        JFreeChart chart =
                ChartFactory.createPieChart(
                        "My favourite programming language",
                        dataset,
                        true,
                        true,
                        false);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        chartPanel.addChartMouseListener((ChartMouseAdapter) e -> {
                ChartEntity chartEntity = e.getEntity();
                if (chartEntity instanceof LegendItemEntity) {
                    LegendItemEntity itemEntity = (LegendItemEntity) chartEntity;
                    String language = String.valueOf(itemEntity.getSeriesKey());
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
