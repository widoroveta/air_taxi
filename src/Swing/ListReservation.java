package Swing;

import com.company.Enum.Cities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListReservation extends JPanel implements MouseListener {
   Object[] m= new Object[50];

    JLabel label = new JLabel("please double click on the reservation you want");
    JList list;

    JScrollPane scrollPane;

    public ListReservation() {
        setLayout(new BorderLayout());
        for(int i=0;i<25;i++){
            m[i]=i;
        }
        list = new JList(m);
        list.setVisibleRowCount(4);
        list.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(list);
      add(label,BorderLayout.NORTH);
       add(scrollPane,BorderLayout.CENTER);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        list= (JList) e.getSource();
        if (e.getClickCount()==2){

list.getSelectedValue();
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
