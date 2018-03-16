package com.kowalczyk.arek.mobilnymandat;

public class Fine {
    private String name;
    private int pesel;
    private String father;
    private String doc;
    private String add;
    private String base;
    private String crime;
    private int price;

    public Fine(String name, int pesel, String father, String doc, String add, String base, String crime, int price)    {
        this.name = name;
        this.pesel = pesel;
        this.father = father;
        this.doc = doc;
        this.add = add;
        this.base = base;
        this.crime = crime;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPesel() {
        return pesel;
    }

    public String getFather() {
        return father;
    }

    public String getDoc() {
        return doc;
    }

    public String getAdd() {
        return add;
    }

    public String getBase() {
        return base;
    }

    public String getCrime() {
        return crime;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "Mandat {" +
                "Imię i nazwisko: " + name +
                ", Pesel: " + pesel +
                ", Imię ojca: " + father +
                ", Dokument: " + doc +
                ", Adres: " + add +
                ", Podstawa: " + base +
                ", Wykroczenie: " + crime +
                ", Kwota: " + price +
                '}';
    }
}
