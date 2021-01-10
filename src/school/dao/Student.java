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
import school.pojo.StudentPojo;

/**
 *
 * @author shree
 */
public class Student {
    static public List<StudentPojo> getallcs()throws SQLException 
    {
        List<StudentPojo> li=new ArrayList<>();
        Statement st=DbConnection.getConnection().createStatement();
        ResultSet re=st.executeQuery("select * from student");
        while(re.next())
        {
            StudentPojo e=new StudentPojo();
            e.setSid(re.getString(2));
            e.setUid(re.getString(3));
            e.setName(re.getString(4));
            e.setFather_name(re.getString(5));
            e.setMother_name(re.getString(6));
            e.setClass(re.getString(7));
            e.setRoll_no(re.getString(8));
            e.setGender(re.getString(9));
            e.setAddress(re.getString(10));
            e.setBloodgroup(re.getString(12));
            e.setDob(re.getString(11));
            e.setClub_name(re.getString(13));
            li.add(e);
            
            
        }
        return li;
    }
    static public List<StudentPojo> getalls(String c) throws SQLException
    {
         List<StudentPojo> li=new ArrayList<>();
        PreparedStatement st=DbConnection.getConnection().prepareStatement("select * from student where class=?");
        st.setString(1, c);
        ResultSet re=st.executeQuery();
        while(re.next())
        {
            StudentPojo e=new StudentPojo();
            e.setSid(re.getString(2));
            e.setUid(re.getString(3));
            e.setName(re.getString(4));
            e.setFather_name(re.getString(5));
            e.setMother_name(re.getString(6));
            e.setClass(re.getString(7));
            e.setRoll_no(re.getString(8));
            e.setGender(re.getString(9));
            e.setAddress(re.getString(10));
            e.setBloodgroup(re.getString(12));
            e.setDob(re.getString(11));
            e.setClub_name(re.getString(13));
            li.add(e);
    }
        return li;
    }
    static public StudentPojo search(String sid)throws SQLException
    {StudentPojo e=new StudentPojo();
        PreparedStatement pe=DbConnection.getConnection().prepareStatement("select * from student where Student_id=?");
        pe.setString(1, sid);
        ResultSet re=pe.executeQuery();
         if(re.next())
        {
            
            e.setSid(re.getString(2));
            e.setUid(re.getString(3));
            e.setName(re.getString(4));
            e.setFather_name(re.getString(5));
            e.setMother_name(re.getString(6));
            e.setClass(re.getString(7));
            e.setRoll_no(re.getString(8));
            e.setGender(re.getString(9));
            e.setAddress(re.getString(10));
            e.setBloodgroup(re.getString(12));
            e.setDob(re.getString(11));
            e.setClub_name(re.getString(13));
           return e; 
    }
        return null;
    }
    public static List<String> getsid()throws SQLException
    {
        Statement pe=DbConnection.getConnection().createStatement();
        ResultSet re=pe.executeQuery("select Student_id from student ");
        List<String> li=new ArrayList<>();
        while(re.next())
        {
            li.add(re.getString(1));
        }
        return li;
    }
    public static boolean Remove(String sid) throws SQLException
    {
        PreparedStatement pe=DbConnection.getConnection().prepareStatement("Delete from student where Student_id=?");
        pe.setString(1, sid);
        return pe.executeUpdate()==1;
    }
    public static boolean Update(StudentPojo e)throws SQLException
    {
        PreparedStatement pe=DbConnection.getConnection().prepareStatement("update student set user_id=?,name=?,Father_name=?,mother_name=?,class=?,roll_no=?,gender=?,address=?,bloodGroup=?,Dob=?,Club_name=? where student_id=?");
        pe.setString(1,e.getUid());
        pe.setString(2,e.getName());
        pe.setString(3,e.getFather_name());
        pe.setString(4,e.getMother_name());
        pe.setString(5,e.getC());
        pe.setString(6,e.getRoll_no());
        pe.setString(7, e.getGender());
        pe.setString(8,e.getAddress());
        pe.setString(9, e.getBloodgroup());
        pe.setString(10,e.getDob());
        pe.setString(11,e.getClub_name() );
        pe.setString(12,e.getSid());
        return pe.executeUpdate()==1;
        
        
    }
    public static boolean newRegisterstudent(StudentPojo e)throws SQLException
    {
        PreparedStatement pe=DbConnection.getConnection().prepareStatement("insert into student values(1,?,?,?,?,?,?,?,?,?,?,?,?)");
        pe.setString(1,e.getSid());
        pe.setString(2,e.getUid());
        pe.setString(3,e.getName());
        pe.setString(4,e.getFather_name());
        pe.setString(5,e.getMother_name());
        pe.setString(6,e.getC());
        pe.setString(7,e.getRoll_no());
        pe.setString(8, e.getGender());
        pe.setString(9,e.getAddress());
        pe.setString(10, e.getBloodgroup());
        pe.setString(11,e.getDob());
        pe.setString(12,e.getClub_name() );
        return pe.executeUpdate()==1;
    
    }
    public static String getsidn()throws SQLException
    {  String d="S100";
        Statement st=DbConnection.getConnection().createStatement();
        ResultSet re=st.executeQuery("select max(student_id) from student");
        if(re.next())
        {
          d=re.getString(1);
        }
        d=d.substring(1);
        int a=Integer.parseInt(d);
        a=a+1;
        return "S"+a;
        
    }
}
