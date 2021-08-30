package threads.v3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

public class SynchronizedParty {

    private static final int NUMBER_OF_CHILDREN = 10;
    private int candies = SynchronizedParty.NUMBER_OF_CHILDREN;
    private final Object lock = new Object(); // monitor lock or intrinsic lock

    // synchronized methods vs synchronized statements
    public void takeCandyAndReport(int id) {
        try {
            int c;
            synchronized (lock) { // vs this vs class
                c = --candies;
            }
            // separate read and write operations and create a window of opportunity for race conditions
            Thread.sleep(1l);
            System.out.println(String.format("Child #%-2d : Only %d candies left...", id, c));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        // Let's make a party...
        SynchronizedParty party = new SynchronizedParty();

        // ... and invite some children for counting candies.
        //List<ChildE> children = new ArrayList<>();
        //for (int i = 0; i < 10; ++i) {
        //    children.add(new ChildE(i + 1, party));
        //}
        //for (ChildE child : children) {
        //    child.start();
        //}

        // ... and invite some children for counting candies.
        ExecutorService children = Executors.newFixedThreadPool(SynchronizedParty.NUMBER_OF_CHILDREN);
        for (int id = 1; id <= SynchronizedParty.NUMBER_OF_CHILDREN; ++id) {
            children.submit(new ChildI(id, party));
        }
        children.shutdown();
    }
}

class ChildE extends Thread {

    private final int id;
    private final SynchronizedParty party;

    public ChildE(int id, SynchronizedParty party) {
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
    private final SynchronizedParty party;

    public ChildI(int id, SynchronizedParty party) {
        this.id = id;
        this.party = party;
    }

    @Override
    public void run() {
        party.takeCandyAndReport(id);
    }
}
