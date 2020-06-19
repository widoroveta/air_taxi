package com.company;

public class Silver extends Avion
{
private boolean ServicioCatering=true;
private final int TarifaFija=4000;

    public Silver(int CapacidadCombustible,int costoxKilometro,int CapacidadMaxPersonas,int VelocidadMax,String TipoPropulsion)
    {
        super(CapacidadCombustible,costoxKilometro,CapacidadMaxPersonas,VelocidadMax,TipoPropulsion);

    }

    public boolean GetServicioCatering()
    {
        return this.ServicioCatering;
    }

    public int GetTarifaFija()
    {
        return this.TarifaFija;
    }
    public String toString()
    {
        System.out.println(" Tipo de avion: Silver \n Servicio Catering: "+GetServicioCatering());
        return super.toString();
    }
}
