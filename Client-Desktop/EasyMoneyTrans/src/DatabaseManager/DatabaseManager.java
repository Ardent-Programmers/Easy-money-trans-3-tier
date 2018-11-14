/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManager;

import data.DataCustomer;

/**
 *
 * @author User
 */
public class DatabaseManager {
    public static CustomerDAO c;
    public static DataCustomer cust;
    public static TransferDAO t;

    public DatabaseManager() {
        
        c = new CustomerDAO();
        cust = new DataCustomer();
        t = new TransferDAO();
        
    }
    
    
    
    
}
