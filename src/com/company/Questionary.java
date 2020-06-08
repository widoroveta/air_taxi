package com.company;

import java.security.acl.LastOwnerException;
import java.time.LocalDate;
import java.util.List;

public class Questionary {
    private LocalDate startDate;
    private LocalDate returnDate;
    private String here;
    private String destiny;
    private int numberOfCompanions;
    private List<Airplane> airplaneList; // modificar esto
public Questionary(){

}
    public Questionary(LocalDate startDate, LocalDate returnDate,String here,String destiny,int numberOfCompanions)
    {

    }
   public Questionary insertData(LocalDate startDate, LocalDate returnDate,String here,String destiny,int numberOfCompanions){
    Questionary q=new Questionary();
     if (here.equalsIgnoreCase(destiny))
     {
         return null;
     }
     else
     {

     }
    return q;
   }

    public void setHere(String here) {
        this.here = here;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setAirplaneList(List<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public void setNumberOfCompanions(int numberOfCompanions) {
        this.numberOfCompanions = numberOfCompanions;
    }
}
