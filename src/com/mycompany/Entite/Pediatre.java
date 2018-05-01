/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author Karim
 */
public class Pediatre {
     private int id;
    private String nom;
    private String prenom;
    private String email;
    private String specialite;
    private int rating;
    private String adresse;
    private double prix;
    private int demande;
    private String description;
    private String image;
    private String formation;
    private String parcours;
    private int vues;
    private int likes;
    private int quiz;
    private int nbrQuiz;
    private int num;
    private int nbJetons;

    public Pediatre(String nom, String prenom, String email, String specialite, int rating, String adresse, double prix, int demande, String description, String image, String formation, String parcours, int vues, int likes, int quiz, int nbrQuiz, int num, int nbJetons) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialite = specialite;
        this.rating = rating;
        this.adresse = adresse;
        this.prix = prix;
        this.demande = demande;
        this.description = description;
        this.image = image;
        this.formation = formation;
        this.parcours = parcours;
        this.vues = vues;
        this.likes = likes;
        this.quiz = quiz;
        this.nbrQuiz = nbrQuiz;
        this.num = num;
        this.nbJetons = nbJetons;
    }

    public Pediatre() {
    }

    public Pediatre(int id, String nom, String prenom, String email, String specialite, int rating, String adresse, double prix, int demande, String description, String image, String formation, String parcours, int vues, int likes, int quiz, int nbrQuiz, int num, int nbJetons) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialite = specialite;
        this.rating = rating;
        this.adresse = adresse;
        this.prix = prix;
        this.demande = demande;
        this.description = description;
        this.image = image;
        this.formation = formation;
        this.parcours = parcours;
        this.vues = vues;
        this.likes = likes;
        this.quiz = quiz;
        this.nbrQuiz = nbrQuiz;
        this.num = num;
        this.nbJetons = nbJetons;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getDemande() {
        return demande;
    }

    public void setDemande(int demande) {
        this.demande = demande;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getParcours() {
        return parcours;
    }

    public void setParcours(String parcours) {
        this.parcours = parcours;
    }

    public int getVues() {
        return vues;
    }

    public void setVues(int vues) {
        this.vues = vues;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getNbrQuiz() {
        return nbrQuiz;
    }

    public void setNbrQuiz(int nbrQuiz) {
        this.nbrQuiz = nbrQuiz;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNbJetons() {
        return nbJetons;
    }

    public void setNbJetons(int nbJetons) {
        this.nbJetons = nbJetons;
    }

    @Override
    public String toString() {
        return "Pediatre{"+"nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", specialite=" + specialite + ", rating=" + rating + ", adresse=" + adresse + ", prix=" + prix + ", demande=" + demande + ", description=" + description + ", image=" + image + ", formation=" + formation + ", parcours=" + parcours + ", vues=" + vues + ", likes=" + likes + ", quiz=" + quiz + ", nbrQuiz=" + nbrQuiz + ", num=" + num + ", nbJetons=" + nbJetons + '}';
    }

  

    
}
