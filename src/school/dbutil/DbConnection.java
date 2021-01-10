/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author shree
 */
public class DbConnection {
    private static Connection conn;
    static 
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//shree-PC:1521/xe","school","school");
            JOptionPane.showMessageDialog(null,"Connection successful!");
        }
         catch(ClassNotFoundException e)
       {
            JOptionPane.showMessageDialog(null,"Can not load driver","Error!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
       }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Connection unsuccessful!");
            System.out.println(e);
        }
    }
    
        public static Connection getConnection()
   {
       return conn;
   }
   public static void closeConnection()
   {
      try{if(conn!=null){
   conn.close();}}
      catch(SQLException e)
      {
           JOptionPane.showMessageDialog(null,"Problem in close in connection","Error!", JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
      }
            
    }
}
