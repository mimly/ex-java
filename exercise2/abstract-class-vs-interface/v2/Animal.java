package animal.v2;

public abstract class Animal {

    private boolean hungry = true;

    public boolean isHungry() {
        return hungry;
    }

    public abstract void feed();
}
