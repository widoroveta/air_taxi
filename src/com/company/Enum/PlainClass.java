package com.company.Enum;

public enum PlainClass {
    GL ("Gold"),
    BZ("Bronze"),
    SL("Silver");
    PlainClass(String g) {
    this.plain_class=g;
    }


    private String plain_class ;

    @Override
    public String toString() {
        return plain_class ;

    }
}
