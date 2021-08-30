package animal.v3;

import animal.v3.*;

public class Parrot extends Animal implements Flyable {

    @Override
    public void feed() {
        System.out.println("Feeding a parrot...");
    }

    @Override
    public void fly() {
        System.out.println("A parrot is flying...");
    }
}
