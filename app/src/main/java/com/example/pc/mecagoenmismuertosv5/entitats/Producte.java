package com.example.pc.mecagoenmismuertosv5.entitats;

import java.io.Serializable;

/**
 * Created by Pc on 11/01/2018.
 */

public class Producte implements Serializable {
    private int id_producte, quantitat, id_comprador;
    private String nom_producte;

    public Producte(int id_producte, int quantitat, int id_comprador, String nom_producte) {
        this.id_producte = id_producte;
        this.quantitat = quantitat;
        this.id_comprador = id_comprador;
        this.nom_producte = nom_producte;
    }

    public Producte(){

    }

    public int getId_producte() {
        return id_producte;
    }

    public void setId_producte(int id_producte) {
        this.id_producte = id_producte;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public int getId_comprador() {
        return id_comprador;
    }

    public void setId_comprador(int id_comprador) {
        this.id_comprador = id_comprador;
    }

    public String getNom_producte() {
        return nom_producte;
    }

    public void setNom_producte(String nom_producte) {
        this.nom_producte = nom_producte;
    }
}
