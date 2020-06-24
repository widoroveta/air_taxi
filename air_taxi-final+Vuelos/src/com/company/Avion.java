package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Avion implements Serializable
{
    private static final long serialVersionUID = 8799656478674716632L;
    public List<Date>FechasVuelos=new ArrayList<>();
    private static int ID;
    private int Identificador;
    private int CapacidadCombustible;
    private int CostoxKilomentro;
    private int CapacidadMax;
    private int capacidadOcupada;
    private int VelocidadMax;
    private String TipoPropulsion;
    private int TarifaFija;
public Avion(){}
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
   public void SetId(int i){
    ID=i;
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

    public void setCapacidadOcupada(int capacidadOcupada) {
        this.capacidadOcupada = capacidadOcupada;

    }

    public int getCapacidadOcupada() {
        return capacidadOcupada;
    }

    public int getIdentificador() {
        return Identificador;
    }

    public List<Date> GetListaFechasDeVuelo()
    {
        return this.FechasVuelos;
    }



///-------------Manejo fechas----------

    public void AgregarFechaVuelo(Date Fecha)    {
        boolean asd=false;
        for(Date e: FechasVuelos)
        {
            if(e.equals(Fecha))
            {
                asd=true;
            }
        }
        if(asd==false)
        {
            FechasVuelos.add(Fecha);
        }
        else
        {
            System.out.println("ERROR---> El avion ya tiene programado un vuelo en esa fecha");
        }
    }

    public void MostrarFechasVuelos()    {
        for (Date e:FechasVuelos)
        {
            System.out.println(e.toString()+"\n");
        }
    }


    //--------------------------------------------------------Metodos--------------------------------------------------------------------
public String toString()
{
    String Mensaje="\n --ID: %d--\n Capacidad Combustible: %d Litros\n Capacidad Personas: %d\n Costo x Kilometro: %d Pesos x Km\n Velocidad Maxima: %d Km/h\n Tipo de Propulcion : %s\n";
    return String.format(Mensaje,GetId(),GetCombustible(),GetCapacidadPersonas(),GetCostoXKilometro(),GetVelocidad(),GetTipoPropulcion());
}

}
