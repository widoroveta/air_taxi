package Swing;

import com.company.Avion;
import com.company.Enum.Cities;
import com.company.Enum.PlainClass;
import com.company.Gold;
import com.company.Person;
import com.company.Reserva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

public class Reservation extends JPanel implements ActionListener {

    JComboBox origin = new JComboBox(Cities.values());
    JComboBox destination = new JComboBox(Cities.values());
    JTextField dayD = new JTextField(2);
    JTextField monthD = new JTextField(2);
    JTextField yearD = new JTextField(4);
    JComboBox plain_class = new JComboBox(PlainClass.values());
    JTextField number_of_companions = new JTextField(6);
    JLabel personalInformation = new JLabel();
    JLabel label1 = new JLabel("Origin");
    JLabel label2 = new JLabel("Destination");
    JLabel label3 = new JLabel("Departure day");
    JLabel label4 = new JLabel("Number of companions");
    JLabel label5 = new JLabel("Plain class");
    JLabel label6 = new JLabel("Total");
    JList plains;
    JTextArea textArea = new JTextArea();
    JButton submit = new JButton("Submit");
    JButton cancel = new JButton("Cancel");

    public Reservation(Person person) {
        this.setLayout(null);
        if (person != null)
            this.personalInformation.setText(person.toString());
        this.personalInformation.setBounds(10, 10, 500, 45);
        this.label1.setBounds(10, 55, 300, 25);
        this.origin.setBounds(10, 75, 300, 25);
        this.label2.setBounds(10, 100, 300, 25);
        this.destination.setBounds(10, 120, 300, 25);
        this.label3.setBounds(10, 140, 300, 25);
        this.dayD.setBounds(20, 170, 25, 25);
        this.monthD.setBounds(50, 170, 25, 25);
        this.yearD.setBounds(80, 170, 40, 25);
        this.label5.setBounds(10, 190, 300, 25);
        this.plain_class.setBounds(10, 210, 300, 25);
        this.label4.setBounds(10, 240, 300, 25);
        this.number_of_companions.setBounds(10, 260, 300, 25);
        this.plains = new JList();
        plains.setBounds(350, 10, 300, 200);
        this.label6.setBounds(450, 220, 50, 40);
        this.textArea.setBounds(500, 220, 150, 40);
        this.submit.setBounds(325, 275, 100, 30);
        this.cancel.setBounds(440, 275, 100, 30);
        this.submit.addActionListener(this::actionPerformed);
        this.cancel.addActionListener(this::actionPerformed);
        this.add(personalInformation);
        this.add(label1);
        this.add(origin);
        this.add(label2);
        this.add(destination);
        this.add(label3);
        this.add(label4);
        this.add(plain_class);
        this.add(label5);
        this.add(dayD);
        this.add(monthD);
        this.add(yearD);
        this.add(number_of_companions);
        this.add(textArea);
        this.add(label6);
        this.add(plains);
        this.add(submit);
        this.add(cancel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().toString().equalsIgnoreCase(submit.toString())) {
            JOptionPane.showMessageDialog(null, this.plain_class.getSelectedItem());

            doReservation((String) this.plain_class.getSelectedItem());

        }
        if (e.getSource().toString().equalsIgnoreCase(submit.toString())) {

        }
    }

    public Reserva doReservation(String m) {
        Date date = new Date(Integer.parseInt(this.yearD.getText()), Integer.parseInt(this.monthD.getText()), Integer.parseInt(this.dayD.getText()));

        switch (m) {
            case "Gold":
                File file = new File("C:\\air_taxi-guido\\src\\com\\company\\PlainFile\\Gold");
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                }
                break;
            case "Bronze":
                // if (Silver)
                break;
            case "Silver":
                //(bronze)
                break;
        }

        return null;
    }

}
