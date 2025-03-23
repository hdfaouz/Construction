package com.example.construction.Model;


import java.sql.Date;

public class Tache {
     private int projet_id;
     private int id;
     private String nomdutache;
     private Date dateDebut;
     private Date dateFin;
     private String description;



    public Tache(int id, String nomdutache, Date dateDebut, Date dateFin,String description) {
        this.id = id;
        this.nomdutache= nomdutache;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;

    }

    public Tache(int projet_id, int id, String nomdutache, Date dateDebut, Date dateFin, String description) {
        this.projet_id = projet_id;
        this.id = id;
        this.nomdutache = nomdutache;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;

    }

    public Tache(String nomdutache, Date dateDebut, Date dateFin, String description) {
        this.nomdutache = nomdutache;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
    }



    public Tache(int id) {
    }

    public Tache() {

    }

    public Tache(int id, int datededebut, int datedefin) {
    }

    public Tache(int id, String nomdutache, Date datededebut, Date datefin, String description, String ressourcenecessaire, int idProjet) {
    }

    public Tache(int id, int datededebut, int datedefin, String description, String ressourcenecessaire, int anInt) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomdutache() {
        return nomdutache;
    }

    public void setNomdutache(String nomdutache) {
        this.nomdutache = nomdutache;
    }

    public int getProjet_id() {
        return projet_id;
    }

    public void setProjet_id(int projet_id) {
        this.projet_id = projet_id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
