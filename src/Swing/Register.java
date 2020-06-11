package Swing;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLUE;

public class Register extends JPanel {

    JTextField name = new JTextField("name", 15);

    JTextField surname = new JTextField("surname", 15);
    JTextField DNI = new JTextField("DNI", 15);
    JTextField age = new JTextField("Age", 15);
    JButton button =new JButton("Submit");
    JButton button2 =new JButton("Cancel");
public Register() {
    this.setLayout(null);
    this.name.setBounds(10, 10, 300, 40);
    this.surname.setBounds(10, 80, 300, 40);
    this.DNI.setBounds(10, 150, 300, 40);
    this.age.setBounds(10, 220, 300, 40);
    this.button.setBounds(350,300,120,40);
    this.button2.setBounds(500,300,120,40);
    this.add(name);
    this.add(surname);
    this.add(DNI);
    this.add(age);
this.add(button);
this.add(button2);

}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.name.setBounds(10, 10, 300, 40);
        this.surname.setBounds(10, 80, 300, 40);
        this.DNI.setBounds(10, 150, 300, 40);
        this.age.setBounds(10, 220, 300, 40);

        this.add(name);
        this.add(surname);
        this.add(DNI);
        this.add(age);
    }
}
