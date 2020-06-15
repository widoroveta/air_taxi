package Swing;

import com.company.Person;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static java.awt.Color.BLUE;

public class Register extends JPanel implements ActionListener {

    JTextField name = new JTextField("name", 15);
    JTextField surname = new JTextField("surname", 15);
    JTextField DNI = new JTextField("DNI", 15);
    JTextField age = new JTextField("Age", 15);
    JButton button = new JButton("Submit");
    JButton button2 = new JButton("Cancel");

    public Register() {
        this.setLayout(null);
        this.name.setBounds(10, 10, 300, 40);
        this.surname.setBounds(10, 80, 300, 40);
        this.DNI.setBounds(10, 150, 300, 40);
        this.age.setBounds(10, 220, 300, 40);
        this.button.setBounds(350, 300, 120, 40);
        this.button2.setBounds(500, 300, 120, 40);
        this.add(name);
        this.add(surname);
        this.add(DNI);
        this.add(age);
        this.add(button);
        this.add(button2);
        this.button.addActionListener(this::actionPerformed);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.name.setBounds(10, 10, 300, 30);
        this.surname.setBounds(10, 80, 300, 30);
        this.DNI.setBounds(10, 150, 300, 30);
        this.age.setBounds(10, 220, 300, 30);

        this.add(name);
        this.add(surname);
        this.add(DNI);
        this.add(age);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Person person = null;
        try {
            person = this.setPerson();

            File file = new File("C:\\air_taxi-guido\\src\\com\\company\\UserFile\\" + person.getDNI() + ".json");
            if (!file.exists()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(file, person);
                JOptionPane.showMessageDialog(null, "\t\t\tYou have registered\n" + "\nName:" + person.getName() + "\nSurname:" + person.getSurname());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public Person setPerson() throws IOException {

        Person person = new Person(this.name.getText().toString(), this.surname.getText().toString(), Integer.parseInt(this.DNI.getText().toString()), Integer.parseInt(this.age.getText().toString()));

        return person;
    }
}
