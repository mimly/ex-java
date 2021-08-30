package v1.event;

import v1.Model;
import v1.ModelDecorator;

public class ModelEvent extends ModelDecorator {

    private final Object source;

    public ModelEvent(Object source, Model model) {
        super(model);
        this.source = source;
    }

    public Object getSource() {
        return this.source;
    }
}
