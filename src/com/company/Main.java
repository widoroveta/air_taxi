package com.company;

import Swing.*;

import Swing.Frame;
import com.sun.xml.internal.ws.spi.db.PropertyAccessor;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String[] m = {"do reservation", "cancel Reservation"};


        final String PATH_USER = "C:\\air_taxi-guido\\src\\com\\company\\UserFile\\";
        MapPerson mapPerson = new MapPerson();
        mapPerson.setMap(PATH_USER);
        String title = "air taxi";
        Frame jf = new Frame(title);
        int inputDni = Integer.parseInt(JOptionPane.showInputDialog(jf.getContentPane(), "Input Dni"));
/*
 jf.add(new Reservation(new Person ("carlos","messi",45454,45)));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
*/

        if (inputDni == 12345678) {
            String[] h = {"add aircraft", "List Aircraft", "List Reservation", "List Person"};
            int i = JOptionPane.showOptionDialog(null, "", "admin menu", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, h, h);
            if (i == 0) {
                jf.add(new AircraftEntry());

                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setVisible(true);
            }
            if (i == 1) {
                try {
                    jf.add(new ListAircrafts());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (i == 2) {
                jf.add(new ListReservation());

                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setVisible(true);
            }
            if (i == 3) {
                jf.add(new ListPeople());
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setVisible(true);
            }


    } else

    {
        if (mapPerson.getMap().containsKey(inputDni)) {
            String[] mmm = {"do reservation", "cancel Reservation"};
            int i = JOptionPane.showOptionDialog(null, "Do you have do?", "Question", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, mmm, mmm);
            if (i == 0) {
                JOptionPane.showMessageDialog(jf.getContentPane(), "Your login was correct" + "");

                jf.add(new Reservation(mapPerson.getMap().get(inputDni)));
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setVisible(true);
            } else {
                ListReservation listReservation = new ListReservation();

                jf.add(listReservation);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setVisible(true);

            }
        } else {

            Register register = new Register();

        }
    }
}
}


