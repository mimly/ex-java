package proxy;

public class Proxy {

    public static void main (String[] args) {
        Service service = new ConcreteService();
        ConcreteConnector proxy = new ConcreteConnector(service);
        proxy.connectViaUSB();
    }
}

/**
 * Proxy design pattern - provides a surrogate or placeholder for another object
 * to control access to it.
 */
class ConcreteConnector implements Service { // proxy
    private final Service service; // proxable (Service or ConcreteService)

    public ConcreteConnector(Service service) {
        this.service = service;
    }

    @Override
    public void connectViaUSB() {
        // ...
        this.service.connectViaUSB(); // delegation
        // ...
    }
}

/**
 * Proxy (ConcreteConnector) provides the same interface to the proxable (Service) object.
 * @See Adapter.java
 * @See Decorator.java
 */
interface Service {
    void connectViaUSB();
}

class ConcreteService implements Service {

    @Override
    public void connectViaUSB() {
        // ...
    }
}
