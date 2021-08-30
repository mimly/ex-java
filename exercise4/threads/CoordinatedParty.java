package threads.v4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

public class CoordinatedParty {

    private static final int NUMBER_OF_CHILDREN = 10;
    private int candies = CoordinatedParty.NUMBER_OF_CHILDREN;
    private final Object lock1 = new Object(); // monitor lock or intrinsic lock
    private final Object lock2 = new Object(); // monitor lock or intrinsic lock
    private static int reported = 1;

    // synchronized methods vs synchronized statements
    public void takeCandyAndReport(int id) {
        try {
            int c;
            synchronized (lock1) { // vs this vs class
                c = --candies;
            }
            // separate read and write operations and create a window of opportunity for race conditions
            Thread.sleep(1l);
            synchronized (lock1) {
                Thread thread = Thread.currentThread();
                while (! thread.getName().equals("pool-1-thread-" + reported) ) {
                    lock1.wait();
                }
                System.out.println(String.format("Child #%-2d : Only %d candies left...", id, c));
                reported++;
                lock1.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        // Let's make a party...
        CoordinatedParty party = new CoordinatedParty();

        // ... and invite some children for counting candies.
        //List<ChildE> children = new ArrayList<>();
        //for (int i = 0; i < 10; ++i) {
        //    children.add(new ChildE(i + 1, party));
        //}
        //for (ChildE child : children) {
        //    child.start();
        //}

        // ... and invite some children for counting candies.
        ExecutorService children = Executors.newFixedThreadPool(CoordinatedParty.NUMBER_OF_CHILDREN);
        for (int id = 1; id <= CoordinatedParty.NUMBER_OF_CHILDREN; ++id) {
            children.submit(new ChildI(id, party));
        }
        children.shutdown();
    }
}

class ChildE extends Thread {

    private final int id;
    private final CoordinatedParty party;

    public ChildE(int id, CoordinatedParty party) {
        super(String.valueOf(id));
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
    private final CoordinatedParty party;

    public ChildI(int id, CoordinatedParty party) {
        this.id = id;
        this.party = party;
    }

    @Override
    public void run() {
        party.takeCandyAndReport(id);
    }
}
