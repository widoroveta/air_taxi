package com.company;

import java.io.Serializable;

public abstract class Avion implements Serializable
{
    private static final long serialVersionUID = 5316748056989930874L;
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


//--------------------------------------------------------Metodos--------------------------------------------------------------------
public String toString()
{
    String Mensaje="\n --ID: %d--\n Capacidad Combustible: %d Litros\n Capacidad Personas: %d\n Costo x Kilometro: %d Pesos x Km\n Velocidad Maxima: %d Km/h\n Tipo de Propulcion : %s\n";
    return String.format(Mensaje,GetId(),GetCombustible(),GetCapacidadPersonas(),GetCostoXKilometro(),GetVelocidad(),GetTipoPropulcion());
}

}
