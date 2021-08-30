package animal.v4;

import animal.v4.*;

public class Parrot extends Animal implements Flyable {

    String favouriteWord = "Sunny";

    @Override
    public void feed() {
        System.out.println("Feeding a parrot...");
    }

    @Override
    public void fly() {
        System.out.println("A parrot is flying...");
    }
}
