package EXAMPLES.level5.HMS;

public class Doctor extends Person{
    String specialization;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    Doctor(int id, String name, String contact, String specialization, double salary) {
        super(id, name, contact);
        this.specialization = specialization;
        this.salary = salary;
    }

    @Override
    void displayDetails(){
        super.displayDetails();
        System.out.println("Specialization: " +specialization);
        System.out.println("Doctor's Salary: " +getSalary());
    }
}
