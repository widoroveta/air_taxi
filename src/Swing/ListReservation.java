package Swing;

import com.company.Person;
import com.company.Reserva;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListReservation extends JPanel implements MouseListener {


    JLabel label = new JLabel("please double click on the reservation you want");
    JList list;

    JScrollPane scrollPane;

    public ListReservation() {
        setLayout(new BorderLayout());

        list = new JList(setReservalist());
        list.setVisibleRowCount(4);
        list.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(list);
      add(label,BorderLayout.NORTH);
       add(scrollPane,BorderLayout.CENTER);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        list = (JList) e.getSource();
        if (e.getClickCount() == 2) {
     Reserva p = (Reserva) list.getSelectedValue();

            int c = JOptionPane.showOptionDialog(null, "Do you have do?", "People", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Delete", "Show"}, new String[]{"Delete", "Show"});
            if (c == 0) {
                File file1 = new File("C:\\air_taxi-guido\\src\\com\\company\\ReservationFile\\" +p.GetNumeroReserva()  + ".json");
                file1.delete();

            } else {
                JOptionPane.showMessageDialog(null, p);
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public Reserva[] setReservalist (){
        List<Reserva> reservaList= new ArrayList<>();
        File file = new File("C:\\air_taxi-guido\\src\\com\\company\\ReservationFile\\");
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    Reserva p = mapper.readValue(file1, Reserva.class);
                    reservaList.add(p);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"This directory has been removed or no it is in the path");
        }
        return (Reserva[]) reservaList.toArray();

    }
}
