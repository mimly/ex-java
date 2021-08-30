package animal.v1;

public class Animal {

    private boolean hungry = true;

    public boolean isHungry() {
        return hungry;
    }

    public void feed() {
        System.out.println("Feeding an animal...");
    }
}
