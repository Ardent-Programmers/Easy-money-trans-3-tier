/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;


import data.DataResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author User
 */
public class SampleMain {
    public static void main(String[] args) {
        ApiManager apiManager = new ApiManager();
        DataResponse dataResponse = null;
        
        String url = "http://localhost:8080/EMT/GetUser";
        
        ArrayList<NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add(new BasicNameValuePair("accno", "456789101"));
        
        try {
              dataResponse =  apiManager.doGetRequest(url,nvps);
            } catch (Exception ex) {
                Logger.getLogger(ApiCall.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(dataResponse.getData());
    }
}
