/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;


import java.util.Date;

/**
 *
 * @author Karim
 */
public class RendezVous {
    
    private int id;
    private int idUser;
    private int idPediatre;
    private String dateRendezVous;
    private String nom;
    private String prenom;
    private String heure;

    public RendezVous() {
    }

    public RendezVous(int id, int idUser, int idPediatre, String dateRendezVous, String nom, String prenom, String heure) {
        this.id = id;
        this.idUser = idUser;
        this.idPediatre = idPediatre;
        this.dateRendezVous = dateRendezVous;
        this.nom = nom;
        this.prenom = prenom;
        this.heure = heure;
    }

    public RendezVous(int idUser, int idPediatre, String dateRendezVous, String nom, String prenom, String heure) {
        this.idUser = idUser;
        this.idPediatre = idPediatre;
        this.dateRendezVous = dateRendezVous;
        this.nom = nom;
        this.prenom = prenom;
        this.heure = heure;
    }

   

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPediatre() {
        return idPediatre;
    }

    public void setIdPediatre(int idPediatre) {
        this.idPediatre = idPediatre;
    }

    public String getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(String dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

  

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "RendezVous{" + "id=" + id + ", idUser=" + idUser + ", idPediatre=" + idPediatre + ", dateRendezVous=" + dateRendezVous + ", nom=" + nom + ", prenom=" + prenom + ", heure=" + heure + '}';
    }

    
    
    
}
