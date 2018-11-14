/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author User
 */
public class TwilioApp {
    
    public static final String ACCOUNT_SID = "AC147c1037bca79837ddae7a50127de480";
    public static final String AUTH_TOKEN = "33eb42675ac5eb9f949f923ececef8c9";    
        public TwilioApp()
    {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
    
    public boolean send(long toPhoneNo,String msg)
    {
        boolean res = true;
        
        try{
            Message message = Message.creator(
                new PhoneNumber("+91"+toPhoneNo), //to
                new PhoneNumber("+13364894484"), // From
                msg)
            .create();
            
            
        }catch(Exception e)
        {
            res= false;
            System.err.println("Error Sending Message to this no "+toPhoneNo);
        }
        return res;
    }
}
