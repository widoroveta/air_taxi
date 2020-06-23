package Swing;

import com.company.Avion;
import com.company.Gold;
import com.company.Person;
import com.company.Silver;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListAircrafts extends JPanel implements MouseListener {


    JLabel label = new JLabel("please double click on the reservation you want");
    JList list;
    Avion avion;
    JScrollPane scrollPane;
    Person person;

    public ListAircrafts() throws IOException {
        setLayout(new BorderLayout());
        if(addAircraft()==null)
        list=new JList();
        else
        list = new JList(addAircraft().toArray());
        list.setVisibleRowCount(4);
        list.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(list);
        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

    }

    public ListAircrafts(List<Avion> avions) {
        setLayout(new BorderLayout());
        if(avions==null)
            list=new JList();
        else
        list = new JList(avions.toArray());
        list.setVisibleRowCount(4);
        list.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(list);
        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

    }

    public ListAircrafts(List<Avion> avions, Person person) {
        setLayout(new BorderLayout());
        if(avions==null)
            list=new JList();
        else
        list = new JList(avions.toArray());
        list.setVisibleRowCount(4);
        list.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(list);
        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        list = (JList) e.getSource();
        if ((e.getClickCount() == 2) || (person.getDNI() != 12345678)) {

            setAvion((Avion) list.getSelectedValue());
        }
        Object[] strings = {"Delete", "add date"};
        if ((e.getClickCount() == 2) || (person.getDNI() == 12345678)) {
            int menu_aircraft = JOptionPane.showOptionDialog(null, "", "menu aircraft", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, strings, strings);
            {
                if (menu_aircraft == 0) {
                    int delet = JOptionPane.showOptionDialog(null, "delete?", "menu aircraft", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Yes", "No"}, new String[]{"Yes", "No"});
                    if (delet == 0) {
                        Avion a = (Avion) list.getSelectedValue();
                        String path = new String();
                        switch (list.getSelectedValue().getClass().toString()) {
                            case "Gold":

                                path = "src\\com\\company\\PlainFile\\Gold\\";
                                break;
                            case "Bronze":

                                path = "src\\com\\company\\PlainFile\\Bronze\\";
                                break;
                            case "Silver":

                                path = "src\\com\\company\\PlainFile\\Silver\\";
                                break;
                            default:
                                avion = null;

                                break;
                        }
                        File file1 = new File(path + a.GetId() + ".json");
                        file1.delete();
                    }
                }
                if (menu_aircraft == 1) {

                }

            }
        }
    }

    public List<Avion> addAircraft() throws IOException {


        String path1 = "src\\com\\company\\PlainFile\\Gold\\";
        String path2 = "src\\com\\company\\PlainFile\\Bronze\\";
        String path3 = "src\\com\\company\\PlainFile\\Silver\\";

        List<Avion> avions = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        File file1 = new File(path1);
      if (file1.isDirectory()||file1.exists()) {

            File[] listfile1 = file1.listFiles();
            for (File file : listfile1) {
                Avion a;
                a = mapper.readValue(file, Avion.class);
                avions.add(a);
            }
        }

        File file2 = new File(path2);

        if (file2.isDirectory()) {
            File[] listfile2 = file2.listFiles();
            for (File file : listfile2) {
                Avion a = mapper.readValue(file, Avion.class);
                avions.add(a);
            }
        }
        File file3 = new File(path3);


        if (file3.isDirectory()) {
            File[] listfile3 = file3.listFiles();
            for (File file : listfile3) {
                Avion a;

                a = mapper.readValue(file, com.company.Silver.class);
                avions.add(a);


            }


        }

        return avions;
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

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Avion getAvion() {
        return avion;
    }
}

