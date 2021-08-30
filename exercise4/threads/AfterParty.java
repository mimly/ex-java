package threads.v5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

public class AfterParty {

    private static final int NUMBER_OF_CHILDREN = 10;
    private int candies = AfterParty.NUMBER_OF_CHILDREN;
    private static int reported = 1;

    // synchronized methods vs synchronized statements
    public synchronized void takeCandyAndReport(int id) {
        try {
            Thread thread = Thread.currentThread();
            while (! thread.getName().equals("pool-1-thread-" + reported) ) {
                wait();
            }
            --candies;
            // separate read and write operations and create a window of opportunity for race conditions
            Thread.sleep(1l);
            System.out.println(String.format("Child #%-2d : Only %d candies left...", id, candies));
            reported++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        // Let's make a party...
        AfterParty party = new AfterParty();

        // ... and invite some children for counting candies.
        //List<ChildE> children = new ArrayList<>();
        //for (int i = 0; i < 10; ++i) {
        //    children.add(new ChildE(i + 1, party));
        //}
        //for (ChildE child : children) {
        //    child.start();
        //}

        // ... and invite some children for counting candies.
        ExecutorService children = Executors.newFixedThreadPool(AfterParty.NUMBER_OF_CHILDREN);
        for (int id = 1; id <= AfterParty.NUMBER_OF_CHILDREN; ++id) {
            children.submit(new ChildI(id, party));
        }
        children.shutdown();
    }
}

class ChildE extends Thread {

    private final int id;
    private final AfterParty party;

    public ChildE(int id, AfterParty party) {
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
    private final AfterParty party;

    public ChildI(int id, AfterParty party) {
        this.id = id;
        this.party = party;
    }

    @Override
    public void run() {
        party.takeCandyAndReport(id);
    }
}
