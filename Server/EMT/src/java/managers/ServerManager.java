/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import twilio.TwilioApp;


/**
 *
 * @author User
 */
public class ServerManager {
    public static DatabaseManager databaseManager;
    public static TwilioApp twilioApp;

    public ServerManager() {
        databaseManager = new DatabaseManager();
        twilioApp = new TwilioApp();
    }
    
    
}
