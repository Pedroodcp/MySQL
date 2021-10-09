package br.com.pedrodcp.mysql.entity;

import java.util.ArrayList;

public class OBJ {

    public static ArrayList<OBJ> players = new ArrayList<>();

    private String playerName;
    private int number;
    private String texto;

    public OBJ(String playerName, int number, String texto) {
        this.playerName = playerName;
        this.number = number;
        this.texto = texto;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
