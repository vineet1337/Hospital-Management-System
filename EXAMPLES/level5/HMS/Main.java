package EXAMPLES.level5.HMS;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;

class Main {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<Prescription> prescriptions = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            showMenu();
            takeChoice(sc);
            int choice = sc.nextInt();
            if (!performOperation(choice, sc)) {
                break;
            }
        }
    }

    static void showMenu() {

        System.out.println("====Hospital Management System====");
        System.out.println();
        System.out.println("Choices: ");
        System.out.println("1. Add Patient");
        System.out.println("2. View Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. View Doctors");
        System.out.println("5. Book Appointments");
        System.out.println("6. View Appointments");
        System.out.println("7. Create Prescription");
        System.out.println("8. View Prescription");
        System.out.println("9. Exit");
    }

    static void takeChoice(Scanner sc) {
        System.out.println("Enter Choice: ");
    }

    static boolean performOperation(int choice, Scanner sc) {
        switch (choice) {
            case 1:
                Patient patient = addPatient(sc);
                patients.add(patient);
                break;
            case 2:
                viewPatient();
                break;
            case 3:
                Doctor doctor = addDoctor(sc);
                doctors.add(doctor);
                break;
            case 4:
                viewDoctor();
                break;
            case 5:
                Appointment appointment = bookAppointment(sc);
                appointments.add(appointment);
                break;
            case 6:
                viewAppointment();
                break;
            case 7:
                createPrescription(sc);
                break;
            case 8:
                viewPrescription();
                break;
            case 9:
                return false;

            default:
                System.out.println("Invalid choice.");
        }
        return true;
    }

    static Patient addPatient(Scanner sc) {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Date of Admission (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.print("Enter Cause: ");
        String cause = sc.nextLine();

        return new Patient(id, name, contact, age, date, cause);
    }

    static void viewPatient() {
        for (Patient P : patients) {
            P.displayDetails();
            System.out.println();
        }
    }

    static Doctor addDoctor(Scanner sc) {
        System.out.println("Enter Doctor Id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Specialization: ");
        String specialization = sc.nextLine();

        System.out.println("Enter Doctor Name");
        String name = sc.nextLine();

        System.out.println("Enter Contact Details: ");
        String contact = sc.nextLine();

        System.out.println("Enter Salary");
        double salary = sc.nextDouble();

        return new Doctor(id, name, contact, specialization, salary);
    }

    static void viewDoctor() {
        for (Doctor D : doctors) {
            D.displayDetails();
            System.out.println();
        }
    }

    static Appointment bookAppointment(Scanner sc) {

        System.out.println("Enter Patient Id: ");
        int id = sc.nextInt();

        Patient patient = null;
        for (Patient p : patients) {
            if (p.id == id) {
                patient = p;
                break;
            }
        }

        Doctor doctor = null;
        System.out.println("Enter Doctor Id: ");
        int doctorId = sc.nextInt();
        sc.nextLine();

        for (Doctor d : doctors) {
            if (d.id == doctorId) {
                doctor = d;
                break;
            }
        }

        System.out.println("Enter time for Appointment : ");
        LocalTime time = LocalTime.parse(sc.nextLine());

        System.out.println("Enter date for Appointment (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.println("Enter cause or reason: ");
        String cause = sc.nextLine();

        return new Appointment(time, date, cause, patient, doctor, id);
    }

    static void viewAppointment() {
        for (Appointment ap : appointments) {
            ap.makeAppointment();
        }
    }

    static Prescription createPrescription(Scanner sc) {
        Patient patient = null;
        Doctor doctor = null;

        System.out.println("Enter Patient Id: ");
        int patientId = sc.nextInt();

        for (Patient p : patients) {
            if (patientId == p.id) {
                patient = p;
                break;
            }
            if (patient == null) {
                System.out.println("Patient Not Found.");
                break;
            }
        }

            System.out.println("Enter Doctor Id: ");
            int doctorId = sc.nextInt();
            sc.nextLine();

            for (Doctor d : doctors) {
                if (doctorId == d.id) {
                    doctor = d;
                }

                if (doctor == null) {
                    System.out.println("Doctor not available.");
                    break;
                }
            }

                Prescription pr = new Prescription(doctor, patient);

                while (true) {
                    System.out.println("Enter Medicine: ");
                    String medicine = sc.nextLine();

                    pr.addMedicine(medicine);

                    System.out.println("Add another medicine? (yes/no)");
                    String choice = sc.nextLine();

                    if (choice.equalsIgnoreCase("no")) {
                        break;
                    }
                }


                prescriptions.add(pr);

                System.out.println("Prescription created successfully.");

                pr.prescription();

        return new Prescription(doctor, patient);
    }

    static void viewPrescription () {

        for (Prescription p : prescriptions) {
            p.prescription();
        }
    }
    }
