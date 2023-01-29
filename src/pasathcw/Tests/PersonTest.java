package pasathcw.Tests;

import pasathcw.Console.Person;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
class PersonTest {
    Person person = new Person("Pasath","Bandara", LocalDate.of(2000,10,1),1123456);

    @org.junit.jupiter.api.Test
    void testSetName() {assertEquals("Pasath", person.getName());}

    @org.junit.jupiter.api.Test
    void testSetsName() {
        assertEquals("Bandara",person.getsName());
    }

    @org.junit.jupiter.api.Test
    void testGetDob() {
        assertEquals(LocalDate.of(2000,10,1),person.getDob());
    }

    @org.junit.jupiter.api.Test
    void TestSetMobileNum() { assertEquals(1123456, person.getMobileNum());}
}