package com.company;

import java.util.Set;

public class Gold extends Avion
{
    private final boolean Wifi=true;
    private boolean ServicioCatering=true;
    private final int TarifaFija=6000;

    public Gold(int CapacidadCombustible,int costoxKilometro,int CapacidadMaxPersonas,int VelocidadMax,String TipoPropulsion)
    {
        super(CapacidadCombustible,costoxKilometro,CapacidadMaxPersonas,VelocidadMax,TipoPropulsion);
    }

    public boolean GetWifi()
    {
        return this.Wifi;
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
        System.out.println(" Tipo de avion: Gold \n Wifi Continuo: "+Wifi+ "\n Servicio Catering: "+GetServicioCatering());
        return super.toString();
    }
}
