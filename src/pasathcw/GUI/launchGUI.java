package pasathcw.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class launchGUI extends JFrame implements ActionListener { // JFrame is a java class that is extended by Frame class of Java.  JFrame is treated as the main window.
    private final ImageIcon doc = new ImageIcon("src\\pasathcw\\assets\\doc.png"); // The ImageIcon component creates an icon sized-image from an image residing at the source URL.
    private final JFrame mainFrame;
    private final JLabel welcome; // JLabel class is used to render a read-only text label or images on the UI.
    private final JButton doctorFrame; // JButton class is used to create a push-button on the UI.
    private final JButton consultation; // JButton class is used to create a push-button on the UI.
    private final Border border = BorderFactory.createLineBorder(Color.black, 3); // Borders can be used to visually separate components and add decorative elements to your user interface.

    public launchGUI() { // the constructor handles all the assets within the jframe and how its added

        mainFrame = new JFrame();
        welcome = new JLabel();
        welcome.setText("Welcome To The Skin Consultation Clinic GUI");// settext can be used to set a user defined output for the jlabel
        welcome.setFont(new Font("Monospaced", Font.BOLD, 40));// set font of text
        welcome.setForeground(Color.WHITE);// setforeground is used to set the colors of the letters
        welcome.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon plus text within label
        welcome.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon plus text within label

        doctorFrame = new JButton();
        doctorFrame.setBounds(530, 490, 250, 50); // can set the x, y coordinates and the width and hieght of the jbutton
        doctorFrame.setFocusable(false); // the cursor does not move to the button automatically
        doctorFrame.addActionListener(this);// the buttons useage depends on the actionlistener where clicking the button does a user defined task
        doctorFrame.setBackground(new Color(22, 219, 147)); //setbackground color sets the background color of any component in swing
        doctorFrame.setIcon(new ImageIcon("src\\pasathcw\\assets\\vd.png")); // the button can be customized with an image with image icon
        doctorFrame.setBorderPainted(false); // It is used to specify whether the border of a button should be painted or not. it accepts only boolean values
        doctorFrame.setFocusPainted(false); // It is used to specify whether the focus indicator of a button should be painted or not.

        consultation = new JButton();
        consultation.setBounds(530, 390, 250, 50);
        consultation.setFocusable(false);
        consultation.addActionListener(this);
        consultation.setBackground(new Color(22, 219, 147));
        consultation.setIcon(new ImageIcon("src\\pasathcw\\assets\\sc.png"));
        consultation.setBorderPainted(false);
        consultation.setFocusPainted(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Main Page"); // title of the window
        this.setSize(1280, 720); // frame size
        this.getContentPane().setBackground(new Color(22, 219, 147)); // frame bg
        this.setIconImage(doc.getImage());

        //this.add(welcomeLabel);
        this.add(doctorFrame); // add method is used to add a component to a container.
        this.add(consultation);
        this.add(welcome);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent b) {
        if (b.getSource() == doctorFrame) { // if the button pressed is equal to doctorFrame it will execute this
            this.dispose(); // closes the old frame
            ViewDoctorsGUI ViewDoctorsGUI = new ViewDoctorsGUI();
        } else if (b.getSource() == consultation) {
            this.dispose();
            ConsultationGUI consultationGUI = new ConsultationGUI();
        }
    }
}
