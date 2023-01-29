package pasathcw.Tests;

import org.junit.jupiter.api.Test;
import pasathcw.Console.Patient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Patient patient = new Patient(1234, "Mohs","Pasath","Bandara" ,LocalDate.of(2000,10,1),123456789, 50);
    @Test
    void testGetPatientId() {
        assertEquals(1234,patient.getPatientId());
    }

    @Test
    void testSetSickness() {
        assertEquals("Mohs", patient.getSickness());
    }
}