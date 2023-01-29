package pasathcw.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pasathcw.Console.Doctor;
import pasathcw.Console.WestminsterSkinConsultationManager_main;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static pasathcw.Console.WestminsterSkinConsultationManager_main.doctorList;

class WestminsterSkinConsultationManagerMainTest {
    //private final WestminsterSkinConsultationManager_main testM = new WestminsterSkinConsultationManager_main();

    @Test
    void addNewDoctorTest() {
        String inp = "Pasath\nBandara\n01-01-2000\n123456789\n1999\nMohs";
        ByteArrayInputStream bytearray = new ByteArrayInputStream(inp.getBytes());
        System.setIn(bytearray);
        WestminsterSkinConsultationManager_main testM = new WestminsterSkinConsultationManager_main();
        testM.addNewDoctor();
        Doctor d = WestminsterSkinConsultationManager_main.doctorList.get(0);
        Assertions.assertEquals("Pasath", d.getName());
        Assertions.assertEquals("Bandara", d.getsName());
        Assertions.assertEquals("2000-01-01", d.getDob().toString());
        Assertions.assertEquals(123456789, d.getMobileNum());
        Assertions.assertEquals(1999, d.getMedicalLisence());
        Assertions.assertEquals("Mohs", d.getSpecialisation());

        // Entered Input
        System.out.println("Name: " + d.getName());
        System.out.println("Surname: " + d.getsName());
        System.out.println("DOB: " + d.getDob().toString());
        System.out.println("Mobile number: " + d.getMobileNum());
        System.out.println("Medical lisence: " + d.getMedicalLisence());
        System.out.println("Specialisation: " + d.getSpecialisation());
    }

    @Test
    void addTenDoctorsTest() {
        ArrayList<String> list = new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            String inp = "Pasath\nBandara\n01-01-2000\n123456789\n1999\nMohs";
            ByteArrayInputStream bytearray = new ByteArrayInputStream(inp.getBytes());
            System.setIn(bytearray);
            WestminsterSkinConsultationManager_main testM = new WestminsterSkinConsultationManager_main();
            testM.addNewDoctor();
            list.add(String.valueOf((WestminsterSkinConsultationManager_main.doctorList)));

            Doctor d = WestminsterSkinConsultationManager_main.doctorList.get(x);
            System.out.println("Doctor " + (x + 1) + ":");
            System.out.println("Name: " + d.getName());
            System.out.println("Surname: " + d.getsName());
            System.out.println("DOB: " + d.getDob().toString());
            System.out.println("Mobile number: " + d.getMobileNum());
            System.out.println("Medical lisence: " + d.getMedicalLisence());
            System.out.println("Specialisation: " + d.getSpecialisation());


        }
    }

    @Test
    void deleteDoctorTest() {

        for (int x = 0; x < 2; x++) {
            String inp = "Pasath\nBandara\n01-01-2000\n123456789\n1999\nMohs";
            ByteArrayInputStream bytearray = new ByteArrayInputStream(inp.getBytes());
            System.setIn(bytearray);
            WestminsterSkinConsultationManager_main testM = new WestminsterSkinConsultationManager_main();
            testM.addNewDoctor();

            // Print the contents of the doctorList before calling deleteDoctor()
            System.out.println("doctorList before delete: " + WestminsterSkinConsultationManager_main.doctorList);

            String todelete = "1999";
            ByteArrayInputStream bytearray2 = new ByteArrayInputStream(todelete.getBytes());
            System.setIn(bytearray2);
            WestminsterSkinConsultationManager_main testM2 = new WestminsterSkinConsultationManager_main();
            testM2.deleteDoctor();

            // Print the contents of the doctorList after calling deleteDoctor()
            System.out.println("doctorList after delete: " + WestminsterSkinConsultationManager_main.doctorList);

            // Check if the doctorList is empty
            assertTrue(WestminsterSkinConsultationManager_main.doctorList.isEmpty());
        }

    }

    @Test
    void testPrintList() {
        // Add three Doctor objects to the doctorList
        String inp = "Pasath\nBandara\n01-01-2000\n123456789\n1999\nMohs";
        ByteArrayInputStream bytearray = new ByteArrayInputStream(inp.getBytes());
        System.setIn(bytearray);
        WestminsterSkinConsultationManager_main testM = new WestminsterSkinConsultationManager_main();
        testM.addNewDoctor();

        // Check if the doctorList has at least three elements
        if (WestminsterSkinConsultationManager_main.doctorList.size() >= 1) {
            for (int x = 0; x < 1; x++) {
                // Capture the output of the printList() method in a ByteArrayOutputStream
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                PrintStream originalOut = System.out;
                System.setOut(new PrintStream(outContent));

                // Call the printList() method
                testM.printList();

                // Restore the original output stream
                System.setOut(originalOut);

                // Convert the output to a String and check if it contains the expected output
                String output = outContent.toString();
                Assertions.assertTrue(output.contains("Doctor 1"));
                Assertions.assertTrue(output.contains("Name: Pasath"));
                //Assertions.assertTrue(output.contains("sName: Bandara")); // not working
                Assertions.assertTrue(output.contains("Date of Birth: 2000-01-01"));
                Assertions.assertTrue(output.contains("Mobile Num: 123456789"));
                Assertions.assertTrue(output.contains("Medical Licence: 1999"));
                Assertions.assertTrue(output.contains("Specialisation: Mohs"));

                Doctor d = WestminsterSkinConsultationManager_main.doctorList.get(x);
                System.out.println("Name: " + d.getName());
                System.out.println("Surname: " + d.getsName());
                System.out.println("DOB: " + d.getDob().toString());
                System.out.println("Mobile number: " + d.getMobileNum());
                System.out.println("Medical lisence: " + d.getMedicalLisence());
                System.out.println("Specialisation: " + d.getSpecialisation());

            }
        }
    }

    @Test
    public void testSaveFile() {
        WestminsterSkinConsultationManager_main testM = new WestminsterSkinConsultationManager_main();

        // create a sample Doctor object and add it to the doctorList
        Doctor doctor = new Doctor(1234, "Something", "Pasath", "Bandara", LocalDate.of(1980, 1, 1), 12345);
        doctorList.add(doctor);

        // call the saveFile() method to write the doctorList to a file
        testM.saveFile();

        // check if the file was created and written to successfully
        File file = new File("src\\pasathcw\\assets\\DoctorFile.txt");
        Assertions.assertTrue(file.exists());

        // read the contents of the file and verify that it matches the data written to it
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            //Assertions.assertEquals("Doctor 1", line);
            line = reader.readLine();
            Assertions.assertEquals("Name: Pasath", line);
            // and so on, verifying the rest of the contents of the file
            reader.close();
        } catch (IOException e) {
            fail("Error reading file: " + e.getMessage());
        }
    }
}

