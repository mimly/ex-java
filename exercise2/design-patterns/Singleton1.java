package singleton;

/**
 * Singleton pattern = only one single instance
 *
 * 1) One private and static singleton instance variable together with the corresponding public and static accessor method.
 * 2) All constructors in a class, especially the default one, marked private.
 */
public final class Singleton1 {
// implicitly final, why?

    private static final Singleton1 instance = new Singleton1();
    // ...

    private Singleton1() {
        // ...
    }

    public static Singleton1 getInstance() {
        return Singleton1.instance;
    }

    // ...
}
