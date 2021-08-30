package animal.v4;

public abstract class Animal {

    private boolean hungry = true;
    String favouriteWord = "???";

    public boolean isHungry() {
        return hungry;
    }

    public abstract void feed();

    public void sayFavouriteWord() {
        System.out.println(favouriteWord);
    }
}
