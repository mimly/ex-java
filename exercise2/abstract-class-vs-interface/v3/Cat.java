package animal.v3;

import animal.v3.*;

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
