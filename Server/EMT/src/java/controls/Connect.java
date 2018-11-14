/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package controls;



import java.sql.*;

/**
 *
 * @author User
 */
public class Connect{
    
    private String url,uname,pwd;
    private Connection con = null;
    
    public Connect()
    {
        this.url = "jdbc:mysql://localhost:3306/students";
        this.uname = "root";
        this.pwd = "rsushma7";
        this.con = getConnection();
    }
    
    public Connect(String url, String uname, String pwd) {
        this.url = url;
        this.uname = uname;
        this.pwd = pwd;
        this.con = getConnection();
    }
    
    public Connect(String db_name)
    {          
       this.url = "jdbc:mysql://localhost:3306/"+ db_name;
        this.uname = "root";
        this.pwd = "rsushma7";
        this.con = getConnection();
        
    }

    public Connection getCon() {
        return con;
    }
    
    
    
    
    private Connection getConnection()
    {
        
       con = new DBConnect(this.url,this.uname,this.pwd).getCon();
        
       return con;
    }
    
    public void close() throws SQLException
    {
        this.con.close();
    }
    
}
