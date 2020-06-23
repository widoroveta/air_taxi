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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    JButton addDateFly = new JButton("add Date fly");

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
        this.addDateFly.setBounds(400, 50, 100, 30);
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
        this.addDateFly.addActionListener(this::actionPerformed);
        this.add(addDateFly);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Avion avion = null;
        String path = new String();
        File file;
        List<Date> dates = new ArrayList<>();
        if (e.getSource().toString().equalsIgnoreCase(addDateFly.toString())) {
            String date = JOptionPane.showInputDialog("Add date", null);
            SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
            Date fecha = null;
            try {
                fecha = format.parse(date);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        if(avion!=null) {
            avion.AgregarFechaVuelo(fecha);
        }
        }

        if (e.getSource().toString().equalsIgnoreCase(submit.toString())) {


            switch (aircraft_type.getSelectedItem().toString()) {
                case "Gold":
                    avion = this.setGold();
                    path = "src\\com\\company\\PlainFile\\Gold\\";
                    break;
                case "Bronze":
                    avion = this.setBronze();
                    path = "src\\com\\company\\PlainFile\\Bronze\\";
                    break;
                case "Silver":
                    avion = this.setSilver();
                    path = "src\\com\\company\\PlainFile\\Silver\\";
                    break;
                default:
                    avion = null;

                    break;
            }

            file = new File(path + avion.getIdentificador() + ".json");

            ObjectMapper mapper = new ObjectMapper();
            try {
                if (!file.exists()) {
                    mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
                    mapper.writeValue(file, com.company.Avion.class);
                    JOptionPane.showMessageDialog(null, avion.toString() + "Fine Aircraft has been save");
                } else {
                    int i=0;
                    File file1;
                    do {
                        file1 = new File(path + i + ".json");
                        i++;
                    }
                    while(file1.exists());

                    avion.SetId(i);

                }
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
        avion = new Gold(Integer.parseInt(fuel_capacity.getText()), Integer.parseInt(cost_per_km.getText()), Integer.parseInt(max_capacity.getText()), Integer.parseInt(max_velocity.getText()), drive_type.getSelectedItem().toString());
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
