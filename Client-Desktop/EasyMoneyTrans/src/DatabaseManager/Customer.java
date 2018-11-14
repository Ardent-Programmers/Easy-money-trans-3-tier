/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManager;

/**
 *
 * @author User
 */
public class Customer {
    public String Name,Address;
    public long MobileNo,AccountNo;
    public int Key;
    public float Amount;

    public Customer() {
    }

    


    public Customer(Customer c) {
        this.Name = c.Name;
        this.Address = c.Address;
        this.MobileNo = c.MobileNo;
        this.AccountNo = c.AccountNo;
        this.Key = c.Key;
        this.Amount = c.Amount;
    }

    
    
    
    
    
    
    
    public String getName() {
        return Name;
    }
    
    

    @Override
    public String toString() {
        return "Customer{" + "Name=" + Name + ", Address=" + Address + ", MobileNo=" + MobileNo + ", AccountNo=" + AccountNo + ", Key=" + Key + ", Amount=" + Amount + '}';
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public long getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(long MobileNo) {
        this.MobileNo = MobileNo;
    }

    public long getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(long AccountNo) {
        this.AccountNo = AccountNo;
    }

    public int getKey() {
        return Key;
    }

    public void setKey(int Key) {
        this.Key = Key;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float Amount) {
        this.Amount = Amount;
    }
    
    
    public void setDefault()
    {
        this.Name = null;
        this.Address = null;
        this.MobileNo = 0L;
        this.AccountNo = 0L;
        this.Key = 0;
        this.Amount = 0.0f;

    }
    
    public void setObject(Customer c)
    {
        this.Name = c.Name;
        this.Address = c.Address;
        this.MobileNo = c.MobileNo;
        this.AccountNo = c.AccountNo;
        this.Key = c.Key;
        this.Amount = c.Amount;

    }
    
}
