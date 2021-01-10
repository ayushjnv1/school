/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import school.dbutil.DbConnection;
import school.pojo.clubPojo;

/**
 *
 * @author shree
 */
public class ClubDao {
   
    static public List<clubPojo> getall()throws SQLException
    {  List<clubPojo> li=new ArrayList<>();
        Statement st=DbConnection.getConnection().createStatement();
        ResultSet re=st.executeQuery("select * from club");
        while(re.next())
        {
            clubPojo e=new clubPojo();
            e.setName(re.getString(2));
            e.setActivity_day(re.getString(3));
            e.setMoto(re.getString(4));
            li.add(e);
        }
        return li;
    }

static public List<String> getallname()throws SQLException
    {  List<String> li=new ArrayList<>();
        Statement st=DbConnection.getConnection().createStatement();
        ResultSet re=st.executeQuery("select name from club");
        while(re.next())
        {
           li.add(re.getString(1));
        }
        return li;
    }
 public static boolean Removeclub(String name) throws SQLException
    {
        PreparedStatement pe=DbConnection.getConnection().prepareStatement("Delete from club where name=?");
        pe.setString(1,name);
        return pe.executeUpdate()==1;
    }
  public static boolean Newclub(clubPojo e)throws SQLException
    {
        PreparedStatement pe=DbConnection.getConnection().prepareStatement("insert into club values(?,?,?,?)");
       pe.setString(1,"1");
        pe.setString(2, e.getName());
        pe.setString(3, e.getActivity_day());
        pe.setString(4, e.getMoto());
        return pe.executeUpdate()==1;
    }
  public static clubPojo search(String name) throws SQLException
    {clubPojo e=new  clubPojo();
     PreparedStatement pe=DbConnection.getConnection().prepareStatement("select * from club where name=? ");
     pe.setString(1, name);
     ResultSet re=pe.executeQuery();
     if(re.next())
     {
          e.setName(re.getString(2));
                e.setActivity_day(re.getString(3));
                e.setMoto(re.getString(4));
                
                return e;
                
         
     }
     else
         return null;
    }
public static boolean update(clubPojo e)throws SQLException
{
    PreparedStatement pe=DbConnection.getConnection().prepareStatement("update club set Activity_day=?,motto=? where name=?") ;
    pe.setString(3, e.getName());
    pe.setString(2,e.getMoto());
    pe.setString(1,e.getActivity_day());
    return pe.executeUpdate()==1;
} 
}
