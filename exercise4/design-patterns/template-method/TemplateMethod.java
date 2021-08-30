package template_method;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class TemplateMethod {

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

        Convertable templateMethod1 = new ToJSONStdOut();
        templateMethod1.convert(person);

        Convertable templateMethod2 = new ToXMLFile();
        templateMethod2.convert(person);
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
 * Template Method design pattern - allows defining a skeleton of an algorithm (a behavior)
 * in the form of steps in the base class and redefining (overriding) some of them in the subclasses
 * without changing the overall structure of the algorithm.
*/
abstract class Convertable {

    private String data;

    public final void convert(Object object) { // template method
        data = create(object);
        send(data);
        long size = getSize();
        System.out.println(String.format("%d bytes sent...", size));
    }

    public abstract String create(Object object); // step 1

    public abstract void send(String data); // step 2

    /**
     * Certain redefinitions of default method implementations may lead to violating LSP
     * (the Liskov-substitution principle).
    */
    public long getSize() { // step 3
        return data.getBytes().length;
    }
}

class ToJSONStdOut extends Convertable {

    @Override
    public String create(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException jpe) {
            return jpe.toString();
        }
    }

    @Override
    public void send(String data) {
        System.out.println(data);
    }
}

class ToXMLFile extends Convertable {

    private LocalDateTime timestamp;

    @Override
    public String create(Object object) {
        try {
            XmlMapper mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException jpe) {
            return jpe.toString();
        }
    }

    @Override
    public void send(String data) {
        timestamp = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        Path path = Paths.get("template-method-" + timestamp + ".xml");
        try {
            Files.write(path, data.getBytes());
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public long getSize() {
        File file = new File("template-method-" + timestamp + ".xml");
        return file.length();
    }
}
