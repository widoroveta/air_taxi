package Swing;

import com.company.Person;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Register extends JPanel implements ActionListener {
    Frame main = new Frame("Register");
    JTextField name = new JTextField("name", 15);
    JTextField surname = new JTextField("surname", 15);
    JTextField DNI = new JTextField("DNI", 15);
    JTextField age = new JTextField("Age", 15);
    JButton button = new JButton("Submit");
    JButton button2 = new JButton("Cancel");
    Person person;

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
        main.add(this);

        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);

        this.button.addActionListener(this::actionPerformed);
        this.button2.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().toString().equalsIgnoreCase(button.toString())) {
            Person person = null;
            try {
                person = this.setPerson();

                File file = new File("src\\com\\company\\UserFile\\" + person.getDNI() + ".json");
                if (!file.exists()) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.writeValue(file, person);
                    JOptionPane.showMessageDialog(null, "\t\t\tYou have registered\n" + "\nName:" + person.getName() + "\nSurname:" + person.getSurname());
                    main.setVisible(false);
                    Frame reservation = new Frame("Reservation");
                    reservation.add(new Reservation(person));
                    reservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    reservation.setVisible(true);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else {
            if (e.getSource().toString().equalsIgnoreCase(button2.toString())) {
                System.exit(0);
            }
        }

    }

    public Person setPerson() throws IOException {

        this.person = new Person(this.name.getText().toString(), this.surname.getText().toString(), Integer.parseInt(this.DNI.getText().toString()), Integer.parseInt(this.age.getText().toString()));

        return person;
    }

    public Person getPerson() {
        return person;
    }
}
