/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import Data.DataCustomer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CustomerDAO {
    private final Connect connect;
    private final Connection c;

    public CustomerDAO(Connect connect) {
        this.connect = connect;
        this.c = this.connect.getCon();
    }
    
    
    
    public DataCustomer getCustomer(long accNo)
    {
        DataCustomer dc = new DataCustomer();
        PreparedStatement ps = null;
        
        
        try {
            
            
            String sql = "SELECT c.`AccNo`, c.`Name`,a.`AvailableAmount` FROM `customer` c ,`account` a\n" +
                    "WHERE c.`AccNo` = ? AND a.`AccNo` = ?;";
            
            
          
            
            ps = c.prepareStatement(sql);
            
            ps.setLong(1, accNo);
            ps.setLong(2, accNo);
            
            
            ResultSet rs = ps.executeQuery();
            
            boolean r = rs.next();
            
            if(r)
            {
                dc.setAccNo(rs.getLong(1));
                dc.setName(rs.getString(2));
                dc.setAmount(rs.getFloat(3));
            }

            
            
            
            
            
            
            
            
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }
        
        return dc;
    }
    public long getPhoneNo(long accNo)
    {
        
        PreparedStatement ps = null;
        
        long pn = 0;
        
        try {
            
            
            String sql = "SELECT c.`PhoneNo` FROM `customer` c WHERE c.`AccNo` = ?";
            
            
          
            
            ps = c.prepareStatement(sql);
            
            ps.setLong(1, accNo);

            
            
            ResultSet rs = ps.executeQuery();
            
            boolean r = rs.next();
            
            if(r)
            {
               pn = rs.getLong(1);
            }

            
            
            
            
            
            
            
            
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }
        
        return pn;
    }
    
    public boolean isCustomerExist(long accNo)
    {
        
        PreparedStatement ps = null;
        boolean res=false;
        
        try {
            
            
            String sql = "SELECT c.`AccNo`, c.`Name` FROM `customer` c \n" +
                    "WHERE c.`AccNo` = ?";
            
            
          
            
            ps = c.prepareStatement(sql);
            
            ps.setLong(1, accNo);
            
            
            ResultSet rs = ps.executeQuery();
            
            res = rs.next();
            
            ps.close();
            
            

            
            
            
            
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return res;
        }
        
        
    }
    
    
    public boolean isLoginCorrect(String sname,long accNo,int key)
    {
        
        PreparedStatement ps = null;
        boolean res=false;
        
        try {
            
            
            String sql = "SELECT `AccNo` FROM `service` WHERE \n" +
                            "`Name` = ? AND\n" +
                            "`AccNo`= ? AND\n" +
                            "`SKey`= ?";
            
            
          
            
            ps = c.prepareStatement(sql);
            
            ps.setString(1, sname);
            ps.setLong(2, accNo);
            ps.setInt(3,key);
            
            
            ResultSet rs = ps.executeQuery();
            
            res = rs.next();
            
            ps.close();
            
            

            
            
            
            
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return res;
        }
        
        
    }

    
    
}
