package pasathcw.Tests;

import org.junit.jupiter.api.Test;
import pasathcw.Console.Doctor;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
Doctor doctor = new Doctor(12345,"Mohs","Stephen", "Strange", LocalDate.of(1989,1,1),456789);
    @Test
    void getMedicalLisence() {
        assertEquals(12345, doctor.getMedicalLisence());
    }

    @Test
    void setSpecialisation() {
        assertEquals("Mohs", doctor.getSpecialisation());
        //assertEquals("Not Mohs", doctor.getSpecialisation());

    }
}