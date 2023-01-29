package pasathcw.Console;

import java.time.LocalDate;

public class Consultation {

    private Doctor doctor;
    private Patient patient;
    private LocalDate dateTimeSlot;
    private int cost;
    private String notes;

    public Consultation( Patient patient, int cost, String notes) {
        this.patient = patient;
        this.cost = cost;
        this.notes = notes;
    }

    public LocalDate getDateTimeSlot() {
        return dateTimeSlot;
    }

    public int getCost() {
        return cost;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
