package introductory;

import java.util.ArrayList;
import java.util.List;

public class GenericInterfaces {

    public static void main (String[] args) {
        GenericInterface<Integer> cc = new ConcreteClass();
        GenericInterface<Integer> gc = new GenericClass<>();
        GenericInterface<Integer> rc = new RawClass();

        System.out.println(cc.method(1));
        System.out.println(cc.method(2));
        System.out.println(cc.method(3));
    }
}

interface GenericInterface<T> {
    T method(T t);
}

class ConcreteClass implements GenericInterface<Integer> {
    @Override
    public Integer method(Integer t) { return t; }
}

class GenericClass<T> implements GenericInterface<T> {
    @Override
    public T method(T t) { return t; }
}

class RawClass implements GenericInterface {
    @Override
    public Object method(Object t) { return t; }
}
