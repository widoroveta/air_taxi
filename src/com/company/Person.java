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

    public boolean checkIn(int DNI) {


            if (this.DNI!=DNI)
            {
               return false;
            }


        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public int getDNI() {
        return DNI;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "\n name='" + name + '\n' +
                ", surname='" + surname + '\n' +
                ", DNI=" + DNI + '\n' +
                ", age=" + age + '\n';
    }
}
