package com.mygdx.cosos.Tym;

public class Tym {
    private String nazev;
    private int body;
    private boolean napoveda1;
    private boolean napoveda2;
    private boolean napoveda3;
    public Tym(String nazev, int body, boolean napoveda1,boolean napoveda2,boolean napoveda3){
        this.nazev = nazev;
        this.body = body;
        this.napoveda1 = napoveda1;
        this.napoveda2 = napoveda2;
        this.napoveda3 = napoveda3;
    }

    public boolean isNapoveda1() {
        return napoveda1;
    }

    public void setNapoveda1(boolean napoveda1) {
        this.napoveda1 = napoveda1;
    }

    public boolean isNapoveda2() {
        return napoveda2;
    }

    public void setNapoveda2(boolean napoveda2) {
        this.napoveda2 = napoveda2;
    }

    public boolean isNapoveda3() {
        return napoveda3;
    }

    public void setNapoveda3(boolean napoveda3) {
        this.napoveda3 = napoveda3;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }
}
