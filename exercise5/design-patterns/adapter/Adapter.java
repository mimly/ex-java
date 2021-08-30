package adapter;

public class Adapter {

    public static void main (String[] args) {
        Service service = new ConcreteService();
        ConcreteConnector adapter = new ConcreteConnector(service);
        adapter.connectViaMicroUSB();
    }
}

/**
 * Adapter design pattern - converts the interface of a class into another interface clients expect
 * and lets classes work together that coudn't otherwise because of incompatible interfaces.
 */
class ConcreteConnector implements Client { // adapter
    private final Service service; // adaptee

    public ConcreteConnector(Service service) {
        this.service = service;
    }

    public void connectViaMicroUSB() {
        // ...
        this.service.connectViaUSB(); // delegation
        // ...
    }
}

/**
 * Adapter (ConcreteConnector) provides a different interface to the adaptee (Service) object.
 * @See Decorator.java
 * @See Proxy.java
 */
interface Client {
    void connectViaMicroUSB();
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
