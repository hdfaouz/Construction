package com.example.construction.Model;

import java.sql.Date;

public class Projets {
    private int id;
    private String nomduprojet;
    private Date datededebut;
    private Date datedefin;
    private String description;
    private Double budget;

    // Constructeur avec tous les attributs
    public Projets(int id, String nomduprojet, Date datededebut, Date datedefin, String description, Double budget) {
        this.id = id;
        this.nomduprojet = nomduprojet;
        this.datededebut = datededebut;
        this.datedefin = datedefin;
        this.description = description;
        this.budget = budget;
    }

    // Constructeur sans ID (par exemple pour la création)
    public Projets(String nomduprojet, Date datededebut, Date datedefin, String description, Double budget) {
        this.nomduprojet = nomduprojet;
        this.datededebut = datededebut;
        this.datedefin = datedefin;
        this.description = description;
        this.budget = budget;
    }
    public Projets(String nomduprojet) {
        this.nomduprojet = nomduprojet;
    }


    // Constructeur par défaut
    public Projets() {
    }

    // Getter et Setter pour ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter et Setter pour Nom du Projet
    public String getNomduprojet() {
        return nomduprojet;
    }

    public void setNomduprojet(String nomduprojet) {
        this.nomduprojet = nomduprojet;
    }

    // Getter et Setter pour Date de Début
    public Date getDatededebut() {
        return datededebut;
    }

    public void setDatededebut(Date datededebut) {
        this.datededebut = datededebut;
    }

    // Getter et Setter pour Date de Fin
    public Date getDatedefin() {
        return datedefin;
    }

    public void setDatedefin(Date datedefin) {
        this.datedefin = datedefin;
    }

    // Getter et Setter pour la Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter et Setter pour le Budget
    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
}
