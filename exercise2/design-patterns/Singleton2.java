package singleton;

/**
 * Singleton pattern = only one single instance
 *
 * 1) One private and static singleton instance variable together with the corresponding public and static accessor method.
 * 2) All constructors in a class, especially the default one, marked private.
 */
public final class Singleton2 {
// implicitly final, why?

    private static final Singleton2 instance;
    // ...

    // static initialization block
    static {
        // Singleton2.instance = new Singleton2(); won't compile, why?
        instance = new Singleton2();
        // ... additional steps to be taken after object creation ...
    }

    private Singleton2() {
        // ...
    }

    public static Singleton2 getInstance() {
        return Singleton2.instance;
    }

    // ...
}
