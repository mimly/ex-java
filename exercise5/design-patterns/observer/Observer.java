package observer;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Observer {
    public static void main(String[] array) {
        final AssociatedPress associatedPress = new AssociatedPress();
        associatedPress.subscribe(breakingNews -> System.out.println("ChannelOne: " + breakingNews.getInfo()));
        associatedPress.subscribe(breakingNews -> System.out.println("ChannelTwo: " + breakingNews.getInfo()));
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            associatedPress.setBreakingNews(scanner.nextLine());
        }
    }
}

/**
 * Observer design pattern - defines a one-to-many dependency between objects, without making objects tightly coupled,
 * so that when one object changes state, all its dependents are notified and updated automatically.
 */
interface NewsAgency {
    void subscribe(final NewsListener listener);

    void unsubscribe(final NewsListener listener);

    void notify(final BreakingNewsEvent breakingNews);
}

class AssociatedPress implements NewsAgency { // publisher or subject
    private final List<NewsListener> listeners;
    private BreakingNewsEvent breakingNews;

    public AssociatedPress() {
        this.listeners = new ArrayList<NewsListener>();
    }

    @Override
    public void subscribe(final NewsListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void unsubscribe(final NewsListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void notify(final BreakingNewsEvent breakingNews) {
        for (NewsListener listener : listeners) {
            listener.newsArrived(breakingNews);
        }
    }

    public void setBreakingNews(final String info) {
        breakingNews = new BreakingNewsEvent(info);
        /**
         * Notification is triggered after the object state has been changed by a setter method.
         * Alternatively, the responsibility of notifying the observers can be moved to the client.
         */
        notify(breakingNews); // or this if observing more subjects than one
    }
}

interface NewsListener { // subscriber or observer
    void newsArrived(final BreakingNewsEvent breakingNews);
}

class BreakingNewsEvent {
    private final String info;

    public BreakingNewsEvent(final String info) {
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }
}

