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
import sb.chcl.belparyaj.model.ComptesModel;
import sb.chcl.belparyaj.services.IModels;

/**
 *
 * @author Steeve
 */
public class ComptesDao implements IModels<ComptesModel>{
PreparedStatement ps=null;
ResultSet rs=null;
Connection con=null;
    @Override
    public int enregistrer(ComptesModel obj) throws SQLException, ClassNotFoundException {
        //Création de la requête
        String sql = "INSERT INTO comptes VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //Connection à la base de données
        System.out.print("Avant:"+con);
        con = DBConnection.connect();
        //Passage de le requete
        System.out.print(con);
        ps = con.prepareStatement(sql);
        //Passage des parametres
        ps.setString(1, obj.getCode());
        ps.setString(2, obj.getNom());
        ps.setString(3, obj.getPrenom());
        ps.setString(4, obj.getSexe());
        ps.setString(5, obj.getAdresse());
        ps.setString(6, obj.getLieu_naissance());
        ps.setDate(7, Date.valueOf(obj.getDate_naissance()));
        ps.setString(8, obj.getPhone());
        ps.setString(9, obj.getNif_cin());
        ps.setString(10, obj.getUsername());
        ps.setString(11, obj.getPassword());
        ps.setDouble(12, obj.getSolde());
        ps.setString(13, obj.getEtat());
        ps.setString(14, obj.getType_compte());
        
        System.out.println(ps);
        //Execution du ps
        int n=ps.executeUpdate();
        System.out.println(n);
      // fermer les connections
        DBConnection.disconnect(rs, ps, con);
        // execution de la requete
        return n;
    }

    public ComptesDao() {
    }

    @Override
    public int modifier(ComptesModel obj) throws SQLException, ClassNotFoundException {
        //Création de la requête
        String sql = "UPDATE comptes SET nom=?, prenom=?, sexe=?, adresse=?, lieu_naissance=?, date_naissance=?, telephone=?, nif_cin=?, username=?, password=?,solde=?, etat=?, type=? WHERE code=?";
        //Connection à la base de données
        con = DBConnection.connect();
        //Passage de le requete
        ps = con.prepareStatement(sql);
        //Passage des parametres        
        ps.setString(1, obj.getNom());
        ps.setString(2, obj.getPrenom());
        ps.setString(3, obj.getSexe());
        ps.setString(4, obj.getAdresse());
        ps.setString(5, obj.getLieu_naissance());
        ps.setDate(6, Date.valueOf(obj.getDate_naissance()));
        ps.setString(7, obj.getPhone());
        ps.setString(8, obj.getNif_cin());
        ps.setString(9, obj.getUsername());
        ps.setString(10, obj.getPassword());
        ps.setDouble(11, obj.getSolde());
        ps.setString(12, obj.getEtat());
        ps.setString(13, obj.getType_compte());
        ps.setString(14, obj.getCode());
        //Execution du ps
        System.out.println(ps);
        int n=ps.executeUpdate();
      // fermer les connections
        DBConnection.disconnect(rs, ps, con);
        // execution de la requete
        return n;
    }

    @Override
    public int supprimer(String id) throws SQLException, ClassNotFoundException {
        //Création de la requête
        String sql = "DELETE FROM comptes WHERE code=?";
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
    public ComptesModel rechercher(String id) throws SQLException, ClassNotFoundException {
        ComptesModel model = null;
    // chaine de requete
      String sql=" SELECT * FROM comptes where code=?";
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
           model = new ComptesModel();
           model.setCode(rs.getString(1));
           model.setNom(rs.getString(2));
           model.setPrenom(rs.getString(3));
           model.setSexe(rs.getString(4));
           model.setAdresse(rs.getString(5));
           model.setLieu_naissance(rs.getString(6));
           model.setDate_naissance(rs.getDate(7).toLocalDate());
           model.setPhone(rs.getString(8));
           model.setNif_cin(rs.getString(9));
           model.setUsername(rs.getString(10));
           model.setPassword(rs.getString(11));
           model.setSolde(rs.getDouble(12));
           model.setEtat(rs.getString(13));
           model.setType_compte(rs.getString(14));          
      }
      DBConnection.disconnect(rs, ps, con);
      return model;
        } 
    
    public ComptesModel verifierUser(String id) throws SQLException, ClassNotFoundException {
        ComptesModel model = null;
    // chaine de requete
      String sql=" SELECT * FROM comptes where username=?";
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      //Passage des parametres        
        ps.setString(1, id);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
      while(rs.next()){
           model = new ComptesModel();
           model.setCode(rs.getString(1));
           model.setNom(rs.getString(2));
           model.setPrenom(rs.getString(3));
           model.setSexe(rs.getString(4));
           model.setAdresse(rs.getString(5));
           model.setLieu_naissance(rs.getString(6));
           model.setDate_naissance(rs.getDate(7).toLocalDate());
           model.setPhone(rs.getString(8));
           model.setNif_cin(rs.getString(9));
           model.setUsername(rs.getString(10));
           model.setPassword(rs.getString(11));
           model.setSolde(rs.getDouble(12));
           model.setEtat(rs.getString(13));
           model.setType_compte(rs.getString(14));          
      }
      DBConnection.disconnect(rs, ps, con);
      return model;
        }
    public ArrayList<String> Validate(ComptesModel model) throws SQLException, ClassNotFoundException{
    ArrayList<String> messages = new ArrayList();
    ArrayList<ComptesModel> co = afficher();
    for(ComptesModel c:co){
        if(c.getUsername().equalsIgnoreCase(model.getUsername())){
            messages.add("Ce nom d'utilisateur est deja pris, veuillez choisir un autre.");
        }
    }
    return messages;
        }

    @Override
    public ArrayList<ComptesModel> afficher() throws SQLException, ClassNotFoundException {
        ArrayList<ComptesModel> liste_comptes=new ArrayList<>();
    // chaine de requete
      String sql=" SELECT * FROM comptes ";
      // connection
      con=DBConnection.connect();
      // passage de la requete
      ps=con.prepareStatement(sql);
      // execution de la requete
      rs=ps.executeQuery();
      // parcourrir le resultSet
       ComptesModel model=null;
      while(rs.next()){
           model = new ComptesModel();
           model.setCode(rs.getString(1));
           model.setNom(rs.getString(2));
           model.setPrenom(rs.getString(3));
           model.setSexe(rs.getString(4));
           model.setAdresse(rs.getString(5));
           model.setLieu_naissance(rs.getString(6));
           model.setDate_naissance(rs.getDate(7).toLocalDate());
           model.setPhone(rs.getString(8));
           model.setNif_cin(rs.getString(9));
           model.setUsername(rs.getString(10));
           model.setPassword(rs.getString(11));
           model.setSolde(rs.getDouble(12));
           model.setEtat(rs.getString(13));
           model.setType_compte(rs.getString(14));
           liste_comptes.add(model);
          
      }
      DBConnection.disconnect(rs, ps, con);
      return liste_comptes;
        }
    
}
