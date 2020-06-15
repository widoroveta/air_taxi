package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args)
    {
        Date Fecha=new Date();
        Sistema Sistema=new Sistema(2);

        Avion Avion1=new Gold(800,200,100,400,"Super",true);
        Avion Avion2=new Silver(500,300,50,200,"Base");
        Reserva Nueva=new Reserva(Fecha,"BsAs","Montevideo",2,Avion1);
        //System.out.println(Nueva.toString());
        Sistema.AgregarAvion(Avion1);
        Sistema.AgregarAvion(Avion2);
        Sistema.CrearReserva();
        Sistema.MostrarReservas();






    }
}
