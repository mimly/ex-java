package introductory;

/**
 * What will be printed out? Justify the answer in each case.
 */
public class VirtualMethodInvocation {

    public static void main(String[] args) {
        Object a = new Object();
        Base b = new Sub();
        Object c = new Sub();

        a.equals(a);
        a.equals(b);
        a.equals(c);

        System.out.println("---");

        b.equals(a);
        b.equals(b);
        b.equals(c);

        System.out.println("---");

        c.equals(a);
        c.equals(b);
        c.equals(c);
    }
}

class Base {

    public boolean equals(Base b) {
        System.out.println("equals(Base) in Base");
        return true;
    }

    public boolean equals(Object o) {
        System.out.println("equals(Object) in Base");
        return true;
    }
}

class Sub extends Base { }
