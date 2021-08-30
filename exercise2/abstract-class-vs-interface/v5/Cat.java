package animal.v5.pet;

import animal.v5.*;

public class Cat extends Animal implements Walkable {

    @Override
    public void feed() {
        System.out.println("Feeding a cat...");
    }

    @Override
    public void walk() {
        System.out.println("A cat is walking...");
    }

    public static void main (String[] args) {
        // Animal parrot = new Parrot();
        // System.out.println(parrot.hungry);
        // System.out.println(parrot.favouriteWord);
        // System.out.println(parrot.favouriteNumber);
        // System.out.println(parrot.favouriteLanguage);
    }
}
