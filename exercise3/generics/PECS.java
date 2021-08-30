package advanced;

import java.util.ArrayList;
import java.util.List;

class A {}
class B extends A {}
class C extends B {}

/**
 * Producer Extends Consumer Super
 */
public class PECS {

    /**
     * Which one of the following lines do and don't compile? And why?
     */
    public static void main (String[] args) {
        List<? extends B> ls1 = new ArrayList<C>();
        ls1.add(new C());
        ls1.set(0, new C());

        List<? super B> ls2 = new ArrayList<A>();
        ls2.add(new C());
        ls2.set(0, new C());
    }
}
