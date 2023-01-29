package pasathcw.Tests;

import org.junit.jupiter.api.Test;
import pasathcw.Console.Consultation;
import pasathcw.Console.Doctor;
import pasathcw.Console.Patient;
import pasathcw.Console.Person;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ConsultationTest {
    Person person = new Person("Pasath", "Bandara", LocalDate.of(2000, 10, 1), 1123456);
    Patient patient = new Patient(1234, "Mohs", "Pasath", "Bandara", LocalDate.of(2000, 10, 1), 123456789, 50);
    Doctor doctor = new Doctor(12345, "Mohs", "Stephen", "Strange", LocalDate.of(1989, 1, 1), 456789);
    Consultation consultation = new Consultation(patient, 50, "Notes for doctor, Hi");

    @Test
    void getCost() {
        assertEquals(50, consultation.getCost());
    }

    @Test
    void getPatient() {
        assertEquals(patient, consultation.getPatient());
    }

    @Test
    void getNotes() {
        assertEquals("Notes for the doctor,Hi", consultation.getNotes());

    }

    @Test
    void setNotes() {
        assertEquals("Notes for doctor, Hi", consultation.getNotes());
    }
}