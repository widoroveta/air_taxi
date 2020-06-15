package com.company;

import Swing.Frame;

import Swing.Register;
import Swing.Reservation;
import com.sun.xml.internal.ws.spi.db.PropertyAccessor;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args)  {


        Frame jf = new Frame("Air taxi");

         jf.add(new Reservation(new Person("jorge","messi ", 2564646 ,2454)),null);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        /*final String PATH_USER = "C:\\air_taxi-guido\\src\\com\\company\\UserFile\\";
        MapPerson mapPerson=new MapPerson();
        try {
            mapPerson.setMap(PATH_USER);
        } finally {

        }
        //person.setMap("C:\\air_taxi-guido\\src\\com\\company\\UserFile");
   //   Frame v = new Frame("Register");
        String inputDni = JOptionPane.showInputDialog(jf.getContentPane(), "Input Dni");
        if (mapPerson.getMap().containsKey(Integer.parseInt(inputDni))) {
            JOptionPane.showMessageDialog(jf.getContentPane(), "Your login was correct" + "");
            jf.setVisible(true);
            jf.add(new Reservation());
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            jf.add(new Register());
            jf.setVisible(true);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }*/
    }
}
