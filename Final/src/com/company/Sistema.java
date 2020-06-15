package com.company;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Sistema
{
    private int i=0;
    private ArrayList<Avion>ListaAviones=new ArrayList<>();
    private ArrayList<Reserva>ListaReservas=new ArrayList<>();

    public Sistema(int dato)
    {
        i=dato;
    }


///------------------------------------------Metodos-----------------------------------------------------------------
    public void AgregarAvion(Avion Nuevo)
    {
        //Comprobar que no exista !
        ListaAviones.add(Nuevo);
    }
    public void MostrarAviones()
    {
        for(Avion e: ListaAviones)
        {
            System.out.println(e.toString());
            System.out.println("\n");
        }
    }

    public void MostrarGolds()
    {
        for(Avion e: ListaAviones)
        {
            if (e instanceof Gold)
            {
                System.out.println(e.toString());
            }
        }
    }

    public void MostrarSilver()
    {
        for(Avion e: ListaAviones)
        {
            if (e instanceof Silver)
            {
                System.out.println(e.toString());
            }
        }

    }

    public void MostrarBronces()
    {
        for(Avion e: ListaAviones)
        {
            if (e instanceof Bronze)
            {
                System.out.println(e.toString());
            }
        }

    }
public void MostrarReservas()
{
    for (Reserva e: ListaReservas)
    {
        System.out.println(e.toString());
        System.out.println("\n");
    }
}
public void CrearReserva(){
    Scanner sc = new Scanner(System.in);
    Date testDate = null;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    boolean Validacion=false;
    String CiudadOrigen="a";
    String CiudadDestino="a";
    int dato=0;
    int cantidadAsientos;
    Avion AvionReserva = null;
    boolean Comp=false;


    while(Validacion==false)
    {
        System.out.println("Introduzca la fecha con formato dd/mm/yyyy \n");
        String fecha = sc.nextLine();
        String date = fecha;

        try{
            testDate = df.parse(date);
        } catch (Exception e){ System.out.println("\n ERROR--------> Formato no Valido\n");}
        if (!df.format(testDate).equals(date)){
            System.out.println("\nERROR--------> Fecha No Valida - Intentelo de nuevo\n");
        } else {
            System.out.println("Fecha Valida\n");
            Validacion=true;
        }
    }
    System.out.println("Ingrese el numero que indica su ciudad De Origen \n");
    System.out.println("1. Buenos Aires \n");
    System.out.println("2. Montevideo \n");
    System.out.println("3. Cordoba \n");
    System.out.println("4. Santiago \n");
    dato=sc.nextInt();
    while (Validacion==true)
    {
        if (dato==1)
    {
        CiudadOrigen="BsAs";
        Validacion=false;
    }
    else if(dato==2)
    {
        CiudadOrigen="Montevideo";
        Validacion=false;
    }
    else if(dato==3)
    {
        CiudadOrigen="Cordoba";
        Validacion=false;
    }
    else if(dato==4)
    {
        CiudadOrigen="Santiago";
        Validacion=false;
    }
    else
        {
            System.out.println("\nERROR--------> Numero no Valido intentelo de nuevo\n");
        }

    }

    while (Comp==false)
    {
        System.out.println("Ingrese el numero que indica su ciudad De Destino \n");
        System.out.println("1. Buenos Aires \n");
        System.out.println("2. Montevideo \n");
        System.out.println("3. Cordoba \n");
        System.out.println("4. Santiago \n");
        dato=sc.nextInt();
        while (Validacion==false)
        {
            if (dato==1)
            {
                CiudadDestino="BsAs";
                Validacion=true;
                Comp=true;
            }
            else if(dato==2)
            {
                CiudadDestino="Montevideo";
                Validacion=true;
                Comp=true;
            }
            else if(dato==3)
            {
                CiudadDestino="Cordoba";
                Validacion=true;
                Comp=true;
            }
            else if(dato==4)
            {
                CiudadDestino="Santiago";
                Validacion=true;
                Comp=true;
            }
            else
            {
                System.out.println("\nERROR--------> Numero no Valido intentelo de nuevo\n");
            }
            if(CiudadDestino.equals(CiudadOrigen))
            {
                System.out.println("\nERROR-------->No puede seleccionar el mismo lugar de Origen y destino intentelo de nuevo\n");
                Comp=false;
            }
        }
    }
    System.out.println("Ingrese cantidad de Asientos ");
    dato=sc.nextInt();
    cantidadAsientos= dato;
    while(Comp==true)
    {
        System.out.println("Ingrese el avion en el que desea viajar");
        dato=0;
        for(Avion e: ListaAviones)
        {
            System.out.println("\n - "+(dato+1)+" - \n"+e.toString());
            dato=dato+1;
        }
        dato=sc.nextInt();
        if(dato>ListaAviones.size())
        {
            System.out.println("\nERROR--------> Numero no valido intentelo de nuevo\n");
        }
        else
        {
            AvionReserva=ListaAviones.get(dato);
            Comp=false;
        }
    }

    Reserva Nueva=new Reserva(testDate,CiudadOrigen,CiudadDestino,cantidadAsientos,AvionReserva);
    ListaReservas.add(Nueva);

}
}
