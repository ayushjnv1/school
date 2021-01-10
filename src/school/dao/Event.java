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
import school.pojo.EventsPojo;
import school.pojo.clubPojo;

/**
 *
 * @author shree
 */
public class Event {
       static public List<EventsPojo> getall()throws SQLException
    {  List<EventsPojo> li=new ArrayList<>();
        Statement st=DbConnection.getConnection().createStatement();
        ResultSet re=st.executeQuery("select * from event");
        while(re.next())
        {
            EventsPojo e=new EventsPojo();
            e.setEvent_name(re.getString(2));
            e.setEvent_date(re.getString(3));
            e.setTime(re.getString(4));
            e.setVenue(re.getString(5));
            e.setCordinator(re.getString(6));
            li.add(e);
        }
        return li;
    }

static public List<String> getallname()throws SQLException
    {  List<String> li=new ArrayList<>();
        Statement st=DbConnection.getConnection().createStatement();
        ResultSet re=st.executeQuery("select event_name from event");
        while(re.next())
        {
           li.add(re.getString(1));
        }
        return li;
    }
 public static boolean Removeclub(String name) throws SQLException
    {
        PreparedStatement pe=DbConnection.getConnection().prepareStatement("Delete from event where event_name=?");
        pe.setString(1,name);
        return pe.executeUpdate()==1;
    }
  public static boolean Newclub(EventsPojo e)throws SQLException
    {
        PreparedStatement pe=DbConnection.getConnection().prepareStatement("insert into event values(?,?,?,?,?,?)");
       pe.setString(1,"1");
        pe.setString(2, e.getEvent_name());
        pe.setString(3, e.getEvent_date());
        pe.setString(4, e.getTime());
          pe.setString(6, e.getCordinator());
           pe.setString(5, e.getVenue());
          return pe.executeUpdate()==1;
    }
  public static EventsPojo search(String name) throws SQLException
    {EventsPojo e=new  EventsPojo();
     PreparedStatement pe=DbConnection.getConnection().prepareStatement("select * from Event where event_name=? ");
     pe.setString(1, name);
     ResultSet re=pe.executeQuery();
     if(re.next())
     {
          e.setEvent_name(re.getString(2));
                e.setEvent_date(re.getString(3));
                e.setTime(re.getString(4));
                 e.setCordinator(re.getString(5));
                  e.setVenue(re.getString(6));
                
                
                return e;
                
         
     }
     else
         return null;
    }
public static boolean update(EventsPojo e)throws SQLException
{
    PreparedStatement pe=DbConnection.getConnection().prepareStatement("update club set date_event=?,time=?,venue=?,cordinator=? where Event_name=?") ;
    pe.setString(1, e.getEvent_date());
    pe.setString(2,e.getTime());
    pe.setString(3,e.getVenue());
     pe.setString(4,e.getCordinator());
      pe.setString(5,e.getEvent_name());
    return pe.executeUpdate()==1;
}
}
