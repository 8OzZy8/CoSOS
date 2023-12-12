package com.mygdx.cosos.Sada;

import java.util.ArrayList;
import java.util.List;

public class Otazka extends Sada {
    private String text;
    private List<Odpoved> odpovedi;
    public Otazka(String text, List<Odpoved> odpovedi) {
    this.text = text;
    this.odpovedi = odpovedi;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Odpoved> getOdpovedi() {
        return odpovedi;
    }

    public void setOdpovedi(List<Odpoved> odpovedi) {
        this.odpovedi = odpovedi;
    }
}
