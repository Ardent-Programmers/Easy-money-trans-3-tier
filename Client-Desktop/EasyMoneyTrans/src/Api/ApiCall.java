/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import java.awt.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author User
 */
public class ApiCall {
        public static void demoGetRESTAPI() throws Exception
        {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            try
            {
                //Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
                HttpPost httpPost = new HttpPost("http://localhost:8080/EMT/GetUser");
                ArrayList<NameValuePair> nvps = new ArrayList <NameValuePair>();
                nvps.add(new BasicNameValuePair("accno", "456789101"));
//                nvps.add(new BasicNameValuePair("password", "secret"));
                httpPost.setEntity(new UrlEncodedFormEntity(nvps));
                

                //Set the API media type in http accept header
                httpPost.addHeader("accept", "application/json");

                //Send the request; It will immediately return the response in HttpResponse object
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
                System.out.println(apiOutput); //<user id="10"><firstName>demo</firstName><lastName>user</lastName></user>

                //In realtime programming, you will need to convert this http response to some java object to re-use it.
                //Lets see how to jaxb unmarshal the api response content
//                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
//                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//                User user = (User) jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));

//                //Verify the populated object
//                System.out.println(user.getId());
//                System.out.println(user.getFirstName());
//                System.out.println(user.getLastName());
            }
            finally
            {
                //Important: Close the connect
                httpClient.close();
            }
        }
        
       public static void main(String[] args) {
        
            try {
                demoGetRESTAPI();
            } catch (Exception ex) {
                Logger.getLogger(ApiCall.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 
        
}
