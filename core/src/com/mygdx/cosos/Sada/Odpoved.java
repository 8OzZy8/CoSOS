package com.mygdx.cosos.Sada;

public class Odpoved extends Sada {
    private String text;
    private int hlasy;
    public Odpoved(String text, int hlasy) {
    this.text = text;
    this.hlasy = hlasy;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getHlasy() {
        return hlasy;
    }

    public void setHlasy(int hlasy) {
        this.hlasy = hlasy;
    }
}
