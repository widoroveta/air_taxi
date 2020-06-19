package com.company;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Sistema
{
    private int i=0;
    private List<Date>ListaFechas=new ArrayList<>();
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
public void CrearReserva()
{
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

public void AgregarFechaVuelo()
{
    int identi=0;
    boolean Validacion=false;
    String fecha;
    Scanner sc = new Scanner(System.in);
    Date testDate = null;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("Estos son los Aviones Disponibles y Sus Fechas Programadas: \n");
    for(Avion e:ListaAviones)
    {
        System.out.println("ID Avion: "+e.GetId() +"\n");
        e.MostrarFechasVuelos();
    }

    while(Validacion==false)
    {
        System.out.println("Introduzca la fecha del nuevo viaje con formato dd/mm/yyyy \n");
        fecha= sc.nextLine();
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
    System.out.println("Ingrese el ID del avion al cual le quiere asignar un nuevo viaje \n");
    identi=sc.nextInt();

    ListaAviones.get(identi).AgregarFechaVuelo(testDate);
}

public void PrecargaDatos() throws ParseException {
    SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy");
    Date uno=null;
    Date dos=new Date();
    Date tres=new Date();
    Date cuatro=new Date();
    Date cinco=new Date();


    String Fecha1="20/06/2020";
    String Fecha2="19/06/2020";
    String Fecha3="25/06/2020";
    String Fecha4="29/06/2020";
    String Fecha5="25/06/2020";
    uno = a.parse(Fecha1);
    dos = a.parse(Fecha2);
    tres = a.parse(Fecha3);
    cuatro = a.parse(Fecha4);
    cinco= a.parse(Fecha5);

    //AVIONES

    Avion Avion1=new Gold(800,200,100,400,"Super",true);
    Avion Avion2=new Silver(500,300,50,200,"Base");

    ListaAviones.add(Avion1);
    ListaAviones.add(Avion2);
    //Reservas

    ListaAviones.get(0).AgregarFechaVuelo(uno);
    ListaAviones.get(0).AgregarFechaVuelo(dos);
    ListaAviones.get(1).AgregarFechaVuelo(tres);
    ListaAviones.get(1).AgregarFechaVuelo(cuatro);
    ListaAviones.get(0).AgregarFechaVuelo(cinco);

}



public void MostrarFechasVuelosSistema()
{
    // Muestra las Reservas entre el dia Actual y 15 dias a futuro.

    boolean valid=true;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date hoy=new Date();
    Date FechaLimite=new Date();
    Calendar FechaInicialCalendario=Calendar.getInstance();
    Calendar FechaLimiteCalendario=Calendar.getInstance();
    Calendar FechaComparacion=Calendar.getInstance();

    FechaInicialCalendario.setTime(hoy);
    FechaLimiteCalendario.setTime(FechaLimite);
    FechaLimiteCalendario.add(Calendar.DAY_OF_YEAR,15);
    FechaLimite=FechaInicialCalendario.getTime();


    System.out.println(""+FechaInicialCalendario.getTime()); //19 junio
    System.out.println(""+FechaLimiteCalendario.getTime());  //4 julio

    while (!FechaInicialCalendario.after(FechaLimiteCalendario))
    {
        System.out.println("\n--------------------------------------------------------------------------------------------");
        System.out.println("\n Los vuelos del dia: "+FechaInicialCalendario.getTime()+" \n");
        for (Avion e:ListaAviones)
        {
            ListaFechas=e.GetListaFechasDeVuelo();
            int s=ListaFechas.size();


            for(int i = 0; i < s; ++i)
            {
                FechaComparacion.setTime(ListaFechas.get(i));
                hoy=FechaInicialCalendario.getTime();
                FechaLimite=FechaComparacion.getTime();
                if (formatter.format(FechaComparacion.getTime()).equals(formatter.format(FechaInicialCalendario.getTime())))
                {
                    System.out.println("El avion ID: "+e.GetId()+" Tiene programado un vuelo para este dia \n");
                    valid=false;

                }
            }
        }
        if (valid==true)
        {
            System.out.println("\n No hay vuelos programados para ese dia \n");
            System.out.println("--------------------------------------------------------------------------------------------");
        }
        valid=true;

        FechaInicialCalendario.add(Calendar.DAY_OF_YEAR,1);
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
}