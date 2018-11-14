/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author User
 */


import DatabaseManager.Customer;
import DatabaseManager.DatabaseManager;
import GUI.Security.NotificationManager;












public class ApplicationManager {
    
    public static DatabaseManager DBManager;
    public static GUIManager application;
    public static NotificationManager Notify;
    public static final long NOTIFY_TIME = 1;
    private static int attempt = 0;

    public static int getAttempt() {
        return attempt;
    }

    public static void incrementAttempt() {
        attempt++;
    }

    public static void setAttempt(int attempt) {
        ApplicationManager.attempt = attempt;
    }
    
    
    
    
//    this method initialize the cust Object in DBManager with respective customer
    public static void InitializeCustomer(long AccNo)
    {
        try {
            
            DBManager.cust.setObject(DBManager.c.getCustomer(AccNo));
        } catch (Exception ex) {
            System.out.println("Customer Initiaization failed");
        }
    }
    
    
    
    
    
        public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                
//                creating GUIManager as Application
                application = new GUIManager();
                
//                creating Notificationmanager Object
                Notify = new NotificationManager();
                
                
                
                //data base connectivity
                
                DBManager = new DatabaseManager();
                
                
//                setting the transfer limit
                DatabaseManager.t.setTransLimit(20000.0f);
//                application.topBarInvisible(true);
               

                
            }
        });
    }
}
