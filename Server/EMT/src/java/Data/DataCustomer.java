/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


/**
 *
 * @author User
 */
public class DataCustomer {
    private long AccNo;
    private String Name;
    private float Amount;

    public DataCustomer() {
    }

    
    public DataCustomer(int AccNo, String Name, float Amount) {
        this.AccNo = AccNo;
        this.Name = Name;
        this.Amount = Amount;
    }
    
    public DataCustomer(DataCustomer c) {
        this.AccNo = c.AccNo;
        this.Name = c.Name;
        this.Amount = c.Amount;
    }

    public long getAccNo() {
        return AccNo;
    }

    public void setAccNo(long AccNo) {
        this.AccNo = AccNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float Amount) {
        this.Amount = Amount;
    }
    
    
    
}
