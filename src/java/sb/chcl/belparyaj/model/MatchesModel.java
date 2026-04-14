/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sb.chcl.belparyaj.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Steeve
 */
public class MatchesModel {
    private String id;
    private String type;
    private String pays;
    private LocalDate date;
    private LocalTime heure;
    private String eq_rec;
    private String eq_vis;
    private double cote;
    private String score;
    private String etat;

    public MatchesModel() {
    }

    public MatchesModel(String id, String type, String pays, LocalDate date, LocalTime heure, String eq_rec, String eq_vis, double cote, String score, String etat) {
        this.id = id;
        this.type = type;
        this.pays = pays;
        this.date = date;
        this.heure = heure;
        this.eq_rec = eq_rec;
        this.eq_vis = eq_vis;
        this.cote = cote;
        this.score = score;
        this.etat = etat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public String getEq_rec() {
        return eq_rec;
    }

    public void setEq_rec(String eq_rec) {
        this.eq_rec = eq_rec;
    }

    public String getEq_vis() {
        return eq_vis;
    }

    public void setEq_vis(String eq_vis) {
        this.eq_vis = eq_vis;
    }

    public double getCote() {
        return cote;
    }

    public void setCote(double cote) {
        this.cote = cote;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    

}
