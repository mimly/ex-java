package v1;

import java.util.Set;

import v1.Model;
import v1.event.ModelListener;

public class ModelDecorator implements Model {

    private final Model model;

    public ModelDecorator(Model model) {
        this.model = model;
    }

    @Override
    public void addModelListener(ModelListener modelListener) {
        this.model.addModelListener(modelListener);
    }

    @Override
    public void removeModelListener(ModelListener modelListener) {
        this.model.removeModelListener(modelListener);
    }

    @Override
    public void notifyListeners(Object source) {
        this.model.notifyListeners(source);
    }

    @Override
    public Set<String> getLanguages() {
        return this.model.getLanguages();
    }

    @Override
    public double calculatePercentageOf(String language) {
        return this.model.calculatePercentageOf(language);
    }

    @Override
    public void collectVoteFor(String language) {
        this.model.collectVoteFor(language);
    }
}
