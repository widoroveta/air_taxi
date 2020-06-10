package com.company;

import Swing.Frame;
import Swing.PanelLogIn;
import com.sun.xml.internal.ws.spi.db.PropertyAccessor;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Person p=new Person("guido","roveta",4521555,22);
        Person c = new Person("cacho","rodriguez",4465465,5);
        File file = new File("users.json");
        File file1 = new File("users2.json");
      // String name = JOptionPane.showInputDialog("Type your name please");
        ObjectMapper mapper= new ObjectMapper();
mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.writeValue(file,c);

        mapper.writeValue(file1,p);

    }
}
