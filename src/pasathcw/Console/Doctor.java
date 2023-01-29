package pasathcw.Console;

import java.time.LocalDate;

/*the inheritor class doctor represents the doctors side of the person superclass where profession specific details are gotten*/
public class Doctor extends Person {
    private int medicalLisence;
    private String specialisation;

    public Doctor(int medicalLisence, String specialisation, String name, String sName, LocalDate dob, int mobileNum) {
        super(name, sName, dob, mobileNum);
        this.medicalLisence = medicalLisence;
        this.specialisation = specialisation;
    }

    public int getMedicalLisence() {
        return medicalLisence;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public void setMedicalLisence(int medicalLisence){this.medicalLisence = medicalLisence;}

}
