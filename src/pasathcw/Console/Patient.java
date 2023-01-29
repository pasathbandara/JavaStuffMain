package pasathcw.Console;

import java.time.LocalDate;

/*the inheritor class patient represents the patients side of the person superclass where profession specific details are gotten*/
public class Patient extends Person{
    private final int patientId;
    private String sickness;
    private final int cost;

    public Patient(int patientId, String sickness,  String name, String sName, LocalDate dob, int mobileNum, int cost) {
        super(name, sName, dob, mobileNum);
        this.patientId = patientId;
        this.sickness = sickness;
        this.cost = cost;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public int getCost(){return cost;}

}
