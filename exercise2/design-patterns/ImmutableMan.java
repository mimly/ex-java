package immutable;

import java.util.List;

/**
 * Immutable object pattern = one state, never changes
 *
 * 1) The state of the object, i.e. all properties, initialized upon creation in constructor.
 * 2) Proper data encapsulation, i.e. private and final instance variables and no mutator methods.
 * 3) No shared references to mutable objects. (wrapper methods/deep copy)
 * 4) No overriden methods. (final class or methods/private constructor and factory)
*/
public final class ImmutableMan { // or not?

    private final int age; // primitive
    private final String name; // immutable reference
    private final List<String> favouriteBooks; // mutable reference

    public ImmutableMan(final int age, final String name, final List<String> favouriteBooks) {
        this.age = age;
        this.name = name;
        this.favouriteBooks = favouriteBooks;
    }

    private int getAge() {
        return age;
    }

    private String getName() {
        return name;
    }

    private List<String> getFavouriteBooks() {
        return favouriteBooks;
    }
}
