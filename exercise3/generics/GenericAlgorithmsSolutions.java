package introductory;

import java.util.Arrays;
import java.util.List;

public class GenericAlgorithmsSolutions {

    /**
     * Will the generic method below compile? If not, why?
     * Rewrite it so that it does compile and take as input an arbitrary number of arguments.
     * What is the method converted to after type erasure?
     * In which ways the method can be invoked?
     * Which methods can be invoked on the instance x, y?
     */
    @SafeVarargs
    public static <T extends Comparable<T>> T max(T... args) {
        T max = null;
        for (T arg : args) {
            if (max == null || arg.compareTo(max) > 0) {
                max = arg;
            }
        }

        return max;
    }

    /**
     * Write a generic method that takes an array and two indices as input,
     * and exchanges the position of two elements at respective indices in the array.
     * Answer the questions above.
     */
    public static <T> void swap(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    /**
     * Write a generic method that looks through a list of any type.
     * Ensure that the method works well for all kinds of lists of objects.
     * Answer the questions above.
     */
    public static void print(List<?> ls) {
        for (Object obj : ls) {
            System.out.println(obj);
        }
    }

    public static void main (String[] args) {
        System.out.println(max(1, 3, 5, 4, 2));
        System.out.println(max("a", "c", "e", "d", "b"));

        Integer[] arr = new Integer[] {1, 2, 3};
        swap(arr, 0, 2);
        System.out.println(Arrays.toString(arr));

        print(List.of(1, 2, 3));
        GenericAlgorithmsSolutions.print(List.of(1.0, 2.0, 3.0));
        GenericAlgorithmsSolutions.<String>print(List.of("a", "b", "c"));
    }
}
