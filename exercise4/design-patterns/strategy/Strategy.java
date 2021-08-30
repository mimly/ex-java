package strategy;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Strategy {

    private Convertable convertable;

    public void setStrategy(Convertable convertable) {
        this.convertable = convertable;
    }

    /*
     * Due to OCP (the open-closed principle), software entities should be
     * open for extension and closed for modification.
     * We can add new strategies without needing to modify the context.
     */
    public String convert(Object object) {
        return this.convertable.convert(object);
    }

    public static void main (String[] args) {
        Person person = new Person(
                "Joe",
                "Doe",
                33,
                List.of(
                    new Book("Joseph Conrad", "Lord Jim"),
                    new Book("Jack London", "Martin Eden"),
                    new Book("Jerome David Salinger", "The Catcher in the Rye")
                )
            );

        Strategy strategy = new Strategy();
        Convertable convertable = new ToXML();
        strategy.setStrategy(convertable);
        System.out.println(strategy.convert(person));
    }
}

/**
 * Test classes.
 */
class Book {
    private final String author;
    private final String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
            "author = " + getAuthor() +
            ", title = " + getTitle() +
            "}";
    }
}

class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final List<Book> favouriteBooks;

    public Person(String firstName, String lastName, int age, List<Book> favouriteBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.favouriteBooks = favouriteBooks;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public List<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    @Override
    public String toString() {
        return "Person{" +
            "firstName = " + firstName +
            ", lastName = " + lastName +
            ", age = " + age +
            ", favouriteBooks = " + favouriteBooks +
            "}";
    }
}

/**
 * Strategy design patter - enables selecting an algorithm (a behavior)
 * of a family of related algorithms at runtime.
*/
@FunctionalInterface
interface Convertable {
    String convert(Object object);
}

class ToJSON implements Convertable {

    @Override
    public String convert(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException jpe) {
            return jpe.toString();
        }
    }
}

class ToString implements Convertable {

    @Override
    public String convert(Object object) {
        return object.toString();
    }
}

class ToXML implements Convertable {

    @Override
    public String convert(Object object) {
        try {
            XmlMapper mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException jpe) {
            return jpe.toString();
        }
    }
}
