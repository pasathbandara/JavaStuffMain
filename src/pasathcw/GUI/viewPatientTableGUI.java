package pasathcw.GUI;

import pasathcw.Console.Doctor;
import pasathcw.Console.Patient;
import pasathcw.Console.WestminsterSkinConsultationManager_main;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

public class viewPatientTableGUI implements ActionListener {
    JFrame frame;
    JTable table = new JTable();
    ImageIcon doc = new ImageIcon("src\\pasathcw\\assets\\doc.png");
    Object[] tableColumns = {"Patient ID", "Specialization", "First Name", "Last Name", "Date Of Birth", "Mobile Number", "Cost"};
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane pane = new JScrollPane(table);

    JMenuBar mb; // main method for menu bar
    JTextField file_path;
    JTextArea addNotesText;

    //    JComboBox
    private final JComboBox patientIdadd;
    private final JComboBox docDate;

    //    JMenu
    private final JMenu fileMenu; // top three items in the menu bar https://www.educba.com/jmenu/, https://www.javatpoint.com/java-jmenuitem-and-jmenu
    private final JMenu editMenu; // top three items in the menu bar https://www.educba.com/jmenu/, https://www.javatpoint.com/java-jmenuitem-and-jmenu
    private final JMenu helpMenu; // top three items in the menu bar https://www.educba.com/jmenu/, https://www.javatpoint.com/java-jmenuitem-and-jmenu

    //    JMenuItem
    private final JMenuItem sortItem; // https://www.javatpoint.com/java-jmenuitem-and-jmenu
    private final JMenuItem userLogin; // https://www.javatpoint.com/java-jmenuitem-and-jmenu
    private final JMenuItem mainMenu; // https://www.javatpoint.com/java-jmenuitem-and-jmenu

    //    JLabel
    private final JLabel addNotes;
    private final JLabel jLabelImage;
    private final JLabel patientId;
    private final JLabel doctorsLabel;

    //    JButton picUpload, encrypt, decrypt, encryptText, decryptText, encryptSub, saveFile;
    private final JButton picUpload;
    private final JButton encrypt;
    private final JButton decrypt;
    private final JButton encryptText;
    private final JButton decryptText;
    private final JButton encryptSub;
    private final JButton saveFile;

    private final Border blackline = BorderFactory.createLineBorder(Color.black);

    List<Patient> myPatientList = ConsultationGUI.patientList;
    List<Patient> pList = ConsultationGUI.patientList;
    List<Doctor> doctorArrayList = WestminsterSkinConsultationManager_main.doctorList;

    String[] doctorList = new String[doctorArrayList.size()];
    String[] patientList = new String[myPatientList.size()];

