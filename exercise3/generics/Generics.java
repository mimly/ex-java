package introductory;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main (String[] args) {
        List<Integer> ls = new ArrayList<>(); // diamond operator, type inference
        ls.add(1);
        ls.add(2);
        ls.add(3);

        int i = ls.get(0); // possible due to autoboxing
        Integer j = ls.get(0); // no explicit (narrowing) type conversion required

        // ls.add("no ClassCastException at runtime"); // impossible, compile-time error
    }
}
