package com.company.Enum;

public enum Cities {
    BsAs("Buenos Aires"),
    CBA("Cordoba"),
    SCL("Santiago De Chile"),
    MVD("Montevideo");


    private String cities;

    Cities(String cities) {
        this.cities = cities;
    }

    public String getCities() {
        return cities;
    }


    @Override
    public String toString() {
        return cities +"(" +super.toString()+")";
    }
}
