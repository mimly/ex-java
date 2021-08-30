package objects;

import java.util.List;

import org.apache.commons.lang3.builder.*;

public class ToString {

    public static void main (String[] args) {
        List<Person> list = List.of(
                new Person("000000-1234", "Alice"),
                new Person("999999-0000", "Bob")
        );

        for (Person person : list) {
            System.out.println(person);
        }
    }
}

class Person {

    private final String personalNumber;
    private final String name;

    public Person(String personalNumber, String name) {
        this.personalNumber = personalNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        // 1
        return ToStringBuilder.reflectionToString(this);

        // 2
        //return "Person{" +
        //   "personalNumber = " + personalNumber +
        //   ", name = " + name +
        //   "}";
    }
}
