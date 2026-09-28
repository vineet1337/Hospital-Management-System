package EXAMPLES.level5.HMS;

class Staff extends Person{

    String department;
    String role;
    String dutyShift;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Staff(int id,String name, String contact, String role,String department, String dutyShift) {
        super(id, name, contact);
        this.role = role;
        this.department = department;
        this.dutyShift = dutyShift;
    }

    @Override
    void displayDetails(){

        super.displayDetails();
        System.out.println("Role: " +role);
        System.out.println("Department: " +department);
        System.out.println("Duty Shift: " +dutyShift);
        System.out.println("Salary: " +getSalary());
    }
}
