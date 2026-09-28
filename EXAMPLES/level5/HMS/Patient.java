package EXAMPLES.level5.HMS;

import java.time.LocalDate;
import java.util.ArrayList;

class Patient extends Person{
    int age;
    private LocalDate dateOfAdmit;
    String cause;
    Person person;

    Patient(int id, String name, String contact, int age, LocalDate dateOfAdmit, String cause) {
        super(id, name, contact);
        this.age = age;
        this.dateOfAdmit = dateOfAdmit;
        this.cause = cause;
    }

    @Override
    void displayDetails(){
        super.displayDetails();

        System.out.println("Patient Age: " +age);
        System.out.println("Date Of Admit: " +dateOfAdmit);
        System.out.println("Cause: " +cause);
    }
}
