/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import Data.DataTransaction;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import managers.ServerManager;

/**
 *
 * @author User
 */



public class TransactionDAO {
    private final Connect connect;
    private final Connection c;

    public TransactionDAO(Connect connect) {
        this.connect = connect;
        this.c = this.connect.getCon();
    }
    
    
    public boolean withdrawATM(long accno,float amount)
    {
        boolean out=false;
        String msg = "Amount "+amount+"has been withdrawed from Your Account "+accno+" In ATM";
        
        try {
            
            String sql = "CALL DoTransactionATM(?,?,?)";
            
            CallableStatement cs= c.prepareCall(sql);
            
            cs.setLong(1, accno);
            cs.setFloat(2, amount);
            cs.setString(3, "W");
            
            
            int r = cs.executeUpdate();
            
            if(r>=1)
            {
                out = true;
            }
            
            
            
            
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(out)
        {
            ServerManager.twilioApp.send(ServerManager.databaseManager.getCdao().getPhoneNo(accno), msg);
        }
        
        
        return out;
    }
    public boolean depositATM(long accno,float amount)
    {
        boolean out=false;
        try {
            
            String sql = "CALL DoTransactionATM(?,?,?)";
            
            CallableStatement cs= c.prepareCall(sql);
            
            cs.setLong(1, accno);
            cs.setFloat(2, amount);
            cs.setString(3, "D");
            
            
            int r = cs.executeUpdate();
            
            if(r>=1)
            {
                out = true;
            }
            
            
            
            
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return out;
    }
    
    
    public List<DataTransaction> getTransactionATM(long accno)
    {
        List<DataTransaction> dts = new ArrayList<>();
        try {
            
            
           
            String sql = "SELECT  `Type`, `Date`, `Time`, `Amount` FROM `transdetails`\n" +
                        "WHERE `Id` IN (\n" +
                        "	SELECT `Id`FROM `transaction`\n" +
                        "    WHERE `SName`='ATM' AND\n" +
                        "    `TAccNo` = ? )\n" +
                        "    ORDER BY `Id`\n" +
                        "    LIMIT 20;\n" +
                        "\n" +
                        "\n" +
                        "";
            
            PreparedStatement ps= c.prepareStatement(sql);
            
            ps.setLong(1, accno);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                 DataTransaction dt= new DataTransaction();
                dt.setType(rs.getString(1));
                dt.setDate(rs.getString(2));
                dt.setTime(rs.getString(3));
                dt.setAmount(rs.getString(4));
                
                dts.add(dt);
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dts;
    }
    
    
    
    
    public boolean transferONLINE(long faccno,float amount,long taccno)
    {
        boolean out=false;
        try {
            
            String sql = "CALL DoTransactionONLINE(?,?,?)";
            
            CallableStatement cs= c.prepareCall(sql);
            
            cs.setLong(1, faccno);
            cs.setFloat(2, amount);
            cs.setLong(3, taccno);

            
            
            int r = cs.executeUpdate();
            
            if(r>=1)
            {
                out = true;
            }
            
            
            
            
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
        
    }
 
    
// online transaction

    
    
    public List<DataTransaction> getTransactionONLINE(long accno)
    {
        List<DataTransaction> dts = new ArrayList<>();
        try {
            
            
           
            String sql = "SELECT  `Type`, `Date`, `Time`, `Amount` FROM `transdetails`\n" +
                        "WHERE `Id` IN (\n" +
                        "	SELECT `Id`FROM `transaction`\n" +
                        "    WHERE `SName`='ATM' AND\n" +
                        "    `TAccNo` = ? )\n" +
                        "    ORDER BY `Id`\n" +
                        "    LIMIT 20;\n" +
                        "\n" +
                        "\n" +
                        "";
            
            PreparedStatement ps= c.prepareStatement(sql);
            
            ps.setLong(1, accno);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                 DataTransaction dt= new DataTransaction();
                dt.setType(rs.getString(1));
                dt.setDate(rs.getString(2));
                dt.setTime(rs.getString(3));
                dt.setAmount(rs.getString(4));
                
                dts.add(dt);
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dts;
    }
   
    
}
