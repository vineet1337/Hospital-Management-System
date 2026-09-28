package EXAMPLES.level5.HMS;

public class Person {
    int id;
    String name;
    String contact;

    public Person(int id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    void displayDetails(){
        System.out.println("Id: " +id);
        System.out.println("Name: " +name);
        System.out.println("Contact Details: " +contact);
    }
}
