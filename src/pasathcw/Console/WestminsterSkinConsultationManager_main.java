package pasathcw.Console;

import pasathcw.GUI.launchGUI;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WestminsterSkinConsultationManager_main implements SkinConsultationManager { // implements keyword is used to "inherit" from an interface

    //    The final keyword can be used in several contexts in Java, but the most common use is to mark a variable as a constant, which means that its value cannot be changed once it is set
    private final Scanner sc = new Scanner(System.in);
    public int doctorCount;
    public int medicalLi;
    public static final List<Doctor> doctorList = new ArrayList<>();
    public static final List<Doctor> doctorListSort = new ArrayList<>(doctorList);/*the static keyword is used to indicate that a member (field, method, or nested class) belongs to a type itself, rather than to an instance of that type.*/

    @Override /*@Override annotation can be used with methods that implement an interface or methods that override a superclass method.*/ public void run() {
        while (true) {
            System.out.println("-----------------Menu-----------------\n");
            System.out.println("1.Add a new doctor");
            System.out.println("2.Delete a doctor");
            System.out.println("3.Print the list of the doctors");
            System.out.println("4.Save in a file");
            System.out.println("5.Read Saved File in Console");
            System.out.println("6.Launch GUI");
            System.out.println("0.Quit");
            System.out.println("--------------------------------------\n");
            System.out.print("Choice: ");

            String choice = sc.next();
            if (choice.equals("1")) {
                addNewDoctor();
            } else if (choice.equals("2")) {
                deleteDoctor();
            } else if (choice.equals("3")) {
                printList();
            } else if (choice.equals("4")) {
                saveFile();
            } else if (choice.equals("5")) {
                readFile();
            } else if (choice.equals("6")) { // the use of ".equals" is used for the specific context of calculating the value of a string
                launchGUI();
            } else if (choice.equals("0")) {
                System.out.println("Quiting Program");
                break; // The Break Statement is used to quit the program
            } else {
                System.out.println("Input a valid number from 0(zero) to 6(six)");
            }
        }
        System.out.println("--------------------------------------\n");
    }

    public void addNewDoctor() {
        System.out.println("\n-----------Add New Doctor-----------");
        if (doctorCount < 10) {
            try {
                System.out.println("Enter Name");
                String name = sc.next();

                System.out.println("Enter Surname");
                String sName = sc.next();

                System.out.println("Enter Date of Birth(dd-mm-yyyy)");
                String inputDate = sc.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy"); /* the DateTimeFormatter class is used to convert between dates and strings,*/
                LocalDate dob = LocalDate.parse(inputDate, formatter);/* object is created using the ofPattern method, which specifies the pattern of the input string.
                                                                         parse method is then used to parse the input string and create a LocalDate object.*/
                System.out.println("Enter Mobile Number");
                int mobileNum = sc.nextInt();

                System.out.println("Enter Medical Licence Number");
//                int medicalLisence = sc.nextInt();
                if (!sc.hasNextInt()) {
                    System.out.println("Enter A valid ID number");// a basic validation is used to check if the entered licence number is an integer
                    // assuming that the company only deals integer id numbers
                    run();
                    return;
                } else {
                    medicalLi = sc.nextInt();
                }

                System.out.println("Enter Specialization out of 'Cosmetic dermatology, Medical dermatology, Paediatric dermatology, Dermatopathology or Mohs Surgery'");
                String specialisation = sc.next();
                //if (specialisation.!equals("Cosmetic dermatology"+"Medical dermatology"+ "Paediatric dermatology"+ "Dermatopathology"+ "Mohs Surgery"))
                if (!(specialisation.equalsIgnoreCase("Cosmetic") || specialisation.equalsIgnoreCase("Medical") || specialisation.equalsIgnoreCase("Paediatric") || specialisation.equalsIgnoreCase("Dermatopathology") || specialisation.equalsIgnoreCase("Mohs"))) {
                    System.out.println("Select one of the Following and Re-Enter" + " " + "'Cosmetic dermatology, Medical dermatology, Paediatric dermatology, Dermatopathology or Mohs Surgery'"); // a validation check is performed to check if the doctors are from the said fields

                } else {
                    System.out.println("Doctor" + " " + name + " " + "added Sucessfully");
                    doctorList.add(new Doctor(medicalLi, specialisation, name, sName, dob, mobileNum)); // new doctor is added with the user entered information
                    doctorListSort.add(new Doctor(medicalLi, specialisation, name, sName, dob, mobileNum));

                    doctorCount++;
                }
            } catch (DateTimeException e) {
                System.out.println("The date you have entered in different format. Please follow the format of dd 'dash' mm 'dash' yyyy " + e); // the use of date time exception is needed to check if the user entered the date is correct and adheres to the rules provided

            }
        } else {
            System.out.println("Doctor Max Capacity reached. 10 is the maximum");
        }
    }

    //     public static final List<Doctor> doctorList = new ArrayList<>();
    public void deleteDoctor() {
        System.out.println("\n-----------Delete Doctor-----------");
        System.out.println("Enter The ID of Doctor to be deleted");
        int id = sc.nextInt();

        boolean found = false;
        for (Iterator<Doctor> iterator = doctorListSort.iterator(); iterator.hasNext(); ) {
            Doctor doctor = iterator.next();
            if (id == doctor.getMedicalLisence()) {
                iterator.remove();
                doctorCount--;
                found = true;
            }
        }

        if (found) {
            System.out.println("Doctor(s) with ID " + id + " has been deleted");
            System.out.println("doctor count: " + doctorCount);
        } else {
            System.out.println("No doctor with ID " + id + " was found");
        }

    }

    @Override
    public void printList() {
        System.out.println("\n--------Print Doctor List--------");
        Collections.sort(doctorListSort, new Comparator<Doctor>() { // https://www.geeksforgeeks.org/collections-sort-java-examples/
            @Override
            public int compare(Doctor d1, Doctor d2) {
                return d1.getsName().compareTo(d2.getsName());
            }
        });
        int count = 1;
        List<Doctor> doctorList = new ArrayList<>();
        for (Doctor doctor : doctorListSort) {
            System.out.println("Doctor " + count++ + "\n");
            System.out.println("Name: " + doctor.getName() + " " + doctor.getsName());
            System.out.println("Date of Birth: " + doctor.getDob().toString());
            System.out.println("Mobile Num: " + doctor.getMobileNum());
            System.out.println("Medical Licence: " + doctor.getMedicalLisence());
            System.out.println("Specialisation: " + doctor.getSpecialisation());
            System.out.println("--------------------------------------\n");
        }
    }

    @Override
    public void saveFile() { // https://www.w3schools.com/java/java_files_create.asp
        System.out.println("\n-----------Save to File-----------");
        try {
            if (!doctorList.isEmpty()) {
                System.out.println("File created");
                FileWriter myWriter = new FileWriter("src\\pasathcw\\assets\\DoctorFile.txt"); // FileWriter is a class in Java that allows you to write text to a file in your file system. It is used to create a Writer that can write to a file.
                int count = 1;
                for (Doctor doctor : doctorListSort) {
                    myWriter.write("Doctor " + count++ + "\n");
                    myWriter.write("Name: " + doctor.getName() + " " + doctor.getsName() + "\n");
                    myWriter.write("DOB: " + doctor.getDob().toString() + "\n");
                    myWriter.write("MobileNum: " + doctor.getMobileNum() + "\n");
                    myWriter.write("Medical Licence: " + doctor.getMedicalLisence() + "\n");
                    myWriter.write("Specialisation: " + doctor.getSpecialisation() + "\n");
                    myWriter.write("--------------------------------------\n");
                }
                myWriter.close();// The close method is used to close a FileWriter and release any system resources associated with it
            } else {
                System.out.println("No Doctors entered yet.");
            }
        } catch (IOException e) {
            System.out.println("Error creating text file " + e);
        }
    }

    private void readFile() { // https://www.w3schools.com/java/java_files_read.asp
        try {
            // Open the file for reading
            FileReader fileReader = new FileReader("src\\pasathcw\\assets\\DoctorFile.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            // Read the file line by line
            String line = reader.readLine();
            ArrayList<String> savedData = new ArrayList<>();
            while (line != null) {
                savedData.add(line);
                line = reader.readLine();
            }

            // Close the file
            reader.close();

            // Print the saved data
            for (String s : savedData) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*The launch of the gui happens from here*/
    // this imports an unedited list
    private void launchGUI() {launchGUI gui = new launchGUI();}

    public static void main(String[] args) {
        new WestminsterSkinConsultationManager_main().run();

    }
}

