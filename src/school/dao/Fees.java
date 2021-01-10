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
import school.pojo.FeesPojo;
import school.pojo.TeacherPojo;

/**
 *
 * @author shree
 */
public class Fees {
    public static boolean update(FeesPojo e)throws SQLException
{
    PreparedStatement pe=DbConnection.getConnection().prepareStatement("update fees set Development_fee=?,tution_fee=?,extra_curr=?,other=?,total=? where class=?") ;
    pe.setDouble(1, e.getDevelopment_fees());
    pe.setDouble(2, e.getTution_fees());
    pe.setDouble(3, e.getExtra_fees());
    pe.setDouble(4, e.getOther_fees());
    pe.setDouble(5, e.getTotal());
    pe.setString(6, e.getC());
    return pe.executeUpdate()==1;
}
       public static List<FeesPojo> getAll() throws SQLException{
        List<FeesPojo> li=new ArrayList<>();
        
            Statement st=DbConnection.getConnection().createStatement();
            ResultSet re=st.executeQuery("select * from fees order by class");
            while(re.next())
            {FeesPojo e=new FeesPojo();
               e.setC(re.getString(2));
                e.setDevelopment_fees(re.getDouble(3));
                e.setTution_fees(re.getDouble(4));
                e.setExtra_fees(re.getDouble(4));
                e.setOther_fees(re.getDouble(5));
                e.setTotal(re.getDouble(6));
               
                li.add(e);
                
            }
            return li;
        
    }
  public static FeesPojo search(String c) throws SQLException
    {FeesPojo e=new  FeesPojo();
     PreparedStatement pe=DbConnection.getConnection().prepareStatement("select * from fees where class=? ");
     pe.setString(1, c);
     ResultSet re=pe.executeQuery();
     if(re.next())
     {
                e.setDevelopment_fees(re.getDouble(3));
                e.setTution_fees(re.getDouble(4));
                e.setExtra_fees(re.getDouble(5));
                e.setOther_fees(re.getDouble(6));
                e.setTotal(re.getDouble(7));
                return e;
           
              }
     else
         return null;
    }

}
