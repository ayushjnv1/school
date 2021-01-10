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
import java.util.*;
import school.dbutil.DbConnection;
import school.pojo.TeacherPojo;

/**
 *
 * @author shree
 */
public class Teacher {
    public static List<TeacherPojo> getAll() throws SQLException{
        List<TeacherPojo> li=new ArrayList<>();
        
            Statement st=DbConnection.getConnection().createStatement();
            ResultSet re=st.executeQuery("select * from teacher");
            while(re.next())
            {TeacherPojo e=new TeacherPojo();
                e.setTid(re.getString(2));
                e.setName(re.getString(3));
                e.setMob(re.getString(4));
                e.setGender(re.getString(5));
                e.setDob(re.getString(6));
                e.setSubject(re.getString(7));
                e.setAddress(re.getString(8));
                e.setUserid(re.getString(9));
                li.add(e);
                
            }
            return li;
        
    }
    public static boolean Newteacher(TeacherPojo e)throws SQLException
    {
        PreparedStatement pe=DbConnection.getConnection().prepareStatement("insert into teacher values(?,?,?,?,?,?,?,?,?)");
       pe.setString(1,"1");
        pe.setString(2, e.getTid());
        pe.setString(3, e.getName());
        pe.setString(4, e.getMob());
        pe.setString(5,e.getGender());
        pe.setString(6,e.getDob());
        pe.setString(7,e.getSubject());
        pe.setString(8,e.getAddress());
        pe.setString(9, e.getUserid());
        return pe.executeUpdate()==1;
    }
    public static boolean RemoveTeacher(String tid) throws SQLException
    {
        PreparedStatement pe=DbConnection.getConnection().prepareStatement("Delete from teacher where teacher_id=?");
        pe.setString(1,tid);
        return pe.executeUpdate()==1;
    }
    public static TeacherPojo search(String tid) throws SQLException
    {TeacherPojo e=new  TeacherPojo();
     PreparedStatement pe=DbConnection.getConnection().prepareStatement("select * from teacher where teacher_id=? ");
     pe.setString(1, tid);
     ResultSet re=pe.executeQuery();
     if(re.next())
     {
          e.setTid(re.getString(2));
                e.setName(re.getString(3));
                e.setMob(re.getString(4));
                e.setGender(re.getString(5));
                e.setDob(re.getString(6));
                e.setSubject(re.getString(7));
                e.setAddress(re.getString(8));
                e.setUserid(re.getString(9));
                return e;
                
         
     }
     else
         return null;
    }

public static boolean update(TeacherPojo e)throws SQLException
{
    PreparedStatement pe=DbConnection.getConnection().prepareStatement("update teacher set name=?,contact_no=?,gender=?,dob=?,main_subject=?,address=?,user_id=? where teacher_id=?") ;
    pe.setString(1, e.getName());
    pe.setString(2,e.getMob());
    pe.setString(3,e.getGender());
    pe.setString(4,e.getDob());
    pe.setString(5,e.getSubject());
    pe.setString(6,e.getAddress());
    pe.setString(7,e.getUserid());
    pe.setString(8,e.getTid());
    return pe.executeUpdate()==1;
}
public static String gettid()throws SQLException
{
    Statement st=DbConnection.getConnection().createStatement();
    ResultSet re=st.executeQuery("select max(teacher_id) from teacher ");
    if(re.next())
        return re.getString(1);
    else
        return null;
}
public static List<String> getAlltid()throws SQLException
{ List<String> li=new ArrayList<>();
    Statement st=DbConnection.getConnection().createStatement();
    ResultSet re=st.executeQuery("select Teacher_id from teacher");
    while(re.next())
    {
        li.add(re.getString(1));
    }
    return li;
}
}
