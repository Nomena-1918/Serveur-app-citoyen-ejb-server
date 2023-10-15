package model;
import java.io.Serializable;
import java.sql.Date;


public class Citoyen implements Serializable {
    private int citoyen_id;
    private String cin;
    private String nom;
    private String prenom;
    private Genre genre;
    private Date dateNaissance;

    public int getCitoyen_id() {
        return citoyen_id;
    }

    public void setCitoyen_id(int citoyen_id) {
        this.citoyen_id = citoyen_id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
