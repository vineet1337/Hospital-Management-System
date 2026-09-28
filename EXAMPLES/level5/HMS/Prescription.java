package EXAMPLES.level5.HMS;

import java.util.ArrayList;

class Prescription {
    Doctor doctor;
    Patient patient;

    ArrayList<String> medicines = new ArrayList<>();

    Prescription(Doctor doctor, Patient patient){
        this.doctor = doctor;
        this.patient = patient;
    }

    public void addMedicine(String medicine){
        medicines.add(medicine);
    }

    void prescription(){

        System.out.println("\n===== PRESCRIPTION =====");
        System.out.println("Patient: " + patient.name);
        System.out.println("Doctor: " + doctor.name);

        System.out.println("Medicines:");

        for (String medicine : medicines) {
            System.out.println("- " + medicine);
        }
    }

}
