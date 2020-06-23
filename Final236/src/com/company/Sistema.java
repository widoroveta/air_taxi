package com.company;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Sistema
{
    private int i=0;
    private ArrayList<Avion>ListaAviones=new ArrayList<>();
    private ArrayList<Reserva>ListaReservas=new ArrayList<>();
    private List<Vuelo>ListaVuelos=new ArrayList<>();
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
    public void CrearReserva(Usuario User,Vuelo vuelo,int acompañantes)
    {

    Reserva Nueva=new Reserva(User,vuelo,acompañantes);
    ListaReservas.add(Nueva);

}
    public void AgregarFechaVuelo(Date fecha,String CiudadOrigen,String CiudadDestino,Avion avion)
    {

        Vuelo nuevo=new Vuelo(fecha,avion,CiudadDestino,CiudadOrigen);
        ListaVuelos.add(nuevo);
    }
    public void PrecargaDatos() throws ParseException
    {
    SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy");
    Date uno=null;
    Date dos=new Date();
    Date tres=new Date();
    Date cuatro=new Date();
    Date cinco=new Date();


    String Fecha1="20/06/2020";
    String Fecha2="19/06/2020";
    String Fecha3="24/06/2020";
    String Fecha4="29/06/2020";
    String Fecha5="25/06/2020";
    uno = a.parse(Fecha1);
    dos = a.parse(Fecha2);
    tres = a.parse(Fecha3);
    cuatro = a.parse(Fecha4);
    cinco= a.parse(Fecha5);

    //AVIONES

    Avion Avion1=new Gold(800,200,100,400,"Super");
    Avion Avion2=new Silver(500,300,50,200,"Base");
    ListaAviones.add(Avion1);
    ListaAviones.add(Avion2);
    //Vuelos
    AgregarFechaVuelo(cuatro,"BsAs","Montevideo",Avion1);
    AgregarFechaVuelo(tres,"BsAs","Montevideo",Avion2);

    //USUARIO
        Usuario Alan=new Usuario("ALAN");
        Usuario Guido=new Usuario("GUIDO");
    //Reservas

        CrearReserva(Alan,ListaVuelos.get(0),2);
        CrearReserva(Guido,ListaVuelos.get(0),2);
        System.out.println("Mostrando Reservas");
        MostrarReservas();
        //VerificarCancelacionReserva(nueva1);
       // System.out.println("\n \n");
        //MostrarReservas();


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


        while (!FechaInicialCalendario.after(FechaLimiteCalendario))
        {

            System.out.println("\n Los vuelos del dia: "+FechaInicialCalendario.getTime()+" \n");
            for (Vuelo e:ListaVuelos)
            {

                FechaComparacion.setTime(e.GetDate());
                hoy=FechaInicialCalendario.getTime();
                FechaLimite=FechaComparacion.getTime();
                if (formatter.format(FechaComparacion.getTime()).equals(formatter.format(FechaInicialCalendario.getTime())))
                {
                    System.out.println("El avion ID: "+e.GetAvion().GetId()+" Tiene programado un vuelo para este dia \n");
                    System.out.println("El ID del vuelo: "+e.Getid()+"\n");

                    valid=false;
                    System.out.println("--------------------------------------------------------------------------------------------");

                }
            }

        if (valid==true)
        {
            System.out.println("\n No hay vuelos programados para ese dia \n");
            System.out.println("--------------------------------------------------------------------------------------------");
        }
        valid=true;

        FechaInicialCalendario.add(Calendar.DAY_OF_YEAR,1);
    }
    }
    public boolean VerificacionIngresoReserva(int Acompañantes, Vuelo nuevo)
    {
    boolean confirmacion=true;
        if(nuevo.VerificarCapacidad(Acompañantes)==false)
        {
            confirmacion=false;
        }
    return  confirmacion;
}
    public boolean VerificacionCreaciondeVuelo(Date fecha,Avion avion)
    {
    //Si retorna false es porque esa fecha ya tiene programado un vuelo con el mismo avion
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    boolean confirm=true;
    for(Vuelo e:ListaVuelos)
    {
        if ( (df.format(e.GetDate()).equals(df.format(fecha))) && avion.GetId()==e.GetAvion().GetId())
        {
            confirm=false;
        }
    }
return confirm;
}

    public boolean VerificarCancelacionReserva(Reserva reserva)
    {
        int i=0;
        Date fechaInicial=new Date();
        Calendar FechaInicialCalendario=Calendar.getInstance();
        Calendar FechaLimiteCalendario=Calendar.getInstance();
        FechaInicialCalendario.setTime(fechaInicial);
        FechaLimiteCalendario.setTime(reserva.GetVuelo().GetDate());
        FechaInicialCalendario.add(Calendar.DAY_OF_YEAR,2);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (formatter.format(FechaLimiteCalendario.getTime()).equals(formatter.format(FechaInicialCalendario.getTime())))
        {
            return false;
        }
        else
        {
            for(Vuelo e:ListaVuelos)
            {
                if(e.equals(ListaVuelos.get(i)))
                {
                    ListaVuelos.remove(i);
                }
                else
                {
                    i=i+1;
                }
            }
            return true;
        }

    }

}