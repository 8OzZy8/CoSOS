package com.mygdx.cosos.Tym;

public class Tym {
    private String nazev;
    private int body;
    public Tym(String nazev, int body){
        this.nazev = nazev;
        this.body = body;
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