    viewPatientTableGUI() {

        frame = new JFrame("Patients");
        frame.setTitle("View Patients");
        frame.setBounds(300, 90, 1280, 960);
        frame.getContentPane().setBackground(new Color(4, 8, 15));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application

        patientId = new JLabel("Patient ID: ");
        patientId.setFont(new Font("Monospaced", Font.BOLD, 20));
        patientId.setForeground(new Color(4, 8, 15));
        patientId.setSize(200, 20);
        patientId.setLocation(100, 300);
        frame.add(patientId);

        System.out.println(myPatientList.size());
        for (int i = 0; i < myPatientList.size(); i++) {
            patientList[i] = myPatientList.get(i).getPatientId() + " " + myPatientList.get(i).getsName();
        }

        patientIdadd = new JComboBox(patientList);
        patientIdadd.setFont(new Font("Monospaced", Font.BOLD, 15));
        patientIdadd.setForeground(new Color(4, 8, 15));
        patientIdadd.setSize(220, 20);
        patientIdadd.setLocation(325, 300);
        frame.add(patientIdadd);

        System.out.println(doctorArrayList.size());
        for (int i = 0; i < doctorArrayList.size(); i++) {
            doctorList[i] = doctorArrayList.get(i).getName() + " " + doctorArrayList.get(i).getsName();
        }
        doctorsLabel = new JLabel("Doctor : ");
        doctorsLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        doctorsLabel.setForeground(new Color(4, 8, 15));
        doctorsLabel.setSize(200, 20);
        doctorsLabel.setLocation(100, 350);
        frame.add(doctorsLabel);

        docDate = new JComboBox(doctorList);
        docDate.setFont(new Font("Monospaced", Font.BOLD, 15));
        docDate.setForeground(new Color(4, 8, 15));
        docDate.setSize(220, 25);
        docDate.setLocation(325, 350);
        frame.add(docDate);

        addNotes = new JLabel("Special Notes: ");
        addNotes.setFont(new Font("Monospaced", Font.BOLD, 20));
        addNotes.setForeground(new Color(4, 8, 15));
        addNotes.setSize(200, 20);
        addNotes.setLocation(100, 400);
        frame.add(addNotes);

        addNotesText = new JTextArea();
        addNotesText.setFont(new Font("Monospaced", Font.BOLD, 15));
        addNotesText.setForeground(new Color(4, 8, 15));
        addNotesText.setSize(220, 75);
        addNotesText.setLocation(325, 400);
        addNotesText.setLineWrap(true);
        frame.add(addNotesText);

        jLabelImage = new JLabel("Your Picture Will Be Displayed Here");
        jLabelImage.setSize(500, 500);
        jLabelImage.setBackground(new Color(152, 210, 235));
        jLabelImage.setLocation(735, 330);
        jLabelImage.setBorder(blackline);
        frame.add(jLabelImage);

        picUpload = new JButton("Add picture To View");
        picUpload.setFont(new Font("Monospaced", Font.BOLD, 15));
        picUpload.setForeground(new Color(4, 8, 15));
        picUpload.setSize(220, 35);
        picUpload.setLocation(325, 500);
        picUpload.addActionListener(this);
        frame.add(picUpload);

        file_path = new JTextField();
        file_path.setFont(new Font("Monospaced", Font.BOLD, 15));
        file_path.setForeground(new Color(4, 8, 15));
        file_path.setSize(220, 20);
        file_path.setLocation(325, 550);
        file_path.setEditable(false);
        frame.add(file_path);

        encryptSub = new JButton("Add Picture to Encrypt");
        encryptSub.setFont(new Font("Monospaced", Font.BOLD, 15));
        encryptSub.setForeground(new Color(4, 8, 15));
        encryptSub.setSize(220, 35);
        encryptSub.setLocation(325, 600);
        encryptSub.addActionListener(this::encryptSubActionPerformed);
        frame.add(encryptSub);

        encrypt = new JButton("Encrypt");
        encrypt.setFont(new Font("Monospaced", Font.BOLD, 15));
        encrypt.setForeground(new Color(4, 8, 15));
        encrypt.setSize(100, 35);
        encrypt.setLocation(325, 650);
        encrypt.addActionListener(this::encryptActionPerformed);
        frame.add(encrypt);

        decrypt = new JButton("Decrypt");
        decrypt.setFont(new Font("Monospaced", Font.BOLD, 15));
        decrypt.setForeground(new Color(4, 8, 15));
        decrypt.setSize(100, 35);
        decrypt.setLocation(445, 650);
        decrypt.addActionListener(this::decryptActionPerformed);
        frame.add(decrypt);

        encryptText = new JButton("Encrypt Text");
        encryptText.setFont(new Font("Monospaced", Font.BOLD, 15));
        encryptText.setForeground(new Color(4, 8, 15));
        encryptText.setSize(220, 35);
        encryptText.setLocation(325, 700);
        encryptText.addActionListener(this::encryptTextActionPerformed);
        frame.add(encryptText);

        decryptText = new JButton("Decrypt Text");
        decryptText.setFont(new Font("Monospaced", Font.BOLD, 15));
        decryptText.setForeground(new Color(4, 8, 15));
        decryptText.setSize(220, 35);
        decryptText.setLocation(325, 750);
        decryptText.addActionListener(this::decryptTextActionPerformed);
        frame.add(decryptText);

        saveFile = new JButton("Save Document");
        saveFile.setFont(new Font("Monospaced", Font.BOLD, 15));
        saveFile.setForeground(new Color(4, 8, 15));
        saveFile.setSize(220, 35);
        saveFile.setLocation(325, 800);
        saveFile.addActionListener(this::saveFileActionPerformed);
        frame.add(saveFile);

        frame.setResizable(true);
        frame.getContentPane().add(pane);

        model.setColumnIdentifiers(tableColumns);

        table.setBackground(Color.red);
        table.setForeground(new Color(4, 8, 15));
        table.setSelectionBackground(Color.red);
        table.setGridColor(Color.red);
        table.setFont(new Font("Monospaced", Font.BOLD, 17));
        table.setModel(model);
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        Object[] tableColumns = new Object[7]; //https://www.geeksforgeeks.org/java-swing-jtable/
        for (Patient patient : pList) {
            tableColumns[0] = patient.getPatientId();
            tableColumns[1] = patient.getSickness();
            tableColumns[2] = patient.getName();
            tableColumns[3] = patient.getsName();
            tableColumns[4] = patient.getDob();
            tableColumns[5] = patient.getMobileNum();
            tableColumns[6] = patient.getCost();

            model.addRow(tableColumns);

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
        frame.setVisible(true);//make frame visible
    }

    private void saveFileActionPerformed(ActionEvent event) { // https://www.w3schools.com/java/java_files_create.asp
        try {
            if (!pList.isEmpty()) {
                System.out.println("File created");
                FileWriter myWriter = new FileWriter("src\\pasathcw\\assets\\PatientInfo.txt"); // FileWriter is a class in Java that allows you to write text to a file in your file system. It is used to create a Writer that can write to a file.
                for (Patient patient : pList) {
                    myWriter.write("Patient ID: " + patient.getPatientId() + "\n");
                    myWriter.write("Name: " + patient.getName() + " " + patient.getsName() + "\n");
                    myWriter.write("DOB: " + patient.getDob().toString() + "\n");
                    myWriter.write("MobileNum: " + patient.getMobileNum() + "\n");
                    myWriter.write("Required Specialization: " + patient.getSickness() + "\n");
                    myWriter.write("Required Doctor: " + docDate.getSelectedItem() + "\n");
                    myWriter.write("Cost: " + patient.getCost());
                    myWriter.write("Special Notes: " + addNotesText.getText() + "\n");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sortItem) {
            //Object[] newColumn = new Object[6];
            model.setRowCount(0);
            int size = pList.size();
            for (int x = 0; x < size; x++) {
                for (int y = size - 1; y > 0; y--) {
                    Patient temp;
                    if (pList.get(y).getName().charAt(0) < pList.get(y - 1).getName().charAt(0)) {
                        temp = pList.get(y);
                        pList.set(y, pList.get(y - 1));
                        pList.set(y - 1, temp);
                    }
                }
            }
            for (Patient patient : pList) {
                tableColumns[0] = patient.getPatientId();
                tableColumns[1] = patient.getSickness();
                tableColumns[2] = patient.getName();
                tableColumns[3] = patient.getsName();
                tableColumns[4] = patient.getDob();
                tableColumns[5] = patient.getMobileNum();
                tableColumns[6] = patient.getCost();

                model.addRow(tableColumns);
            }
        } else if (e.getSource() == userLogin) {
            frame.dispose();
            ConsultationGUI consultationGUI = new ConsultationGUI();

        } else if (e.getSource() == mainMenu) {
            frame.dispose();
            launchGUI gui = new launchGUI();

        } else if (e.getSource() == picUpload) { // https://www.javatpoint.com/java-jfilechooser
            JFileChooser browse = new JFileChooser();
            browse.setCurrentDirectory(new File("src\\pasathcw\\assets\\"));
            FileNameExtensionFilter extentFilter = new FileNameExtensionFilter("IMAGES", "png", "jpeg", "jpg");
            browse.addChoosableFileFilter(extentFilter);
            int showOpenDialog = browse.showOpenDialog(null);

            if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
                File selectedImageFile = browse.getSelectedFile();
                String selectedImagePath = selectedImageFile.getAbsolutePath();
                JOptionPane.showMessageDialog(null, selectedImagePath);
                ImageIcon icon = new ImageIcon(selectedImagePath);
                Image image = icon.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);

                jLabelImage.setIcon(new ImageIcon(image));

            }
        }
    }

    private void encryptSubActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser encryptChooser = new JFileChooser();
        encryptChooser.setCurrentDirectory(new File("src\\pasathcw\\assets\\"));
        FileNameExtensionFilter extentFilter = new FileNameExtensionFilter("IMAGES", "png", "jpeg", "jpg");
        encryptChooser.addChoosableFileFilter(extentFilter);
        encryptChooser.showOpenDialog(null);
        File f = encryptChooser.getSelectedFile();
        file_path.setText(f.getAbsolutePath());

    }

