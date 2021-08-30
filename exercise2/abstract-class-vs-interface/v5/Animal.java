package animal.v5;

public abstract class Animal {

    private boolean hungry = true;
    String favouriteWord = "???";
    protected int favouriteNumber = -1;
    public String favouriteLanguage = "???";

    public boolean isHungry() {
        return hungry;
    }

    public abstract void feed();

    public void sayFavouriteWord() {
        System.out.println(favouriteWord);
    }

    public static void main (String[] args) {
        Animal parrot = new Parrot();
        System.out.println(parrot.hungry);
        System.out.println(parrot.favouriteWord);
        System.out.println(parrot.favouriteNumber);
        System.out.println(parrot.favouriteLanguage);
    }
}
