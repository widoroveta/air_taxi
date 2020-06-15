package com.company;

import com.company.Person;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MapPerson implements Serializable {
    private Map<Integer, Person> map = new HashMap<>();

    public MapPerson() {

    }

    public Map<Integer, Person> getMap() {
        return map;
    }

    public void setMap(String path) {
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        try {
    /*if(!file.exists()){
file.createNewFile();

    }*/
            if (file.isDirectory()) {
                // final String PATH_USER = "C:\\air_taxi-guido\\src\\com\\company\\UserFile\\";
                //        File file =new File(PATH_USER);
                //        File[] listfile=file.listFiles();
                //        for (File f:listfile) {
                //            System.out.println(f.getName());
                //        }
                File[] files = file.listFiles();
                for (File file1 : files) {
                    Person p = mapper.readValue(file1, Person.class);
                    this.map.put(p.getDNI(), p);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "MapPerson{" +
                "map=" + map +
                '}';
    }
}
