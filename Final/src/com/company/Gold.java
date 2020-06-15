package com.company;

import java.util.Set;

public class Gold extends Avion
{
    private boolean Wifi;
    private boolean ServicioCatering=true;
    private int TarifaFija=6000;

    public Gold(int CapacidadCombustible,int costoxKilometro,int CapacidadMaxPersonas,int VelocidadMax,String TipoPropulsion,boolean WifiContinuo)
    {
        super(CapacidadCombustible,costoxKilometro,CapacidadMaxPersonas,VelocidadMax,TipoPropulsion);
        SetWifi(WifiContinuo);

    }

    private void SetWifi(boolean WifiContinuo)
    {
        this.Wifi=WifiContinuo;
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
