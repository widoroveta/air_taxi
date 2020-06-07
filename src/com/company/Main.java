package com.company;

import Swing.Frame;
import Swing.PanelLogIn;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
      // String name = JOptionPane.showInputDialog("Type your name please");

      /*  Object[] options1 = { "Si", "No",
                };

        JPanel panel = new JPanel();
        Component usted_esta_regritrado = panel.add(new JLabel("Usted esta regritrado"));


        int result = JOptionPane.showOptionDialog(null, panel, "Sistema de logeo",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        if (result == JOptionPane.YES_OPTION){
            //     JOptionPane.showMessageDialog(null, "Hello " + name);*/
       /*Frame miMarco=new Frame();
     miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

*/
    Frame frame = new Frame("Demo application");


        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);

       // }
    }
    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 100, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        JButton registerButton = new JButton("register");
        registerButton.setBounds(180, 80, 80, 25);
        panel.add(registerButton);
    }
}
