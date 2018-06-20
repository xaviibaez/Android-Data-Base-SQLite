package com.example.pc.mecagoenmismuertosv5.entitats;

import java.io.Serializable;

/**
 * Created by Pc on 11/01/2018.
 */

public class Usuari implements Serializable {
    private int id_usuari;
    private String nom, cognom, telefon;


    public Usuari(int id_usuari, String nom, String telefon) {
        this.id_usuari = id_usuari;
        this.nom = nom;
        this.telefon = telefon;
    }

    public Usuari(){
    }

    public int getId_usuari() {
        return id_usuari;
    }

    public void setId_usuari(int id_usuari) {
        this.id_usuari = id_usuari;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
