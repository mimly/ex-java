package advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * Which subtyping relationships apply between the generic types (classes and/or interfaces) below? And why? Draw a UML diagram.
 * - GenericType<?>
 * - GenericType<? extends Number>
 * - GenericType<? extends Integer>
 * - GenericType<? super Number>
 * - GenericType<? super Integer>
 * - GenericType<Number>
 * - GenericType<Integer>
 * Please recall that Integer extends Number.
 */
public class GenericsAndInheritance {

    /**
     * Which one of the following lines do and don't compile? And why?
     */
    public static void main (String[] args) {
        // List<Integer> ls1 = new ArrayList<Integer>();
        // List<Integer> ls2 = new List<Integer>();
        // ArrayList<Integer> ls3 = new ArrayList<Integer>();
        // ArrayList<Integer> ls4 = new List<Integer>();

        // List<?> ls5 = new ArrayList<Number>();
        // List<?> ls6 = new ArrayList<? extends Number>();
        // List<? extends Number> ls7 = new ArrayList<Number>();
        // List<? extends Integer> ls8 = new ArrayList<Number>();
        // List<? super Number> ls9 = new ArrayList<Number>();
        // List<? super Integer> ls10 = new ArrayList<Number>();
    }
}
