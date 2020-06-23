package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva
{
    private static int ID;
    private int NumeroDeReserva;
    private boolean activo=false;
    private Date fecha=new Date();
    private Vuelo vuelo;
    private Usuario user;
    private int Acompañantes;
    private int CostoVuelo;
    private final int TarifaGlobal=3500;



   public Reserva(Usuario user, Vuelo vuelo,int Acompañantes)
   {
       SetAcompañantes(Acompañantes);
       SetNumeroReserva();
       SetUser(user);
       SetVuelo(vuelo);
       CalcularPrecioViaje();
       AgregarPasagerosaVuelo(Acompañantes,vuelo);


   }
///--------------------------------------------Getters and Setters-------------------------------------------------------------------

    private void AgregarPasagerosaVuelo(int dato,Vuelo vuelo)
    {
        vuelo.AgregarReserva(dato);
    }
   private void SetAcompañantes(int acompañantes)
   {
       this.Acompañantes=acompañantes;
   }
   private void SetNumeroReserva()   {
       this.NumeroDeReserva=ID;
       ID=ID+1;
   }
   private void SetUser(Usuario user)
   {
       this.user=user;
   }
   private void SetVuelo(Vuelo vuelo)
   {
       this.vuelo=vuelo;
   }
    public int GetNumeroReserva()
   {
       return this.NumeroDeReserva;
   }
    public int GetAcompañantes()
   {
       return this.Acompañantes;
   }
    public Usuario GetUsuario()
    {
        return this.user;
    }
    public Vuelo GetVuelo()
   {
       return this.vuelo;
   }
   public int GetPrecioFinal()
   {
       return this.CostoVuelo;
   }


///-------------------------------------------------Metodos-----------------------------------------------------------------------
private void CalcularPrecioViaje() {
    int suma=0;

    if((vuelo.GetCiudadDestino().equals("BsAs") && vuelo.GetCiudadOrigen().equals("Cordoba")) || (vuelo.GetCiudadDestino().equals("Cordoba") && vuelo.GetCiudadOrigen().equals("BsAs")))
    {
        suma=(625* vuelo.GetAvion().GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+(vuelo.GetAvion().GetTarifaFija());
        CostoVuelo=suma;
    }
    else if ((vuelo.GetCiudadDestino().equals("BsAs") && vuelo.GetCiudadOrigen().equals("Santiago")) || (vuelo.GetCiudadDestino().equals("Santiago") && vuelo.GetCiudadOrigen().equals("BsAs")))
    {
        suma=(1400* vuelo.GetAvion().GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+(vuelo.GetAvion().GetTarifaFija());
        CostoVuelo=suma;
    }
    else if ((vuelo.GetCiudadDestino().equals("BsAs") && vuelo.GetCiudadOrigen().equals("Montevideo")) || (vuelo.GetCiudadDestino().equals("Montevideo") && vuelo.GetCiudadOrigen().equals("BsAs")))
    {
        suma=(950* vuelo.GetAvion().GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+(vuelo.GetAvion().GetTarifaFija());
        CostoVuelo=suma;
    }
    else if ((vuelo.GetCiudadDestino().equals("Cordoba") && vuelo.GetCiudadOrigen().equals("Montevideo")) || (vuelo.GetCiudadDestino().equals("Montevideo") && vuelo.GetCiudadOrigen().equals("Cordoba")))
    {
        suma=(1190* vuelo.GetAvion().GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+(vuelo.GetAvion().GetTarifaFija());
        CostoVuelo=suma;
    }
    else if((vuelo.GetCiudadDestino().equals("Cordoba") && vuelo.GetCiudadOrigen().equals("Santiago")) || (vuelo.GetCiudadDestino().equals("Santiago") && vuelo.GetCiudadOrigen().equals("Cordoba")))
    {
        suma=(1050* vuelo.GetAvion().GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+(vuelo.GetAvion().GetTarifaFija());
        CostoVuelo=suma;
    }
    else if((vuelo.GetCiudadDestino().equals("Montevideo") && vuelo.GetCiudadOrigen().equals("Santiago")) || (vuelo.GetCiudadDestino().equals("Santiago") && vuelo.GetCiudadOrigen().equals("Montevideo")))
    {
        suma=(1050* vuelo.GetAvion().GetCostoXKilometro())+(Acompañantes*TarifaGlobal)+vuelo.GetAvion().GetTarifaFija();
        CostoVuelo=suma;
    }

}
public String toString(){
    String Mensaje= "ID RESERVA: %d \nDatos Usuario: %s  \n Datos Vuelo: %s \n Acompañantes: %d\nPrecio viaje: %d\n";
    return String.format(Mensaje,GetNumeroReserva(),user.toString(),vuelo.toString(),GetAcompañantes(),GetPrecioFinal());
}


}
