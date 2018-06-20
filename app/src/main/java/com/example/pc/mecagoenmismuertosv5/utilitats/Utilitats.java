package com.example.pc.mecagoenmismuertosv5.utilitats;

/**
 * Created by Pc on 11/01/2018.
 */

public class Utilitats {

    //Constants taula usuari
    public static final String TAULA_USUARI = "usuari";
    public static final String ID_USUARI = "id_usuari";
    public static final String NOM_USUARI = "nom";
    public static final String COGNOM_USUARI = "cognom";
    public static final String TELEFON_USUARI ="telefon";

    public static final String CREAR_TAULA_USUARI = "CREATE TABLE " + TAULA_USUARI
            + " ("
            + ID_USUARI + " INTEGER PRIMARY KEY AUTOINCREMENT, " //INTEGER
            + NOM_USUARI + " TEXT,"
            + COGNOM_USUARI + " TEXT,"
            + TELEFON_USUARI + " TEXT"
            + ")";

    //Constants taula productes
    public static final String TAULA_PRODUCTE = "producte";
    public static final String ID_PRODUCTE = "id_producte";
    public static final String NOM_PRODUCTE = "nom_producte";
    public static final String QUANTITAT_PRODUCTE = "quantitat";
    public static final String ID_COMPRADOR = "id_comprador";

    public static final String CREAR_TAULA_PRODUCTE = "CREATE TABLE " + TAULA_PRODUCTE
            + " ("
            + ID_PRODUCTE +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOM_PRODUCTE +" TEXT, "
            + QUANTITAT_PRODUCTE +" INTEGER,"
            + ID_COMPRADOR +" INTEGER"
            + ")";
}
