
package bookborrowing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBConnection {
     private static Connection conn=null;
      
    private static final String USERNAME="root";
    private static final String passwordDB="";
    private static final String conString="jdbc:mysql://localhost:3306/progProj";
    
       public static Connection getConnection(){
            try{
           conn=DriverManager.getConnection(conString,USERNAME,passwordDB);
          
       } catch (SQLException ex) {
                System.out.print(ex.getMessage());
    }
            return conn;
       }
}
