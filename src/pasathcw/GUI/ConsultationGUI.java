package pasathcw.GUI;

import pasathcw.Console.Consultation;
import pasathcw.Console.Doctor;
import pasathcw.Console.Patient;
import pasathcw.Console.WestminsterSkinConsultationManager_main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConsultationGUI extends JFrame implements ActionListener {
    JLabel loginLabel;
    JMenuBar mb; // menu bar component which is needed for a small menu on the top
    ImageIcon doc = new ImageIcon("src\\pasathcw\\assets\\doc.png");
    Container container;
    private final ButtonGroup genderGroup; // the button group components makes sure that only one radio button can be selected

    // JButton
    private final JButton sub;
    private final JButton reset;

    //JTextArea
    private final JTextArea notesArea; // used to display the user
    private final JTextArea resAdd;
    private final JTextArea tout;

    //JRadioButton
    private final JRadioButton maleBtn; // the radio buttons for gender
    private final JRadioButton femaleBtn; // the radio buttons for gender

    //JCheckbox
    private final JCheckBox termsCheckBox; // multiple selection check box
    private final JCheckBox feesCheckBox; // multiple selection check box

    //JMenu
    private final JMenu fileMenu; // top three items in the menu bar https://www.educba.com/jmenu/, https://www.javatpoint.com/java-jmenuitem-and-jmenu
    private final JMenu editMenu; // top three items in the menu bar https://www.educba.com/jmenu/, https://www.javatpoint.com/java-jmenuitem-and-jmenu
    private final JMenu helpMenu; // top three items in the menu bar https://www.educba.com/jmenu/, https://www.javatpoint.com/java-jmenuitem-and-jmenu

    //JTextField
    private final JTextField tNameField; // text input area which is proceeded with the label name
    private final JTextField stNameField; // text input area which is proceeded with the label name
    private final JTextField tmNoField; // text input area which is proceeded with the label name

    //JMenuItem
    private final JMenuItem mainMenu; // sub items which are in the JMenuBar https://www.javatpoint.com/java-jmenuitem-and-jmenu
    private final JMenuItem viewDocs; // sub items which are in the JMenuBar https://www.javatpoint.com/java-jmenuitem-and-jmenu
    private final JMenuItem resetFrom; // sub items which are in the JMenuBar https://www.javatpoint.com/java-jmenuitem-and-jmenu
    private final JMenuItem viewPatients; // sub items which are in the JMenuBar https://www.javatpoint.com/java-jmenuitem-and-jmenu

    //JComboBox
    private final JComboBox date;
    private final JComboBox month;
    private final JComboBox year;
    private final JComboBox specs1;
    private final JComboBox docDate;
    private final JComboBox hoursField;

    //JLABELS
    private final JLabel title;
    private final JLabel fNameLabel;
    private final JLabel sNameLabel;
    private final JLabel mNoLabel;
    private final JLabel genderLabel;
    private final JLabel dobLabel;
    private final JLabel specsLabel;
    private final JLabel notesLabel;
    private final JLabel doctorsLabel;
    private final JLabel res;
    private final JLabel visitHours;

    // array created inorder for the combo boxes to access
    String[] dates = {" ",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "" +
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String[] months = {" ",
            "Jan", "Feb", "Mar",
            "Apr", "May", "Jun", "Jul",
            "Aug", "Sup", "Oct", "Nov", "Dec"};
    String[] years = {" ",
            "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939",
            "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949",
            "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959",
            "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
            "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
            "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
            "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
            "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
            "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
            "2020", "2021", "2022"};

    String[] specialization = {" ", "Cosmetic dermatology", "Medical dermatology",
            "Paediatric dermatology", "Dermatopathology", "Mohs Surgery"};
    String[] hoursVisit = {"1", "2", "3", "4"};

    List<Doctor> doctorArrayList = WestminsterSkinConsultationManager_main.doctorList;
    String[] doctorList = new String[doctorArrayList.size()];
    public static final List<Patient> patientList = new ArrayList<>();
    public static final List<Consultation> consultationList = new ArrayList<>();

    ConsultationGUI() {
        setTitle("Consultation Form");
        this.getContentPane().setBackground(new Color(163, 121, 201));
        setBounds(300, 90, 1280, 960);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        title = new JLabel("Consultation Form");
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setForeground(new Color(225, 242, 254));
        title.setSize(300, 30);
        title.setLocation(500, 30);
        title.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon plus text within label
        title.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon plus text within label
        container.add(title);

        fNameLabel = new JLabel("First Name: ");
        fNameLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        fNameLabel.setForeground(new Color(225, 242, 254));
        fNameLabel.setSize(200, 20);
        fNameLabel.setLocation(100, 100);
        container.add(fNameLabel);

        tNameField = new JTextField();
        tNameField.setFont(new Font("Monospaced", Font.BOLD, 15));
        tNameField.setForeground(new Color(4, 8, 15));
        tNameField.setSize(220, 20);
        tNameField.setLocation(325, 100);
        container.add(tNameField);

        sNameLabel = new JLabel("Surname: ");
        sNameLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        sNameLabel.setForeground(new Color(225, 242, 254));
        sNameLabel.setSize(200, 20);
        sNameLabel.setLocation(100, 150);
        container.add(sNameLabel);

        stNameField = new JTextField();
        stNameField.setFont(new Font("Monospaced", Font.BOLD, 15));
        stNameField.setForeground(new Color(4, 8, 15));
        stNameField.setSize(220, 20);
        stNameField.setLocation(325, 150);
        container.add(stNameField);

        mNoLabel = new JLabel("Mobile Number: ");
        mNoLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        mNoLabel.setForeground(new Color(225, 242, 254));
        mNoLabel.setSize(200, 20);
        mNoLabel.setLocation(100, 200);
        container.add(mNoLabel);

        tmNoField = new JTextField();
        tmNoField.setFont(new Font("Monospaced", Font.BOLD, 15));
        tmNoField.setForeground(new Color(4, 8, 15));
        tmNoField.setSize(220, 20);
        tmNoField.setLocation(325, 200);
        container.add(tmNoField);

        genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        genderLabel.setForeground(new Color(225, 242, 254));
        genderLabel.setSize(100, 20);
        genderLabel.setLocation(100, 250);
        container.add(genderLabel);

        maleBtn = new JRadioButton("Male");
        maleBtn.setFont(new Font("Monospaced", Font.BOLD, 15));
        maleBtn.setForeground(new Color(4, 8, 15));
        maleBtn.setBackground(new Color(163, 121, 201));
        maleBtn.setSelected(false);
        maleBtn.setSize(75, 20);
        maleBtn.setLocation(325, 250);
        container.add(maleBtn);

        femaleBtn = new JRadioButton("Female");
        femaleBtn.setFont(new Font("Monospaced", Font.BOLD, 15));
        femaleBtn.setForeground(new Color(4, 8, 15));
        femaleBtn.setBackground(new Color(163, 121, 201));
        femaleBtn.setSelected(false);
        femaleBtn.setSize(80, 20);
        femaleBtn.setLocation(425, 250);
        container.add(femaleBtn);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);

        dobLabel = new JLabel("D.O.B");
        dobLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        dobLabel.setForeground(new Color(225, 242, 254));
        dobLabel.setSize(100, 20);
        dobLabel.setLocation(100, 300);
        container.add(dobLabel);

        date = new JComboBox(dates);
        date.setFont(new Font("Monospaced", Font.BOLD, 15));
        date.setForeground(new Color(4, 8, 15));
        date.setSelectedIndex(0);
        date.setSize(50, 20);
        date.setLocation(325, 300);
        container.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Monospaced", Font.BOLD, 15));
        month.setForeground(new Color(4, 8, 15));
        month.setSelectedIndex(0);
        month.setSize(60, 20);
        month.setLocation(400, 300);
        container.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Monospaced", Font.BOLD, 15));
        year.setForeground(new Color(4, 8, 15));
        year.setSelectedIndex(0);
        year.setSize(70, 20);
        year.setLocation(475, 300);
        container.add(year);

        specsLabel = new JLabel("Specialization: ");
        specsLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        specsLabel.setForeground(new Color(225, 242, 254));
        specsLabel.setSize(200, 20);
        specsLabel.setLocation(100, 350);
        container.add(specsLabel);

        specs1 = new JComboBox(specialization);
        specs1.setFont(new Font("Monospaced", Font.BOLD, 15));
        specs1.setSelectedIndex(0);
        specs1.setForeground(new Color(4, 8, 15));
        specs1.setSize(220, 25);
        specs1.setLocation(325, 350);
        specs1.addActionListener(this);
        container.add(specs1);

        System.out.println(doctorArrayList.size());
        for (int i = 0; i < doctorArrayList.size(); i++) {
            doctorList[i] = doctorArrayList.get(i).getName() + " " + doctorArrayList.get(i).getsName();
        }
        doctorsLabel = new JLabel("Doctor : ");
        doctorsLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        doctorsLabel.setForeground(new Color(225, 242, 254));
        doctorsLabel.setSize(200, 20);
        doctorsLabel.setLocation(100, 400);
        container.add(doctorsLabel);

        docDate = new JComboBox(doctorList);
        docDate.setFont(new Font("Monospaced", Font.BOLD, 15));
        docDate.setForeground(new Color(4, 8, 15));
        docDate.setSize(220, 25);
        docDate.setLocation(325, 400);
        //docDate.setEnabled(false);
        container.add(docDate);

        notesLabel = new JLabel("Notes: ");
        notesLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        notesLabel.setForeground(new Color(225, 242, 254));
        notesLabel.setSize(200, 20);
        notesLabel.setLocation(100, 450);
        container.add(notesLabel);

        notesArea = new JTextArea();
        notesArea.setFont(new Font("Monospaced", Font.BOLD, 15));
        notesArea.setForeground(new Color(4, 8, 15));
        notesArea.setSize(220, 75);
        notesArea.setLocation(325, 450);
        notesArea.setLineWrap(true);
        container.add(notesArea);

        visitHours = new JLabel("Visiting hours: ");
        visitHours.setFont(new Font("Monospaced", Font.BOLD, 20));
        visitHours.setForeground(new Color(225, 242, 254));
        visitHours.setSize(200, 20);
        visitHours.setLocation(100, 550);
        container.add(visitHours);

        hoursField = new JComboBox(hoursVisit);
        hoursField.setFont(new Font("Monospaced", Font.BOLD, 15));
        hoursField.setForeground(new Color(4, 8, 15));
        hoursField.setSelectedIndex(0);
        hoursField.setSize(70, 20);
        hoursField.setLocation(325, 550);
        hoursField.addActionListener(this);
        container.add(hoursField);

        termsCheckBox = new JCheckBox("Accept Terms And Conditions.");
        termsCheckBox.setForeground(new Color(4, 8, 15));
        termsCheckBox.setBackground(new Color(163, 121, 201));
        termsCheckBox.setFont(new Font("Monospaced", Font.BOLD, 15));
        termsCheckBox.setSize(400, 20);
        termsCheckBox.setLocation(325, 600);
        container.add(termsCheckBox);

        feesCheckBox = new JCheckBox();
        feesCheckBox.setText("Select If This Is Your First Time Consultation.");
        feesCheckBox.setBackground(new Color(163, 121, 201));
        feesCheckBox.setForeground(new Color(4, 8, 15));
        feesCheckBox.setFont(new Font("Monospaced", Font.BOLD, 15));
        feesCheckBox.setSize(400, 20);
        feesCheckBox.setLocation(325, 630);
        //feesCheckBox.addActionListener(this::calculateValueActionPerformed);
        container.add(feesCheckBox);

        sub = new JButton("Submit");
        sub.setFont(new Font("Monospaced", Font.BOLD, 15));
        sub.setForeground(new Color(4, 8, 15));
        sub.setSize(100, 20);
        sub.setLocation(325, 700);
        sub.addActionListener(this);
        container.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Monospaced", Font.BOLD, 15));
        reset.setForeground(new Color(4, 8, 15));
        reset.setSize(100, 20);
        reset.setLocation(475, 700);
        reset.addActionListener(this);
        container.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Monospaced", Font.BOLD, 15));
        tout.setForeground(new Color(4, 8, 15));
        tout.setBackground(new Color(152, 210, 235));
        tout.setSize(400, 400);
        tout.setLocation(800, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        container.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Monospaced", Font.BOLD, 20));
        res.setBackground(new Color(152, 210, 235));
        res.setForeground(new Color(4, 8, 15));
        res.setSize(400, 25);
        res.setLocation(800, 500);
        container.add(res);

        resAdd = new JTextArea();
        resAdd.setFont(new Font("Monospaced", Font.BOLD, 15));
        resAdd.setForeground(new Color(4, 8, 15));
        resAdd.setBackground(new Color(152, 210, 235));
        resAdd.setSize(400, 75);
        resAdd.setLocation(800, 100);
        resAdd.setLineWrap(true);
        container.add(resAdd);

        helpMenu = new JMenu("Help");
        mainMenu = new JMenuItem("Back To Home");
        helpMenu.add(mainMenu);
        mainMenu.addActionListener(this);

        editMenu = new JMenu("Edit");
        resetFrom = new JMenuItem("Reset Form");
        editMenu.add(resetFrom);
        resetFrom.addActionListener(this);

        fileMenu = new JMenu("File");
        viewDocs = new JMenuItem("View Doctors");
        fileMenu.add(viewDocs);
        viewDocs.addActionListener(this);

        viewPatients = new JMenuItem("View Patients");
        fileMenu.add(viewPatients);
        viewPatients.addActionListener(this);

        mb = new JMenuBar();
        mb.add(fileMenu); // added the three main items onto the menu bar
        mb.add(editMenu);
        mb.add(helpMenu);

        this.setIconImage(doc.getImage());

        loginLabel = new JLabel();
        this.add(loginLabel);
        this.setJMenuBar(mb); // setting the menu bar visible
        setVisible(true);
        // method actionPerformed()
        // to get the action performed
        // by the user and act accordingly
    }


    public void actionPerformed(ActionEvent e) {
        int selectedIndex = hoursField.getSelectedIndex();
        int selectedValue = Integer.parseInt(hoursVisit[selectedIndex]);
        Object selectedItem = hoursField.getSelectedItem();
        int calculation = 0;

        if (e.getSource() == sub) {
            if (termsCheckBox.isSelected()) {
                String data1;
                String data4;
                String data = "Name : " + tNameField.getText() + "\n" + "\n" + "Surname : " + stNameField.getText() + "\n" + "\n" + "Mobile : " + tmNoField.getText() + "\n" + "\n";
                if (maleBtn.isSelected()) data1 = "Gender : Male" + "\n" + "\n";
                else data1 = "Gender : Female" + "\n" + "\n";

                String data2 = "DOB : " + date.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem() + "\n" + "\n"
                        + "Specialization: " + specs1.getSelectedItem() + "\n" + "\n"
                        + "Doctor Name: " + docDate.getSelectedItem() + "\n" + "\n";

                if ((selectedValue == 1) && (feesCheckBox.isSelected())) calculation = 15;
                else if ((selectedValue == 2) && (feesCheckBox.isSelected())) calculation = 15 + 25;
                else if ((selectedValue == 3) && (feesCheckBox.isSelected())) calculation = 15 + 25 + 25;
                else if ((selectedValue == 4) && (feesCheckBox.isSelected())) calculation = 15 + 25 + 25 + 25;
                else if ((selectedValue == 1) && (!feesCheckBox.isSelected())) calculation = 25;
                else if ((selectedValue == 2) && (!feesCheckBox.isSelected())) calculation = 25 + 25;
                else if ((selectedValue == 3) && (!feesCheckBox.isSelected())) calculation = 25 + 25 + 25;
                else if ((selectedValue == 4) && (!feesCheckBox.isSelected())) calculation = 25 + 25 + 25 + 25;
                data4 = "Payment Status:" + calculation + "\n" + "\n";

                String data3 = "Notes : " + notesArea.getText() + "\n";
                tout.setText(data + data1 + data2 + data3 + "\n" + data4);
                tout.setEditable(false);
                JOptionPane.showMessageDialog(null, "Registration Successfully Completed..", "Welcome", JOptionPane.PLAIN_MESSAGE);
                //res.setText("Registration Successfully Completed..");

                String sDate = date.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
                LocalDate dob = LocalDate.parse(sDate, formatter);

                int min = 0;
                int max = 9999;
                int b = (int) (Math.random() * (max - min + 1) + min);

                Patient patient1 = new Patient(b, (String) specs1.getSelectedItem(), tNameField.getText(), stNameField.getText(), dob, Integer.parseInt(tmNoField.getText()), calculation);
                patientList.add(patient1);
                Consultation consultation1 = new Consultation(patient1, calculation, notesArea.getText());
                consultationList.add(consultation1);

            } else {
                tout.setText("");
                resAdd.setText("");
                JOptionPane.showMessageDialog(null, "Please accept the terms & conditions", "Error", JOptionPane.PLAIN_MESSAGE);
                //res.setText("Please accept the" + " terms & conditions..");
            }
        } else if ((e.getSource() == reset) || (e.getSource() == resetFrom)) {
            String def = "";
            tNameField.setText(def);
            stNameField.setText(def);
            notesArea.setText(def);
            tmNoField.setText(def);
            res.setText(def);
            tout.setText(def);
            termsCheckBox.setSelected(false);
            feesCheckBox.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            specs1.setSelectedIndex(0);

            resAdd.setText(def);
            JOptionPane.showMessageDialog(null, "The Form Was Reset", "Form Reset", JOptionPane.PLAIN_MESSAGE);
        } else if (e.getSource() == viewDocs) {
            this.dispose();
            ViewDoctorsGUI docs = new ViewDoctorsGUI();

        } else if (e.getSource() == mainMenu) {
            this.dispose();
            launchGUI gui = new launchGUI();

        } else if (e.getSource() == viewPatients) {
            this.dispose();
            viewPatientTableGUI pt = new viewPatientTableGUI();
        }
    }

}

