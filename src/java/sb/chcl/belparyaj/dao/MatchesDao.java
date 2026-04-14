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
import java.sql.Time;
import java.util.ArrayList;
import sb.chcl.belparyaj.dbutils.DBConnection;
import sb.chcl.belparyaj.model.MatchesModel;
import sb.chcl.belparyaj.services.IModels;

/**
 *
 * @author Steeve
 */
public class MatchesDao implements IModels<MatchesModel> {
PreparedStatement ps=null;
ResultSet rs=null;
Connection con=null;
    @Override
    public int enregistrer(MatchesModel obj) throws SQLException, ClassNotFoundException {
                //Création de la requête
        String sql = "INSERT INTO matches VALUES(?,?,?,?,?,?,?,?,?,?)";
        //Connection à la base de données
        con = DBConnection.connect();
        //Passage de le requete
        ps = con.prepareStatement(sql);
        //Passage des parametres
        ps.setString(1, obj.getId());
        ps.setString(2, obj.getType());
        ps.setString(3, obj.getPays());
        ps.setDate(4, Date.valueOf(obj.getDate()));
        ps.setTime(5, Time.valueOf(obj.getHeure()));
        ps.setString(6, obj.getEq_rec());
        ps.setString(7, obj.getEq_vis());
        ps.setDouble(8, obj.getCote());
        ps.setString(9, obj.getScore());
        ps.setString(10, obj.getEtat());
        System.out.println(ps);
        int n=ps.executeUpdate();
        System.out.println(n);
        //fermer les connections
        DBConnection.disconnect(rs, ps, con);
        // execution de la requete
        return n;
    }

    @Override
    public int modifier(MatchesModel obj) throws SQLException, ClassNotFoundException {
         //Création de la requête
        String sql = "UPDATE matches SET type_de_match=?, pays=?, date=?, heure=?, eq_rec=?, eq_vis=?, cote=?, score_final=?, etat=? WHERE id=?";
        //Connection à la base de données
        con = DBConnection.connect();
        //Passage de le requete
        ps = con.prepareStatement(sql);
        //Passage des parametres
        
        ps.setString(1, obj.getType());
        ps.setString(2, obj.getPays());
        ps.setDate(3, Date.valueOf(obj.getDate()));
        ps.setTime(4, Time.valueOf(obj.getHeure()));
        ps.setString(5, obj.getEq_rec());
        ps.setString(6, obj.getEq_vis());
        ps.setDouble(7, obj.getCote());
        ps.setString(8, obj.getScore());
        ps.setString(9, obj.getScore());
        ps.setString(10, obj.getId());
        //Execution du ps
        int n=ps.executeUpdate();
      // fermer les connections
        DBConnection.disconnect(rs, ps, con);
        // execution de la requete
        return n;
    }
    public int modifierScore(MatchesModel obj) throws SQLException, ClassNotFoundException {
         //Création de la requête
        String sql = "UPDATE matches SET score_final=?, etat=? WHERE id=?";
        //Connection à la base de données
        con = DBConnection.connect();
        //Passage de le requete
        ps = con.prepareStatement(sql);
        //Passage des parametres
        
        ps.setString(1, obj.getScore());
        ps.setString(2, obj.getEtat());
        ps.setString(3, obj.getId());
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
        String sql = "DELETE FROM matches WHERE id=?";
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
    public ArrayList<MatchesModel> afficher() throws SQLException, ClassNotFoundException {
    ArrayList<MatchesModel> liste_matches=new ArrayList<>();
    // chaine de requete
      String sql=" SELECT * FROM matches ";
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
       MatchesModel model;
      while(rs.next()){
           model = new MatchesModel();
           model.setId(rs.getString(1));
           model.setType(rs.getString(2));
           model.setPays(rs.getString(3));
           model.setDate(rs.getDate(4).toLocalDate());
           model.setHeure(rs.getTime(5).toLocalTime());
           model.setEq_rec(rs.getString(6));
           model.setEq_vis(rs.getString(7));
           model.setCote(rs.getDouble(8));
           model.setScore(rs.getString(9));
           model.setEtat(rs.getString(10));
           liste_matches.add(model);
      }
      DBConnection.disconnect(rs, ps, con);
      return liste_matches;    
    }
    
    public ArrayList<MatchesModel> afficherM(String id) throws SQLException, ClassNotFoundException {
    ArrayList<MatchesModel> liste_matches=new ArrayList<>();
    // chaine de requete
      String sql=" SELECT * FROM matches where id=?";
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      //Passage des parametres        
        ps.setString(1, id);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
       MatchesModel model;
      while(rs.next()){
           model = new MatchesModel();
           model.setId(rs.getString(1));
           model.setType(rs.getString(2));
           model.setPays(rs.getString(3));
           model.setDate(rs.getDate(4).toLocalDate());
           model.setHeure(rs.getTime(5).toLocalTime());
           model.setEq_rec(rs.getString(6));
           model.setEq_vis(rs.getString(7));
           model.setCote(rs.getDouble(8));
           model.setScore(rs.getString(9));
           model.setEtat(rs.getString(10));
           liste_matches.add(model);
      }
      DBConnection.disconnect(rs, ps, con);
      return liste_matches;    
    }

    @Override
    public MatchesModel rechercher(String id) throws SQLException, ClassNotFoundException {
        MatchesModel model = null;
    // chaine de requete
      String sql=" SELECT * FROM matches where id=?";
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      //Passage des parametres        
        ps.setString(1, id);
        System.out.println(ps);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
      while(rs.next()){
           model = new MatchesModel();
           model.setId(rs.getString(1));
           model.setType(rs.getString(2));
           model.setPays(rs.getString(3));
           model.setDate(rs.getDate(4).toLocalDate());
           model.setHeure(rs.getTime(5).toLocalTime());
           model.setEq_rec(rs.getString(6));
           model.setEq_vis(rs.getString(7));
           model.setCote(rs.getDouble(8));
           model.setScore(rs.getString(9));
           model.setEtat(rs.getString(10));
      }
      DBConnection.disconnect(rs, ps, con);
      return model;
    }
    
    }
