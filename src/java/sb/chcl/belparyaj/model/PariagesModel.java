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
public class PariagesModel {
    private String id;
    private String id_compte;
    private String id_match;
    private LocalDate date;
    private String score_prevu;
    private double montant;

    public PariagesModel() {
    }

    public PariagesModel(String id, String id_compte, String id_match, LocalDate date, String score_prevu, double montant) {
        this.id = id;
        this.id_compte = id_compte;
        this.id_match = id_match;
        this.date = date;
        this.score_prevu = score_prevu;
        this.montant = montant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_compte() {
        return id_compte;
    }

    public void setId_compte(String id_compte) {
        this.id_compte = id_compte;
    }

    public String getId_match() {
        return id_match;
    }

    public void setId_match(String id_match) {
        this.id_match = id_match;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getScore_prevu() {
        return score_prevu;
    }

    public void setScore_prevu(String score_prevu) {
        this.score_prevu = score_prevu;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "PariagesModel{" + "id=" + id + ", id_compte=" + id_compte + ", id_match=" + id_match + ", date=" + date + ", score_prevu=" + score_prevu + ", montant=" + montant + '}';
    }
    
    
    
}
