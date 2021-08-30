package singleton;

/**
 * Singleton pattern = only one single instance
 *
 * 1) One private and static singleton instance variable together with the corresponding public and static accessor method.
 * 2) All constructors in a class, especially the default one, marked private.
 */
public final class Singleton3 {
// implicitly final, why?

    // cannot be final, why?
    private static Singleton3 instance;
    // ...

    private Singleton3() {
        // ...
    }

    // not synchronized = not thread-safe (use case: coordinating access to shared resources)
    public static synchronized Singleton3 getInstance() {
        if (Singleton3.instance == null) {
            // lazy instantiation, object created on request, not when class has been loaded
            Singleton3.instance = new Singleton3();
        }

        return Singleton3.instance;
    }

    // ...
}
