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
import java.time.LocalDate;
import java.util.ArrayList;
import sb.chcl.belparyaj.dbutils.DBConnection;
import sb.chcl.belparyaj.model.ComptesModel;
import sb.chcl.belparyaj.model.PariagesModel;
import sb.chcl.belparyaj.services.IModels;

/**
 *
 * @author Steeve
 */
public class PariagesDao implements IModels<PariagesModel>{
PreparedStatement ps = null;
ResultSet rs = null;
Connection con = null;

    @Override
    public int enregistrer(PariagesModel obj) throws SQLException, ClassNotFoundException {
      String sql = "INSERT INTO pariages VALUES(?, ?, ?, ?, ?, ?)";
       //Connection à la base de données
        con = DBConnection.connect();
       //Passage de la requete
       ps = con.prepareStatement(sql);
       //passage des parametres
       ps.setInt(1,0);
       ps.setString(2, obj.getId_compte());
       ps.setString(3, obj.getId_match());
       ps.setDate(4, Date.valueOf(obj.getDate()));
       ps.setString(5, obj.getScore_prevu());
       ps.setDouble(6, obj.getMontant());
       System.out.println(ps);
       //Execution de la requete
       int n =  ps.executeUpdate();
       //Fermer les connetions
       DBConnection.disconnect(rs, ps, con);
       return n;  
    }

    @Override
    public int modifier(PariagesModel obj) throws SQLException, ClassNotFoundException {
        //Création de la requête
        String sql = "UPDATE pariages set id_compte=?, id_match=?, date=?, score=?, montant=? WHERE id=?";
        //Connection à la base de données
        con = DBConnection.connect();
        //Passage de le requete
        ps = con.prepareStatement(sql);
        //Passage des parametres
        ps.setString(1, obj.getId_compte());
        ps.setString(2, obj.getId_match());
        ps.setDate(3, Date.valueOf(obj.getDate()));
        ps.setString(4, obj.getScore_prevu());
        ps.setDouble(5, obj.getMontant());
        ps.setString(6,obj.getId());
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
        String sql = "DELETE FROM pariages WHERE code=?";
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
    public PariagesModel rechercher(String id) throws SQLException, ClassNotFoundException {
        PariagesModel model = null;
    // chaine de requete
      String sql=" SELECT * FROM pariages where id=?";
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
           model = new PariagesModel();
           model.setId(rs.getString(1));
           model.setId_compte(rs.getString(2));
           model.setId_match(rs.getString(3));
           model.setDate(rs.getDate(4).toLocalDate());
           model.setScore_prevu(rs.getString(5));
           model.setMontant(Double.parseDouble(rs.getString(6)));
      }
      DBConnection.disconnect(rs, ps, con);
      return model;
    }

    @Override
    public ArrayList<PariagesModel> afficher() throws SQLException, ClassNotFoundException {
        ArrayList<PariagesModel> liste_pariages=new ArrayList<>();
    // chaine de requete
      String sql=" SELECT * FROM pariages ";
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
       PariagesModel model=null;
      while(rs.next()){
           model = new PariagesModel();
           model.setId(rs.getString(1));
           model.setId_compte(rs.getString(2));
           model.setId_match(rs.getString(3));
           model.setDate(rs.getDate(4).toLocalDate());
           model.setScore_prevu(rs.getString(5));
           liste_pariages.add(model);          
      }
      DBConnection.disconnect(rs, ps, con);
      return liste_pariages;
    }
    public ArrayList<PariagesModel> afficherP(String id_match) throws SQLException, ClassNotFoundException {
        ArrayList<PariagesModel> liste_pariages=new ArrayList<>();
    // chaine de requete
      String sql=" SELECT * FROM pariages where id_match=?";
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      //Passage des parametres        
        ps.setString(1, id_match);
        System.out.println(ps);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
       PariagesModel model=null;
      while(rs.next()){
           model = new PariagesModel();
           model.setId(rs.getString(1));
           model.setId_compte(rs.getString(2));
           model.setId_match(rs.getString(3));
           model.setDate(rs.getDate(4).toLocalDate());
           model.setScore_prevu(rs.getString(5));
           model.setMontant(rs.getDouble(6));
           liste_pariages.add(model);          
      }
      DBConnection.disconnect(rs, ps, con);
      return liste_pariages;
    }
            public ArrayList<PariagesModel> afficherPuser(String id_match) throws SQLException, ClassNotFoundException {
        ArrayList<PariagesModel> liste_pariages=new ArrayList<>();
    // chaine de requete
      String sql=" SELECT * FROM pariages where id_compte=?";
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      //Passage des parametres        
        ps.setString(1, id_match);
        System.out.println(ps);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
       PariagesModel model=null;
      while(rs.next()){
           model = new PariagesModel();
           model.setId(rs.getString(1));
           model.setId_compte(rs.getString(2));
           model.setId_match(rs.getString(3));
           model.setDate(rs.getDate(4).toLocalDate());
           model.setScore_prevu(rs.getString(5));
           model.setMontant(Double.parseDouble(rs.getString(6)));
           liste_pariages.add(model);          
      }
      DBConnection.disconnect(rs, ps, con);
      return liste_pariages;
    }
    
        public ArrayList<PariagesModel> todayP(ComptesModel co) throws SQLException, ClassNotFoundException {
        ArrayList<PariagesModel> liste_pariages=new ArrayList<>();
    // chaine de requete
      String sql=" SELECT * FROM pariages where date=? and id_compte=?" ;
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      
      //Passage des parametres        
        ps.setDate(1, Date.valueOf(LocalDate.now()));
        ps.setString(2,co.getCode());
        System.out.println(ps);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
       PariagesModel model=null;
      while(rs.next()){
           model = new PariagesModel();
           model.setId(rs.getString(1));
           model.setId_compte(rs.getString(2));
           model.setId_match(rs.getString(3));
           model.setDate(rs.getDate(4).toLocalDate());
           model.setScore_prevu(rs.getString(5));
           model.setMontant(Double.parseDouble(rs.getString(6)));
           liste_pariages.add(model);          
      }
      DBConnection.disconnect(rs, ps, con);
      return liste_pariages;
    }
        
       
    
    public ArrayList<String> Validate(ComptesModel compte, PariagesModel pariage) throws SQLException, ClassNotFoundException {
        ArrayList<String> messages=new ArrayList<>();
        ArrayList<PariagesModel> pod =todayP(compte); 
        Double s=0.0;
        System.out.println(compte.toString());
        System.out.println(pariage.getMontant());
        if(pariage.getMontant()>compte.getSolde()){
            messages.add("Solde inssufisant! ( "+compte.getSolde()+" Gourdes. )");
        }
        if(pod!=null && !pod.isEmpty()){
            for(PariagesModel p : pod){
                s=s+ p.getMontant();
                System.out.println("Montant pariage:"+p.getMontant());
            }
        }
            if((s+pariage.getMontant())>75000){
                messages.add("Vous ne pourrez pas depasser 75000 gourdes pour la journee. Restant: "+(75000-s)+" Gdes.");
            }
             for(PariagesModel par:pod){
          System.out.println(par.toString());
      }
      for(String w:messages){
          System.out.println(w);
      }
      return messages;
    }
    
}
