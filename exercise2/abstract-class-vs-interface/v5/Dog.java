package animal.v5.pet;

import animal.v5.*;

public class Dog extends Animal implements Walkable {

    @Override
    public void feed() {
        System.out.println("Feeding a dog...");
    }

    @Override
    public void walk() {
        System.out.println("A dog is walking...");
    }

    public static void main (String[] args) {
        // Animal parrot = new Parrot();
        // System.out.println(parrot.hungry);
        // System.out.println(parrot.favouriteWord);
        // System.out.println(parrot.favouriteNumber);
        // System.out.println(parrot.favouriteLanguage);
    }
}
