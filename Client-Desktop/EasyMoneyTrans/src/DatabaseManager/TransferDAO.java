/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManager;

import Api.ApiCall;
import Api.ApiManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ran.jdbc.Connect;
import data.DataResponse;
import data.DataTransaction;
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
public class TransferDAO {
    Connection con;
    float TransLimit;

    public void setTransLimit(float TransLimit) {
        this.TransLimit = TransLimit;
    }
    
    public TransferDAO()
    {
        con = new Connect("test").getConnection();
    }
    
    
    
//    ths method for getting the user information 
//    with all field in Customer object and return
            
            
            
    public DataTransaction[] getTransaction(long AccountNo)
    {
        
        ApiManager apiManager = new ApiManager();
        DataResponse dataResponse = null;
        
        Gson gson = new Gson();
        
        String url = "http://localhost:8080/EMT/GetTransaction";
        
        ArrayList<NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add(new BasicNameValuePair("accno", AccountNo+""));
        
        try {
              dataResponse =  apiManager.doGetRequest(url,nvps);
            } catch (Exception ex) {
                Logger.getLogger(ApiCall.class.getName()).log(Level.SEVERE, null, ex);
        }        
        DataTransaction [] dataTransactions = new DataTransaction[20];
        dataTransactions = gson.fromJson(dataResponse.getData().toString(),DataTransaction[].class);
        
//        ArrayList<DataTransaction> trans = new ArrayList(dataTransactions);
        
//        try
//        {
//            PreparedStatement ps = con.prepareStatement("select * from transaction where AccountNo = ? limit 20");
//            ps.setLong(1, AccountNo);
//
//            ResultSet st = ps.executeQuery();
//
//            while(st.next())
//            {
//                DataTransaction dataTransaction = new DataTransaction();
//                t.AccountNo = st.getLong("AccountNo");
//                t.Date = st.getString("Date");
//                t.Time = st.getString("Time");
//                t.Deposit = st.getBoolean("Deposit");
//                t.Withdraw = st.getBoolean("Withdraw");
//                t.Amount = st.getFloat("Amount");
//
//                boolean add = trans.add(dataTransaction);
//                System.out.println("is it added: "+add);
//
//            }
//        }catch(Exception e)
//        {
//            System.out.println("unable to get transaction : "+e);
//            
//        }
//        
        
        
        return dataTransactions;
    }
    
    
    

    
    
    
//    this methodd will add new customer and return 
//    the Customer info if Succeed other wise it will return the Null
    
    public Transfer addTransaction(Transfer t)
    {
        
        int rowsEffected;
        String sql = "INSERT INTO `transaction` VALUES (?,?,?,?,?,?)";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, t.AccountNo);
            ps.setString(2, t.Date);
            ps.setString(3, t.Time);
            ps.setBoolean(4, t.Withdraw);
            ps.setBoolean(5, t.Deposit);
            ps.setFloat(6, t.Amount);

            rowsEffected = ps.executeUpdate();
            
            
            if(rowsEffected < 1)
            {
                t = null;
            }
        }catch(Exception e)
        {
            System.out.println("unable to get transaction : "+e);
            
        }
        
        
            
            
        return t;
    }
    
}
