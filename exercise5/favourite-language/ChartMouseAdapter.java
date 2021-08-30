package v1.event;

import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;

@FunctionalInterface
public interface ChartMouseAdapter extends ChartMouseListener {

    default void chartMouseMoved(ChartMouseEvent chartMouseEvent) {}
}
