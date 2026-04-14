/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sb.chcl.belparyaj.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Owner
 */
public class DBConnection {
 static Connection con=null;
 
 //SET GLOBAL time_zone = '+3:00';
 public static Connection connect() throws ClassNotFoundException, SQLException{
     // charger le nom du pilote de la BD
     Class.forName("com.mysql.cj.jdbc.Driver");
     // etabllir la connexion a BD
     String url="jdbc:mysql://localhost:3306/bel-paryaj";
     con=DriverManager.getConnection(url,"root","");
     return con;
 }
 
 public static void disconnect(ResultSet rs,PreparedStatement ps,Connection con) throws SQLException{
    if(rs!=null) {
        rs.close();
    }
    if(ps!=null) {
        ps.close();
    }
    if(con!=null) {
        con.close();
    }
 }
}

