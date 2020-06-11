package Swing;

import javafx.scene.layout.BorderPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

        JPanel panel;
        JLabel user_label, password_label, message;
        JTextField userName_text;

        JButton submit, cancel;

         public Login() {

            // User Label
            user_label = new JLabel();
            user_label.setText("DNI");
            userName_text = new JTextField();


            // Submit

            submit = new JButton("SUBMIT");

            panel = new JPanel(new GridBagLayout());
            
            panel.add(user_label);
            panel.add(userName_text);


            message = new JLabel();
            panel.add(message);
            panel.add(submit);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Adding the listeners to components..
            submit.addActionListener(this);

            add(panel,BorderLayout.CENTER);
             Toolkit miPantalla = Toolkit.getDefaultToolkit();
             Dimension pantalla = miPantalla.getScreenSize();
             int altura = pantalla.height;
             int ancho = pantalla.width;
             setBounds(ancho / 4, altura / 4, ancho / 2, altura / 2);
        /*     Image miIcono = miPantalla.getImage("src/graficos/martillo.png");
             setIconImage(miIcono);*/
         /*   setTitle("Please Login Here !");
            setSize(300, 100);*/
            setVisible(true);

        }



        @Override
        public void actionPerformed(ActionEvent ae) {
            String userName = userName_text.getText();

            if (userName.trim().equals("admin") ){
                message.setText(" Hello " + userName
                        + "");
            } else {
                message.setText(" Invalid user.. ");
            }

        }

    }

