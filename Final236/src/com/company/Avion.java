package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Avion
{
    public List<Date>FechasVuelos=new ArrayList<>();
    public List<Vuelo>Vuelos=new ArrayList<>();
    private static int ID;
    private int Identificador;
    private int CapacidadCombustible;
    private int CostoxKilomentro;
    private int CapacidadMax;
    private int VelocidadMax;
    private String TipoPropulsion;
    private int TarifaFija;

    public Avion (int CapacidadCombustible,int costoxKilometro,int CapacidadMaxPersonas,int VelocidadMax,String TipoPropulsion )
    {
        SetCapacidadPersonas(CapacidadMaxPersonas);
        SetCostoxKm(costoxKilometro);
        SetCapacidadCombustible(CapacidadCombustible);
        SetVelocidadMax(VelocidadMax);
        SetTipoPropulsion(TipoPropulsion);
        SetId();

    }

///------------------------------------------Getters and Setters----------------------------------------------------------------
private void SetId(){
    Identificador=ID;
    ID=ID+1;
}
private void SetCapacidadCombustible(int capacidad)
{
    this.CapacidadCombustible=capacidad;
}
private void SetCostoxKm(int Costo)
{
    this.CostoxKilomentro=Costo;
}
private void SetCapacidadPersonas(int Personas)
    {
        this.CapacidadMax=Personas;
    }
private void SetVelocidadMax(int Velocidad)
    {
        this.VelocidadMax=Velocidad;
    }
private void SetTipoPropulsion(String Tipo)
    {
        this.TipoPropulsion=Tipo;
    }
public int GetCombustible()
{
    return this.CapacidadCombustible;
}
public int GetCapacidadPersonas()
{
    return this.CapacidadMax;
}
public int GetVelocidad()
{
    return this.VelocidadMax;
}
public String GetTipoPropulcion()
{
    return this.TipoPropulsion;
}
public int GetCostoXKilometro()
{
    return this.CostoxKilomentro;
}
public int GetTarifaFija()
    {
        return this.TarifaFija;
    }
public int GetId()
    {
        return this.Identificador;
    }


    public void MostrarFechasVuelos()    {
        for (Vuelo e:Vuelos)
        {
            System.out.println(e.GetDate()+"\n");
        }
    }


    //--------------------------------------------------------Metodos--------------------------------------------------------------------
public String toString()
{
    String Mensaje="\nAvion ID: %d--\nCapacidad Combustible: %d Litros\nCapacidad Personas: %d\nCosto x Kilometro: %d Pesos x Km\nVelocidad Maxima: %d Km/h\nTipo de Propulcion : %s\n";
    return String.format(Mensaje,GetId(),GetCombustible(),GetCapacidadPersonas(),GetCostoXKilometro(),GetVelocidad(),GetTipoPropulcion());
}

}
