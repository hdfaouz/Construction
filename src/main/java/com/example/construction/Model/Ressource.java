package com.example.construction.Model;

public class Ressource {
    int id;
    String nom;
    String Type;
    int quantite;

    public Ressource(int id, String nom, String type, int quantite) {
        this.id = id;
        this.nom = nom;
        Type = type;
        this.quantite = quantite;
    }

    public Ressource(String nom, String type, int quantite) {
        this.nom = nom;
        Type = type;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
