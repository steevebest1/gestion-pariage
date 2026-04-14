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
public class PaiementsModel {
    private String id;
    private String id_pariage;
    private LocalDate date;

    public PaiementsModel() {
    }

    public PaiementsModel(String id, String id_pariage, LocalDate date) {
        this.id = id;
        this.id_pariage = id_pariage;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_pariage() {
        return id_pariage;
    }

    public void setId_pariage(String id_pariage) {
        this.id_pariage = id_pariage;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
}
