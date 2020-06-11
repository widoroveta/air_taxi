package com.company;

import Swing.Frame;

import Swing.Login;
import Swing.Register;
import com.sun.naming.internal.FactoryEnumeration;
import com.sun.xml.internal.ws.spi.db.PropertyAccessor;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Frame jf = new Frame("Air taxi");

         Frame v = new Frame("Register");
        String inputDni = JOptionPane.showInputDialog(jf.getContentPane(), "Input Dni");
        if (inputDni.equalsIgnoreCase("guido")) {
            JOptionPane.showMessageDialog(jf.getContentPane(), "es correcto" +
                    "");
            jf.setVisible(true);
        } else {
            jf.add(new Register());
            jf.setVisible(true);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

    }
}
