package animal.v4;

import animal.v4.*;

public class Cat extends Animal implements Walkable {

    @Override
    public void feed() {
        System.out.println("Feeding a cat...");
    }

    @Override
    public void walk() {
        System.out.println("A cat is walking...");
    }
}
