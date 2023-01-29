package pasathcw.GUI;

import pasathcw.Console.Doctor;
import pasathcw.Console.WestminsterSkinConsultationManager_main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewDoctorsGUI implements ActionListener {
    JFrame frame = new JFrame("Doctors");
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane pane = new JScrollPane(table);
    ImageIcon doc = new ImageIcon("src\\pasathcw\\assets\\doc.png");
    Object[] tableColumns = {"Name", "Surname", "MobileNumber", "LicenseNumber", "Specialization"};
    private final JMenuBar mb; // main method for menu bar https://www.educba.com/jmenu/
    //    JMenu fileMenu,editMenu,helpMenu;// top three items in the menu bar https://www.educba.com/jmenu/
    private final JMenu fileMenu;// top three items in the menu bar https://www.educba.com/jmenu/
    private final JMenu editMenu;// top three items in the menu bar https://www.educba.com/jmenu/
    private final JMenu helpMenu;// top three items in the menu bar https://www.educba.com/jmenu/

    //    JMenuItem
//    JMenuItem sortItem, userLogin, mainMenu;
    private final JMenuItem sortItem;
    private final JMenuItem userLogin;
    private final JMenuItem mainMenu;
    List<Doctor> doctorArrayList = WestminsterSkinConsultationManager_main.doctorList;

    ViewDoctorsGUI() {

        frame.setTitle("Skin Consultation Manager");
        frame.setSize(1280, 720);
        frame.setVisible(true);//make frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(true);
        frame.getContentPane().add(pane);

        model.setColumnIdentifiers(tableColumns);

        table.setModel(model);
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        pane.setForeground(Color.RED);
        pane.setBackground(Color.black);
        pane.setBounds(0, 0, 500, 100);

        Object[] columns = new Object[5]; // https://www.geeksforgeeks.org/java-swing-jtable/
        for (Doctor doctor : doctorArrayList) {
            columns[0] = doctor.getName();
            columns[1] = doctor.getsName();
            columns[2] = doctor.getMobileNum();
            columns[3] = doctor.getMedicalLisence();
            columns[4] = doctor.getSpecialisation();

            model.addRow(columns);
        }
        sortItem = new JMenuItem("Sort Alphabetically");
        sortItem.addActionListener(this);
        userLogin = new JMenuItem("Sign up for consultation");
        userLogin.addActionListener(this);
        mainMenu = new JMenuItem("Back To Home");
        mainMenu.addActionListener(this);

        helpMenu = new JMenu("Help");
        helpMenu.add(mainMenu);
        editMenu = new JMenu("Edit");
        editMenu.add(sortItem);
        fileMenu = new JMenu("File");
        fileMenu.add(userLogin);

        mb = new JMenuBar();
        mb.add(fileMenu);
        mb.add(editMenu);
        mb.add(helpMenu); // added the three main items onto the menu bar
        frame.setJMenuBar(mb);  // setting the menu bar visible

        frame.setIconImage(doc.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sortItem) {
            Object[] newColumn = new Object[5];
            model.setRowCount(0);
            int size = doctorArrayList.size();
            for (int x = 0; x < size; x++) {
                for (int y = size - 1; y > 0; y--) {
                    Doctor temp;
                    if (doctorArrayList.get(y).getName().charAt(0) < doctorArrayList.get(y - 1).getName().charAt(0)) {
                        temp = doctorArrayList.get(y);
                        doctorArrayList.set(y, doctorArrayList.get(y - 1));
                        doctorArrayList.set(y - 1, temp);
                    }
                }
            }
            for (Doctor doctor : doctorArrayList) {
                tableColumns[0] = doctor.getName();
                tableColumns[1] = doctor.getsName();
                tableColumns[2] = doctor.getMobileNum();
                tableColumns[3] = doctor.getMedicalLisence();
                tableColumns[4] = doctor.getSpecialisation();

                model.addRow(tableColumns);
            }
        } else if (e.getSource() == userLogin) {
            frame.dispose();
            ConsultationGUI consultationGUI = new ConsultationGUI();
        } else if (e.getSource() == mainMenu) {
            frame.dispose();
            launchGUI gui = new launchGUI();
        }
    }
}

