/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sb.chcl.belparyaj.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sb.chcl.belparyaj.dbutils.DBConnection;
import sb.chcl.belparyaj.model.PaiementsModel;
import sb.chcl.belparyaj.services.IModels;

/**
 *
 * @author Steeve
 */
public class PaiementsDao implements IModels<PaiementsModel> {
PreparedStatement ps = null;
ResultSet rs = null;
Connection con = null;
    @Override
    public int enregistrer(PaiementsModel obj) throws SQLException, ClassNotFoundException {
       String sql = "INSERT INTO paiements VALUES(?, ?, ?)";
      // connection
      con=DBConnection.connect();
       //Passage de la requete
       ps = con.prepareStatement(sql);
       //passage des parametres
       ps.setInt(1,0);
       ps.setString(2, obj.getId_pariage());
       ps.setDate(3, Date.valueOf(obj.getDate()));
       System.out.print(ps);
       //Execution de la requete
       int n =  ps.executeUpdate();
       //Fermer les connetions
       DBConnection.disconnect(rs, ps, con);
       return n;
    }

    @Override
    public int modifier(PaiementsModel obj) throws SQLException, ClassNotFoundException {
        //Création de la requête
        String sql = "UPDATE comptes set id_pariage=?, date=? WHERE id=?";
        //Connection à la base de données
        con = DBConnection.connect();
        //Passage de le requete
        ps = con.prepareStatement(sql);
        //Passage des parametres 
        ps.setString(1, obj.getId_pariage());
        ps.setDate(2, Date.valueOf(obj.getDate()));
        ps.setString(3,obj.getId());
        //Execution du ps
        int n=ps.executeUpdate();
      // fermer les connections
        DBConnection.disconnect(rs, ps, con);
        // execution de la requete
        return n;
    }   

    @Override
    public int supprimer(String id) throws SQLException, ClassNotFoundException {
        //Création de la requête
        String sql = "DELETE FROM paiements WHERE code=?";
        //Connection à la base de données
        con = DBConnection.connect();
        //Passage de le requete
        ps = con.prepareStatement(sql);
        //Passage des parametres        
        ps.setString(1, id);
        //Execution du ps
        int n=ps.executeUpdate();
      // fermer les connections
        DBConnection.disconnect(rs, ps, con);
        // execution de la requete
        return n;
    }

    @Override
    public PaiementsModel rechercher(String id) throws SQLException, ClassNotFoundException {
        PaiementsModel model = null;
    // chaine de requete
      String sql=" SELECT * FROM paiements where id_pariage=?";
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      //Passage des parametres        
        ps.setInt(1, Integer.parseInt(id));
        System.out.println(ps);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
      while(rs.next()){
           model = new PaiementsModel();
           model.setId(rs.getString(1));
           model.setId_pariage(rs.getString(2));
           model.setDate(rs.getDate(3).toLocalDate());
          
      }
      DBConnection.disconnect(rs, ps, con);
      return model;
    }

    @Override
    public ArrayList<PaiementsModel> afficher() throws SQLException, ClassNotFoundException {
        ArrayList<PaiementsModel> liste_paiements=new ArrayList<>();
    // chaine de requete
      String sql=" SELECT * FROM paiements ";
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
       PaiementsModel model=null;
      while(rs.next()){
           model = new PaiementsModel();
           model.setId(rs.getString(1));
           model.setId_pariage(rs.getString(2));
           model.setDate(rs.getDate(3).toLocalDate());
           liste_paiements.add(model);
          
      }
      DBConnection.disconnect(rs, ps, con);
      return liste_paiements;
    }
    
    
    public ArrayList<PaiementsModel> afficherP(String id) throws SQLException, ClassNotFoundException {
        ArrayList<PaiementsModel> liste_paiements=new ArrayList<>();
    // chaine de requete
      String sql=" SELECT * FROM paiements where id_pariage=?";
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      //Passage des parametres        
        ps.setString(1, id);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
       PaiementsModel model=null;
      while(rs.next()){
           model = new PaiementsModel();
           model.setId(rs.getString(1));
           model.setId_pariage(rs.getString(2));
           model.setDate(rs.getDate(3).toLocalDate());
           liste_paiements.add(model);
          
      }
      DBConnection.disconnect(rs, ps, con);
      return liste_paiements;
    }
}
