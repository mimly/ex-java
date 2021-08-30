package v1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.LinkedList;

import v1.Model;
import v1.event.ModelEvent;
import v1.event.ModelListener;

public class FavouriteLanguagePoll implements Model {

    private final Map<String, Integer> immutableLanguages = Map.of("C/C++", 1, "Haskell", 1, "Java", 1, "JavaScript", 1, "Python", 1);
    private final Map<String, Integer> favouriteLanguages = new HashMap<>(immutableLanguages);
    private final List<ModelListener> listeners = new LinkedList<>();

    @Override
    public void addModelListener(ModelListener modelListener) {
        this.listeners.add(modelListener);
    }

    @Override
    public void removeModelListener(ModelListener modelListener) {
        this.listeners.remove(modelListener);
    }

    @Override
    public void notifyListeners(Object source) {
        this.listeners.forEach(modelListener -> modelListener.modelChanged(new ModelEvent(source, this)));
    }

    @Override
    public Set<String> getLanguages() {
        return this.favouriteLanguages.keySet();
    }

    @Override
    public double calculatePercentageOf(String language) {
        int votes = this.favouriteLanguages.get(language);
        int totalVotes = this.favouriteLanguages.values().stream().mapToInt(Integer::intValue).sum();
        return votes * 100.0 / totalVotes;
    }

    @Override
    public void collectVoteFor(String language) {
        int votes = this.favouriteLanguages.get(language);
        this.favouriteLanguages.put(language, votes + 1);
    }
}
