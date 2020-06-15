package Swing;

import com.company.Enum.Cities;
import com.company.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reservation extends JPanel implements ActionListener {
    JComboBox origin = new JComboBox(Cities.values());
    JComboBox destination = new JComboBox(Cities.values());
    JTextField dayD = new JTextField(2);
    JTextField monthD = new JTextField(2);
    JTextField yearD = new JTextField(4);
 /*   JTextField dayA = new JTextField(2);
    JTextField monthA = new JTextField(2);
    JTextField yearA = new JTextField(4);
*/
    JLabel personalInformation;
    JLabel label1 = new JLabel("Origin");
    JLabel label2 = new JLabel("Destination");
    JLabel label3 = new JLabel("Departure day");
    JLabel label4 = new JLabel("Number of companions");
    JLabel label5 = new JLabel("Plain class");


    public Reservation(Person person) {
        this.setLayout(null);
        this.personalInformation = new JLabel(person.toString());
        //
        this.personalInformation.setBounds(10, 10, 500, 45);
        this.label1.setBounds(10, 55, 300, 25);
        this.origin.setBounds(10, 75, 300, 25);
        this.label2.setBounds(10, 100, 300, 25);
        this.destination.setBounds(10, 120, 300, 25);
        this.label3.setBounds(10, 140, 300, 25);
        this.dayD.setBounds(20, 170, 25, 25);
        this.monthD.setBounds(50, 170, 25, 25);
        this.yearD.setBounds(80, 170, 40, 25);
    //    this.label4.setBounds(10, 190, 300, 25);
      /*  this.dayA.setBounds(20, 210, 25, 25);
        this.monthA.setBounds(50, 210, 25, 25);
        this.yearA.setBounds(80, 210, 40, 25);*/
        //
        this.add(personalInformation);
        this.add(label1);
        this.add(origin);
        this.add(label2);
        this.add(destination);
        this.add(label3);
      //  this.add(label4);
      //  this.add(label5);
    //    this.add(dayA);
        this.add(dayD);
     //   this.add(monthA);
        this.add(monthD);
    //    this.add(yearA);
        this.add(yearD);


    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
      /*  this.setLayout(null);
        this.origin.setBounds(10,10,300,25);
        this.destination.setBounds(10,40,300,25);
        this.add(origin);
        //this.add(destination);
        this.add(hola);
    */
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
