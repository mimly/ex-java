package v1.event;

import v1.event.ModelEvent;

@FunctionalInterface
public interface ModelListener {

    void modelChanged(ModelEvent modelEvent);
}
