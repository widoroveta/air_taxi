package com.company;

import java.io.Serializable;

public class Silver extends Avion implements Serializable
{
    private static final long serialVersionUID = 5316748056989930878L;
private boolean ServicioCatering=true;
private int TarifaFija=4000;

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
