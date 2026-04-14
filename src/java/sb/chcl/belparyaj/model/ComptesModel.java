/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sb.chcl.belparyaj.model;
import java.time.LocalDate;

/**
 *
 * @author Steeve
 */
public class ComptesModel {
    private String code;
    private String nom;
    private String prenom;
    private String sexe;
    private String Adresse;
    private String lieu_naissance;
    private LocalDate date_naissance;
    private String phone;
    private String nif_cin;
    private String username;
    private String password;
    private double solde;
    private String etat;
    private String type_compte;

    public ComptesModel() {
    }

    public ComptesModel(String code, String nom, String prenom, String sexe, String Adresse, String lieu_naissance, LocalDate date_naissance, String phone, String nif_cin, String username, String password, double solde, String etat, String type_compte) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.Adresse = Adresse;
        this.lieu_naissance = lieu_naissance;
        this.date_naissance = date_naissance;
        this.phone = phone;
        this.nif_cin = nif_cin;
        this.username = username;
        this.password = password;
        this.solde = solde;
        this.etat = etat;
        this.type_compte = type_compte;
    }

    public ComptesModel(String code, String nom, String prenom, String sexe, String Adresse, String lieu_naissance, LocalDate date_naissance, String phone, String nif_cin, String username, String password) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.Adresse = Adresse;
        this.lieu_naissance = lieu_naissance;
        this.date_naissance = date_naissance;
        this.phone = phone;
        this.nif_cin = nif_cin;
        this.username = username;
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getLieu_naissance() {
        return lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNif_cin() {
        return nif_cin;
    }

    public void setNif_cin(String nif_cin) {
        this.nif_cin = nif_cin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getType_compte() {
        return type_compte;
    }

    public void setType_compte(String type_compte) {
        this.type_compte = type_compte;
    }

    @Override
    public String toString() {
        return "ComptesModel{" + "Code: " + code + "\n"+ "Nom:" + nom + "\n" + "Prenom: " + prenom + "\n" + "Sexe: " + sexe + "\n" +"Adresse: " + Adresse + "\n" +"Lieu_naissance: " + lieu_naissance + "\n" +"Date_naissance: " + date_naissance + "\n" +"Phone: " + phone + "\n" +"Nif_cin: " + nif_cin + "\n" +"Username: " + username + "\n" +"Password: " + password + "\n" +"Solde: " + solde + "Etat: " + etat + "\n" +"Type_compte: " + type_compte + "\n" + '}';
    }

    
    
}
