package decorator;

public class Decorator {

    public static void main (String[] args) {
        Service service = new ConcreteService();
        Connector decorator = new ConcreteConnector(service);
        decorator.connectViaUSB();
    }
}

/**
 * Decorator design pattern - attaches additional responsibilities to an object dynamically
 * and provides a flexible alternative to subclassing for extending functionality.
 */
abstract class Connector implements Service { // decorator
    private final Service service; // decorable

    public Connector(Service service) {
        this.service = service;
    }

    @Override
    public void connectViaUSB() {
        this.service.connectViaUSB(); // delegation
    }
}

/**
 * Decorator (ConcreteConnector) provides an enhanced interface to the decorable (Service) object,
 * without changing its interface.
 * @See Adapter.java
 * @See Proxy.java
 */
class ConcreteConnector extends Connector {

    public ConcreteConnector(Service service) {
        super(service);
    }

    @Override
    public void connectViaUSB() {
        // ...
        super.connectViaUSB();
        // ...
    }

    // ...
}

interface Service {
    void connectViaUSB();
}

class ConcreteService implements Service {

    @Override
    public void connectViaUSB() {
        // ...
    }
}
