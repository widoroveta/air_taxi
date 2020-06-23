package com.company;

import java.io.StringReader;

public class Usuario {

    String nombre;

    public Usuario(String nombre)
    {
        SetNombre(nombre);
    }
     private void SetNombre(String nombre)
     {
         this.nombre=nombre;
     }
     public String GetNombre()
     {
         return this.nombre;
     }

     public String toString()
     {
         String Mensaje="Nombre Usuario: %s";
         return String.format(Mensaje,GetNombre());
     }
}
