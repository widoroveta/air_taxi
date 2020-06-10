package com.company;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 8799656478674716653L;
    private String name;
    private String surname;
    private int DNI;
    private int age;

    public Person() {
    }

    public Person(String name, String surname, int DNI, int age) {
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean checkIn(String name, String Surname, int DNI, int age) {
        boolean check = true;
        while (check) {
            if (this.name.equalsIgnoreCase(name)) {
                check = false;
            }
            if (this.surname.equalsIgnoreCase(surname)) {
                check = false;
            }
            if (this.age != age) {
                check = false;
            }
            if (this.DNI!=DNI)
            {
                check=false;
            }
        }

        return check;
    }

    @Override
    public String toString() {
        return "name='" + name + '\n' +
                ", surname='" + surname + '\n' +
                ", DNI=" + DNI + '\n' +
                ", age=" + age + '\n';
    }
}
