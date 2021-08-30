package introductory;

public class ArraysVsGenerics {

    public static void main (String[] args) {
        Number[] ns = new Integer[3];
        ns[0] = 1;
        ns[1] = 2;
        ns[2] = 3;

        Object[] os = ns; // covariance, implicit (widening) type conversion
        os[0] = "ArrayStoreException at runtime.";
    }
}
