package net.sqlitetutorial;


import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author sqlitetutorial.net
 */
public class SelectAppWithParam {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/abhi2.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectAppWithParam app = new SelectAppWithParam();
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter the Movie Name:");
	String y=sc.nextLine();
        app.getName(y);
    }

    /**
     * Get the warehouse whose capacity greater than a specified capacity
     * @param capacity 
     */
    public void getName(String nm){
               String sql = "SELECT *"
                          + "FROM Movies WHERE name = ?";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setString(1,nm);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            if(rs.next()) {
                //System.out.println(rs.getInt("id") +  "\t" + 
                           //        rs.getString("name"));
                  System.out.println("This Movie is premering");
            }
else
{
System.out.println("Not Available Now...");
}
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}