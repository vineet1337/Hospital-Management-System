package EXAMPLES.level5.HMS;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private LocalTime time;
    private LocalDate date;
    String cause;
    Patient patient;
    Doctor doctor;
    int id;

    public Appointment(LocalTime time, LocalDate date, String cause, Patient patient, Doctor doctor,int id) {
        this.time = time;
        this.date = date;
        this.cause = cause;
        this.patient = patient;
        this.doctor = doctor;
        this.id = id;
    }

    void makeAppointment(){
        if(verification()){
            System.out.println("Patient name  " + patient.name + " and Id " + patient.id);
            System.out.println("Reason: " + cause);
            System.out.println("Date and Time of Appointment: " + date + " " + time);
            System.out.println("Doctor name " + doctor.name + " and Id " + doctor.id);
            System.out.println("Appointment booked for " +date +" at " +time);
        }
        else {
            System.out.println("Appointment cannot be booked.");
        }
    }

    boolean verification(){
        if(cause == null){
            throw new InvalidReason("Not a valid reason for Appointment.");
        }
        else if (patient.id != id){
            throw new PatientNotFound("Patient not found.");
        }
        return true;
    }
}
