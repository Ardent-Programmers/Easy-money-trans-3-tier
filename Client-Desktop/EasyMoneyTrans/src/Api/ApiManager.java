/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import com.google.gson.Gson;
import data.DataResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author User
 */
public class ApiManager {
    
    
    public DataResponse doGetRequest(String url,ArrayList<NameValuePair> nvps)
    {
        DataResponse dataResponse=null;
        Gson gson = new Gson();
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            
            HttpPost httpPost = new HttpPost(url);
            
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            
            HttpResponse response = httpClient.execute(httpPost);
                            //verify the valid error code first
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 200)
                {
                    throw new RuntimeException("Failed with HTTP error code : " + statusCode);
                }

                //Now pull back the response object
                HttpEntity httpEntity = response.getEntity();
                String apiOutput = EntityUtils.toString(httpEntity);

                //Lets see what we got from API
                System.out.println(apiOutput);
            
         dataResponse = gson.fromJson(apiOutput, DataResponse.class);
            
            
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ApiManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataResponse;
    }
}
