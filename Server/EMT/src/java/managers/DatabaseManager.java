/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import Data.DataCustomer;
import controls.Connect;
import controls.CustomerDAO;
import controls.TransactionDAO;

/**
 *
 * @author User
 */
public class DatabaseManager {
    private  CustomerDAO cdao;
//    private static DataCustomer cust;
    private  TransactionDAO tdao;
    private Connect connect;

    public DatabaseManager() {
        this.connect = new Connect("easymoneytrans");
        this.cdao = new CustomerDAO(connect);
//        cust = new DataCustomer();
        this.tdao = new TransactionDAO(connect);
        
    }

    public CustomerDAO getCdao() {
        return cdao;
    }

    public void setCdao(CustomerDAO cdao) {
        this.cdao = cdao;
    }

    public TransactionDAO getTdao() {
        return tdao;
    }

    public void setTdao(TransactionDAO tdao) {
        this.tdao = tdao;
    }

    public Connect getConnect() {
        return connect;
    }

    public void setConnect(Connect connect) {
        this.connect = connect;
    }
    
    
    
    
    
    
}
