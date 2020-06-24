package com.company;

import com.company.Enum.Cities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva implements Serializable
{
    private static int ID;
    private int NumeroDeReserva;
    private boolean activo=false;
   private Date fecha=new Date();
   private String CiudadOrigen;
   private String CiudadDestino;
   private int Acompañantes;
   private Avion Nuevo;
   private int CostoVuelo;
   private final int TarifaGlobal=3500;
   private Person person ;


   public Reserva(Date Fecha,String CiudadOrg,String CiudadDestin, int Acompañantes, Avion nuevo,Person person)
   {
       SetAvion(nuevo);
       SetAcompañantes(Acompañantes);
       SetCiudadDestino(CiudadDestin);
       SetCiudadOrigen(CiudadOrg);
       SetFecha(Fecha);
       CalcularPrecioViaje();
   }
///--------------------------------------------Getters and Setters-------------------------------------------------------------------
   private void SetFecha(Date Fecha)
   {
       this.fecha=Fecha;
   }
   private void SetCiudadOrigen(String Origen)
   {
       this.CiudadOrigen=Origen;
   }
   private void SetCiudadDestino(String Destino)
   {
       this.CiudadDestino=Destino;
   }
   private void SetAvion(Avion nave)
   {
       this.Nuevo=nave;
   }
   private void SetAcompañantes(int acompañantes)
   {
       this.Acompañantes=acompañantes;
   }
   private void SetNumeroReserva()   {
       this.NumeroDeReserva=ID;
       ID=ID+1;
   }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int GetNumeroReserva()
   {
       return this.NumeroDeReserva;
   }
    public int GetTarifaGlobal()
{
    return this.TarifaGlobal;
}
    public int GetAcompañantes()
   {
       return this.Acompañantes;
   }
    public String GetCiudadOrigen()
   {
       return this.CiudadOrigen;
   }
    public String GetCiudadDestino()
   {
       return this.CiudadDestino;
   }
    public Avion GetAvion()
   {
       return this.Nuevo;
   }
   public int GetPrecioFinal()
   {
       return this.CostoVuelo;
   }

    public Date getFecha() {
        return fecha;
    }

    public Person getPerson() {
        return person;
    }

    ///-------------------------------------------------Metodos-----------------------------------------------------------------------
private void CalcularPrecioViaje() {
    int suma=0;

    if((CiudadDestino.equals(Cities.BsAs.getCities()) && CiudadOrigen.equals(Cities.CBA.getCities())) || (CiudadDestino.equals(Cities.CBA.getCities()) && CiudadOrigen.equals(Cities.BsAs.getCities())))
    {
        suma=(625* Nuevo.GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+(Nuevo.GetTarifaFija());
        CostoVuelo=suma;
    }
    else if ((CiudadDestino.equals(Cities.BsAs.getCities()) && CiudadOrigen.equals(Cities.SCL.getCities())) || (CiudadDestino.equals(Cities.SCL.getCities()) && CiudadOrigen.equals(Cities.BsAs.getCities())))
    {
        suma=(1400* Nuevo.GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+(Nuevo.GetTarifaFija());
        CostoVuelo=suma;
    }
    else if ((CiudadDestino.equals(Cities.BsAs.getCities()) && CiudadOrigen.equals(Cities.MVD.getCities())) || (CiudadDestino.equals(Cities.MVD.getCities()) && CiudadOrigen.equals(Cities.BsAs.getCities())))
    {
        suma=(950* Nuevo.GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+(Nuevo.GetTarifaFija());
        CostoVuelo=suma;
    }
    else if ((CiudadDestino.equals(Cities.CBA.getCities()) && CiudadOrigen.equals(Cities.MVD.getCities())) || (CiudadDestino.equals(Cities.MVD.getCities()) && CiudadOrigen.equals(Cities.CBA.getCities())))
    {
        suma=(1190* Nuevo.GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+(Nuevo.GetTarifaFija());
        CostoVuelo=suma;
    }
    else if((CiudadDestino.equals(Cities.CBA.getCities()) && CiudadOrigen.equals(Cities.SCL.getCities())) || (CiudadDestino.equals(Cities.SCL.getCities()) && CiudadOrigen.equals(Cities.CBA.getCities())))
    {
        suma=(1050* Nuevo.GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+(Nuevo.GetTarifaFija());
        CostoVuelo=suma;
    }
    else if((CiudadDestino.equals(Cities.MVD.getCities()) && CiudadOrigen.equals(Cities.SCL.getCities())) || (CiudadDestino.equals(Cities.SCL.getCities()) && CiudadOrigen.equals(Cities.MVD.getCities())))
    {
        suma=(1050* Nuevo.GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+(Nuevo.GetTarifaFija());
        CostoVuelo=suma;
    }

}
public String toString(){
    String Mensaje= "Reserva N°%d \n Fecha: %s \n Ciudad Origen: %s \n Ciudad Destino: %s \n Avion Seleccionado: %s\n Precio Viaje: %d";
    return String.format(Mensaje,GetNumeroReserva(),fecha.toString(),GetCiudadOrigen(),GetCiudadDestino(),Nuevo.toString(),GetPrecioFinal());
}


}
