package animal.v5;

import animal.v5.*;

public class Parrot extends Animal implements Flyable {

    private boolean hungry = false;
    String favouriteWord = "Sunny";
    protected int favouriteNumber = 7;
    public String favouriteLanguage = "Java";

    @Override
    public void feed() {
        System.out.println("Feeding a parrot...");
    }

    @Override
    public void fly() {
        System.out.println("A parrot is flying...");
    }

    public static void main (String[] args) {
        // Animal parrot = new Parrot();
        // System.out.println(parrot.hungry);
        // System.out.println(parrot.favouriteWord);
        // System.out.println(parrot.favouriteNumber);
        // System.out.println(parrot.favouriteLanguage);
    }
}
