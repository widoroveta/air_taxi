package Swing;

import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(String title) {


        setTitle(title);
        Toolkit myscreen = Toolkit.getDefaultToolkit();
        Dimension screenSize= myscreen.getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        setBounds(width / 4, height / 4, width / 2, height / 2);
        //setLayout(null);
     /*   Image miIcono = miPantalla.getImage("src/graficos/martillo.png");
        setIconImage(miIcono);*/


    }
}