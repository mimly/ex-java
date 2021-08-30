package introductory;

import java.util.ArrayList;
import java.util.List;

public class RawTypesVsGenerics {

    public static void main (String[] args) {
        List ls = new ArrayList();
        ls.add(1);
        ls.add(2);
        ls.add(3);

        // int i = ls.get(0); // incompatible types: java.lang.Object cannot be converted to int
        Integer i = (Integer) ls.get(0); // explicit (narrowing) type conversion required

        ls.add("ClassCastException may occur at runtime"); // heterogenous lists, not type-safe
        Integer j = (Integer) ls.get(3);
    }
}
