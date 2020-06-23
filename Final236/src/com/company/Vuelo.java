package com.company;

import java.util.Date;

public class Vuelo {
    private static int ID;
    private int identi;
    private Date FechaVuelo=new Date();
    private Avion avion;
    private int UsuariosRegistradosEnVuelo;
    private int Max;
    private String CiudadOrigen;
    private String CiudadDestino;

    public Vuelo(Date fecha,Avion nuevo,String CiudadDestino,String CiudadOrigen)
    {
        Setid();
        SetFecha(fecha);
        SetAvion(nuevo);
        SetMax(Max);
        SetCiudadDestino(CiudadDestino);
        SetCiudadOrigen(CiudadOrigen);
    }
    public void SetAvion(Avion nuevo)
    {
        this.avion=nuevo;
    }
    public void SetCiudadOrigen(String Origen)
    {
        this.CiudadOrigen=Origen;
    }
    public void SetCiudadDestino(String Destino)
    {
        this.CiudadDestino=Destino;
    }
    public void SetFecha(Date fecha)
    {
        this.FechaVuelo=fecha;
    }
    private void SetMax(int Max)
    {
        this.Max=Max;
    }
    public void Setid()    {
        this.identi=ID;
        ID=ID+1;
    }
    public int Getid()
    {
        return this.identi;
    }
    public Avion GetAvion()
    {
        return this.avion;
    }
    public Date GetDate()
    {
        return this.FechaVuelo;
    }
    public String GetCiudadDestino()
{
    return this.CiudadDestino;
}
    public String GetCiudadOrigen()
    {
        return this.CiudadOrigen;
    }
    public int GetCantidadReservas()
    {
        return this.UsuariosRegistradosEnVuelo;
    }



    ///METODOS
    public void AgregarReserva(int dato)
    {
        this.UsuariosRegistradosEnVuelo=UsuariosRegistradosEnVuelo+dato;
    }
    public boolean VerificarCapacidad(int Asientos)    {
        int dato=UsuariosRegistradosEnVuelo+Asientos;
        if (Max>dato)
        {
            UsuariosRegistradosEnVuelo=UsuariosRegistradosEnVuelo+Asientos;
            return true;
        }
        else
        {
            return false;
        }
    }
    public String toString(){
    String Mensaje= "\nVuelo id: %d \nAvion: %s \nFecha: %s \nCiudad Destino: %s\nCiudad Origen: %s\nAsientos Ocupados en Avion: %s\n";
    return String.format(Mensaje,Getid(),GetAvion().toString(),GetDate().getTime(),GetCiudadDestino(),GetCiudadOrigen(),GetCantidadReservas());
}
}
