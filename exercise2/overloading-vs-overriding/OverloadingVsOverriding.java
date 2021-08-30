package introductory;

public class OverloadingVsOverriding { }

/**
 * Which method or methods listed below overload or override a method in the superclass? And why?
 */
class Course {
    protected boolean passed;

    protected void passCourse() { }
}

class DD1385 extends Course {
    public static void passCourse() { }
    public final void passCourse() { }
    private void passCourse() { }
    protected void passCourse() { }
    public void passCourse() { }
    public void passcourse() { }
    public void passCourse(boolean passed) { }
    public boolean passCourse() { return true; }
    public void failCourse() { }
}

/**
 * Consider the code below and answer the question again. Which rule applies for overriden methods regarding throwing exceptions?
 */
class UnregisteredStudentException extends Exception { }

class Course {
    // ...

    public void passCourse() throws UnregisteredStudentException { }
}

class DD1385 extends Course {
     public void passCourse() { }
     public void passCourse() throws Exception { }
     public void passCourse() throws RuntimeException { }
     public void passCourse() throws UnregisteredStudentException { }
}

/**
 * Which rule applies for overriden methods regarding return type?
 */

abstract class CourseFactory {
    public abstract Course createCourse();
}

class CustomCourseFactory extends CourseFactory {
    public Object createCourse() { return new DD1385(); }
    public Course createCourse() { return new DD1385(); }
    public DD1385 createCourse() { return new Course(); }
    public DD1385 createCourse() { return new DD1385(); }
}

//------------------------------------------------------------------------------------------------//

/**
 * What will be printed out if each of the classes below has this main method?
 *
 * public static void main(String... args) {
 *     Course course = new DD1385();
 *     course.printGrade();
 *     System.out.println(course.grade);
 * }
 */

// I
class Course {
    public String grade = "F";

    public void printGrade() { System.out.println(grade); }
}

class DD1385 extends Course {
    public String grade = "A";

    public void printGrade() { System.out.println(grade); }
}

// II
class Course {
    public String grade = "F";

    public void printGrade() { System.out.println(grade); }
}

class DD1385 extends Course {
    public String grade = "A";
}

/**
 * And the following main method...? Justify the answer.
 *
 * public static void main(String... args) {
 *     Course course = new DD1385();
 *     course.doPrinting();
 * }
 */
class Course {
    public String grade = "F";

    public void doPrinting() { printGrade(); }
    public void printGrade() { System.out.println(grade); }
}

class DD1385 extends Course {
    public String grade = "A";

    public void printGrade() { System.out.println(grade); }
}
