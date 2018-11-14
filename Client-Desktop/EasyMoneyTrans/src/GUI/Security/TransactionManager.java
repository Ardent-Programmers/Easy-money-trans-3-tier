/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Security;

import Api.ApiCall;
import Api.ApiManager;
import DatabaseManager.Transfer;
import DatabaseManager.TransferDAO;
import GUI.ApplicationManager;
import GUI.Options.Options;
import data.DataCustomer;
import data.DataResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author User
 */
public class TransactionManager {
    
    static Transfer trans = new Transfer();
    static DataCustomer cust = ApplicationManager.DBManager.cust;
    static TransferDAO t = ApplicationManager.DBManager.t;
    
    public static void withdraw(float Amount) {
        

        
        if(Amount > cust.getAmount())
        {
            ApplicationManager.Notify.sendNotification("You Don't have Enuff money u have only " + cust.getAmount(), 1);
        }
        else if(Amount <= 0)
        {
            ApplicationManager.Notify.sendNotification("wrong Input",1);
        }
        else
        {
            ApiManager apiManager = new ApiManager();
            DataResponse dataResponse = null;


            String url = "http://localhost:8080/EMT/Withdraw";

            ArrayList<NameValuePair> nvps = new ArrayList <>();
            nvps.add(new BasicNameValuePair("accno", cust.getAccNo()+""));
            nvps.add(new BasicNameValuePair("amount", Amount+""));

            try {
                  dataResponse =  apiManager.doGetRequest(url,nvps);
                } catch (Exception ex) {
                    Logger.getLogger(ApiCall.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            if(!dataResponse.isStatus())
            {
                ApplicationManager.Notify.sendNotification(dataResponse.getError(),1);
            }
            else{
                ApplicationManager.application.loadScene(new Options());
            }
        }
        
        
        
    }
    
    
    public static void deposit(float Amount) {

        
        if(Amount <= 0)
        {
            ApplicationManager.Notify.sendNotification("wrong Input",1);
        }
        else
        {
            ApiManager apiManager = new ApiManager();
            DataResponse dataResponse = null;


            String url = "http://localhost:8080/EMT/Deposit";

            ArrayList<NameValuePair> nvps = new ArrayList <>();
            nvps.add(new BasicNameValuePair("accno", cust.getAccNo()+""));
            nvps.add(new BasicNameValuePair("amount", Amount+""));

            try {
                  dataResponse =  apiManager.doGetRequest(url,nvps);
                } catch (Exception ex) {
                    Logger.getLogger(ApiCall.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            if(!dataResponse.isStatus())
            {
                ApplicationManager.Notify.sendNotificationBig(dataResponse.getError(),1000);
            }
            else{
                ApplicationManager.Notify.sendNotificationBig("Success",1000);
//                ApplicationManager.application.loadScene(new Options());
            }
        }
              
    }
    
    

    
    
}
