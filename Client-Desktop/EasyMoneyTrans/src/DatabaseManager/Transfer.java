/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author User
 */
public class Transfer {
    public long AccountNo;
    public String Date,Time;
    
//    formate date: yyyy/MM/dd time: hh:mm:ss 
    
    public boolean Withdraw,Deposit;

    /**
     *
     */
    public float Amount;
    
     public Transfer() {
    }

    
    
    public Transfer(Transfer t) {
        this.AccountNo = t.AccountNo;
        this.Date = t.Date;
        this.Time = t.Time;
        this.Withdraw = t.Withdraw;
        this.Deposit = t.Deposit;
        this.Amount = t.Amount;
    }

    
    
    
    @Override
    public String toString() {
        return "Transfer{" + "AccountNo=" + AccountNo + ", Date=" + Date + ", Time=" + Time + ", Withdraw=" + Withdraw + ", Deposit=" + Deposit + ", Amount=" + Amount + '}';
    }
    
    
    
        
}
