package bank.v2.account.holder; // change package declaration to see how access modifiers work

import bank.v2.account.holder.Student;

public class DD1385Student extends Student {

    public DD1385Student(String kthId, String lastName, String firstName) {
        super(kthId, lastName, firstName);
    }

    // move main method to other classes to see how access modifiers work
    public static void main (String[] args) {
        Student student = new DD1385Student("mlynczak", "Młyńczak", "Mikołaj");
        System.out.println(student.kthId); // public
        System.out.println(student.lastName); // protected
        System.out.println(student.firstName); // default
        // System.out.println(student.accounts); // private
    }

}
