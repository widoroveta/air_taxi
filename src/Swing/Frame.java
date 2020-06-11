package Swing;

import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(String demo_application) {


        setTitle(demo_application);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension pantalla = miPantalla.getScreenSize();
        int altura = pantalla.height;
        int ancho = pantalla.width;
        setBounds(ancho / 4, altura / 4, ancho / 2, altura / 2);
        //setLayout(null);
     /*   Image miIcono = miPantalla.getImage("src/graficos/martillo.png");
        setIconImage(miIcono);*/


    }
}