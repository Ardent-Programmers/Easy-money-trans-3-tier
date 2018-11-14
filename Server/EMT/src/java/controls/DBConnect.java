package controls;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class DBConnect {
    
    private Connection con = null;

    public Connection getCon() {
        return con;
    }
    
    /**
     *this will take 3 arguments 
     * @param url
     * @param uname
     * @param pwd
     */
    public DBConnect(String url,String uname,String pwd){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pwd);
        } catch (Exception ex) {
            System.out.println(ex);
        }
       
    }
    
    public void close()
    {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
