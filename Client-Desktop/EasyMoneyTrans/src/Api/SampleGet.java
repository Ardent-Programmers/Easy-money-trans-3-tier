/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import com.google.gson.Gson;
import data.DataResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author User
 */
public class SampleGet {
        public void demoGet() throws IOException
        {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            try
            {
                //Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
                //Choice depends on type of method you will be invoking.
                HttpGet getRequest = new HttpGet();
                

                //Set the API media type in http accept header
                getRequest.addHeader("accept", "application/json");

                //Send the request; It will immediately return the response in HttpResponse object
                HttpResponse response = httpClient.execute(getRequest);

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
                System.out.println(apiOutput); //<user id="10"><firstName>demo</firstName><lastName>user</lastName></user>


                
            }
            catch (IOException ex) {
                Logger.getLogger(SampleGet.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                //Important: Close the connect
                httpClient.close();
            }
        }
        
 
 
        
}
