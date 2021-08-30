package v1;

import java.util.Set;

import v1.event.ModelListener;

public interface Model {

    void addModelListener(ModelListener modelListener);
    void removeModelListener(ModelListener modelListener);
    void notifyListeners(Object source);
    Set<String> getLanguages();
    double calculatePercentageOf(String language);
    void collectVoteFor(String language);
}
