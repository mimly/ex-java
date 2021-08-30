package introductory;

public class GenericAlgorithms {

    /**
     * Will the generic method below compile? If not, why?
     * Rewrite it so that it does compile and take as input an arbitrary number of arguments.
     * What is the method converted to after type erasure?
     * In which ways the method can be invoked?
     * Which methods can be invoked on the instance x, y?
     */
    public static <T> T max(T x, T y) {
        return x > y ? x : y;
    }

    /**
     * Write a generic method that takes an array and two indices as input,
     * and exchanges the position of two elements at respective indices in the array.
     * Answer the questions above.
     */
    public static <T> void swap(T[] arr, int x, int y) {
        // ...
    }

    /**
     * Write a generic method that looks through a list of any type.
     * Ensure that the method works well for all kinds of lists of objects.
     * Answer the questions above.
     */
}
