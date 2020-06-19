package Swing;

import com.company.Avion;
import com.company.Bronze;
import com.company.Enum.DriveType;
import com.company.Enum.PlainClass;
import com.company.Gold;
import com.company.Silver;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AircraftEntry extends JPanel implements ActionListener {

    JTextField fuel_capacity = new JTextField();
    JTextField cost_per_km = new JTextField();
    JTextField max_capacity = new JTextField();
    JTextField max_velocity = new JTextField();
    JComboBox drive_type = new JComboBox(DriveType.values());
    JComboBox aircraft_type = new JComboBox(PlainClass.values());
    JLabel label1 = new JLabel("Aircraft type");
    JLabel label2 = new JLabel("Fuel capacity");
    JLabel label3 = new JLabel("Cost per km");
    JLabel label4 = new JLabel("Max capacity");
    JLabel label5 = new JLabel("Max velocity");
    JLabel label6 = new JLabel("Drive type");
    JButton submit = new JButton("Submit");
    JButton cancel = new JButton("Cancel");

    public AircraftEntry() {
        this.setLayout(null);
        this.label1.setBounds(10, 10, 300, 25);
        this.aircraft_type.setBounds(10, 30, 300, 25);
        this.label2.setBounds(10, 55, 300, 25);
        this.fuel_capacity.setBounds(10, 75, 300, 25);
        this.label3.setBounds(10, 100, 300, 25);
        this.cost_per_km.setBounds(10, 120, 300, 25);
        this.label4.setBounds(10, 145, 300, 25);
        this.max_capacity.setBounds(10, 165, 300, 25);
        this.label5.setBounds(10, 190, 300, 25);
        this.max_velocity.setBounds(10, 210, 300, 25);
        this.label6.setBounds(10, 235, 300, 25);
        this.drive_type.setBounds(10, 255, 300, 25);
        this.submit.setBounds(325, 260, 100, 30);
        this.cancel.setBounds(440, 260, 100, 30);
        this.submit.addActionListener(this::actionPerformed);
        this.cancel.addActionListener(this::actionPerformed);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(aircraft_type);
        this.add(fuel_capacity);
        this.add(cost_per_km);
        this.add(max_capacity);
        this.add(max_velocity);
        this.add(drive_type);
        this.add(submit);
        this.add(cancel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Avion avion;
        String path = new String();
        File file;
        if (e.getSource().toString().equalsIgnoreCase(submit.toString())) {

            switch (aircraft_type.getSelectedItem().toString()) {
                case "Gold":
                    avion = this.setGold();
                    path = "C:\\air_taxi-guido\\src\\com\\company\\PlainFile\\Gold\\";
                    break;
                case "Bronze":
                    avion = this.setBronze();
                    path = "C:\\air_taxi-guido\\src\\com\\company\\PlainFile\\Bronze\\";
                    break;
                case "Silver":
                    avion = this.setSilver();
                    path = "C:\\air_taxi-guido\\src\\com\\company\\PlainFile\\Silver\\";
                    break;
                default:
                    avion = null;

                    break;
            }
            file = new File(path + avion.GetId() + ".json");

            ObjectMapper mapper = new ObjectMapper();
            try {
                mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
                mapper.writeValue(file, avion);
                JOptionPane.showMessageDialog(null, avion.toString() + "Fine Aircraft has been save");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        } else {
            if (e.getSource().toString().equalsIgnoreCase(cancel.toString()))
                System.exit(0);
        }
    }


    public Gold setGold() {
        Gold avion;
        avion = new Gold(Integer.parseInt(fuel_capacity.getText()), Integer.parseInt(cost_per_km.getText()), Integer.parseInt(max_capacity.getText()), Integer.parseInt(max_velocity.getText()), drive_type.getSelectedItem().toString(), true);
        return avion;
    }

    public Bronze setBronze() {
        Bronze avion;
        avion = new Bronze(Integer.parseInt(fuel_capacity.getText()), Integer.parseInt(cost_per_km.getText()), Integer.parseInt(max_capacity.getText()), Integer.parseInt(max_velocity.getText()), drive_type.getSelectedItem().toString());
        return avion;
    }

    public Silver setSilver() {
        Silver avion;
        avion = new Silver(Integer.parseInt(fuel_capacity.getText()), Integer.parseInt(cost_per_km.getText()), Integer.parseInt(max_capacity.getText()), Integer.parseInt(max_velocity.getText()), drive_type.getSelectedItem().toString());
        return avion;
    }
}
