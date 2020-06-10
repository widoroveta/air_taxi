package Swing;

import javax.swing.*;

public class PanelLogIn extends JPanel {
    JTextField password = new JTextField(15);
    JTextField email=new JTextField(15);
    public PanelLogIn (){
this.email.setBounds(20,50,300,20);
add(email);
        this.password.setBounds(20,80,300,20);
        add(password);

    }
}
