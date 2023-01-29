package pasathcw.Console;

import java.time.LocalDate;

/*creation of the super class where all the common details of both the doctor and patient are gathered*/
/*the inheritors are the Doctor class and the Patient Class*/
public class Person {
    private String name;
    private String sName;
    private LocalDate dob;
    private int mobileNum;

    public Person(String name, String sName, LocalDate dob, int mobileNum) {
        this.name = name;
        this.sName = sName;
        this.dob = dob;
        this.mobileNum = mobileNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(int mobileNum) {
        this.mobileNum = mobileNum;
    }

}


