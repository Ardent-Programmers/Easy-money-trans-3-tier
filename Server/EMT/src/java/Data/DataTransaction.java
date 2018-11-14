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
public class DataTransaction {
    private String Type,Date,Time,Amount;

    public DataTransaction() {
    }

    public DataTransaction(String Type, String Date, String Time, String Amount) {
        this.Type = Type;
        this.Date = Date;
        this.Time = Time;
        this.Amount = Amount;
    }
    
    public DataTransaction(DataTransaction dt) {
        this.Type = dt.Type;
        this.Date = dt.Date;
        this.Time = dt.Time;
        this.Amount = dt.Amount;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }
    
    
    
    
    
}
