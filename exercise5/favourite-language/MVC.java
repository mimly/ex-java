package v1;

import javax.swing.SwingUtilities;

import v1.BarChartView;
import v1.FavouriteLanguagePoll;
import v1.Model;
import v1.PieChartView;

public class MVC {

    public static void main (String[] args) {
        final Model model = new FavouriteLanguagePoll();
        SwingUtilities.invokeLater(() -> BarChartView.createAndShowGUI(model));
        SwingUtilities.invokeLater(() -> PieChartView.createAndShowGUI(model));
    }
}
