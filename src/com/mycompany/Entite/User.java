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
public class User {
    
     private int id;
    private String Username;
    private String Password;
    private String CanonicalUsername;
    private String Email;
    private String CanonicalEmail;
    private int Enabled;
    private Date LastLogin;
    private String Role;
    private int Jeton;
    private String Addresse;
    private int NbEnfants;
    private String Nom;
    private String Prenom;
    private double Niveau;
       public static User instance;

    public User() {
    }
    
 public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;

    }

    public static void setInstance(User instance) {
        User.instance = instance;
    }
 
   

   

    public double getNiveau() {
        return Niveau;
    }

    public void setNiveau(double Niveau) {
        this.Niveau = Niveau;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getCanonicalUsername() {
        return CanonicalUsername;
    }

    public void setCanonicalUsername(String CanonicalUsername) {
        this.CanonicalUsername = CanonicalUsername;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCanonicalEmail() {
        return CanonicalEmail;
    }

    public void setCanonicalEmail(String CanonicalEmail) {
        this.CanonicalEmail = CanonicalEmail;
    }

    public int getEnabled() {
        return Enabled;
    }

    public void setEnabled(int Enabled) {
        this.Enabled = Enabled;
    }

    public Date getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(Date LastLogin) {
        this.LastLogin = LastLogin;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getJeton() {
        return Jeton;
    }

    public void setJeton(int Jeton) {
        this.Jeton = Jeton;
    }

    public String getAddresse() {
        return Addresse;
    }

    public void setAddresse(String Addresse) {
        this.Addresse = Addresse;
    }

    public int getNbEnfants() {
        return NbEnfants;
    }

    public void setNbEnfants(int NbEnfants) {
        this.NbEnfants = NbEnfants;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    
    public User(String Username, String CanonicalUsername, String Email, String CanonicalEmail, int Enabled, Date LastLogin, String Role, int Jeton, String Addresse, int NbEnfants, String Nom, String Prenom) {
        this.Username = Username;
        this.CanonicalUsername = CanonicalUsername;
        this.Email = Email;
        this.CanonicalEmail = CanonicalEmail;
        this.Enabled = Enabled;
        this.LastLogin = LastLogin;
        this.Role = Role;
        this.Jeton = Jeton;
        this.Addresse = Addresse;
        this.NbEnfants = NbEnfants;
        this.Nom = Nom;
        this.Prenom = Prenom;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", Username=" + Username + ", Password=" + Password + ", CanonicalUsername=" + CanonicalUsername + ", Email=" + Email + ", CanonicalEmail=" + CanonicalEmail + ", Enabled=" + Enabled + ", LastLogin=" + LastLogin + ", Role=" + Role + ", Jeton=" + Jeton + ", Addresse=" + Addresse + ", NbEnfants=" + NbEnfants + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Niveau=" + Niveau + '}';
    }
    
}
