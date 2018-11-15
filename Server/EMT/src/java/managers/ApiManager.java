/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import Data.DataResponse;
import Data.Dummy;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ApiManager {
    
    public static enum Error{
         ERROR_PARAMETR
    }
   
    private DataResponse dataResponse;
    private final Gson gson;
    private final ServerManager sm;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public ApiManager(HttpServletRequest request,HttpServletResponse response) {
        this.sm = new ServerManager();
        this.gson = new Gson();
        
        this.request = request;
        this.response = response;
    }

    
    public ApiManager(HttpServletRequest request,HttpServletResponse response,DataResponse dataResponse) {
        this.dataResponse = dataResponse;        
        this.gson = new Gson();
        this.sm = new ServerManager();
        
        this.request = request;
        this.response = response;
    }

    public void setDataResponse(DataResponse dataResponse) {
        this.dataResponse = dataResponse;
    }
    
//    this method should be calleed if DataResponse object is not set 
    public void dummy(boolean status,String error)
    {
        dataResponse = new DataResponse();
        dataResponse.setData(new Dummy());
        dataResponse.setStatus(status);
        dataResponse.setError(error);
    }
    
    
    public boolean checkParameters(String ... params)
    {
        
        Enumeration<String> parameterNames = request.getParameterNames();
        
        boolean res = false;
        try{
            int i=0;
            while(parameterNames.hasMoreElements())
            {
                
                if(!parameterNames.nextElement().equals(params[i]))
                {
                    
                    break;
                }
                i++;
                    
            }
            
            if(i == params.length)
            {
                res = true;
            }

            
            
        }catch(Exception e)
        {
            
        }
        System.out.println("managers.ApiManager.checkParameters()"+res);
        return res;
    }
    
    
//    this method for sending the response
    //Take response from the server
    public void send()
    {
        PrintWriter pw = null;
        try {
            String json = gson.toJson(dataResponse);
            response.setContentType("application/json");
            pw = response.getWriter();
            pw.print(json);
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(ApiManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }
    }
    
    //send error
    public void sendError(Error err)
    {
        switch(err)
        {
            case ERROR_PARAMETR:
                dummy(false,"Parameters not full filled");
                send();
                break;
                
        }
    }
    
    
    
}
