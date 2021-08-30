package threads.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

public class Party {

    private static final int NUMBER_OF_CHILDREN = 10;
    private int candies = Party.NUMBER_OF_CHILDREN;

    public void takeCandyAndReport(int id) {
        try {
            --candies;
            // separate read and write operations and create a window of opportunity for race conditions
            Thread.sleep(1l);
            System.out.println(String.format("Child #%-2d : Only %d candies left...", id, candies));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        // Let's make a party...
        Party party = new Party();

        // ... and invite some children for counting candies.
        //List<ChildE> children = new ArrayList<>();
        //for (int i = 0; i < 10; ++i) {
        //    children.add(new ChildE(i + 1, party));
        //}
        //for (ChildE child : children) {
        //    child.start();
        //}

        // ... and invite some children for counting candies.
        ExecutorService children = Executors.newFixedThreadPool(Party.NUMBER_OF_CHILDREN);
        for (int id = 1; id <= Party.NUMBER_OF_CHILDREN; ++id) {
            children.submit(new ChildI(id, party));
        }
        children.shutdown();
    }
}

class ChildE extends Thread {

    private final int id;
    private final Party party;

    public ChildE(int id, Party party) {
        this.id = id;
        this.party = party;
    }

    @Override
    public void run() {
        party.takeCandyAndReport(id);
    }
}

class ChildI implements Runnable {

    private final int id;
    private final Party party;

    public ChildI(int id, Party party) {
        this.id = id;
        this.party = party;
    }

    @Override
    public void run() {
        party.takeCandyAndReport(id);
    }
}
