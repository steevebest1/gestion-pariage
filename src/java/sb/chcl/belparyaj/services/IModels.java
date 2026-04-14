/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sb.chcl.belparyaj.services;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Steeve
 */
public interface IModels<T> {
    int enregistrer(T obj) throws SQLException, ClassNotFoundException;

    int modifier(T obj) throws SQLException, ClassNotFoundException;

    int supprimer(String id) throws SQLException, ClassNotFoundException;

    T rechercher(String id) throws SQLException, ClassNotFoundException;

    ArrayList<T> afficher() throws SQLException, ClassNotFoundException;
}
