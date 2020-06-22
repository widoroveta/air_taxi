package Swing;

import com.company.MapPerson;
import com.company.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Path;

public class ListPeople extends JPanel implements MouseListener {


    final String PATH_USER = "C:\\air_taxi-guido\\src\\com\\company\\UserFile\\";
    JLabel label = new JLabel("please double click on the reservation you want");
    JList list;
    MapPerson mapPerson = new MapPerson();
    JScrollPane scrollPane;

    public ListPeople() {
        mapPerson.setMap("C:\\air_taxi-guido\\src\\com\\company\\UserFile\\");

        setLayout(new BorderLayout());
        list = new JList(mapPerson.getMap().values().toArray());
        list.setVisibleRowCount(4);
        list.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(list);
        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        list = (JList) e.getSource();
        if (e.getClickCount() == 2) {
            Person p = (Person) list.getSelectedValue();

            int c = JOptionPane.showOptionDialog(null, "Do you have do?", "People", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Delete", "Show"}, new String[]{"Delete", "Show"});
            if (c == 0) {
                File file1 = new File(PATH_USER + p.getDNI() + ".json");
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
}


