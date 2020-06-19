package com.company;

import java.io.Serializable;

public class Bronze extends Avion implements Serializable
{
    private static final long serialVersionUID = 5316748056989930875L;
    private int TarifaFija=3000;

    public Bronze (int CapacidadCombustible,int costoxKilometro,int CapacidadMaxPersonas,int VelocidadMax,String TipoPropulsion )
    {
        super(CapacidadCombustible,costoxKilometro,CapacidadMaxPersonas,VelocidadMax,TipoPropulsion);
    }


    public int GetTarifaFija()
    {
        return this.TarifaFija;
    }
    public String toString()
    {
        System.out.println(" Tipo de avion: Bronze ");
        return super.toString();
    }

}
