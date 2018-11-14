/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Security;

import GUI.AccountValidation;
import GUI.ApplicationManager;
import java.util.Date;

/**
 *
 * @author User
 */
public class NotificationManager {

    private Notification POPUP;
    public NotificationManager( ) {
        
        POPUP = ApplicationManager.application.popup;
    }
    
     
    
    private  void show()
    {
        POPUP.setVisible(true);
    }
    
    public void hide()
    {
        POPUP.setVisible(false);
    }
    
//    ??min is the minute ,how long the message should display
    public  void sendNotification(String msg,long sec)
    {
        POPUP.setMessage(msg);
        POPUP.setVisible(true);
        
        
//        long startTime = System.currentTimeMillis();
//        long elapsedTime = 0L;
//
//        while (elapsedTime < min*60*1000) {
//            
//            elapsedTime = (new Date()).getTime() - startTime;
//        }

        
        
        
//        POPUP.setVisible(false);
    }
    
      public  void sendNotificationBig(String msg,long sec)
    {
        ApplicationManager.application.loadScene(new BigNotification(msg));
        
        
        
        
        
//        long startTime = System.currentTimeMillis();
//        long elapsedTime = 0L;
//
//        while (elapsedTime < min*60*1000) {
//            
//            elapsedTime = (new Date()).getTime() - startTime;
//        }

        
        
        
//        POPUP.setVisible(false);
    }
    
}
