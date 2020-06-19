package com.company;

public class Bronze extends Avion
{
    private final int TarifaFija=3000;

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
