package animal.v4;

import animal.v4.*;

public class Dog extends Animal implements Walkable {

    @Override
    public void feed() {
        System.out.println("Feeding a dog...");
    }

    @Override
    public void walk() {
        System.out.println("A dog is walking...");
    }
}
