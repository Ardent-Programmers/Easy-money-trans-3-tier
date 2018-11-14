/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManager;

import Api.ApiCall;
import Api.ApiManager;
import com.google.gson.Gson;
import com.ran.jdbc.Connect;
import data.DataCustomer;
import data.DataResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author User
 */
public class CustomerDAO {
    Connection con;
    
    public CustomerDAO()
    {
        con = new Connect("test").getConnection();
    }
    
    
    
//    ths method for getting the user information 
//    with all field in Customer object and return
            
            
            
    public DataCustomer getCustomer(long AccountNo) throws Exception
    {
        DataCustomer cust = new DataCustomer();
        ApiManager apiManager = new ApiManager();
        DataResponse dataResponse = null;
        
        Gson gson = new Gson();
        
        String url = "http://localhost:8080/EMT/GetUser";
        
        ArrayList<NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add(new BasicNameValuePair("accno", AccountNo+""));
        
        try {
              dataResponse =  apiManager.doGetRequest(url,nvps);
            } catch (Exception ex) {
                Logger.getLogger(ApiCall.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println(dataResponse.getData());
        
        if(dataResponse.isStatus())
        {
            cust.setObject(gson.fromJson(dataResponse.getData().toString(), DataCustomer.class));
        }
        
        return cust;
    }
    
    
    
//    
//    this method for checking wether the user with given 
//            AccountNo is registered or not
    
    public boolean isCustomerExist(long AccountNo) throws Exception
    {
        boolean val;
        

        ApiManager apiManager = new ApiManager();
        DataResponse dataResponse = null;

        
        String url = "http://localhost:8080/EMT/IsCustomerExit";
        
        ArrayList<NameValuePair> nvps = new ArrayList <>();
        nvps.add(new BasicNameValuePair("accno", AccountNo+""));
        
        try {
              dataResponse =  apiManager.doGetRequest(url,nvps);
            } catch (Exception ex) {
                Logger.getLogger(ApiCall.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            val = dataResponse.isStatus();
        }
        
        return val;
    }
    
    
//    this method for Authentication
    
    public boolean isLoginCorrect(long AccountNo,int Key) throws Exception
    {
        boolean val;
        

        ApiManager apiManager = new ApiManager();
        DataResponse dataResponse = null;

        
        String url = "http://localhost:8080/EMT/IsLoginCorect?sname=ATM";
        
        ArrayList<NameValuePair> nvps = new ArrayList <>();
        nvps.add(new BasicNameValuePair("sname", "ATM"));
        nvps.add(new BasicNameValuePair("accno", AccountNo+""));
        nvps.add(new BasicNameValuePair("key", Key+""));
        
        try {
              dataResponse =  apiManager.doGetRequest(url,nvps);
            } catch (Exception ex) {
                Logger.getLogger(ApiCall.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            val = dataResponse.isStatus();
        }
        
        return val;
    }
    
    
    
    
//    this methodd will add new customer and return 
//    the Customer info if Succeed other wise it will return the Null
    
    public Customer addCustomer(Customer cust) throws Exception
    {
        
        
        String sql = "INSERT INTO `customer`(`SecretKey`, `Name`, `Address`, `MobileNo`, `Amount`) VALUES (?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, cust.Key);
        ps.setString(2, cust.Name);
        ps.setString(3, cust.Address);
        ps.setLong(4, cust.MobileNo);
        ps.setFloat(5, cust.Amount);
        
        int rowsEffected = ps.executeUpdate();
        
        if(rowsEffected < 1)
        {
            cust = null;
        }
          
        ps.close();
            
        return cust;
    }
    
//    to change the amount it helps in transfer the amount
    public boolean changeAmount(float amt,Long AccNo)
    {
        boolean status=true;
        String sql = "UPDATE `customer` SET `Amount`=? WHERE AccountNo=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setFloat(1, amt);
            ps.setLong(2, AccNo);
            
            int rowsEffected = ps.executeUpdate();
        
            if(rowsEffected < 1)
            {
             status = false;
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("unable to Update amount");
        }
        
        return status;
    }
    
}