    private void encryptActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            FileInputStream file = new FileInputStream(file_path.getText());

            FileOutputStream outStream = new FileOutputStream("src\\pasathcw\\assets\\EncryptedImage.jpg");
            byte[] k = "CooL2116NiTh5252".getBytes();
            SecretKeySpec key = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.ENCRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while ((read = file.read(buf)) != -1) {
                cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();
            JOptionPane.showMessageDialog(null, "The file encrypted Successfully" + "\n"
                    + "Please Select The File To Decrypt It");
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "" +
                    "src\\pasathcw\\assets\\EncryptedImage.jpg");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void decryptActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            FileInputStream file = new FileInputStream(file_path.getText());
            FileOutputStream outStream = new FileOutputStream("src\\pasathcw\\assets\\DecryptedImage.jpg");
            byte[] k = "CooL2116NiTh5252".getBytes();
            SecretKeySpec key = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.DECRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while ((read = file.read(buf)) != -1) {
                cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();
            JOptionPane.showMessageDialog(null, "The image was decrypted successfully");
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "src\\pasathcw\\assets\\DecryptedImage.jpg");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private final int key = 6;
    private String encryptedID = "";
    private String encryptedText = "";

    private void encryptTextActionPerformed(java.awt.event.ActionEvent evt) {
        String text = patientId.getText();
        String spNotes = addNotesText.getText();
        char[] charsID = text.toCharArray();
        char[] charsSPN = spNotes.toCharArray();
        System.out.println("Patient ID: ");
        for (char c : charsID) {
            c += key;
            encryptedID += c;
            System.out.print(c);
        }
        System.out.println("\n");
        System.out.println("Special Notes: ");
        for (char x : charsSPN) {
            x += key;
            encryptedText += x;
            System.out.print(x);
        }
        System.out.println("\n" + "-------------------------------------");
    }

    private void decryptTextActionPerformed(java.awt.event.ActionEvent evt) {
        char[] charsID = encryptedID.toCharArray();
        char[] charsSPN = encryptedText.toCharArray();
        System.out.println("Decrypted Information: ");
        System.out.println("Patient ID: ");
        for (char c : charsID) {
            c -= key;
            System.out.print(c);
        }
        System.out.println("\n");
        System.out.println("Special Notes: ");
        for (char x : charsSPN) {
            x -= key;
            System.out.print(x);
        }
        System.out.println("\n" + "-------------------------------------");
    }
}

