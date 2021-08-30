package objects;

import java.util.HashSet;
import java.util.Set;

import java.util.TreeSet;

// import org.apache.commons.lang3.builder.*;

public class EqualsAndHashCode {

    public static void main (String[] args) {
        Set<Person> hashSet = new HashSet<>();
        Set<Person> treeSet = new TreeSet<>();

        Person person1 = new Person("000000-1234", "Alice");
        Person person2 = new Person("999999-0000", "Bob");
        Person person3 = new Person("000000-1234", "Caroline");

        hashSet.add(person1);
        hashSet.add(person2);
        hashSet.add(person3);

        treeSet.add(person1);
        treeSet.add(person2);
        treeSet.add(person3);

        System.out.println("HASH SET: " + hashSet);
        System.out.println("TREE SET: " + treeSet);
    }
}

class Person implements Comparable<Person> {

    private final String personalNumber;
    private final String name;

    public Person(String personalNumber, String name) {
        this.personalNumber = personalNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        // 1
        // return ToStringBuilder.reflectionToString(this);

        // 2
        return "Person{" +
           "personalNumber = " + personalNumber +
           ", name = " + name +
           "}";
    }

    /**
     * Different objects do not need to return different hash codes, but equal objects
     * (according to the equals(Object) method) must generate equal hash codes.
     */

    @Override
    public int hashCode() {
        // 1
        // return HashCodeBuilder.reflectionHashCode(this);

        // 2
        return this.name.length();

        // 3
        // int result = 17;
        // result = 31 * result + (personalNumber != null ? personalNumber.hashCode() : 0);
        // result = 31 * result + (name != null ? name.hashCode() : 0);
        // return result;
    }

    @Override
    public boolean equals(Object o) {
        // 1
        // return EqualsBuilder.reflectionEquals(this, o);

        // 2
        return this.personalNumber.equals(((Person) o).personalNumber);

        // 3
        // if (this == o) return true; // reflexiv
        // if (o == null || getClass() != o.getClass()) return false; // konsistent

        // Person object = (Person) o;

        // if (personalNumber != null ? !personalNumber.equals(object.personalNumber) : object.personalNumber != null) return false;
        // return !(name != null ? !name.equals(object.name) : object.name != null); // symmetrisk och transitiv
    }

    @Override
    public int compareTo(Person person) {
        return this.personalNumber.compareTo(person.personalNumber);
    }
}
