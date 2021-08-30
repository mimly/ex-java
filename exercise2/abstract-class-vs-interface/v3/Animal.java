package animal.v3;

public abstract class Animal {

    private boolean hungry = true;

    public boolean isHungry() {
        return hungry;
    }

    public abstract void feed();
}
