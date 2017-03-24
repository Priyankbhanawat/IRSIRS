/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Priyank_Bhanawat
 */
import java.sql.*;
public class Temp {
    private final String USERNAME = "root";
    private final String PASSWORD= "";
    private final String CONN_STRING = "jdbc:mysql://localhost:3306/mydb";
    
   public void tempMethod()
   {
       Connection conn = null;
       
       try {
           conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
           System.out.println("Connected!");
           Statement stmt = (Statement) conn.createStatement();
           String Fname1 = "Karsanbhai";
           String Lname1 = "Patel";
           String insert = "INSERT INTO mytable (Fname,Lname) VALUES ('"+Fname1+"','"+Lname1+"')";
           stmt.executeUpdate(insert);
           
       }catch (SQLException e) {
           System.err.println(e);
       }
   }
    
}
